package Gladiators;

import java.util.Random;
import Gladiators.GladiatorNode;
import Json.Json_editor;
import Gladiators.Gladiator;

/**
 * Lista doblemente enlazada, utilizada para 
 * almacenar Gladiadores.
 * @author dantroll
 *
 */
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
	 * Remueve un nodo a partir del Gladiador que hay en él. Compara cada Gladeto con
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
	 * Obtiene el Gladiador de un nodo, a partir de un indice especificado. Recorre
	 * los nodos y cuando llega al nodo deseado retorna el Gladeto dentro de ese
	 * nodo.
	 * 
	 * @param i
	 * @return
	 */
	public Gladiator getE(int id) {
		int count = 0;
		GladiatorNode temporal = this.head;

		while (temporal!=null) {
			if(temporal.getGlad().getID()==id) {
				return temporal.getGlad();
			}
			else {
			temporal = temporal.getNext();
			count++;}
			
		}
		return null;
		
	}
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
/**
 * Funcion utilizada para reemplazar un Gladiador hijo-mejorado-,
 * con uno random de la poblaciòn.
 * @param Glad
 */
	public void replace(Gladiator Glad) {
		int p = rand.nextInt(this.size);
		GladiatorNode temporal = this.head;
		int count = 0;
		while (count <p) {
			temporal = temporal.getNext();
			count++;
		}
		temporal.setGlad(Glad);
	}
	public void head(Gladiator Glad) {
		this.head.setGlad(Glad);
	}
public int getSize() {
	return this.size;
}
/**
 * Obtiene al mejor Gladiador, basado en sus atributos 
 * y su valor de fitness.
 * @param i
 * @return
 */
public Gladiator getFittest(int i) {
	Gladiator fit = null;
	GladiatorNode temporal = this.head;
	int count =0;
	fit = get(size-i);
	return fit;
}
/**
 * Se calcula el "fitness" de cada gladiador, comparando sus 
 * atribtos con el individuo "base" al cual deben llegar.
 * 
 */
public void fitness() {
	int fitness =0;
	int count = 0;
	GladiatorNode temporal = this.head;
	while (count <size) {
		fitness=0;
		for (int i = 0; i < goal.length; i++) {
			
			if(temporal.getGlad().getCromosome(i+1)==goal[i])
			{
				fitness++;
			}
		}
		temporal.getGlad().setFitness(fitness);
		temporal = temporal.getNext();
		count++;
	}
}



int partition(int low,int high) 
{ 
    int pivot = get(high).getFitness();  
    int i = (low-1);
    for (int j=low; j<high; j++) 
    { 
        if (get(j).getFitness() <= pivot) 
        { 
            i++; 
            Gladiator temp = get(i); 
            geta(i).setGlad(get(j)); 
            geta(j).setGlad(temp); 
        } 
    } 

    Gladiator temp = get(i+1); 
    geta(i+1).setGlad(get(high)); 
    geta(high).setGlad(temp); 

    return i+1; 
} 

/**
 * QuickSort utilizado para reordenar los Gladiadores.
 * @param low
 * @param high
 */
public void sort(int low, int high) 
{ 
    if (low < high) 
    { 
        int pi = partition(low, high); 
        sort(low, pi-1); 
        sort(pi+1, high); 
    } 
}}




