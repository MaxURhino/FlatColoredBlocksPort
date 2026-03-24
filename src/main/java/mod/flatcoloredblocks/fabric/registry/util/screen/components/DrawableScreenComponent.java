package mod.flatcoloredblocks.fabric.registry.util.screen.components;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;

public class DrawableScreenComponent {
    private Identifier texture;
    private float x;
    private float y;
    private float scale;

    public DrawableScreenComponent(Identifier texture, float x, float y) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.scale = 1;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Identifier getTexture() {
        return texture;
    }

    public float getScale() {
        return scale;
    }


    public DrawableScreenComponent setX(float x) {
        this.x = x;
        return this;
    }

    public DrawableScreenComponent setY(float y) {
        this.y = y;
        return this;
    }

    public DrawableScreenComponent setTexture(Identifier texture) {
        this.texture = texture;
        return this;
    }

    public DrawableScreenComponent setScale(float scale) {
        this.scale = scale;
        return this;
    }

    public DrawableScreenComponent setPosition(float x, float y) {
        return this.setX(x).setY(y);
    }



    public void draw(GuiGraphics graphics) {
        graphics.pose().pushMatrix();

        graphics.pose().scale(scale);

        graphics.blit(RenderPipelines.GUI_TEXTURED, texture, Math.round(x), Math.round(y), 0, 0, 12, 15, 12, 15);

        graphics.pose().popMatrix();
    }
}
