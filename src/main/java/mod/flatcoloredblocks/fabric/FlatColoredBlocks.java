package mod.flatcoloredblocks.fabric;

import mod.flatcoloredblocks.fabric.registry.block.FlatColoredBlockRegistry;
import mod.flatcoloredblocks.fabric.registry.item.FlatColoredBlocksItemRegistry;
import mod.flatcoloredblocks.fabric.registry.item.group.FlatColoredBlocksCreativeModeTabRegistry;
import mod.flatcoloredblocks.fabric.registry.util.FlatColoredBlocksComponents;
import mod.flatcoloredblocks.fabric.registry.util.packets.SetColorPacket;
import mod.flatcoloredblocks.fabric.registry.util.screen.screens.ColorerBlockMenu;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlatColoredBlocks implements ModInitializer {
    public static final String MOD_ID = "flatcoloredblocks";
    public static final String NAME = "FlatColoredBlocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    @Override
    public void onInitialize() {
        FlatColoredBlockRegistry.bootstrap();
        FlatColoredBlocksItemRegistry.bootstrap();
        FlatColoredBlocksComponents.bootstrap();
        FlatColoredBlocksCreativeModeTabRegistry.bootstrap();

        PayloadTypeRegistry.playC2S().register(SetColorPacket.TYPE, SetColorPacket.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(SetColorPacket.TYPE, (payload, ctx) -> {
            ctx.server().execute(() -> {
                if (ctx.player().containerMenu instanceof ColorerBlockMenu menu) {
                    menu.colorRed.set(payload.red());
                    menu.colorGreen.set(payload.green());
                    menu.colorBlue.set(payload.blue());
                    menu.slotsChanged(menu.getCraftingContainer());
                }
            });
        });
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
