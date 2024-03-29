package solaralpha.dogswithgenetics.dogs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import solaralpha.dogswithgenetics.References;
import solaralpha.dogswithgenetics.dogs.genetics.GeneticsHandler;
import solaralpha.dogswithgenetics.dogs.model.ModelDog;

@SideOnly(Side.CLIENT)
public class RenderDog extends RenderLiving<EntityDog>{
	private static final ResourceLocation BLACK_HUSKY_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/husky/black.png");
    private static final ResourceLocation GRAY_HUSKY_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/husky/gray.png");
    private static final ResourceLocation RED_HUSKY_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/husky/red.png");
    private static final ResourceLocation AGOUTI_HUSKY_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/husky/agouti.png");
    private static final ResourceLocation WHITE_HUSKY_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/husky/white.png");
	private static final ResourceLocation BLACK_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/black.png");
    private static final ResourceLocation GRAY_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/gray.png");
    private static final ResourceLocation RED_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/red.png");
    private static final ResourceLocation AGOUTI_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/agouti.png");
    private static final ResourceLocation WHITE_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/white.png");
    
    public RenderDog(RenderManager manager) {
		super(manager, new ModelDog(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityDog entity) {
		if(GeneticsHandler.getBody(((EntityDog)entity).getGenotype()).equals("HH")){
			if(GeneticsHandler.getCoatColorAlleles(entity.getGenotype()).contains("b")) {
				return BLACK_HUSKY_TEXTURES;
			}
			if(GeneticsHandler.getCoatColorAlleles(entity.getGenotype()).contains("g")) {
				return GRAY_HUSKY_TEXTURES;
			}
			if(GeneticsHandler.getCoatColorAlleles(entity.getGenotype()).contains("r")) {
				return RED_HUSKY_TEXTURES;
			}
			if(GeneticsHandler.getCoatColorAlleles(entity.getGenotype()).contains("a")) {
				return AGOUTI_HUSKY_TEXTURES;
			}
			return WHITE_HUSKY_TEXTURES;
		}else if(GeneticsHandler.getBody(((EntityDog)entity).getGenotype()).equals("EE")){
			if(GeneticsHandler.getCoatColorAlleles(entity.getGenotype()).contains("b")) {
				return BLACK_ESKIMO_TEXTURES;
			}
			if(GeneticsHandler.getCoatColorAlleles(entity.getGenotype()).contains("g")) {
				return GRAY_ESKIMO_TEXTURES;
			}
			if(GeneticsHandler.getCoatColorAlleles(entity.getGenotype()).contains("r")) {
				return RED_ESKIMO_TEXTURES;
			}
			if(GeneticsHandler.getCoatColorAlleles(entity.getGenotype()).contains("a")) {
				return AGOUTI_ESKIMO_TEXTURES;
			}
			return WHITE_ESKIMO_TEXTURES;
		}
		return null;
	}
	
	@Override
	protected void applyRotations(EntityDog entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
