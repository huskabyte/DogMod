package solaralpha.dogswithgenetics.dogs.genetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GeneticsHandler {
	private static HashMap<String, String[]> breeds = new HashMap<String, String[]>();
	public static ArrayList<String> breedList = new ArrayList<String>();
	
	public static void addBreed(String name, String size, String eyeColorPossible, String body, String bodyColor) {
		String[] attributes = new String[5];
		attributes[0] = "XY";
		attributes[1] = size;
		attributes[2] = eyeColorPossible;
		attributes[3] = body;
		attributes[4] = bodyColor;
		
		breeds.put(name, attributes);
		breedList.add(name);
	}
	
	public static String createRandomGenotypeByBreed(String breed) {
		String genotype = "";
		Random r = new Random();
		if(r.nextBoolean() == true) {
			genotype = genotype + "XX";
		}else {
			genotype = genotype + "XY";
		}
		for(int i = 1; i < breeds.get(breed).length; i++) {
			genotype = genotype + breeds.get(breed)[i].charAt(r.nextInt(breeds.get(breed)[i].length()));
			genotype = genotype + breeds.get(breed)[i].charAt(r.nextInt(breeds.get(breed)[i].length()));
		}
		
		System.out.println(genotype);
		return genotype;
	}
	
	public static boolean isMale(String genotype) {
		return genotype.substring(0, 1).equals("XY");
	}
	
	public static int getSize(String genotype) {
		if(genotype.substring(2, 3).equals("ss")) {
			return 50;
		}else if(genotype.substring(2, 3).equals("SS")) {
			return 75;
		}else {
			return 100;
		}
	}
	
	public static String getEyeColorAlleles(String genotype) {
		return genotype.substring(4, 5);
	}
	
	public static String getBody(String genotype) {
		return genotype.substring(6, 7);
	}
	
	public static String getCoatColorAlleles(String genotype) {
		return genotype.substring(8, 9);
	}
}