import java.io.IOException;
import java.util.Random;

import org.json.simple.parser.ParseException;

import Gladiators.Gladiator;
import Gladiators.Population;
import Json.Json_editor;

public class Genetic {
	int generations;
	private Gladiator glad;
	Json_editor json = new Json_editor();
	int size;
	private int[] goal = { 9, 5, 9, 3, 7, 9, 9 };
	Random rand = new Random();
	Population popu = new Population(goal);
	int[] createGen() {
		int id = rand.nextInt(999999);

		int array[] = { id, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 1; i < 9; i++) {
			array[i] = rand.nextInt(10);
		}
		return array;
	}

	int[] mutate(int[] arr) {
		int s = rand.nextInt(9);
		int p = rand.nextInt(100) / 100;

		if (s == 0 || arr[s] == 10 || arr[s] == 1 ) {
			arr = mutate(arr);
		} else if(p>=0.20) {

			int k = arr[s];
			int d = k + 1;
			arr[s] = d;
		}else if(p<0.05) {

			int k = arr[s];
			int d = k -1;
			arr[s] = d;
		}
		return arr;
	}



	Gladiator crossover(Gladiator p1, Gladiator p2) {
		int id = rand.nextInt(999999);
		int p = rand.nextInt(100) / 100;
		int[] array = { id, 0, 0, 0, 0, 0, 0, 0, 0 };
		
		if (p >= 0.50) {
			for (int i = 1; i < 5; i++) {
				array[i] = p1.getCromosome(i);
			}
			for (int i = 5; i < 9; i++) {
				array[i] = p2.getCromosome(i);
			}
		}
		else if (p<0.50) {
			for (int i = 1; i < 5; i++) {
				array[i] = p2.getCromosome(i);
			}
			for (int i = 5; i < 9; i++) {
				array[i] = p1.getCromosome(i);
			}
		}
//		else if(p>=0.10) {
//			int counter =0;
//			int i=0;
//			int j=1;
//			while(j<9) {
//				array[i] = p1.getCromosome(i);
//				array[i] = p2.getCromosome(j);
//				counter++;
//				i+=2;
//				j+=2;
//			}
//		}

		Gladiator hijo = new Gladiator(array);
		return hijo;

	}
	void init(int size) {
		
	}
	void newgeneration() {

		int count = 0;
		Gladiator son = null;

		boolean stop = false;
		while(stop==false) {

			son = crossover(popu.getFittest(1),popu.getFittest(2));
			son.setCromosome(mutate(son.getCromosome()));

			stop=true;
//			int id1 = popu.get(0).getID();
//			int id2 = popu.get(2).getID();
//
//			if(id1!=id2) {
//			son = aparear(popu.getE(id1),popu.getE(id2));
//			son.setCromosome(mutate(son.getCromosome()));
//			stop=true;
//			}
		}
		popu.clear();
		while(count<size) {
			Gladiator gladi = new Gladiator(createGen());
			popu.add(gladi);
			count++;
		}
		popu.head(son);

		popu.fitness();
		popu.sort(0, size-1);

		generations++;

		//printPopu();
	}
	void run(int size) throws IOException, ParseException {
		this.size = size;
		int generation = 0;
		int count = 0;
		generations++;
		count = 0;
		while(count<size) {
			Gladiator gladi = new Gladiator(createGen());
			popu.add(gladi);
			count++;
		}
		popu.fitness();
		//json.createJson(popu);
		System.out.println("Primera Generación: ");
		//printPopu();
		while(popu.getFittest(1).getFitness()<7){
		newgeneration();
		}


//		while(popu.getFittest() <2) {
//
//			Gladiator hijo = aparear(popu.get(size),popu.get(size-1));
//			popu.Fitness();
//
//			popu.sort(0, popu.size()-1);
//
//			popu.head(hijo);
//			count++;
//		}

		System.out.println("\n"+"DESPUES DE CROSSOVER");
		//printPopu();
		System.out.println("Generaciones: "+generations);

	}
	void printPopu() {
		for (int i = 0; i < popu.size(); i++) {
			System.out.println("");
			for (int j = 0; j < goal.length+1; j++) {
				System.out.print(popu.get(i).getCromosome(j)+",");
			}
			System.out.print(": Fitness= " + popu.get(i).getFitness());
		}
		System.out.println(" ");
	}
	public String getPopuJson() throws IOException {
		String s = json.getString_json(json.createJson(popu));
		return s;
	}
	}





