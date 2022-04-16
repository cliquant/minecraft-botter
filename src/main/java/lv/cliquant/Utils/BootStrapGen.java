package lv.cliquant.Utils;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lv.cliquant.Loaders.SelMethod;
import lv.cliquant.Main;
import lv.cliquant.Main;

import java.net.InetSocketAddress;

public class BootStrapGen {
    public static final SelMethod method = Main.methodSelector;

    public Bootstrap generateBootstrap(EventLoopGroup group) {
        Bootstrap bootstrap = new Bootstrap();
        ((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)bootstrap.group(group))
                .channel(EpollSocketChannel.class))
                .option(ChannelOption.TCP_NODELAY, Boolean.valueOf(true)))
                .option(ChannelOption.TCP_FASTOPEN_CONNECT, Boolean.valueOf(true)))
                .option(ChannelOption.AUTO_READ, Boolean.valueOf(false)))
                .handler((ChannelHandler)new ChannelInitializer<Channel>() {
                    protected void initChannel(final Channel ch) throws Exception {
                        try {
                            ChannelPipeline p = ch.pipeline();
                            final InetSocketAddress Tproxy = Main.Loader.getProxy();
                            final Socks4ProxyHandler socks = new Socks4ProxyHandler(Tproxy);
                            socks.setConnectTimeoutMillis(10000L);
                            socks.connectFuture().addListener(new GenericFutureListener<Future<? super Channel>>() {
                                public void operationComplete(Future<? super Channel> future) throws Exception {
                                    if (socks.isConnected())
                                        BootStrapGen.method.accept(ch, Tproxy);
                                }
                            });
                            p.addFirst(new ChannelHandler[] { (ChannelHandler)socks }).addLast(new ChannelHandler[] { new ChannelHandler() {
                                public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {}

                                public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {}

                                public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {}
                            } });
                        } catch (Exception exception) {}
                    }

                    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                        ctx.close();
                    }
                });
        return bootstrap;
    }
}

// © 2022 Copyright www.pixeldown.ml - Cliquant

