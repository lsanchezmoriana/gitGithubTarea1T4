package apuesta;

public class Main {

    public static void main(String[] args) {
        Apuesta laApuesta;
        int mi_dinero;

        laApuesta = new Apuesta(1000, 4, 2);
        
       
        try {
            System.out.println("Apostando...");
            laApuesta.apostar(25);
        } catch (Exception e) {
            System.out.println("Fallo al realizar la Apuesta");
        }

        try {
            System.out.println("Intento cobrar apuesta segun el resultado del partido");
            laApuesta.cobrar_apuesta(2, 3);
        } catch (Exception e) {
            System.out.println("Fallo al cobrar la apuesta");
        }
        
        
        // Introducimos el método operativaApuesta con el objeto creado laApuesta
        try {
			laApuesta.operativaApuesta(50, 1, 2, 10);
		} catch (Exception e1) {
			System.out.println("Error.");
		}
        
        mi_dinero = laApuesta.getDinero_disp();
        System.out.println("El dinero que tengo tras las apuestas es " + mi_dinero);
    }
}
