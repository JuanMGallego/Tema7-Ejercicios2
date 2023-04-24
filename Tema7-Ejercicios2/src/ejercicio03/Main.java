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

        //Se pide por teclado el dia, mes y año
        System.out.println("-- Introduce una fecha --");
        System.out.println();
        
        System.out.print("Dia: ");
        dia = sc.nextInt();
        
        System.out.print("Mes: ");
        mes = sc.nextInt();
        
        System.out.print("Año: ");
        ano = sc.nextInt();

        //Se crea un objeto Fecha utilizando el consructor con parámetros
        Fecha fecha = new Fecha(dia,mes,ano);

      //si la fecha es correcta
        if (fecha.fechaCorrecta()) { 

           //Se muestra la fecha
        	System.out.println();
            System.out.println("Fecha introducida: " + fecha);

            //Se muestran el día siguiente                         
            System.out.print("El día siguiente es: ");
            
            //Se hace uso del método diaSiguiente()
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
