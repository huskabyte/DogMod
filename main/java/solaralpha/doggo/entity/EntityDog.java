package solaralpha.doggo.entity;

import java.util.Random;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityDog extends EntityWolf{
	
	private static final DataParameter<Integer> DOG_COLOR = EntityDataManager.<Integer>createKey(EntityDog.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> DOG_EYE_COLOR = EntityDataManager.<Integer>createKey(EntityDog.class, DataSerializers.VARINT);
	
	private static final DataParameter<String> DOG_GENOTYPE = EntityDataManager.<String>createKey(EntityDog.class, DataSerializers.STRING);

	public EntityDog(World worldIn) {
		super(worldIn);
	}
	
	protected void entityInit(){
        super.entityInit();
        this.setRandomGenotype();
    }
	
	public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setString("Genotype", this.getGenotype());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setGenotype(compound.getString("Genotype"));
        System.out.println(this.dataManager.get(DOG_GENOTYPE));
    }
    
    public String getGenotype() {
    	return this.dataManager.get(DOG_GENOTYPE);
    }
	
	public void readFromGenotype() {
		String genotype = this.dataManager.get(DOG_GENOTYPE);
		if(genotype.contains("b")) {
			this.dataManager.set(DOG_COLOR, 3);
		}else if(genotype.contains("g")){
			this.dataManager.set(DOG_COLOR, 2);
		}else if(genotype.contains("r")){
			this.dataManager.set(DOG_COLOR, 1);
		}else{
			this.dataManager.set(DOG_COLOR, 0);
		}
		
		if(genotype.contains("P")) {
			this.dataManager.set(DOG_EYE_COLOR, 3);
		}else if(genotype.contains("py")){
			this.dataManager.set(DOG_EYE_COLOR, 2);
		}else if(genotype.contains("pp")){
			this.dataManager.set(DOG_EYE_COLOR, 1);
		}else{
			this.dataManager.set(DOG_EYE_COLOR, 0);
		}
	}
	
	public int getCoat() {
		return (Integer)this.dataManager.get(DOG_COLOR).intValue();
	}
	
	public int getEyes() {
		return (Integer)this.dataManager.get(DOG_EYE_COLOR).intValue();
	}
	
	public void setGenotype(String genotype) {
		this.dataManager.set(DOG_GENOTYPE, genotype);
		this.readFromGenotype();
	}
	
	
	
	//
	
	
	
	public void setRandomGenotype() {
		Random r = new Random();
    	int random = r.nextInt(10);
    	int colorDataValue = 0;
    	int eyecolorDataValue;
    	for(int i = 0; i < 4; i++) {
    		if(random<=i) {
    			colorDataValue = i;
    			break;
    		}
    		random-=(i+1);
    	}
    	random = r.nextInt(7);
    	if(random < 3) {
    		eyecolorDataValue = random;
    	}else {
    		eyecolorDataValue = 3;
    	}
    	this.dataManager.register(DOG_COLOR, Integer.valueOf(colorDataValue));
    	this.dataManager.register(DOG_EYE_COLOR, Integer.valueOf(eyecolorDataValue));
    
    	this.dataManager.register(DOG_GENOTYPE, "");
    
    	String color = "";
    	String eyecolor = "";
    
    	//COAT COLOR
    	if ((Integer)this.dataManager.get(DOG_COLOR).intValue() == 0){
    		//Agouti
    	
    		color = "aa";
    	}else if((Integer)this.dataManager.get(DOG_COLOR).intValue() == 1) {
    		//Red
    	
    		if(r.nextInt(2) == 0) {
    			color = "ra";
    		}else {
    			color = "rr";
    		}
        }else if((Integer)this.dataManager.get(DOG_COLOR).intValue() == 2) {
        	//Gray
        	
        	int i = r.nextInt(3);
        	if(i==0) {
        		color = "ga";
        	}else if(i==1){
        		color = "gr";
        	}else if(i==2) {
        		color = "gg";
        	}
        }else if((Integer)this.dataManager.get(DOG_COLOR).intValue() == 3) {
        	//Black
        	
        	int i = r.nextInt(4);
        	if(i==0) {
        		color = "ba";
        	}else if(i==1){
        		color = "br";
        	}else if(i==2) {
        		color = "bg";
        	}else if(i==3) {
        		color = "bb";
        	}
        }
        
        //EYE COLOR
        if ((Integer)this.dataManager.get(DOG_EYE_COLOR).intValue() == 0){
        	//Blue
        	
        	eyecolor = "yy";
        }else if((Integer)this.dataManager.get(DOG_EYE_COLOR).intValue() == 1) {
        	//Green
        	
        	eyecolor = "pp";
        }else if((Integer)this.dataManager.get(DOG_EYE_COLOR).intValue() == 2) {
        	//Bi
        	
        	eyecolor = "py";
        }else if((Integer)this.dataManager.get(DOG_EYE_COLOR).intValue() == 3) {
        	//Brown
        	
        	int i = r.nextInt(3);
        	if(i==0) {
        		eyecolor = "PP";
        	}else if(i==1){
        		eyecolor = "Pp";
        	}else if(i==2) {
        		eyecolor = "Py";
        	}
        }
        
        this.setGenotype(color + " " + eyecolor);
	}
}
