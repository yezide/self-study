package com.yezide.io.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @author yzd
 * @des
 * @date 2019/5/14
 */
public class Server {


    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(1);

        AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8888));
        assc.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel channel, Object attachment) {
                assc.accept(null, this);
                ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                byteBuffer.clear();
                channel.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer len, ByteBuffer attachment) {

                        attachment.flip();
                        String clientMsg = new String(attachment.array(), 0, len);
                        System.out.println(clientMsg);
                        channel.write(ByteBuffer.wrap(("接受到了您的消息:" + clientMsg).getBytes()));
                        ByteBuffer byteBufferTemp = ByteBuffer.allocate(512);
                        byteBufferTemp.clear();
                        channel.read(byteBufferTemp, byteBufferTemp, this);
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        exc.printStackTrace();
                        cdl.countDown();
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
                cdl.countDown();
            }
        });

        cdl.await();

    }

}
