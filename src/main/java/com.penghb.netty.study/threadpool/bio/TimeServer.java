package com.penghb.netty.study.threadpool.bio;

import com.penghb.netty.study.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 时间服务器
 * @author: penghb
 * @createDate: 2019/7/14 3:46 PM
 * @version: 1.0
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server starts in port: " + port);
            TimeServerHandlerExecuterPool timeServerHandlerExecuterPool = new TimeServerHandlerExecuterPool(50, 100);
            Socket socket;
            while (true) {
                socket = serverSocket.accept();
                timeServerHandlerExecuterPool.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
