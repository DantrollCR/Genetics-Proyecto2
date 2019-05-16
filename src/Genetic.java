import java.util.Random;

import Gladiators.Gladiator;
import Gladiators.Population;

public class Genetic {
	private Population popu;
	private Gladiator glad;
	private int[] goal = { 4, 2, 5, 3, 2, 1, 8, 9 };
	Random rand = new Random();

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
		if (s == 0 || arr[s] == 10) {
			mutate(arr);
		} else {

			int k = arr[s];
			int d = k + 1;
			arr[s] = d;
		}
		return arr;
	}

	boolean fitness(Population popu) {
		for (int i = 0; i < popu.size(); i++) {
			Gladiator res;
			int res1 = ((Gladiator) popu.get(i)).getResist();
			if (res1 == 100) {
				return true;
			} else {
			}
		}
		return false;

	}

	Gladiator aparear(Gladiator p1, Gladiator p2) {
		int id = rand.nextInt(999999);
		int p = rand.nextInt(100) / 100;
		int[] array = { id, 0, 0, 0, 0, 0, 0, 0, 0 };

		for (int i = 1; i < 5; i++) {
			array[i] = p1.getCromosome(i);
		}
		for (int i = 5; i < 9; i++) {
			array[i] = p2.getCromosome(i);
		}
		if (p >= 0.90) {
			array = mutate(array);
		}
		Gladiator hijo = new Gladiator(array);
		return hijo;

	}

	void run(int size) {

		int generation = 0;
		Population popu = new Population(goal);
		int count = 0;
		while (count <= size) {
			
			Gladiator glad = new Gladiator(createGen());
			popu.add(glad);
			count++;
		}
		count = 0;
		while(popu.getFittest() <2) {

			Gladiator hijo = aparear(popu.get(size),popu.get(size-1));
			popu.Fitness();

			popu.sort(0, popu.size()-1);

			popu.head(hijo);
			count++;
		}

		System.out.println("Hola");

		for (int i = 0; i < popu.size(); i++) {
			System.out.println(popu.get(i).getFitness());
		}
		System.out.println("Despues del sort");
		for (int i = 0; i < popu.size(); i++) {
			System.out.println(popu.get(i).getFitness());
		}
		for (int i = 0; i < goal.length; i++) {
			System.out.println(popu.get(size-1).getCromosome(i));
			
		}
	}}





