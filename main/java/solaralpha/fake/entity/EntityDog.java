package solaralpha.fake.entity;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityDog extends EntityWolf {

	private static final DataParameter<Integer> DOG_COLOR = EntityDataManager.<Integer>createKey(EntityDog.class,
			DataSerializers.VARINT);
	private static final DataParameter<Integer> DOG_EYE_COLOR = EntityDataManager.<Integer>createKey(EntityDog.class,
			DataSerializers.VARINT);
	private static final DataParameter<Integer> DOG_SIZE = EntityDataManager.<Integer>createKey(EntityDog.class,
			DataSerializers.VARINT);
	private static final DataParameter<Integer> DOG_BODY = EntityDataManager.<Integer>createKey(EntityDog.class,
			DataSerializers.VARINT);

	private static final DataParameter<String> DOG_GENOTYPE = EntityDataManager.<String>createKey(EntityDog.class,
			DataSerializers.STRING);
	private static final DataParameter<String> BREEDING_GENOTYPE = EntityDataManager.<String>createKey(EntityDog.class,
			DataSerializers.STRING);

	public EntityDog(World worldIn) {
		super(worldIn);
	}

	protected void entityInit() {
		super.entityInit();
		this.setRandomGenotype();
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("Genotype", this.getGenotype());
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setGenotype(compound.getString("Genotype"));
		System.out.println(this.dataManager.get(DOG_GENOTYPE));
	}

	@Override
	public EntityDog createChild(EntityAgeable ageable) {
		EntityDog dog = new EntityDog(world);
		dog.setGenotype(this.dataManager.get(BREEDING_GENOTYPE));
		return dog;
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
				if (this.isInLove() && dog.isInLove()) {
					Random r = new Random();
					String[] splitGenes = this.getGenotype().split("\\s+");
					ArrayList<Character> newGenotype = new ArrayList<Character>();
					for (int i = 0; i < splitGenes.length; i++) {
						newGenotype.add(splitGenes[i].charAt(r.nextInt(2)));
					}
					splitGenes = dog.getGenotype().split("\\s+");
					for (int i = 0; i < splitGenes.length; i++) {
						newGenotype.add(splitGenes[i].charAt(r.nextInt(2)));
					}
					
					StringBuffer str= new StringBuffer("");
					
					for (int i = 0; i < splitGenes.length; i++) {
						str.append(newGenotype.get(i));
						str.append(newGenotype.get(i) + splitGenes.length);
						str.append(" ");
					}
					
					this.dataManager.register(BREEDING_GENOTYPE, str.toString());
				}
				return this.isInLove() && dog.isInLove();
			}
		}
	}

	public String getGenotype() {
		return this.dataManager.get(DOG_GENOTYPE);
	}

	public void readFromGenotype() {
		String genotype = this.dataManager.get(DOG_GENOTYPE);
		if (genotype.contains("b")) {
			this.dataManager.set(DOG_COLOR, 3);
		} else if (genotype.contains("g")) {
			this.dataManager.set(DOG_COLOR, 2);
		} else if (genotype.contains("r")) {
			this.dataManager.set(DOG_COLOR, 1);
		} else {
			this.dataManager.set(DOG_COLOR, 0);
		}

		if (genotype.contains("P")) {
			this.dataManager.set(DOG_EYE_COLOR, 3);
		} else if (genotype.contains("py")) {
			this.dataManager.set(DOG_EYE_COLOR, 2);
		} else if (genotype.contains("pp")) {
			this.dataManager.set(DOG_EYE_COLOR, 1);
		} else {
			this.dataManager.set(DOG_EYE_COLOR, 0);
		}

		if (genotype.contains("LL")) {
			this.dataManager.set(DOG_SIZE, 2);
		} else if (genotype.contains("ll")) {
			this.dataManager.set(DOG_SIZE, 0);
		} else {
			this.dataManager.set(DOG_SIZE, 1);
		}

		if (genotype.contains("H") || genotype.contains("hh")) {
			this.dataManager.set(DOG_BODY, 1);
		} else {
			this.dataManager.set(DOG_BODY, 0);
		}
	}

	public int getCoat() {
		return (Integer) this.dataManager.get(DOG_COLOR).intValue();
	}

	public int getEyes() {
		return (Integer) this.dataManager.get(DOG_EYE_COLOR).intValue();
	}

	public int getSize() {
		return (Integer) this.dataManager.get(DOG_SIZE).intValue();
	}

	public int getBody() {
		return (Integer) this.dataManager.get(DOG_BODY).intValue();
	}

	public void setGenotype(String genotype) {
		this.dataManager.set(DOG_GENOTYPE, genotype);
		this.readFromGenotype();
	}

	//

	public void setRandomGenotype() {
		Random r = new Random();
		int random = r.nextInt(15);
		int colorDataValue = 0;
		int eyecolorDataValue;
		int breedValue;
		for (int i = 0; i < 5; i++) {
			if (random <= i) {
				colorDataValue = i;
				break;
			}
			random -= (i + 1);
		}
		random = r.nextInt(7);
		if (random < 3) {
			eyecolorDataValue = random;
		} else {
			eyecolorDataValue = 3;
		}
		random = r.nextInt(2);
		breedValue = random;
		this.dataManager.register(DOG_COLOR, Integer.valueOf(colorDataValue));
		this.dataManager.register(DOG_EYE_COLOR, Integer.valueOf(eyecolorDataValue));
		this.dataManager.register(DOG_BODY, Integer.valueOf(breedValue));
		this.dataManager.register(DOG_SIZE, Integer.valueOf(breedValue));

		this.dataManager.register(DOG_GENOTYPE, "");

		String color = "";
		String eyecolor = "";
		String breed = "";
		String size = "";

		// COAT COLOR
		if ((Integer) this.dataManager.get(DOG_COLOR).intValue() == 0 || (breedValue == 0)) {
			// White

			color = "ss";
		} else if ((Integer) this.dataManager.get(DOG_COLOR).intValue() == 1) {
			// Agouti

			int i = r.nextInt(2);
			if (i == 0) {
				color = "as";
			} else if (i == 1) {
				color = "aa";
			}
		} else if ((Integer) this.dataManager.get(DOG_COLOR).intValue() == 2) {
			// Red

			int i = r.nextInt(3);
			if (i == 0) {
				color = "rs";
			} else if (i == 1) {
				color = "ra";
			} else if (i == 2) {
				color = "rr";
			}
		} else if ((Integer) this.dataManager.get(DOG_COLOR).intValue() == 3) {
			// Gray

			int i = r.nextInt(4);
			if (i == 0) {
				color = "gs";
			} else if (i == 1) {
				color = "ga";
			} else if (i == 2) {
				color = "gr";
			} else if (i == 3) {
				color = "gg";
			}
		} else if ((Integer) this.dataManager.get(DOG_COLOR).intValue() == 4) {
			// Black

			int i = r.nextInt(5);
			if (i == 0) {
				color = "bs";
			} else if (i == 1) {
				color = "ba";
			} else if (i == 2) {
				color = "br";
			} else if (i == 3) {
				color = "bg";
			} else if (i == 4) {
				color = "bb";
			}
		}

		// EYE COLOR
		if ((Integer) this.dataManager.get(DOG_EYE_COLOR).intValue() == 0) {
			// Blue

			eyecolor = "yy";
		} else if ((Integer) this.dataManager.get(DOG_EYE_COLOR).intValue() == 1) {
			// Green

			eyecolor = "pp";
		} else if ((Integer) this.dataManager.get(DOG_EYE_COLOR).intValue() == 2) {
			// Bi

			eyecolor = "py";
		} else if ((Integer) this.dataManager.get(DOG_EYE_COLOR).intValue() == 3) {
			// Brown

			int i = r.nextInt(3);
			if (i == 0) {
				eyecolor = "PP";
			} else if (i == 1) {
				eyecolor = "Pp";
			} else if (i == 2) {
				eyecolor = "Py";
			}
		}

		// BREED
		if ((Integer) this.dataManager.get(DOG_SIZE).intValue() == 0) {
			size = "ll";
		} else if ((Integer) this.dataManager.get(DOG_SIZE).intValue() == 1) {
			size = "Ll";
		} else {
			size = "LL";
		}

		if ((Integer) this.dataManager.get(DOG_SIZE).intValue() == 0) {
			breed = "Ee";
		} else if ((Integer) this.dataManager.get(DOG_SIZE).intValue() == 1) {
			breed = "Hh";
		}
		this.setGenotype(color + " " + eyecolor + " " + size + " " + breed);
	}
}
