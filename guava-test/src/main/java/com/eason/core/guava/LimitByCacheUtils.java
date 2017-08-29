package com.eason.core.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by feng yingsheng on 4/18/2017.
 */
public class LimitByCacheUtils {

    public static LoadingCache<Long, AtomicLong> counter = CacheBuilder.newBuilder()
            .expireAfterWrite(2,  TimeUnit.MINUTES)
            .build(new CacheLoader<Long, AtomicLong>() {
                @Override
                public AtomicLong load(Long seconds) throws Exception {
                    return new AtomicLong(0);
                }
            });

    public static void main(String[] args) throws Exception {
        for(;;) {
            if(limitInterfaceAccess()) {
                break;
            }
        }
    }

    public static boolean limitInterfaceAccess() throws ExecutionException {
        long currentSeconds = System.currentTimeMillis() / 1000;
        if(counter.get(currentSeconds).incrementAndGet() > 3000000) {
            System.out.println("限流了(current limittimes is : " + counter.get(currentSeconds).get() + ")：" + new Date(currentSeconds * 1000));
            return true;
        }
        return false;
    }
}
