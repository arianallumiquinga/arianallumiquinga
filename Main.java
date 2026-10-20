

    public static void main(String[] args) {

        System.out.println("=== SIMULADOR ASTRONOMICO - MISION KEPLER ===");
        System.out.println();
        // 1. Crear objetos con los 3 constructores
        CuerpoCeleste c1 = new CuerpoCeleste();                                  // C 1
        CuerpoCeleste c2 = new CuerpoCeleste("Apolo 803g", 1.305, 8600);       // C 2
        CuerpoCeleste c3 = new CuerpoCeleste("Rodolfo-196f", 8.604, 7454, 53.3, 0); // C3

        c2.setDistanciaSol(12.8);
        c2.setCantidadSatelites(2);
        c1.setNombre("Ariana Apolo 19");
        c1.setMasaKg(7.2004);
        c1.setRadioKm(6200);
        c1.setDistanciaSol(40.5);
        //Prueba
        //c3.setMasaKg(-1);
        //c3.setRadioKm(0);
        //System.out.println();
        /*System.out.println("--- Calculos ---");
        System.out.println(c1.getNombre() + " -> volumen: " + c1.calcularVolumen());
        System.out.println(c1.getNombre() + " -> densidad: " + c1.calcularDensidad());
        System.out.println(c2.getNombre() + " -> densidad: " + c2.calcularDensidad());
        System.out.println(c3.getNombre() + " -> densidad: " + c3.calcularDensidad());
        System.out.println();*/



        c1.imprimirReporte(15);
        System.out.println();

        c2.imprimirReporte(-30);
        System.out.println();

        c3.imprimirReporte(10);

    }
