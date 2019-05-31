package com.yezide.io.bio;

import java.net.Socket;
import java.util.Date;

/**
 * @author yzd
 * @des
 * @date 2019/5/8
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 8888);
        while (true) {
            byte[] input = new byte[512];
            System.out.print("请输入信息:");
            System.in.read(input);
            client.getOutputStream().write(input);
            client.getOutputStream().flush();
            byte[] bytes = new byte[512];
            int len = client.getInputStream().read(bytes);
            System.out.println(new Date() + " 服务器:" + new String(bytes, 0, len));
        }
    }

}
