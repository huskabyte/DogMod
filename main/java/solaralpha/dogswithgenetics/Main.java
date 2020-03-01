package solaralpha.dogswithgenetics;

import java.awt.Color;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import solaralpha.dogswithgenetics.dogs.EntityDog;
import solaralpha.dogswithgenetics.dogs.EntityInit;
import solaralpha.dogswithgenetics.dogs.RenderDog;
import solaralpha.dogswithgenetics.dogs.genetics.GeneticsHandler;
import solaralpha.dogswithgenetics.proxy.CommonProxy;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class Main {

	@Mod.Instance(References.MODID)
	public static Main instance;
	
	@SidedProxy(serverSide = "solaralpha.dogswithgenetics.proxy.CommonProxy", clientSide = "solaralpha.dogswithgenetics.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GeneticsHandler.addBreed("Husky", "S", "Ppy", "H", "bgras");
		EntityInit.registerEntity("dog", EntityDog.class, 120, 100, Color.WHITE.getRGB(), Color.GRAY.getRGB());
		RenderingRegistry.registerEntityRenderingHandler(EntityDog.class, new IRenderFactory<EntityDog>() {

			@Override
			public Render<? super EntityDog> createRenderFor(RenderManager manager) {
				return new RenderDog(manager);
			}
		});
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
