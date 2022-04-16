 package lv.cliquant.Packets;
 
 import io.netty.buffer.ByteBuf;
 import io.netty.buffer.Unpooled;
 import lv.cliquant.Utils.VarUtil;

 public class JoinPacket
 {
   public byte[] getJoin(String nick) {
     ByteBuf buffer = Unpooled.buffer();
     buffer.writeByte(0);
     VarUtil.writeString(nick, buffer);
     ByteBuf wrap = Unpooled.buffer();
     VarUtil.writeVarInt(buffer.readableBytes(), wrap);
     wrap.writeBytes(buffer);
     byte[] bytes = new byte[wrap.readableBytes()];
     wrap.getBytes(0, bytes);
     wrap.release();
     return bytes;
   }

   public byte[] getNullJoin() {
     ByteBuf buffer = Unpooled.buffer();
     buffer.writeByte(0);
     VarUtil.writeString("", buffer);
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