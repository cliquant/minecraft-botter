 package lv.cliquant.Packets;
 
 import io.netty.buffer.ByteBuf;
 import io.netty.buffer.Unpooled;
 import lv.cliquant.Utils.VarUtil;
 
 public class EncryptResponse
 {
   public byte[] getPacket() {
     ByteBuf buffer = Unpooled.buffer();
     buffer.writeByte(1);
     VarUtil.writeVarInt(99999, buffer);
     buffer.writeBytes(new byte[] { 1, 2, 3, 4, 5, 6, 7, 7, 9, 16 });
     VarUtil.writeVarInt(10000, buffer);
     buffer.writeBytes(new byte[] { 1, 2, 3, 4, 5, 6, 7, 7, 9, 16 });
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