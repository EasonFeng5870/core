package com.eason.core.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁测试
 *
 * Created by fengyingsheng on 2017-8-29.
 */
public class LockTest {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        //普通锁
//        simpleLockTest();
        //trylock 方法测试
        tryLockTest();

    }

    private static void tryLockTest() {
        final LockTest test = new LockTest();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                test.tryInsert();
            }
        }, "Thread-1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                test.tryInsert();
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }

    private void tryInsert() {
        if(lock.tryLock()) {
            try{
                System.out.println(Thread.currentThread().getName() + "_获取锁成功");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                System.out.println(Thread.currentThread().getName() + "_释放锁成功");
                lock.unlock();
            }
        }
        else {
            System.out.println(Thread.currentThread().getName() + "_获取锁失败");
        }
    }

    private static void simpleLockTest() {
        final LockTest test = new LockTest();
        new Thread(new Runnable() {
            public void run() {
                test.insert();
            }
        }, "Thread-1").start();

        new Thread(new Runnable() {
            public void run() {
                test.insert();
            }
        }, "Thread-2").start();
    }

    private void insert() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "_获得了锁");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + "_释放了锁");
            lock.unlock();
        }

    }


}
