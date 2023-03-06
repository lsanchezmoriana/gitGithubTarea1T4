package apuesta;

/**
 * @author carmen
 *
 */
public class Apuesta {

    private int dinero_disp;
    private int goles_local;
    private int goles_visitante;
    private int apostado;

    /*Contructor por defecto*/
    public Apuesta() {
    }

    /*Contructor por parámetros*/
    /**
     * @param dinero_disp
     * @param goles_local
     * @param goles_visitante
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
  
    
// Atributos encapsulados
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////77    
    public int getGoles_local() {
		return goles_local;
	}
	public void setGoles_local(int goles_local) {
		this.goles_local = goles_local;
	}
	public int getGoles_visitante() {
		return goles_visitante;
	}
	public void setGoles_visitante(int goles_visitante) {
		this.goles_visitante = goles_visitante;
	}
	public int getApostado() {
		return apostado;
	}
	public void setApostado(int apostado) {
		this.apostado = apostado;
	}
	public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////77    

    
    /*Método para obtener el valor del atributo dinero_disp*/

    /**
     * @return
     */
    public int getDinero_disp() {
        return dinero_disp;
    }
    /*Método para modificar el valor del atributo dinero_disp*/

    

    /*Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     */
    /**
     * @param dinero
     * @throws Exception
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > dinero_disp) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            dinero_disp = dinero - dinero_disp;
            apostado = dinero;
        }
    }
    /*Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * 
     */

    /**
     * @param local
     * @param visitante
     * @return
     * @throws Exception
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (goles_local == local && goles_visitante == visitante) {
            acertado = true;
        }
        return acertado;
    }
    /* Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
     */

    /**
     * @param cantidad_goles_local
     * @param cantidad_goles_visit
     * @throws Exception
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dinero_disp = dinero_disp * 10;

    }
    
    
    // Método operativaApuesta
    /**
     * @param cantidad
     * @param golesLocal
     * @param golesVisitante
     * @param dinero
     * @throws Exception
     */
    public void operativaApuesta(int cantidad, int golesLocal, int golesVisitante, int dinero) throws Exception {
    	apostar(cantidad);
        boolean resultado = comprobar_resultado(golesLocal, golesVisitante);
        if (resultado) {
        	cobrar_apuesta(golesLocal, golesVisitante);
        }
    }
}
