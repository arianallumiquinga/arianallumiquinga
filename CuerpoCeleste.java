public class CuerpoCeleste {
    private String nombre;
    private double masaKg;
    private double radioKm;
    private double distanciaSol;
    private int cantidadSatelites;
    // Constructor1
    public CuerpoCeleste(){
        this.nombre= "Cuerpo 1.36";
        this.masaKg= 8.6010;
        this.radioKm=1200;
        this.distanciaSol=60.12;
        this.cantidadSatelites=3;
    }
    // Constructor 2
    public CuerpoCeleste(String nombre, double masaKg, double radioKm) {
        this.nombre = nombre;
        this.masaKg = masaKg;
        this.radioKm = radioKm;
        this.distanciaSol = 0;
        this.cantidadSatelites = 0;
    }
    // Constructor 3
    public CuerpoCeleste(String nombre,double masakg,double radioKm, double distanciaSol, int cantidadSatelites){
        this.nombre=nombre;
        this.masaKg=masakg;
        this.radioKm=radioKm;
        this.distanciaSol=distanciaSol;
        this.cantidadSatelites=cantidadSatelites;

    }
    // Getters y Setters
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.equals("")) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: el nombre no puede estar vacio.");
        }
    }

    public double getMasaKg() {
        return masaKg;
    }

    public void setMasaKg(double masaKg) {
        if (masaKg > 0) {
            this.masaKg = masaKg;
        } else {
            System.out.println("Error: la masa debe ser mayor que 0.");
        }
    }

    public double getRadioKm() {
        return radioKm;
    }

    public void setRadioKm(double radioKm) {
        if (radioKm > 0) {
            this.radioKm = radioKm;
        } else {
            System.out.println("Error: el radio debe ser mayor que 0.");
        }
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }

    public void setDistanciaSol(double distanciaSol) {
        if (distanciaSol >= 0) {
            this.distanciaSol = distanciaSol;
        } else {
            System.out.println("Error: la distancia no puede ser negativa.");
        }
    }

    public int getCantidadSatelites() {
        return cantidadSatelites;
    }

    public void setCantidadSatelites(int cantidadSatelites) {
        if (cantidadSatelites >= 0) {
            this.cantidadSatelites = cantidadSatelites;
        } else {
            System.out.println("Error: la cantidad de satelites no pueden ser negativos.");
        }
    }
    // Calcular Volumen
    public double calcularVolumen() {
        double radioM = radioKm * 1000;   // km a m
        return (4.0 / 3.0) * Math.PI * Math.pow(radioM, 3);
    }

    // Densidad = masa / volumen  (kg/m^3)
    public double calcularDensidad() {
        return masaKg / calcularVolumen();
    }
    public double calcularGravedad() {
        double G = 6.67430e-11;
        double radioM = radioKm * 1000;
        return G * masaKg / Math.pow(radioM, 2);
    }

    // Habitabl entre -20 y 50 °C y la densidad > 1
    public boolean esHabitable(double temperaturaSuperficie) {
        boolean temperaturaOk = temperaturaSuperficie >= -20 && temperaturaSuperficie <= 50;
        boolean densidadOk = calcularDensidad() > 1;

        if (temperaturaOk && densidadOk) {
            System.out.println(nombre + ": SI es habitable.");
            return true;
        } else {
            if (!temperaturaOk) {
                System.out.println(nombre + ": NO, la temperatura esta fuera de -20 a 50 C.");
            }
            if (!densidadOk) {
                System.out.println(nombre + ": NO, la densidad debe ser mayor que 1.");
            }
            return false;
        }
    }
    public void imprimirReporte(double temperaturaSuperficie) {
        System.out.println("===== FICHA TECNICA =====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Masa: " + masaKg + " kg");
        System.out.println("Radio: " + radioKm + " km");
        System.out.println("Distancia a su sol: " + distanciaSol + " millones de km");
        System.out.println("Satelites: " + cantidadSatelites);
        System.out.println("Volumen: " + calcularVolumen() + " m3");
        System.out.println("Densidad: " + calcularDensidad() + " kg/m3");
        System.out.println("Gravedad superficial: " + calcularGravedad() + " m/s2");
        System.out.println("Temperatura: " + temperaturaSuperficie + " C");
        esHabitable(temperaturaSuperficie);
        System.out.println("=======gracias por usar el programa de Ari========");
    }
}
