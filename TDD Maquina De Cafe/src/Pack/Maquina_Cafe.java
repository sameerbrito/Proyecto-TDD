package Pack;

import java.util.Scanner;

public class Maquina_Cafe {
    private int cantidadDeCafe;
    private int cantidadDeAzucar;
    private int cantidadDeVasos;

    public Maquina_Cafe(int cafe, int azucar, int vasos) {
        this.cantidadDeCafe = cafe;
        this.cantidadDeAzucar = azucar;
        this.cantidadDeVasos = vasos;
    }

    public int getCantidadDeCafe() {
        return cantidadDeCafe;
    }

    public void setCantidadDeCafe(int cantidadDeCafe) {
        this.cantidadDeCafe = cantidadDeCafe;
    }

    public int getCantidadDeAzucar() {
        return cantidadDeAzucar;
    }

    public void setCantidadDeAzucar(int cantidadDeAzucar) {
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public int getCantidadDeVasos() {
        return cantidadDeVasos;
    }

    public void setCantidadDeVasos(int cantidadDeVasos) {
        this.cantidadDeVasos = cantidadDeVasos;
    }

    public boolean hasCafe(int cantidad) {
        return cantidadDeCafe >= cantidad;
    }

    public boolean hasAzucar(int cantidad) {
        return cantidadDeAzucar >= cantidad;
    }

    public boolean hasVasos(int cantidad) {
        return cantidadDeVasos >= cantidad;
    }

    public boolean giveCafe(int cantidad) {
        if (hasCafe(cantidad)) {
            cantidadDeCafe -= cantidad;
            return true;
        } else {
            return false;
        }
    }

    public boolean giveAzucar(int cantidad) {
        if (hasAzucar(cantidad)) {
            cantidadDeAzucar -= cantidad;
            return true;
        } else {
            return false;
        }
    }

    public boolean giveVasos(int cantidad) {
        if (hasVasos(cantidad)) {
            cantidadDeVasos -= cantidad;
            return true;
        } else {
            return false;
        }
    }

    public String getContenido() {
        return "Caf�: " + cantidadDeCafe + " oz\nAz�car: " + cantidadDeAzucar + " cucharadas\nVasos: " + cantidadDeVasos;
    }

    public boolean servirCafe(int tamanoVaso, int cantidadAzucar) {
        int cantidadCafe = 0;
        switch (tamanoVaso) {
            case 1:
                cantidadCafe = 3;
                break;
            case 2:
                cantidadCafe = 5;
                break;
            case 3:
                cantidadCafe = 7;
                break;
            default:
                System.out.println("Tama�o de vaso no v�lido.");
                return false;
        }

        if (giveCafe(cantidadCafe) && giveAzucar(cantidadAzucar) && giveVasos(1)) {
            System.out.println("Sirviendo " + cantidadCafe + " oz de caf� en un vaso " + getTipoVaso(tamanoVaso) + " con " + cantidadAzucar + " cucharadas de az�car.");
            return true;
        } else {
            System.out.println("No es posible servir el caf�.");
            return false;
        }
    }
    public String getTipoVaso(int tamano) {
        switch (tamano) {
            case 1:
                return "Peque�o (3 oz)";
            case 2:
                return "Mediano (5 oz)";
            case 3:
                return "Grande (7 oz)";
            default:
                return "Desconocido";
        }
    }
    public static void main(String[] args) {
        Maquina_Cafe maquina = new Maquina_Cafe(10, 20, 30);
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la m�quina de caf�.");
        while (true) {
            System.out.println("Por favor, seleccione una opci�n:");
            System.out.println("1. Servir caf�");
            System.out.println("2. Ver contenido de la m�quina");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccione el tama�o del vaso (1 = peque�o, 2 = mediano, 3 = grande):");
                    int tamanoVaso = scanner.nextInt();

                    System.out.println("Ingrese la cantidad de az�car (en cucharadas):");
                    int cantidadAzucar = scanner.nextInt();

                    System.out.println("Ingrese la cantidad de onzas de caf�:");
				maquina.servirCafe(tamanoVaso, cantidadAzucar);
                    break;
                case 2:
                    System.out.println(maquina.getContenido());
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opci�n inv�lida. Por favor seleccione una opci�n v�lida.");
            }
        }
    }
}
    
    