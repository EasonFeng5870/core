package com.eason.payment.threadpool;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by feng yingsheng on 10/1/2017.
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("执行一步任务：" + i);
    }

    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行一步任务+1：" + (i+1));
    }


}
