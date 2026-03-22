package mod.flatcoloredblocks.fabric.registry.block.entity.renderer.type;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.flatcoloredblocks.fabric.registry.block.entity.type.ColorerBlockEntity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ColorerBlockEntityRenderer implements BlockEntityRenderer<ColorerBlockEntity, ColorerBlockEntityRenderState> {
    public ColorerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public ColorerBlockEntityRenderState createRenderState() {
        return new ColorerBlockEntityRenderState();
    }

    @Override
    public void extractRenderState(ColorerBlockEntity blockEntity, ColorerBlockEntityRenderState state, float tickProgress, @NonNull Vec3 cameraPos, ModelFeatureRenderer.@Nullable CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);
        state.setItems(blockEntity.getItems());
        state.setLevel(blockEntity.getLevel());
        state.setBlockPos(blockEntity.getBlockPos());
    }

    @Override
    public void submit(ColorerBlockEntityRenderState state, @NonNull PoseStack pose, @NonNull SubmitNodeCollector collector, @NonNull CameraRenderState camera) {
        ItemStack stack = state.getItem(0);

        //collector.submitItem(pose, ItemDisplayContext.GUI, getLightLevel(state.getLevel(), state.getBlockPos()), OverlayTexture.NO_OVERLAY);
    }

    private int getLightLevel(Level world, BlockPos pos) {
        int bLight = world.getBrightness(LightLayer.BLOCK, pos);
        int sLight = world.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
