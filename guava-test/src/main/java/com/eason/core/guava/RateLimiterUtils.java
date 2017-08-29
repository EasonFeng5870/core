package com.eason.core.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * Created by feng yingsheng on 4/18/2017.
 */
public class RateLimiterUtils {

    public static void main(String[] args) throws InterruptedException {
//        normalRateLimiter();
        secondNormalRateLimiterIfBigComing();
    }

    private static void secondNormalRateLimiterIfBigComing() throws InterruptedException {
        RateLimiter limiter = RateLimiter.create(5, 1000, TimeUnit.MILLISECONDS);
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        Thread.sleep(1000L);
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
//        System.out.println(limiter.acquire(5));
    }

    private static void normalRateLimiter() {
        RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire(5));
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
    }
}
