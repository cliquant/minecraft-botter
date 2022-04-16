 package lv.cliquant.Methods;
 
 import io.netty.buffer.Unpooled;
 import io.netty.channel.Channel;
 import java.net.InetSocketAddress;
 import lv.cliquant.Loaders.SelMethod;
 import lv.cliquant.Packets.HandShakePacket;
 import lv.cliquant.Packets.JoinPacket;
 
 public class NullPing
   implements SelMethod {
   private byte[] handshakePacket = (new HandShakePacket()).getJoinHS();
   
   public void accept(Channel ch, InetSocketAddress proxy) {
     ch.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakePacket));
     ch.writeAndFlush(Unpooled.buffer().writeBytes((new JoinPacket()).getNullJoin()));
   }
 }



// © 2022 Copyright www.pixeldown.ml - Cliquant