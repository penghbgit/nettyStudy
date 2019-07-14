package com.penghb.netty.study.nio;

/**
 * @description: 客户端
 * @author: penghb
 * @createDate: 2019/7/14 10:36 PM
 * @version: 1.0
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;

        new Thread(new TimeClientHandle("127.0.0.1", port), "nio-client-1").start();
    }
}
