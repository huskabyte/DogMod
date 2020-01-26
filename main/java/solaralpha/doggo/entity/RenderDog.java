package solaralpha.doggo.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import solaralpha.doggo.StaticInfo;
import solaralpha.doggo.entity.model.ModelHusky;

@SideOnly(Side.CLIENT)
public class RenderDog extends RenderLiving<EntityDog>{
	private static final ResourceLocation BLACK_HUSKY_TEXTURES = new ResourceLocation(StaticInfo.MODID + ":" + "textures/entity/husky/black.png");
    private static final ResourceLocation GRAY_HUSKY_TEXTURES = new ResourceLocation(StaticInfo.MODID + ":" + "textures/entity/husky/gray.png");
    private static final ResourceLocation RED_HUSKY_TEXTURES = new ResourceLocation(StaticInfo.MODID + ":" + "textures/entity/husky/red.png");
    private static final ResourceLocation AGOUTI_HUSKY_TEXTURES = new ResourceLocation(StaticInfo.MODID + ":" + "textures/entity/husky/agouti.png");
    
    public RenderDog(RenderManager manager) {
		super(manager, new ModelHusky(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityDog entity) {
		switch (entity.getCoat()) {
			case 0:
				return AGOUTI_HUSKY_TEXTURES;
			case 1:
				return RED_HUSKY_TEXTURES;
			case 2:
				return GRAY_HUSKY_TEXTURES;
			case 3:
				return BLACK_HUSKY_TEXTURES;
		}
		return null;
	}
	
	@Override
	protected void applyRotations(EntityDog entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
