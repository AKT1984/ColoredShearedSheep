package net.alexandr.sheepcolor;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@Mod(modid = "sheepcolor", name = "Colored Sheared Sheep", version = "1.0")
public class SheepColor {


	 @Mod.EventHandler
	    public void preInit(FMLPreInitializationEvent event) {
	        RenderingRegistry.registerEntityRenderingHandler(EntitySheep.class, new CustomRenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
	    }
	
	 @Mod.EventHandler
	    public void init(FMLInitializationEvent event) {
	    	RenderManager.instance.entityRenderMap.put(EntitySheep.class, new CustomRenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
	 }

}



