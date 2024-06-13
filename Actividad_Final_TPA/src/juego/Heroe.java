package juego;

public class Heroe {
	private String nombre; // Nombre del héroe
	private ArbolHabilidadesDinamico<Habilidad> arbolHabilidades; // Árbol de habilidades del héroe
	private int posicion; // Posición actual del héroe en el grafo
	private int vida; // Vida del héroe

	// Constructor de la clase Heroe
	public Heroe(String nombre, Habilidad habilidadPrincipal, int vida) {
		this.nombre = nombre;
		this.arbolHabilidades = new ArbolHabilidadesDinamico<>(habilidadPrincipal); // Inicializa el árbol de
																					// habilidades con la habilidad
																					// principal
		this.vida = vida; // Establece la vida inicial del héroe
		this.posicion = 0; // Inicialmente, el héroe comienza en el vértice 0
	}

	// Método para obtener el nombre del héroe
	public String getNombre() {
		return nombre;
	}

	// Método para obtener el árbol de habilidades del héroe
	public ArbolHabilidadesDinamico<Habilidad> getArbolHabilidades() {
		return arbolHabilidades;
	}

	// Método para obtener la vida del héroe
	public int getVida() {
		return vida;
	}

	// Método para establecer la vida del héroe
	public void setVida(int vida) {
		this.vida = vida;
	}

	// Método para obtener la posición actual del héroe
	public int getPosicion() {
		return posicion;
	}

	// Método para establecer la posición actual del héroe
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	// Método para restar vida al héroe
	public void restarVida(int cantidad) {
		vida -= cantidad; // Reduce la vida del héroe
		if (vida < 0) {
			vida = 0; // La vida no puede ser negativa
		}
	}

	// Método para imprimir el árbol de habilidades del héroe
	public void imprimirArbolHabilidades() {
		System.out.println("Arbol de Habilidades del Heroe" + " (VIDA:" + vida + ")"); // Imprime la vida del héroe
		arbolHabilidades.imprimirArbol(); // Llama al método para imprimir el árbol de habilidades
	}
}