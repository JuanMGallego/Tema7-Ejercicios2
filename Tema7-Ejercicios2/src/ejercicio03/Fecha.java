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
     * Constructor con parámetros
     * @param dia Día introducido por el usuario
     * @param mes Mes introducido por el usuario
     * @param ano Año introducido por el usuario
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
    public void setAño(int a) {
        ano = a;
    }
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAño() {
        return ano;
    }

    /**
     * Método para comprobar si la fecha es correcta
     * @return
     */
    public boolean fechaCorrecta() {
    	
    	//Variables booleanas para comprobar que sean correctos los datos
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        
        //Se colocan los valores por defecto de cada boolean en función de
        //los atributos
        añoCorrecto = ano > 0;
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
                
            //Casos de meses con 30 días
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }

    /**
     * Método privado para comprobar si el año es bisiesto
     * @return
     */
    private boolean esBisiesto() {
        return (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0);
    }

    /**
     * Método que modifica la fecha cambiándola por la del día siguiente                                           
     */
    public void diaSiguiente() {
    	
    	//Suma un día
        dia++;
        
        //Si al sumarle un día la fecha ya no es correcta, se le suma un mes
        //y el día cambia a 1
        if (!fechaCorrecta()) {
        	
            dia = 1;
            mes++;
            
            //Si todavía sigue mal, significa que el més era Diciembre y este
            //cambiará a 1
            if (!fechaCorrecta()) {
            	
                mes = 1;
                ano++;
                
            }

        }
    }

    /**
     * Método toString para mostrar la fecha
     */
    public String toString() {
    	
    	//Se inicializa vacía
    	String fecha = "";
    	
    	//Si el día tiene un solo dígito, se le añade un "0" al inicio
    	if (dia < 10) {
    		
    		fecha += "0";
    		
    	}
    	
    	//Se suma el día a la cadena y antes del mes se coloca un guión
    	fecha += (dia + "-");
    	
    	//Si el mes tiene un dígito, se le añade delante un "0"
    	if (mes < 10) {
    		
    		fecha += "0";
    		
    	}
    	
    	//Se suma el mes y el año a la cadena y antes del año se coloca un guión
    	fecha += (mes + "-" + ano);
    	
    	//Devuelve la fecha
        return fecha;
    }
}
