package lv.cliquant.Packets;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lv.cliquant.Main;
import lv.cliquant.Utils.VarUtil;

import java.util.Random;

public class HandShakePacket {
    private Random r = new Random();

    public byte[] getJoinHS() {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeByte(0);
        VarUtil.writeVarInt(Main.protocol, buffer);
        VarUtil.writeString(Main.ip, buffer);
        buffer.writeShort(Main.port);
        VarUtil.writeVarInt(2, buffer);
        ByteBuf wrap = Unpooled.buffer();
        VarUtil.writeVarInt(buffer.readableBytes(), wrap);
        wrap.writeBytes(buffer);
        byte[] bytes = new byte[wrap.readableBytes()];
        wrap.getBytes(0, bytes);
        wrap.release();
        return bytes;
    }

    public byte[] getRHS() {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeByte(0);
        VarUtil.writeVarInt(Main.protocol, buffer);
        VarUtil.writeString(Main.ip, buffer);
        buffer.writeShort(Main.port);
        VarUtil.writeVarInt(this.r.nextInt(2), buffer);
        ByteBuf wrap = Unpooled.buffer();
        VarUtil.writeVarInt(buffer.readableBytes(), wrap);
        wrap.writeBytes(buffer);
        byte[] bytes = new byte[wrap.readableBytes()];
        wrap.getBytes(0, bytes);
        wrap.release();
        return bytes;
    }

    public byte[] getPingHS() {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeByte(0);
        VarUtil.writeVarInt(47, buffer);
        VarUtil.writeString(Main.ip, buffer);
        buffer.writeShort(Main.port);
        VarUtil.writeVarInt(1, buffer);
        ByteBuf wrap = Unpooled.buffer();
        VarUtil.writeVarInt(buffer.readableBytes(), wrap);
        wrap.writeBytes(buffer);
        byte[] bytes = new byte[wrap.readableBytes()];
        wrap.getBytes(0, bytes);
        wrap.release();
        return bytes;
    }

    public byte[] getBadID() {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeByte(209);
        VarUtil.writeVarInt(Main.protocol, buffer);
        VarUtil.writeString(Main.ip, buffer);
        buffer.writeShort(Main.port);
        VarUtil.writeVarInt(2, buffer);
        ByteBuf wrap = Unpooled.buffer();
        VarUtil.writeVarInt(buffer.readableBytes(), wrap);
        wrap.writeBytes(buffer);
        byte[] bytes = new byte[wrap.readableBytes()];
        wrap.getBytes(0, bytes);
        wrap.release();
        return bytes;
    }

    public byte[] getKV() {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeByte(0);
        VarUtil.writeVarInt(Main.protocol, buffer);
        VarUtil.writeString(Main.ip, buffer);
        buffer.writeShort(Main.port);
        VarUtil.writeVarInt(999, buffer);
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

