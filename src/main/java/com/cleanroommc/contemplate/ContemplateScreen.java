package com.cleanroommc.contemplate;

import com.cleanroommc.contemplate.script.Contemplating;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;

public class ContemplateScreen extends GuiScreen {

    private final Contemplating contemplating;

    public ContemplateScreen(Contemplating contemplating) {
        this.contemplating = contemplating;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        this.drawBackgroundLayer();

        GlStateManager.disableLighting();
        this.drawForegroundLayer();

        GlStateManager.enableLighting();
    }

    private void drawBackgroundLayer() {
        GlStateManager.pushMatrix();

        GlStateManager.popMatrix();
    }

    private void drawForegroundLayer() {
        GlStateManager.pushMatrix();

        GlStateManager.popMatrix();
    }

}
