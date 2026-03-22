package mod.flatcoloredblocks.fabric.registry.item.type;

import mod.flatcoloredblocks.fabric.registry.util.FlatColoredBlocksComponents;
import mod.flatcoloredblocks.fabric.registry.util.FlatColoredBlocksUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PaintBrushItem extends Item {
    public PaintBrushItem(Properties properties) {
        super(properties);
    }

    @Override
    public Component getName(ItemStack itemStack) {
        Integer amount = itemStack.get(FlatColoredBlocksComponents.AMOUNT);
        if (amount != null) {
            if (amount == 0) {
                return super.getName(itemStack);
            }
            return Component.translatable("item.flatcoloredblocks.paint_brush.with_contents", amount, FlatColoredBlocksUtil.getColorName(itemStack));
        }
        return super.getName(itemStack);
    }
}
