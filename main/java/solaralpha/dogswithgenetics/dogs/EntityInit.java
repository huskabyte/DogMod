package solaralpha.dogswithgenetics.dogs;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import solaralpha.dogswithgenetics.Main;
import solaralpha.dogswithgenetics.References;

public class EntityInit {
		public static void registerEntity(String name, Class<? extends Entity> entityClass, int id, int range, int color1, int color2) {
			EntityRegistry.registerModEntity(new ResourceLocation(References.MODID + ":" + name), entityClass, name, id, Main.instance, range, 1, true, color1, color2);;
		}
}
