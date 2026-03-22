package mod.flatcoloredblocks.fabric.registry.block.entity.renderer.type;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ColorerBlockEntityRenderState extends BlockEntityRenderState {
    private NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    private Level level;
    private BlockPos blockPos;

    public void setItem(int index, ItemStack stack) {
        items.set(index, stack);
    }

    public ItemStack getItem(int index) {
        return items.get(index);
    }

    public NonNullList<ItemStack> getItems() {
        return items;
    }

    public void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }
}
