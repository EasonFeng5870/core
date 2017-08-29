package com.eason.netty.fun1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by feng yingsheng on 2/10/2017.
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        System.out.println(Thread.currentThread() + "|" + this);
        ch.pipeline().addLast(new TimeServerHandler());
    }
}
