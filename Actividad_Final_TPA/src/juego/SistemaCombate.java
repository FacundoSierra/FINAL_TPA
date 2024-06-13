package juego;

import grafo.Grafo;

public class SistemaCombate {
	private static Nodo nodo; // Nodo utilizado para cálculos internos (suponiendo su definición en otro
								// lugar)

	// Método para gestionar el combate entre el héroe y el villano en un vértice
	// específico
	public static void combatir(Grafo grafo, Heroe heroe, int vertice) {
		Villano villano = grafo.getVillano_Tablero(vertice); // Obtener el villano en el vértice especificado

		if (villano == null) {
			System.out.println("No hay villano en este vertice.\n");
			return; // No hay villano en el vértice, salir del método
		}

		System.out.println("Combatiendo contra " + villano.getNombre() + " en el vertice " + vertice);

		// Resolver el combate comparando las habilidades del héroe y el villano
		int resultadoCombate = resolverCombate(heroe.getArbolHabilidades(), villano.getArbolHabilidades());

		if (resultadoCombate > 0) {
			System.out.println("El heroe ha ganado el combate.\n");
		} else if (resultadoCombate < 0) {
			System.out.println("El villano ha ganado el combate.");
			heroe.restarVida(1); // Reducir la vida del héroe si pierde
			System.out.println("Vida restante del heroe: " + heroe.getVida() + "\n");
		} else {
			System.out.println("El combate ha terminado en empate.\n");
		}

		// Actualizar la posición del héroe al vértice actual
		heroe.setPosicion(vertice);
	}

	// Método para reconocer si hay un villano en el vértice especificado sin
	// combatir
	public static void reconocer(Grafo grafo, Heroe heroe, int vertice) {
		Villano villano = grafo.getVillano(vertice); // Obtener el villano en el vértice especificado

		if (villano == null) {
			System.out.println("No hay villano en este vertice.\n");
			return; // No hay villano en el vértice, salir del método
		}

		System.out.println("Se encuentra el " + villano.getNombre() + "\n");
	}

	/*
	 * Método para resolver el combate comparando las puntuaciones de los árboles de
	 * habilidades del héroe y el villano
	 */
	private static int resolverCombate(ArbolHabilidadesDinamico<Habilidad> arbolHeroe,
			ArbolHabilidadesDinamico<Habilidad> arbolVillano) {
		int puntuacionHeroe = calcularPuntuacion(arbolHeroe.getRaiz()); // Calcular la puntuación del héroe
		int puntuacionVillano = calcularPuntuacion(arbolVillano.getRaiz()); // Calcular la puntuación del villano

		return Integer.compare(puntuacionHeroe, puntuacionVillano); // Comparar las puntuaciones
	}

	// Método recursivo para calcular la puntuación de un árbol de habilidades a
	// partir de su raíz
	private static int calcularPuntuacion(Nodo<Habilidad> nodo) {
		if (nodo == null) {
			return 0; // Si el nodo es nulo, la puntuación es 0
		}

		int puntuacion = nodo.getValor().getNivel(); // Obtener el nivel (puntuación) de la habilidad en el nodo
		puntuacion += calcularPuntuacion(nodo.getIzquierdo()); // Calcular la puntuación del subárbol izquierdo
		puntuacion += calcularPuntuacion(nodo.getDerecho()); // Calcular la puntuación del subárbol derecho

		return puntuacion; // Retornar la puntuación total del árbol
	}
}