package juego;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolHabilidadesDinamico<T extends Habilidad> {

	private Nodo<T> raiz;

	public ArbolHabilidadesDinamico(T raiz) {
		this.raiz = new Nodo<>(raiz);
	}

	private Nodo<T> buscarNodo(Nodo<T> nodo, T habilidad) {
		if (nodo != null) {
			if (nodo.getValor().equals(habilidad)) {
				return nodo;
			}
			Nodo<T> nodoIzquierdo = buscarNodo(nodo.getIzquierdo(), habilidad);
			if (nodoIzquierdo != null) {
				return nodoIzquierdo;
			}
			return buscarNodo(nodo.getDerecho(), habilidad);
		}
		return null;
	}

	// Método para agregar habilidades en el árbol.
	public void agregarHabilidad(T padre, T habilidadIzquierda, T habilidadDerecha) {
		Nodo<T> nodoPadre = buscarNodo(raiz, padre);
		if (nodoPadre != null) {
			nodoPadre.setIzquierdo(new Nodo<>(habilidadIzquierda));
		}
		if (nodoPadre.getDerecho() == null && habilidadDerecha != null) {
			nodoPadre.setDerecho(new Nodo<>(habilidadDerecha));
		}
	}

	public T buscarHabilidadIRD(String nombre) {
		return buscarHabilidadIRD(raiz, nombre);
	}

	private T buscarHabilidadIRD(Nodo<T> nodo, String nombre) {
		if (nodo != null) {
			T habilidadEncontrada = buscarHabilidadIRD(nodo.getIzquierdo(), nombre);
			if (habilidadEncontrada != null) {
				return habilidadEncontrada;
			}
			if (nodo.getValor().getNombre().equals(nombre)) {
				return nodo.getValor();
			}
			habilidadEncontrada = buscarHabilidadIRD(nodo.getDerecho(), nombre);
			if (habilidadEncontrada != null) {
				return habilidadEncontrada;
			}
		}
		return null;
	}

	public T buscarHabilidadRID(String nombre) {
		return buscarHabilidadRID(raiz, nombre);
	}

	private T buscarHabilidadRID(Nodo<T> nodo, String nombre) {
		if (nodo != null) {
			T habilidadEncontrada = buscarHabilidadRID(nodo.getDerecho(), nombre);
			if (habilidadEncontrada != null) {
				return habilidadEncontrada;
			}
			if (nodo.getValor().getNombre().equals(nombre)) {
				return nodo.getValor();
			}
			habilidadEncontrada = buscarHabilidadRID(nodo.getIzquierdo(), nombre);
			if (habilidadEncontrada != null) {
				return habilidadEncontrada;
			}
		}
		return null;
	}

	public T buscarHabilidadIDR(String nombre) {
		return buscarHabilidadIDR(raiz, nombre);
	}

	private T buscarHabilidadIDR(Nodo<T> nodo, String nombre) {
		if (nodo != null) {
			if (nodo.getValor().getNombre().equals(nombre)) {
				return nodo.getValor();
			}
			T habilidadEncontrada = buscarHabilidadIDR(nodo.getIzquierdo(), nombre);
			if (habilidadEncontrada != null) {
				return habilidadEncontrada;
			}
			habilidadEncontrada = buscarHabilidadIDR(nodo.getDerecho(), nombre);
			if (habilidadEncontrada != null) {
				return habilidadEncontrada;
			}
		}
		return null;
	}

	public T buscarHabilidadAnchura(String nombre) {
		return buscarHabilidadAnchura(raiz, nombre);
	}

	public T buscarHabilidadAnchura(Nodo<T> raiz, String nombre) {
		if (raiz == null) {
			return null;
		}

		Queue<Nodo<T>> cola = new LinkedList<>();
		cola.offer(raiz);

		while (!cola.isEmpty()) {
			Nodo<T> nodoActual = cola.poll();
			if (nodoActual.getValor().getNombre().equals(nombre)) {
				return nodoActual.getValor();
			}

			if (nodoActual.getIzquierdo() != null) {
				cola.offer(nodoActual.getIzquierdo());
			}

			if (nodoActual.getDerecho() != null) {
				cola.offer(nodoActual.getDerecho());
			}
		}

		return null;
	}

	// Método para visualizar el árbol de habilidades (recorrido In-orden).
	public void imprimirArbol() {
		imprimirArbolJerarquico(raiz, 0);
	}

	private void imprimirArbolJerarquico(Nodo<T> nodo, int nivel) {
		if (nodo != null) {
			// Agrega sangrías según el nivel del nodo para representar la jerarquía
			for (int i = 0; i < nivel; i++) {
				System.out.print("  ");
			}
			// Imprime el valor del nodo
			System.out.println("- " + nodo.getValor());

			// Recorre recursivamente el subárbol izquierdo e incrementa el nivel
			imprimirArbolJerarquico(nodo.getIzquierdo(), nivel + 1);
			// Recorre recursivamente el subárbol derecho e incrementa el nivel
			imprimirArbolJerarquico(nodo.getDerecho(), nivel + 1);
		}
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

}
