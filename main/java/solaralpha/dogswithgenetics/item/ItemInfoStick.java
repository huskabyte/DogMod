package solaralpha.dogswithgenetics.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import solaralpha.dogswithgenetics.Main;
import solaralpha.dogswithgenetics.init.StickStuff;
import solaralpha.dogswithgenetics.proxy.ClientProxy;

public class ItemInfoStick extends Item implements IHasModel 
{
	public ItemInfoStick(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		StickStuff.ITEMS.add(this);
	}
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	

}
