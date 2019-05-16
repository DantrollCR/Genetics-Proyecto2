package Gladiators;

import java.util.Random;

import Gladiators.GladiatorNode;
import Gladiators.Gladiator;

public class Population {
	private GladiatorNode head;
	private GladiatorNode tail;
	Random rand = new Random();
	private int[] goal;
	private int size = 0;

	public Population(int[] solution) {
		this.head = null;
		this.tail = null;
		this.goal = solution;

	}

	public void add(Gladiator Glad) {
		this.size += 1;

		if (head == null) {
			this.head = new GladiatorNode(Glad);
			this.tail = head;
		} else {
			GladiatorNode temp = this.tail;
			temp.linkNext(new GladiatorNode(Glad));
			this.tail = temp.getNext();
			// this.head = node;

		}

	}

	public void clear() {
		this.head = null;
		this.size = 0;
	}

	public Gladiator getFirst() {
		return this.head.getGlad();
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			System.out.println("True");
			return true;
		} else {			
			System.out.println("False: "+size );

			return false;
		}
	}

	public int size() {
		return this.size;
	}

	/**
	 * Remueve un nodo a partir del Gladeto que hay en él. Compara cada Gladeto con
	 * el introducido, y al encontrarlo elimina el nodo que lo contiene.
	 * 
	 * @param Glad
	 */
	public void remove(Gladiator Glad) {
		GladiatorNode nodo = this.head;
		if (nodo.getGlad() == Glad) {
			this.head = nodo.getNext();
			size--;
		} else {
			while (nodo.getNext() != null) {
				if (nodo.getNext().getGlad() == Glad) {
					nodo.linkNext(nodo.getNext().getNext());
					size--;
					// if(nodo.getNext() == null){
					// this.tail = nodo;
					// }
					break;
				} else {
					nodo = nodo.getNext();
				}
			}
		}
	}

	/**
	 * Obtiene el Gladeto de un nodo, a partir de un indice especificado. Recorre
	 * los nodos y cuando llega al nodo deseado retorna el Gladeto dentro de ese
	 * nodo.
	 * 
	 * @param i
	 * @return
	 */
	public Gladiator get(int i) {
		int count = 0;
		GladiatorNode temporal = this.head;

		while (count < i) {
			temporal = temporal.getNext();
			count++;
		}
		return temporal.getGlad();
	}
	public GladiatorNode geta(int i) {
		int count = 0;
		GladiatorNode temporal = this.head;

		while (count < i) {
			temporal = temporal.getNext();
			count++;
		}
		return temporal;
	}

	public void replace(Gladiator Glad) {
		int p = rand.nextInt(this.size);
		GladiatorNode temporal = this.head;
		int count = 0;
		while (count < 2) {
			temporal = temporal.getNext();
			count++;
		}
		temporal.setGlad(Glad);
		// System.out.println("Se cambiò en "+2);
	}
	public void head(Gladiator Glad) {
		this.head.setGlad(Glad);
	}

	public int getFittest() {
		return this.tail.getGlad().getFitness();
	}

	public void Fitness() {
		int fitness = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < goal.length; j++) {
				if (get(i).getCromosome(j) == goal[j]) {
					fitness++;

				}
				get(i).setFitness(fitness);

			}
		
		}
	}

int partition(int low,int high) 
{ 
    int pivot = get(high).getFitness();  
    int i = (low-1); // index of smaller element 
    for (int j=low; j<high; j++) 
    { 
        // If current element is smaller than or 
        // equal to pivot 
        if (get(j).getFitness() <= pivot) 
        { 
            i++; 

            // swap get(i] and get(j] 
            Gladiator temp = get(i); 
            geta(i).setGlad(get(j)); 
            geta(j).setGlad(temp); 
        } 
    } 

    // swap get(i+1] and get(high] (or pivot) 
    Gladiator temp = get(i+1); 
    geta(i+1).setGlad(get(high)); 
    geta(high).setGlad(temp); 

    return i+1; 
} 


/* The main function that implements QuickSort() 
  get(] --> Array to be sorted, 
  low  --> Starting index, 
  high  --> Ending index */
public void sort(int low, int high) 
{ 
    if (low < high) 
    { 
        /* pi is partitioning index, arr[pi] is  
          now at right place */
        int pi = partition(low, high); 

        // Recursively sort elements before 
        // partition and after partition 
        sort(low, pi-1); 
        sort(pi+1, high); 
    } 
}}




