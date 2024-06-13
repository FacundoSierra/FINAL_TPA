package grafo;

import java.util.List;
import java.util.Random;

import juego.Habilidad;
import juego.Heroe;
import juego.SistemaCombate;
import juego.Villano;

public class Main {

	// Método principal para ejecutar el programa
	public static void main(String[] args) {

		Random asignacion_villano = new Random(); // Generador de números aleatorios para asignar villanos a vértices
		Random asignacion_nivel = new Random(); // Generador de números aleatorios para asignar niveles de habilidad

		// Crear el héroe y su árbol de habilidades
		Habilidad habilidadPrincipalHeroe = new Habilidad("Fuego", "", 1); // Tipo de habilidad del héroe
		Heroe heroe = new Heroe("Heroe", habilidadPrincipalHeroe, 2); // Crear héroe con vida inicial de 2

		// Agregar una habilidad secundaria al héroe
		heroe.getArbolHabilidades().agregarHabilidad(habilidadPrincipalHeroe,
				new Habilidad("Llamarada", "Ataque", asignacion_nivel.nextInt(14)), null);

		// Crear el grafo dirigido y ponderado
		Grafo grafo = new Grafo(6);
		grafo.agregarArista(0, 1, 5); // Añadir arista de vértice 0 a vértice 1 con peso 5
		grafo.agregarArista(1, 3, 7);
		grafo.agregarArista(3, 2, 10);
		grafo.agregarArista(2, 4, 3);
		grafo.agregarArista(4, 5, 1);
		grafo.agregarArista(3, 5, 15);

		grafo.setHeroe(heroe); // Asignar el héroe al grafo posicion 0

		// Crear villanos y asignarlos a los vértices
		Villano villano1 = new Villano("Villano1", new Habilidad("Oscuridad", "", 1));
		villano1.getArbolHabilidades().agregarHabilidad(villano1.getArbolHabilidades().getRaiz().getValor(),
				new Habilidad("Sombra", "Ataque", asignacion_nivel.nextInt(14)), null);

		grafo.agregarVillano(asignacion_villano.nextInt(5) + 1, villano1); // Asignar villano1 a un vértice aleatorio

		Villano villano2 = new Villano("Villano2", new Habilidad("Veneno", "", 1));
		villano2.getArbolHabilidades().agregarHabilidad(villano2.getArbolHabilidades().getRaiz().getValor(),
				new Habilidad("Toxina", "Ataque", asignacion_nivel.nextInt(14)), null);

		grafo.agregarVillano(asignacion_villano.nextInt(5) + 1, villano2); // Asignar villano2 a un vértice aleatorio

		Villano villano3 = new Villano("Villano3", new Habilidad("Magia", "", 1));
		villano3.getArbolHabilidades().agregarHabilidad(villano3.getArbolHabilidades().getRaiz().getValor(),
				new Habilidad("Polvo de Hada", "Ataque", asignacion_nivel.nextInt(14)), null);

		grafo.agregarVillano(asignacion_villano.nextInt(5) + 1, villano3); // Asignar villano3 a un vértice aleatorio

		// Imprimir los árboles de habilidades del héroe y los villanos

		System.out.println("--------------------------------------");
		System.out.println("ARBOL DE HABLIDADES DE LOS PERSONAJES:");
		System.out.println("--------------------------------------");
		heroe.imprimirArbolHabilidades();
		villano1.imprimirArbolHabilidades();
		villano2.imprimirArbolHabilidades();
		villano3.imprimirArbolHabilidades();

		System.out.println("---------------------------------------");
		// Imprimir la matriz de adyacencia del grafo
		grafo.imprimirMatrizAdyacencia();

		System.out.println("---------------------------------");

		System.out.println("BUSQUEDA DE VILLANOS MEDIANTE DFS:");
		System.out.println("---------------------------------");
		// Obtener el camino utilizando DFS y buscar villanos en cada vértice del camino
		List<Integer> caminoDFS = DFS.dfsCamino(grafo, 0);
		for (int vertice : caminoDFS) {
			System.out.println("Buscamos villano en vertice: " + vertice);
			SistemaCombate.reconocer(grafo, heroe, vertice); // Reconocer villanos en el vértice actual
		}

		System.out.println("----------------------");

		System.out.println("TABLERO DE LA PARTIDA:");
		System.out.println("----------------------");
		grafo.imprimirTablero(); // Imprimir el estado inicial del tablero

		System.out.println("-------------------------------------");
		// Obtener el camino utilizando Dijkstra y mover al héroe por los vértices del
		// camino
		System.out.println("CAMINO DEL HEROE UTILIZANDO DIJKSTRA:");
		System.out.println("-------------------------------------");
		List<Integer> caminoDijkstra = Dijkstra.dijkstraCamino(grafo, 0, 5);

		for (int vertice : caminoDijkstra) {
			if (heroe.getVida() > 0) { // Verificar si el héroe sigue vivo
				System.out.println("Moviendose al vertice " + vertice);
				SistemaCombate.combatir(grafo, heroe, vertice); // Combatir villanos en el vértice actual
			} else {
				System.out.println("EL HEROE SE HA MUERTO");
				break; // Terminar el bucle si el héroe muere
			}
		}
		System.out.println("---------------------------------");
	}
}