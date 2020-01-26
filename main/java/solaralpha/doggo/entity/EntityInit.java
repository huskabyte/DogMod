package solaralpha.doggo.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import solaralpha.doggo.Main;
import solaralpha.doggo.StaticInfo;

public class EntityInit {
	public static void registerEntity(String name, Class<? extends Entity> entityClass, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(StaticInfo.MODID + ":" + name), entityClass, name, id, Main.instance, range, 1, true, color1, color2);;
	}
}