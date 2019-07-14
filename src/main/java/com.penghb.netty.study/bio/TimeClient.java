package com.penghb.netty.study.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description: 客户端
 * @author: penghb
 * @createDate: 2019/7/14 4:03 PM
 * @version: 1.0
 */
public class TimeClient {

    public static void main(String[] args) throws IOException {
        int port = 8080;

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("QUERY TIME");
            System.out.println("send order success");
            String rep = in.readLine();
            System.out.println("now is: " + rep);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
            if (in != null) {
                in.close();
            }
            if (socket != null)
                socket.close();
        }
    }
}
