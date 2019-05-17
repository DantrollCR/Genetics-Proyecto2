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
	private int[] goal = { 9, 9, 9, 9, 9, 9, 9, 9 };
	Random rand = new Random();
	Population popu = new Population(goal);
/**
 * Funcion para crear los genes, le asigna un ID y además
 * le asigna numeros aleatorios de 0 a 9, creando así un 
 * cromosoma.
 * @return
 */
	int[] createGen() {
		int id = rand.nextInt(999999);

		int array[] = { id, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 1; i < 9; i++) {
			array[i] = rand.nextInt(10);
		}
		array[8] = prom(array);
		return array;
	}
/**
 * Funcion básica para obtener un promedio.
 * @param array
 * @return
 */
	int prom(int[] array) {
		int sum = 0;
		int total = 0;
		for (int i = 1; i < array.length; i++) {
			sum += array[i];
		}
		total = sum / 7;
		return total;

	}
/**
 * Aqui se da la mutació de un espacio en el array, dependiendo
 * se le suma o resta un uno, con probabilidades de 5% y 1%
 * @param arr
 * @return
 */
	int[] mutate(int[] arr) {
		int s = rand.nextInt(7);
		int p = rand.nextInt(100) / 100;

		if (s == 0 || arr[s] == 10 || arr[s] == 1) {
			arr = mutate(arr);
		} else if (p >= 0.95) {

			int k = arr[s];
			int d = k + 1;
			arr[s] = d;
		} else if (p < 0.01) {

			int k = arr[s];
			int d = k - 1;
			arr[s] = d;
		}

		return arr;
	}
/**
 * Función encargada de "unir" los cromosomas de los 
 * mejores individuos de la iteraciòn anterior.
 * Con una probabilidad de 5% de que mute y no haga nada màs.
 * Las probabilidades de 50 son dividir el cromosoma y ponerlo 
 * en un individuo "hijo"-
 * @param p1
 * @param p2
 * @return
 */
	Gladiator crossover(Gladiator p1, Gladiator p2) {
		int id = rand.nextInt(999999);
		int p = rand.nextInt(100) / 100;
		int[] array = { id, 0, 0, 0, 0, 0, 0, 0, 0 };

		if (p > 0.50) {
			for (int i = 1; i < 5; i++) {
				array[i] = p1.getCromosome(i);
			}
			for (int i = 5; i < 8; i++) {
				array[i] = p2.getCromosome(i);
			}
		} else if (p < 0.50) {
			for (int i = 1; i < 5; i++) {
				array[i] = p2.getCromosome(i);
			}
			for (int i = 5; i < 8; i++) {
				array[i] = p1.getCromosome(i);
			}
		}
		else if (p < 0.05) {
			array = mutate(array);
		}
		array[8] = prom(array);
		Gladiator hijo = new Gladiator(array);
		return hijo;

	}

	void init(int size) {

	}
/**
 * Usada para generar las nuevas generaciones, aqui es donde se 
 * inicializan los nuevos hijos y se le dan los valores a 
 * buscar para hacer el cruce.
 */
	void newgeneration() {

		int count = 0;
		Gladiator son = null;
		Gladiator son1 = null;
		son = crossover(popu.getFittest(1), popu.getFittest(2));
		son1 = crossover(popu.getFittest(1), popu.getFittest(4));

		popu.clear();

		while (count < size) {
			Gladiator gladi = new Gladiator(createGen());
			popu.add(gladi);
			count++;
		}
		popu.replace(son);
		popu.head(son1);

		popu.fitness();
		popu.sort(0, size - 1);

		generations++;
	}
/**
 * Función de inicio, esta es la funcion que se llama en el main 
 * o en donde se necesite ejecutar el algoritmo.
 * @param size
 * @throws IOException
 * @throws ParseException
 */
public void run(int size) throws IOException, ParseException {
		popu.clear();
		generations = 0;
		this.size = size;
		int generation = 0;
		int count = 0;
		generations++;
		count = 0;
		while (count < size) {
			Gladiator gladi = new Gladiator(createGen());
			popu.add(gladi);
			count++;
		}
		popu.fitness();

		// json.createJson(popu);
		System.out.println("Primera Generación: ");
		while (popu.getFittest(1).getFitness() < 7) {
			newgeneration();
		}

		System.out.println("\n" + "DESPUES DE CROSSOVER");
		System.out.println("Generaciones: " + generations);

	}

	void printPopulation() {
		for (int i = 0; i < popu.size(); i++) {
			System.out.println("");
			for (int j = 0; j < goal.length + 1; j++) {
				System.out.print(popu.get(i).getCromosome(j) + ",");
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
