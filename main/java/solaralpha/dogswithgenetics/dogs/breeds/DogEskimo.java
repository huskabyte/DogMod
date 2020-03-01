package solaralpha.dogswithgenetics.dogs.breeds;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import solaralpha.dogswithgenetics.dogs.EntityDog;
import solaralpha.dogswithgenetics.dogs.genetics.GeneticsHandler;

public class DogEskimo extends EntityDog{

	public DogEskimo(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		Random r = new Random();
		this.dataManager.register(DOG_GENOTYPE, GeneticsHandler.createRandomGenotypeByBreed("Eskimo"));
	}
	
	protected void initEntityAI()
    {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIMate(this, 1.0D, EntityDog.class));
        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(9, new EntityAIBeg(this, 8.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityAnimal.class, false, new Predicate<Entity>()
        {
            public boolean apply(@Nullable Entity p_apply_1_)
            {
                return p_apply_1_ instanceof EntitySheep || p_apply_1_ instanceof EntityRabbit;
            }
        }));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, AbstractSkeleton.class, false));
    }
	
	public boolean canMateWith(EntityAnimal otherAnimal) {
		if (otherAnimal == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(otherAnimal instanceof DogHusky) && !(otherAnimal instanceof DogEskimo)) {
			return false;
		} else {
			EntityDog dog = (EntityDog) otherAnimal;

			if (!dog.isTamed()) {
				return false;
			} else if (dog.isSitting()) {
				return false;
			} else {
				if(GeneticsHandler.isMale(this.getGenotype()) == GeneticsHandler.isMale(dog.getGenotype())) {
					return false;
				}else
				if (this.isInLove() && dog.isInLove()) {
					this.dataManager.register(BREEDING_GENOTYPE, GeneticsHandler.createGenotypeFromParents(this.getGenotype(), dog.getGenotype()));
					}
				}
				return this.isInLove() && dog.isInLove();
			}
		}
	
	@Override
	public EntityDog createChild(EntityAgeable ageable) {
		if(GeneticsHandler.getBody(this.dataManager.get(BREEDING_GENOTYPE)).equals("HH")) {
			EntityDog dog = new DogHusky(world);
			dog.setGenotype(this.dataManager.get(BREEDING_GENOTYPE));
			return dog;
		}else if(GeneticsHandler.getBody(this.dataManager.get(BREEDING_GENOTYPE)).equals("EE")) {
			EntityDog dog = new DogEskimo(world);
			dog.setGenotype(this.dataManager.get(BREEDING_GENOTYPE));
			return dog;
		}
		return null;
	}

}
