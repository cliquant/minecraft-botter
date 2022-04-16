 package lv.cliquant.Packets;
 
 import io.netty.buffer.ByteBuf;
 import io.netty.buffer.Unpooled;
 import lv.cliquant.Utils.VarUtil;
 
 public class CustomPayload2
 {
   public byte[] getPayload() {
     ByteBuf buffer = Unpooled.buffer();
     buffer.writeByte(10);
     VarUtil.writeString("MC|BSign", buffer);
     buffer.writeBytes(new byte[] { 0 });
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