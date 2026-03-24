package mod.flatcoloredblocks.fabric.registry.util.screen.screens;

import mod.flatcoloredblocks.fabric.FlatColoredBlocks;
import mod.flatcoloredblocks.fabric.registry.util.FlatColoredBlocksUtil;
import mod.flatcoloredblocks.fabric.registry.util.screen.components.DrawableScreenComponent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import org.jspecify.annotations.NonNull;

public class ColorerBlockScreen extends AbstractContainerScreen<ColorerBlockMenu> {
    private static final Identifier CONTAINER_TEXTURE = FlatColoredBlocks.id("textures/gui/container/colorer.png");
    private FlatColoredBlocksUtil.Color color;

    private DrawableScreenComponent redSlider;

    public ColorerBlockScreen(ColorerBlockMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
        this.redSlider = new DrawableScreenComponent(
                FlatColoredBlocks.id("textures/gui/sprites/container/colorer/color_slider.png"),
                0, 0
        );

        //this.redSlider.setScale(0.5f);

        this.redSlider.setPosition(100, 100);
    }

    @Override
    protected void init() {
        super.init();

        // Center the title
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;

        color = FlatColoredBlocksUtil.RED;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float delta, int mouseX, int mouseY) {
        int xo = (this.width - this.imageWidth) / 2;
        int yo = (this.height - this.imageHeight) / 2;
        graphics.blit(RenderPipelines.GUI_TEXTURED, CONTAINER_TEXTURE, xo, yo, 0.0F, 0.0F, this.imageWidth, this.imageHeight, BACKGROUND_TEXTURE_WIDTH, BACKGROUND_TEXTURE_HEIGHT);
    }

    @Override
    public void render(@NonNull GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);

        renderTooltip(graphics, mouseX, mouseY);

        int x = 380;
        int y = 116;

        graphics.fill(x, y, x + 16, y + 16, color.getColorAsARGB());

        int r = color.red();
        int g = color.green();
        int b = color.blue();

        x -= (18 * 5) - 6;
        y -= 3;

        graphics.pose().pushMatrix();

        graphics.pose().translate(x, y);

        graphics.pose().rotate((float) Math.toRadians(-90));

        graphics.fillGradient(-4, 0, 0, 45, FlatColoredBlocksUtil.Color.toARGB(0, g, b), FlatColoredBlocksUtil.Color.toARGB(0xFF, g, b));

        graphics.pose().popMatrix();

        y += 12;

        graphics.pose().pushMatrix();

        graphics.pose().translate(x, y);

        graphics.pose().rotate((float) Math.toRadians(-90));

        graphics.fillGradient(-4, 0, 0, 45, FlatColoredBlocksUtil.Color.toARGB(r, 0, b), FlatColoredBlocksUtil.Color.toARGB(r, 0xFF, b));

        graphics.pose().popMatrix();

        y += 12;

        graphics.pose().pushMatrix();

        graphics.pose().translate(x, y);

        graphics.pose().rotate((float) Math.toRadians(-90));

        graphics.fillGradient(-4, 0, 0, 45, FlatColoredBlocksUtil.Color.toARGB(r, g, 0), FlatColoredBlocksUtil.Color.toARGB(r, g, 0xFF));

        graphics.pose().popMatrix();

        this.redSlider.draw(graphics);
    }
}
