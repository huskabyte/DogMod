package solaralpha.doggo.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import solaralpha.doggo.StaticInfo;

public class DoggoTab extends CreativeTabs {

	public DoggoTab() {
		super(StaticInfo.MODID);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.SPAWN_EGG);
	}

}