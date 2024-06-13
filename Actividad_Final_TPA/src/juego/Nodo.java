package juego;

public class Nodo<T> {
	private T valor;
	private Nodo<T> izquierdo;
	private Nodo<T> derecho;

	public Nodo(T valor) {
		this.valor = valor;
	}

	public T getValor() {
		return valor;
	}

	public Nodo<T> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo<T> izquierdo) {
		this.izquierdo = izquierdo;
	}

	public Nodo<T> getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo<T> derecho) {
		this.derecho = derecho;
	}
}
