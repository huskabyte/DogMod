package solaralpha.fake.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import solaralpha.fake.entity.model.ModelDog;

@SideOnly(Side.CLIENT)
public class RenderDog extends RenderLiving<EntityDog>{
    
    public RenderDog(RenderManager manager) {
		super(manager, new ModelDog(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityDog entity) {
		return null;
	}
	
	@Override
	protected void applyRotations(EntityDog entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
