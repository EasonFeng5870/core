package com.eason.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by feng yingsheng on 2/16/2017.
 */
public class TimeServer implements Runnable {

    public static void main(String[] args) {
        Thread t1 = new Thread(new TimeServer());
        t1.start();
        System.out.println(1<<0);
        System.out.println(1<<2);
        System.out.println(1<<3);
        System.out.println(1<<4);
    }

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    public TimeServer(){
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(8888), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("started.");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void run() {
        try{
            while(!stop) {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                while(it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    handleInput(key);
                    if(key != null) {
                        key.cancel();
                        if(key.channel() != null) {
                            key.channel().close();
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleInput(SelectionKey key) throws Exception {
        if(key.isValid()) {
            if(key.isAcceptable()) {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }

            if(key.isReadable()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int readableBytes = socketChannel.read(byteBuffer);
                if(readableBytes > 0) {
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);
                    String str = new String(bytes, "UTF-8");
                    System.out.println("Receive string:" + str);
                    String currentTime = ("QUERY TIME ORDER".equalsIgnoreCase(str)) ?
                            (new Date()).toString() : "BAD ORDER";
                    doWrite(socketChannel, currentTime);
                }
                else if(readableBytes < 0) {
                    key.cancel();
                    key.channel().close();
                }
                else {
                    ;
                }
            }

        }
    }

    private void doWrite(SocketChannel socketChannel, String response) throws Exception {
        byte[] bytes = response.getBytes("UTF-8");
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
    }

}
