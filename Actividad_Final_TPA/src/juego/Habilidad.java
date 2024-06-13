package juego;

public class Habilidad {
	private String nombre;
	private String tipo;
	private int nivel;
	private final int maxNivel = 14;

	public Habilidad(String nombre, String tipo, int nivel) {
		this.nombre = nombre;
		this.tipo = tipo;
//		this.nivel = (int) (Math.random() * 10);
		this.nivel = nivel;
	}

	public void incrementarNivel() {
		if (nivel < maxNivel) {
			nivel++;
		}
	}

	// Getters
	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getNivel() {
		return nivel;
	}

	public int getMaxNivel() {
		return maxNivel;
	}

	@Override
	public String toString() {
		return nombre + " (Nivel " + nivel + "/" + maxNivel + "): " + tipo;
	}

}
