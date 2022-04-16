 package lv.cliquant.Methods;
 
 import io.netty.buffer.Unpooled;
 import io.netty.channel.Channel;
 import java.net.InetSocketAddress;
 import lv.cliquant.Loaders.SelMethod;
 import lv.cliquant.Packets.HandShakePacket;
 import lv.cliquant.Packets.PingPacket;
 
 public class Motd
   implements SelMethod
 {
   private byte[] handshakePacket = (new HandShakePacket()).getPingHS();
   private byte[] pingPacket = (new PingPacket()).getPing();
   
   public void accept(Channel ch, InetSocketAddress proxy) {
     ch.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakePacket));
     ch.writeAndFlush(Unpooled.buffer().writeBytes(new byte[] { 1 }));
     ch.writeAndFlush(Unpooled.buffer().writeBytes(this.pingPacket));
   }
 }


// © 2022 Copyright www.pixeldown.ml - Cliquant