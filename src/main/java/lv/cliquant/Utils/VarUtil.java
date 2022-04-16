package lv.cliquant.Utils;

import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

public class VarUtil {
    public static void writeVarInt(int value, ByteBuf output) {
        do {
            int part = value & 0x7F;
            value >>>= 7;
            if (value != 0)
                part |= 0x80;
            output.writeByte(part);
        } while (value != 0);
    }

    public static void writeString(String s, ByteBuf buf) {
        if (s.length() > 32767)
            throw new RuntimeException("Cannot send string longer than Short.MAX_VALUE (got " + s.length() + " characters)");
        byte[] b = s.getBytes(StandardCharsets.UTF_8);
        writeVarInt(b.length, buf);
        buf.writeBytes(b);
    }
}

// © 2022 Copyright www.pixeldown.ml - Cliquant
