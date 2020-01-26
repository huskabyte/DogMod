package solaralpha.doggo;

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
import solaralpha.doggo.creativetabs.DoggoTab;
import solaralpha.doggo.entity.EntityDog;
import solaralpha.doggo.entity.EntityInit;
import solaralpha.doggo.entity.RenderDog;
import solaralpha.doggo.proxy.CommonProxy;

@Mod(modid = StaticInfo.MODID, name = StaticInfo.NAME, version = StaticInfo.VERSION)
public class Main {

	@Mod.Instance(StaticInfo.MODID)
	public static Main instance;
	
	@SidedProxy(serverSide = "solaralpha.doggo.proxy.CommonProxy", clientSide = "solaralpha.doggo.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	public static final DoggoTab creativeTab = new DoggoTab();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
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
