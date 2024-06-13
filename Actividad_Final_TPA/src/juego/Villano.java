package juego;

public class Villano {
	private String nombre;
	private ArbolHabilidadesDinamico<Habilidad> arbolHabilidades;

	public Villano(String nombre, Habilidad habilidadInicial) {
		this.nombre = nombre;
		this.arbolHabilidades = new ArbolHabilidadesDinamico<>(habilidadInicial);
	}

	public String getNombre() {
		return nombre;
	}

	public ArbolHabilidadesDinamico<Habilidad> getArbolHabilidades() {
		return arbolHabilidades;
	}

	public void agregarHabilidad(Habilidad padre, Habilidad habilidadIzquierda, Habilidad habilidadDerecha) {
		arbolHabilidades.agregarHabilidad(padre, habilidadIzquierda, habilidadDerecha);
	}

	public void imprimirHabilidades() {
		arbolHabilidades.imprimirArbol();
	}

	public void imprimirArbolHabilidades() {
		System.out.println("\n" + "Arbol de Habilidades del " + nombre);
		arbolHabilidades.imprimirArbol();
	}
}
