package com.eason.netty.nio;

import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by feng yingsheng on 2/16/2017.
 */
public class TimeClient implements Runnable {

    private Selector selector;

    private SocketChannel socketChannel;

    public TimeClient() {
        try{
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try{
            doConnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doConnect() {

    }
}
