 package lv.cliquant.Packets;
 
 import io.netty.buffer.ByteBuf;
 import io.netty.buffer.Unpooled;
 import lv.cliquant.Utils.VarUtil;
 
 public class PingPacket
 {
   public byte[] getPing() {
     ByteBuf buffer = Unpooled.buffer();
     buffer.writeByte(1);
     buffer.writeLong(1000L);
     ByteBuf wrap = Unpooled.buffer();
     VarUtil.writeVarInt(buffer.readableBytes(), wrap);
     wrap.writeBytes(buffer);
     byte[] bytes = new byte[wrap.readableBytes()];
     wrap.getBytes(0, bytes);
     wrap.release();
     return bytes;
   }
 }

 // © 2022 Copyright www.pixeldown.ml - Cliquant