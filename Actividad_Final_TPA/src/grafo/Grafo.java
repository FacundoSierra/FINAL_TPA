package grafo;

import juego.Heroe;
import juego.Villano;

public class Grafo {
	private int numVertices; // Número de vértices en el grafo
	private static int[][] matrizAdyacencia1; // Matriz de adyacencia para representar el grafo
	private Villano[] villanos; // Array de villanos, uno por vértice
	private Heroe heroe; // Referencia al héroe en el grafo

	// Constructor para inicializar el grafo con un número específico de vértices
	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		matrizAdyacencia1 = new int[numVertices][numVertices];
		villanos = new Villano[numVertices];
	}

	// Método para agregar una arista al grafo con un peso específico
	public void agregarArista(int origen, int destino, int peso) {
		matrizAdyacencia1[origen][destino] = peso;
	}

	// Método para imprimir la matriz de adyacencia del grafo
	public static void imprimirMatrizAdyacencia() {
		System.out.println("MATRIZ DE ADYACENCIA:");
		System.out.println("---------------------");
		int[][] matrizAdyacencia = matrizAdyacencia1;
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			for (int j = 0; j < matrizAdyacencia[i].length; j++) {
				System.out.print("[" + matrizAdyacencia[i][j] + "]");
			}
			System.out.println();
		}
	}

	// Método para obtener el número de vértices en el grafo
	public int getNumVertices() {
		return numVertices;
	}

	// Método para obtener la matriz de adyacencia del grafo
	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia1;
	}

	// Método para asignar un villano a un vértice específico
	public void asignarVillano(int vertice, Villano villano) {
		villanos[vertice] = villano;
	}

	// Método para obtener el villano en un vértice específico
	public Villano getVillano(int vertice) {
		return villanos[vertice];
	}

	// Método para obtener el villano en un vértice específico (versión redundante)
	public Villano getVillano_Tablero(int vertice) {
		if (vertice < 0 || vertice >= villanos.length) {
			return null;
		}
		return villanos[vertice];
	}

	// Método para agregar un villano a un vértice específico
	public void agregarVillano(int vertice, Villano villano) {
		if (vertice >= 0 && vertice < villanos.length) {
			villanos[vertice] = villano;
		}
	}

	// Método para asignar el héroe al grafo
	public void setHeroe(Heroe heroe) {
		this.heroe = heroe;
	}

	// Método para imprimir el tablero del grafo con la posición del héroe y los
	// villanos
	public void imprimirTablero() {
		for (int i = 0; i < villanos.length; i++) {
			if (heroe.getPosicion() == i) { // Verificar si el héroe está en el vértice
				System.out.println("Vertice " + i + ": Heroe");
			} else if (villanos[i] != null) { // Verificar si hay un villano en el vértice
				System.out.println("Vertice " + i + ": " + villanos[i].getNombre());
			} else { // Si no hay ni héroe ni villano, el vértice está vacío
				System.out.println("Vertice " + i + ": Vacio");
			}
		}
	}
}