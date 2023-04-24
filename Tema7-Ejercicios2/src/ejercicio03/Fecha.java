package ejercicio03;

/**
 * Clase para modificar y usar una fecha 
 * 
 * @author jmgallego
 *
 */
public class Fecha {

	
    private int dia = 1;
    private int mes = 1;
    private int ano = 1970;

    /**
     * Constructor por defecto
     */
    public Fecha() {
    }

    /**
     * Constructor con par�metros
     * @param dia D�a introducido por el usuario
     * @param mes Mes introducido por el usuario
     * @param ano A�o introducido por el usuario
     */
    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * setters y getters
     * @param d
     */
    public void setDia(int d) {
        dia = d;
    }
    public void setMes(int m) {
        mes = m;
    }
    public void setA�o(int a) {
        ano = a;
    }
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getA�o() {
        return ano;
    }

    /**
     * M�todo para comprobar si la fecha es correcta
     * @return
     */
    public boolean fechaCorrecta() {
    	
    	//Variables booleanas para comprobar que sean correctos los datos
        boolean diaCorrecto, mesCorrecto, a�oCorrecto;
        
        //Se colocan los valores por defecto de cada boolean en funci�n de
        //los atributos
        a�oCorrecto = ano > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        
        //Comprueba por mes
        switch (mes) {
        
        	//En caso de que sea Febrero
            case 2:
            	
            	//Si es bisiesto
                if (esBisiesto()) {
                	
                	//Comprueba el rango hasta 29
                    diaCorrecto = dia >= 1 && dia <= 29;
                    
                //Si no
                } else {
                	
                	//EL rango es hasta 28
                    diaCorrecto = dia >= 1 && dia <= 28;
                    
                }
                
                //Sale del switch
                break;
                
            //Casos de meses con 30 d�as
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && a�oCorrecto;
    }

    /**
     * M�todo privado para comprobar si el a�o es bisiesto
     * @return
     */
    private boolean esBisiesto() {
        return (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0);
    }

    /**
     * M�todo que modifica la fecha cambi�ndola por la del d�a siguiente                                           
     */
    public void diaSiguiente() {
    	
    	//Suma un d�a
        dia++;
        
        //Si al sumarle un d�a la fecha ya no es correcta, se le suma un mes
        //y el d�a cambia a 1
        if (!fechaCorrecta()) {
        	
            dia = 1;
            mes++;
            
            //Si todav�a sigue mal, significa que el m�s era Diciembre y este
            //cambiar� a 1
            if (!fechaCorrecta()) {
            	
                mes = 1;
                ano++;
                
            }

        }
    }

    /**
     * M�todo toString para mostrar la fecha
     */
    public String toString() {
    	
    	//Se inicializa vac�a
    	String fecha = "";
    	
    	//Si el d�a tiene un solo d�gito, se le a�ade un "0" al inicio
    	if (dia < 10) {
    		
    		fecha += "0";
    		
    	}
    	
    	//Se suma el d�a a la cadena y antes del mes se coloca un gui�n
    	fecha += (dia + "-");
    	
    	//Si el mes tiene un d�gito, se le a�ade delante un "0"
    	if (mes < 10) {
    		
    		fecha += "0";
    		
    	}
    	
    	//Se suma el mes y el a�o a la cadena y antes del a�o se coloca un gui�n
    	fecha += (mes + "-" + ano);
    	
    	//Devuelve la fecha
        return fecha;
    }
}
