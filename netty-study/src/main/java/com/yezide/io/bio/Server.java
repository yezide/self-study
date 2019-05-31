package com.yezide.io.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author yzd
 * @des
 * @date 2019/5/8
 */
public class Server {

    // 实际网络编程中，throws Exception可能会引起链接通道未关闭，不能使用throws。
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(8888);

        while (true) {
            Socket sk = s.accept();
            new Thread(() -> {
                handel(sk);
            }).start();
        }

    }

    private static void handel(Socket sk) {

        try (
                InputStream input = sk.getInputStream();
                OutputStream output = sk.getOutputStream()
            ){
            byte[] bytes = new byte[1024];
            int len = input.read(bytes);
            String body = new String(bytes, 0, len);
            System.out.println(new Date() + " 服务器收到客户端数据:" + body);
            Thread.sleep(1000);
            output.write("服务器返回".getBytes());
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
