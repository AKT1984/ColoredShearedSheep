package net.alexandr.sheepcolor;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class CustomRenderSheep extends RenderSheep {
    public CustomRenderSheep(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3) {
        super(par1ModelBase, par2ModelBase, par3);
    }

    private static final ResourceLocation[] sheepTextures = new ResourceLocation[16];

    static {
        for (int i = 0; i < 16; i++) {
            sheepTextures[i] = new ResourceLocation("sheepcolor", "textures/entity/sheep/sheep_fur_" + i + ".png");
        }
    }

    @Override
    protected ResourceLocation func_110883_a(EntitySheep par1EntitySheep) {
        int color = par1EntitySheep.getFleeceColor();
        if (color < 0 || color >= sheepTextures.length) {
            return sheepTextures[0]; // Default to white texture if color is invalid
        }
        return sheepTextures[color];
    }

    @Override
    protected int setWoolColorAndRender(EntitySheep par1EntitySheep, int par2, float par3) {
        return super.setWoolColorAndRender(par1EntitySheep, par2, par3);
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {
        return super.shouldRenderPass(par1EntityLivingBase, par2, par3);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.func_110883_a((EntitySheep) par1Entity);
    }

}
