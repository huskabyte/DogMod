package solaralpha.dogswithgenetics.dogs.breeds;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import solaralpha.dogswithgenetics.References;
import solaralpha.dogswithgenetics.dogs.genetics.GeneticsHandler;
import solaralpha.dogswithgenetics.dogs.model.ModelEskimo;

@SideOnly(Side.CLIENT)
public class RenderEskimo extends RenderLiving<DogEskimo>{
	private static final ResourceLocation BLACK_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/black.png");
    private static final ResourceLocation GRAY_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/gray.png");
    private static final ResourceLocation RED_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/red.png");
    private static final ResourceLocation AGOUTI_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/agouti.png");
    private static final ResourceLocation WHITE_ESKIMO_TEXTURES = new ResourceLocation(References.MODID + ":" + "textures/entity/eskimo/white.png");
    
    public RenderEskimo(RenderManager manager) {
		super(manager, new ModelEskimo(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(DogEskimo entity) {
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
	
	@Override
	protected void applyRotations(DogEskimo entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}

