package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import twilightforest.client.model.ModelTFIceShooter;

public class RenderTFIceShooter extends RenderTFBiped {

	public RenderTFIceShooter() {
		super(new ModelTFIceShooter(), 1.0F, "iceshooter.png");
	}

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float partialTick)
    {
		float bounce = par1EntityLivingBase.ticksExisted + partialTick;
		
		GL11.glTranslatef(0F, MathHelper.sin((bounce) * 0.2F) * 0.15F, 0F);
    }
}
