package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import twilightforest.TwilightForestMod;

public class RenderTFTowerBroodling extends RenderSpider {

    private static final ResourceLocation textureLoc = new ResourceLocation(
            TwilightForestMod.MODEL_DIR + "towerbroodling.png");

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return textureLoc;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        float scale = 0.7F;
        GL11.glScalef(scale, scale, scale);
    }
}
