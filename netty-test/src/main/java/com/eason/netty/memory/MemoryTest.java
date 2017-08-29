package com.eason.netty.memory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

/**
 * Created by feng yingsheng on 1/20/2017.
 */
public class MemoryTest {

    public static void main(String[] args) throws Exception {
        PooledByteBufAllocator allocator = new PooledByteBufAllocator(false);
        ByteBuf buf = allocator.heapBuffer(32);
        System.out.println(buf);
    }
}
