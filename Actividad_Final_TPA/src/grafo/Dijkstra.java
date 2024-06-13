package grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

	// Clase interna Nodo que representa un nodo en la cola de prioridad
	private static class Nodo implements Comparable<Nodo> {
		int vertice, peso; // vertice y peso del nodo

		Nodo(int vertice, int peso) {
			this.vertice = vertice;
			this.peso = peso;
		}

		@Override
		public int compareTo(Nodo other) {
			// Comparar nodos por peso para la cola de prioridad
			return Integer.compare(this.peso, other.peso);
		}
	}

	// Método estático para encontrar el camino más corto usando el algoritmo de
	// Dijkstra
	public static List<Integer> dijkstraCamino(Grafo grafo, int inicio, int destino) {
		int numVertices = grafo.getNumVertices(); // Número de vértices en el grafo
		int[] distancias = new int[numVertices]; // Array para almacenar las distancias mínimas
		boolean[] visitados = new boolean[numVertices]; // Array para marcar los vértices visitados
		int[] previos = new int[numVertices]; // Array para reconstruir el camino

		Arrays.fill(distancias, Integer.MAX_VALUE); // Inicializar todas las distancias a infinito
		distancias[inicio] = 0; // La distancia al vértice de inicio es 0

		PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(); // Cola de prioridad para seleccionar el nodo con la
																	// menor distancia
		colaPrioridad.add(new Nodo(inicio, 0)); // Añadir el nodo inicial a la cola

		while (!colaPrioridad.isEmpty()) {
			Nodo nodoActual = colaPrioridad.poll(); // Obtener el nodo con la menor distancia
			int verticeActual = nodoActual.vertice;

			if (visitados[verticeActual]) // Si el vértice ya fue visitado, saltar al siguiente
				continue;
			visitados[verticeActual] = true; // Marcar el vértice como visitado

			// Iterar sobre todos los vértices para actualizar las distancias
			for (int i = 0; i < numVertices; i++) {
				int pesoArista = grafo.getMatrizAdyacencia()[verticeActual][i]; // Obtener el peso de la arista
				if (pesoArista > 0 && !visitados[i]) { // Si hay una arista y el vértice no ha sido visitado
					int nuevaDistancia = distancias[verticeActual] + pesoArista; // Calcular la nueva distancia
					if (nuevaDistancia < distancias[i]) { // Si la nueva distancia es menor, actualizar
						distancias[i] = nuevaDistancia;
						previos[i] = verticeActual; // Guardar el vértice previo para reconstruir el camino
						colaPrioridad.add(new Nodo(i, nuevaDistancia)); // Añadir el vértice a la cola de prioridad
					}
				}
			}
		}

		// Reconstruir el camino desde el destino hasta el inicio
		List<Integer> camino = new ArrayList<>();
		for (int at = destino; at != inicio; at = previos[at]) {
			camino.add(at);
		}
		camino.add(inicio); // Añadir el vértice inicial al camino
		Collections.reverse(camino); // Invertir el camino para obtener la secuencia correcta

		return camino;
	}
}