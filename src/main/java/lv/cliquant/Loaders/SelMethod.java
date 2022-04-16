package lv.cliquant.Loaders;

import io.netty.channel.Channel;
import java.net.InetSocketAddress;
import java.util.function.BiConsumer;

public interface SelMethod extends BiConsumer<Channel, InetSocketAddress> {}



// © 2022 Copyright www.pixeldown.ml - Cliquant