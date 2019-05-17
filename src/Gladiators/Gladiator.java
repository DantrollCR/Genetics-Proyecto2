package Gladiators;

public class Gladiator {
	private int ID;
	private int Age;	
	private int Prob_nextGen;
	private int Gen_surivive;
	private int Emotions;
	private int Phisique;
	private int Upper_strength;
	private int Lower_strenght;
	private int Resist;
	private int[] Cromosome;
	private int fitness;
	
	public int getFitness() {
		return fitness;
	}
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	public int getCromosome(int i) {
		return Cromosome[i];
	}
	public int[] getCromosome() {
		return Cromosome;
	}


	public void setCromosome(int[] cromosome) {
		this.Cromosome = cromosome;
	}


	public Gladiator(int[] cromosome) {
		Cromosome = cromosome;
		ID = cromosome[0];
		Age = cromosome[1];
		Prob_nextGen = cromosome[2];
		Gen_surivive = cromosome[3];
		Emotions = cromosome[4];
		Phisique = cromosome[5];
		Upper_strength = cromosome[6];
		Lower_strenght = cromosome[7];
		Resist = cromosome[8];
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public int getProb_nextGen() {
		return Prob_nextGen;
	}


	public void setProb_nextGen(int prob_nextGen) {
		Prob_nextGen = prob_nextGen;
	}


	public int getGen_surivive() {
		return Gen_surivive;
	}


	public void setGen_surivive(int gen_surivive) {
		Gen_surivive = gen_surivive;
	}


	public int getEmotions() {
		return Emotions;
	}


	public void setEmotions(int emotions) {
		Emotions = emotions;
	}


	public int getPhisique() {
		return Phisique;
	}


	public void setPhisique(int phisique) {
		Phisique = phisique;
	}


	public int getUpper_strength() {
		return Upper_strength;
	}


	public void setUpper_strength(int upper_strength) {
		Upper_strength = upper_strength;
	}


	public int getLower_strenght() {
		return Lower_strenght;
	}


	public void setLower_strenght(int lower_strenght) {
		Lower_strenght = lower_strenght;
	}


	public int getResist() {
		return Resist;
	}


	public void setResist(int resist) {
		Resist = resist;
	}
	public void printCromosome() {
		for (int i = 1; i < Cromosome.length; i++) {
			System.out.print(Cromosome[i]+",");
			
		}
		System.out.println("");
	}
}
