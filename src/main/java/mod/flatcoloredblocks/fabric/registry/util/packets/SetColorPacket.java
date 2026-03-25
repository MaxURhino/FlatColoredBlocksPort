package mod.flatcoloredblocks.fabric.registry.util.packets;

import mod.flatcoloredblocks.fabric.FlatColoredBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;


public record SetColorPacket(int red, int green, int blue) implements CustomPacketPayload {
    public static final Type<SetColorPacket> TYPE =
            new Type<>(FlatColoredBlocks.id("set_color"));

    public static final StreamCodec<FriendlyByteBuf, SetColorPacket> CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.INT, SetColorPacket::red,
                    ByteBufCodecs.INT, SetColorPacket::green,
                    ByteBufCodecs.INT, SetColorPacket::blue,
                    SetColorPacket::new
            );

    @Override public Type<SetColorPacket> type() { return TYPE; }
}
