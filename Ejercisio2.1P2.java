public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getInfo() {
        return nombre + " - $" + precio + " - " + stock + " u.";
    }


    public static void ejecutarInventario() {
        int MAX = 3;
        Producto[] inventario = new Producto[MAX];
        int cantidad = 0;


        Producto[] productosNuevos = {
                new Producto("Cuaderno", 2.5, 10),
                new Producto("Esfero", 0.8, 50),
                new Producto("Mochila", 25.0, 3),
                new Producto("Regla", 1.2, 20)
        };


        for (Producto p : productosNuevos) {
            if (cantidad < MAX) {
                inventario[cantidad] = p;
                cantidad++;
            } else {
                System.out.println("No hay espacio para " + p.getNombre());
            }
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println(inventario[i].getInfo());
        }


        double valorInventario = 0;
        Producto masCaro = inventario[0];

        for (int i = 0; i < cantidad; i++) {
            valorInventario += inventario[i].getPrecio() * inventario[i].getStock();

            if (inventario[i].getPrecio() > masCaro.getPrecio()) {
                masCaro = inventario[i];
            }
        }

        System.out.println("Valor del inventario: $" + valorInventario);
        System.out.println("Más caro: " + masCaro.getNombre());
    }
}
