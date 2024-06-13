package grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

	// Método para realizar una búsqueda en profundidad (DFS) en el grafo y obtener
	// el camino recorrido
	public static List<Integer> dfsCamino(Grafo grafo, int inicio) {
		boolean[] visitados = new boolean[grafo.getNumVertices()]; // Array para marcar los vértices visitados
		List<Integer> camino = new ArrayList<>(); // Lista para almacenar el camino recorrido
		Stack<Integer> stack = new Stack<>(); // Pila para gestionar los vértices a visitar
		stack.push(inicio); // Comenzar desde el vértice inicial

		// Mientras la pila no esté vacía
		while (!stack.isEmpty()) {
			int verticeActual = stack.pop(); // Obtener el siguiente vértice a visitar

			// Si el vértice actual no ha sido visitado
			if (!visitados[verticeActual]) {
				visitados[verticeActual] = true; // Marcar el vértice como visitado
				camino.add(verticeActual); // Añadir el vértice al camino recorrido

				// Explorar los vecinos del vértice actual
				for (int i = 0; i < grafo.getNumVertices(); i++) {
					// Si hay una arista desde el vértice actual al vecino y el vecino no ha sido
					// visitado
					if (grafo.getMatrizAdyacencia()[verticeActual][i] > 0 && !visitados[i]) {
						stack.push(i); // Añadir el vecino a la pila para visitarlo
					}
				}
			}
		}

		return camino; // Retornar el camino recorrido
	}
}