package lv.cliquant.Loaders;
 import java.io.BufferedReader;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileReader;
 import java.io.IOException;
 import java.net.InetSocketAddress;
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;

 public class ProxyLoader {
   public List<InetSocketAddress> proxyList = new ArrayList<>();
   public int pNum = -1;
   
   public void loadProxies() {
     File f = new File("proxy.txt");
     if (!f.exists()) {
           System.err.println("[ERROR] Proxy file proxy.txt not found");
           System.err.println("");
           System.err.println("Closing...");
           System.exit(0);
     }
 
     
     try { BufferedReader list = new BufferedReader(new FileReader("proxy.txt"));
       String line;
       while ((line = list.readLine()) != null) {
         String[] proxy = line.trim().split(":");
         String IP = proxy[0];
         int port = Integer.parseInt(proxy[1]);
         this.proxyList.add(new InetSocketAddress(IP, port));
         this.proxyList.add(new InetSocketAddress(IP, port));
         this.proxyList.add(new InetSocketAddress(IP, port));
         this.proxyList.add(new InetSocketAddress(IP, port));
         this.proxyList.add(new InetSocketAddress(IP, port));
       }
       if(this.proxyList.size() == 0) {
           System.err.println("[ERROR] Proxy file must contain list of socks4 proxies.");
           System.err.println("");
           System.err.println("Closing...");
           System.exit(0);
       }
       System.out.println("Loaded " + this.proxyList.size() / 5 + " proxies!");
       Collections.shuffle(this.proxyList); }
     catch (FileNotFoundException fileNotFoundException) {  }
     catch (IOException iOException) {}
   }
   
   public InetSocketAddress getProxy() {
     this.pNum++;
    if (this.pNum > this.proxyList.size()) {
       this.pNum = 0;
     }
     return this.proxyList.get(this.pNum);
   }
 }



// © 2022 Copyright www.pixeldown.ml - Cliquant
