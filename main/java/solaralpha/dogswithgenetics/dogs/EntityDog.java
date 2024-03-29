package solaralpha.dogswithgenetics.dogs;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import solaralpha.dogswithgenetics.dogs.genetics.GeneticsHandler;
import solaralpha.dogswithgenetics.dogs.model.ModelHusky;
import solaralpha.dogswithgenetics.gui.DogGuiScreen;
import solaralpha.dogswithgenetics.item.ItemInfoStick;

public abstract class EntityDog extends EntityWolf{
	protected static final DataParameter<String> DOG_GENOTYPE = EntityDataManager.<String>createKey(EntityDog.class, DataSerializers.STRING);
	protected static final DataParameter<String> BREEDING_GENOTYPE = EntityDataManager.<String>createKey(EntityDog.class, DataSerializers.STRING);

	public EntityDog(World worldIn) {
		super(worldIn);
	}
	
	public boolean canMateWith(EntityAnimal otherAnimal) {
		if (otherAnimal == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(otherAnimal instanceof EntityDog)) {
			return false;
		} else {
			EntityDog dog = (EntityDog) otherAnimal;

			if (!dog.isTamed()) {
				return false;
			} else if (dog.isSitting()) {
				return false;
			} else {
				if(GeneticsHandler.isMale(this.getGenotype()) == GeneticsHandler.isMale(this.getGenotype())) {
					return false;
				}else
				if (this.isInLove() && dog.isInLove()) {
					this.dataManager.register(BREEDING_GENOTYPE, GeneticsHandler.createGenotypeFromParents(this.getGenotype(), dog.getGenotype()));
					}
				}
				return this.isInLove() && dog.isInLove();
			}
		}
	
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("Genotype", this.getGenotype());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setGenotype(compound.getString("Genotype"));
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		
        if (itemstack.getItem() instanceof ItemInfoStick){
            processInteractHelper();
        }
        
		return super.processInteract(player, hand);
		
	}
	
	public String getGenotype() {
		return this.dataManager.get(DOG_GENOTYPE);
	}
	
	public void setGenotype(String genotype) {
		this.dataManager.set(DOG_GENOTYPE, genotype);
	}
	
	@SideOnly(Side.CLIENT)
	public void processInteractHelper() {
		Minecraft.getMinecraft().displayGuiScreen(new DogGuiScreen(this));
	}
}
