package com.penghb.netty.study.nio;

/**
 * @description: 时间服务器
 * @author: penghb
 * @createDate: 2019/7/14 9:44 PM
 * @version: 1.0
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        MutiplexerTimeServer mutiplexerTimeServer = new MutiplexerTimeServer(port);
        new Thread(mutiplexerTimeServer, "nio-server-1").start();
    }
}
