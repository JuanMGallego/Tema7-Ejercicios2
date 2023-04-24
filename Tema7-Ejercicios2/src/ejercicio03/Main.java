package ejercicio03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Escaner
        Scanner sc = new Scanner(System.in);
        
        //Variables para cada dato
        int dia;
        int mes;
        int ano;

        //Se pide por teclado el dia, mes y a�o
        System.out.println("-- Introduce una fecha --");
        System.out.println();
        
        System.out.print("Dia: ");
        dia = sc.nextInt();
        
        System.out.print("Mes: ");
        mes = sc.nextInt();
        
        System.out.print("A�o: ");
        ano = sc.nextInt();

        //Se crea un objeto Fecha utilizando el consructor con par�metros
        Fecha fecha = new Fecha(dia,mes,ano);

      //si la fecha es correcta
        if (fecha.fechaCorrecta()) { 

           //Se muestra la fecha
        	System.out.println();
            System.out.println("Fecha introducida: " + fecha);

            //Se muestran el d�a siguiente                         
            System.out.print("El d�a siguiente es: ");
            
            //Se hace uso del m�todo diaSiguiente()
            fecha.diaSiguiente();
            System.out.println(fecha);

        //Si la fecha no es correcta
        } else {
        	
        	//Lo imprime
        	System.out.println();
            System.out.println("Fecha no valida");
            
        }
        
        //Cierra escaner
        sc.close();
        
    }

}
