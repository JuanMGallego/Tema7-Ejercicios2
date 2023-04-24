package ejercicio02;

public class Contador {

private int contador;
	
	public Contador() {
		super();
	}

	public Contador(int contador) {
		if(contador<0) {
			this.contador = 0;
		} else {
			this.contador = contador;
		}
	}

	public Contador(Contador cont) {
		this.contador = cont.contador;
	}
	
	
	
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public void incrementar() {
		this.contador++;
	}
	
	public void decrementar() {
		this.contador--;
	}

}
