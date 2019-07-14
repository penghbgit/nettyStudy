package com.penghb.netty.study.threadpool.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author: penghb
 * @createDate: 2019/7/14 9:28 PM
 * @version: 1.0
 */
public class TimeServerHandlerExecuterPool {

    private ExecutorService executor;

    public TimeServerHandlerExecuterPool(int maxPoolSize, int queueSize) {
        executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable runnable) {
        executor.execute(runnable);
    }
}
