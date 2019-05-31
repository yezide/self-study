package com.yezide.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * @author yzd
 * @des
 * @date 2019/5/14
 */
public class NettyUse {

    public static void main(String[] args) throws Exception {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(boosGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {
                channel.pipeline().addLast(new Handel());
            }
        });
        ChannelFuture channelFuture = bootstrap.bind(8888).sync();
        Channel channel = channelFuture.channel();
        ChannelFuture channelFuture1 = channel.closeFuture();
        channelFuture1.sync();

    }

    protected static class Handel extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

            ByteBuf buf = (ByteBuf) msg;
            System.out.println(buf.toString(CharsetUtil.UTF_8));
            ctx.writeAndFlush(msg);

        }

        @Override
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
            throwable.printStackTrace();
        }

    }

}
