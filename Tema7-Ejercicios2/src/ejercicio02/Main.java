package ejercicio02;

public class Main {

	public static void main(String[] args) {
		Contador cont1 = new Contador(5);
		Contador cont2 = new Contador(cont1);
		
		cont1.decrementar();
		cont2.incrementar();
		
		System.out.println("Cont1 " + cont1.getContador());
		System.out.println("Cont2 " + cont2.getContador());
	}

}
