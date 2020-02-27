package solaralpha.doggo.geneticsHandler;

import net.minecraft.entity.Entity;
import solaralpha.doggo.entity.EntityDog;

public class Genetics {
	private EntityDog dog;
	
	private String genotype;
	
	public Genetics(EntityDog dog) {
		this.dog = dog;
	}
	
	public Genetics(EntityDog dog, Genetics mom, Genetics dad) {
		this.dog = dog;
	}
	
	private String getGenotype() {
		return genotype;
	}
	
	private void setGenotype(String genotype) {
		this.genotype = genotype;
	}
	
	private Phenotype getPhenotype() {
		return new Phenotype(this.dog);
	}
	
	public static boolean usesGenetics(Entity thing) {
		if (thing instanceof EntityDog) return true;
		return false;
	}
}
