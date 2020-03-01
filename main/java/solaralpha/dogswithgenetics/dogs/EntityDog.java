package solaralpha.dogswithgenetics.dogs;

import java.util.Random;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import solaralpha.dogswithgenetics.dogs.genetics.GeneticsHandler;

public class EntityDog extends EntityWolf{
	private static final DataParameter<String> DOG_GENOTYPE = EntityDataManager.<String>createKey(EntityDog.class, DataSerializers.STRING);

	public EntityDog(World worldIn) {
		super(worldIn);
	}
	
	protected void entityInit() {
		super.entityInit();
		Random r = new Random();
		this.dataManager.register(DOG_GENOTYPE, GeneticsHandler.createRandomGenotypeByBreed(GeneticsHandler.breedList.get(r.nextInt(GeneticsHandler.breedList.size()))));
	}
	
}
