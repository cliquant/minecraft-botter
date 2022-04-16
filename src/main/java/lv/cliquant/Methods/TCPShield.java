 package lv.cliquant.Methods;
 
 import io.netty.buffer.Unpooled;
 import io.netty.channel.Channel;
 import java.net.InetSocketAddress;
 import java.util.Random;
 import lv.cliquant.Loaders.SelMethod;
 import lv.cliquant.Packets.HandShakePacket;
 import lv.cliquant.Packets.JoinPacket;
 
 public class TCPShield
   implements SelMethod
 {
   private byte[] handshakePacket = (new HandShakePacket()).getJoinHS();
   
   public void accept(Channel ch, InetSocketAddress proxy) {
     (new Thread(() -> {
           try {
             ch.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakePacket));
             Thread.sleep(200L);
               String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
               StringBuilder sb = new StringBuilder();
               Random random = new Random();
               int length = 4;
               for(int i = 0; i < length; i++) {
                   int index = random.nextInt(alphabet.length());
                   char randomChar = alphabet.charAt(index);
                   sb.append(randomChar);
               }
               String randomString = sb.toString();
             ch.writeAndFlush(Unpooled.buffer().writeBytes((new JoinPacket()).getJoin("PixelDown_" + randomString)));
             Thread.sleep(2000L);
             while (!ch.isOpen()) {
               ch.read();
             }
           } catch (InterruptedException interruptedException) {}
         })).start();
   }
 }


// © 2022 Copyright www.pixeldown.ml - Cliquant
