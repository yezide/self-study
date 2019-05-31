package com.yezide.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yzd
 * @des
 * @date 2019/5/8
 */
public class PoolServer {

    private static ExecutorService pool = Executors.newFixedThreadPool(50);

    // 实际网络编程中，throws Exception可能会引起链接通道未关闭，不能使用throws。
    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress("127.0.0.1", 8888));
        Selector s = Selector.open();
        ssc.register(s, SelectionKey.OP_ACCEPT);

        while (true) {
            s.select();
            pool.execute(new HandelThread(s));

        }

    }

    private static class HandelThread implements Runnable {

        private Selector s;

        public HandelThread(Selector s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                Set<SelectionKey> keys = s.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    SelectionKey selectionKey = it.next();
                    it.remove();
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = serverChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
                    }
                    if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        byteBuffer.clear();
                        int len = socketChannel.read(byteBuffer);
                        if (len != -1) {
                            System.out.printf(new Date() + " 客户端:" + new String(byteBuffer.array(), 0, len));
                        }

                        byte[] input = new byte[512];
                        System.out.print("请输入信息:");
                        System.in.read(input);

                        ByteBuffer write = ByteBuffer.wrap(input);
                        socketChannel.write(write);
                        socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
