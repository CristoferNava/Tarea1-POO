package Negocios;

import Datos.DataArchivo;

import java.util.LinkedList;
import java.util.Scanner;

public class VideogameManager {
    private LinkedList<Videogame> videogamesList = new LinkedList<>();
    private DataArchivo data;
    private Scanner input = new Scanner(System.in);

    public VideogameManager() throws Exception {
        try {
            this.data = DataArchivo.getInstancia();
            this.data.cargar();
            if (this.data.get("videogame") != null) {
                this.videogamesList = (LinkedList<Videogame>) this.data.get("videogame");
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void addVideogame() throws Exception {
        System.out.println("Introduzca el SKU:");
        String sku = input.nextLine();

        if (this.searchVideogame(sku) == -1) {
            System.out.println("Introduzca el título:");
            String title = input.nextLine();
            System.out.println("Introduzca el año:");
            String year = input.nextLine();
            System.out.println("Introduzca la edición:");
            String edition = input.nextLine();
            System.out.println("Introduzca la clasificación:");
            String rating = input.nextLine();
            System.out.println("Introduzca la consola (PS, Xbox, Switch): ");
            String console = input.nextLine();

            Videogame videogame = new Videogame(sku, title, year, edition, rating, console);
            try {
                this.videogamesList.add(videogame);
                this.data.add("videogame", this.videogamesList);
                this.data.guardar();
                System.out.println("El videojuego se agregó correctamente.");
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("SKU existente. No se ha podido agregar el juego.");
        }
    }

    public void readVideogame() {
        System.out.println("Introduzca el SKU del videojuego a consultar:");
        String sku = input.nextLine();

        int index = this.searchVideogame(sku);

        if (index != -1) {
            System.out.println(this.videogamesList.get(index));
        } else {
            System.out.println("Videojuego no encontrado.");
        }
    }

    private int searchVideogame(String sku) {
        for (int i = 0; i <= this.videogamesList.size() - 1; i++) {
            if (this.videogamesList.get(i).getSku().equals(sku)) {
                return i;
            }
        }
        return -1;
    }

    public void updateVideogame() throws Exception {
        System.out.println("Introduzca el SKU del juego a actualizar:");
        String sku = input.nextLine();
        int index = this.searchVideogame(sku);

        if (index != -1) {
            System.out.println("Llene los campos con la nueva información");
            System.out.println("Introduzca el título:");
            String title = input.nextLine();
            System.out.println("Introduzca el año:");
            String year = input.nextLine();
            System.out.println("Introduzca la edición:");
            String edition = input.nextLine();
            System.out.println("Introduzca la clasificación:");
            String rating = input.nextLine();
            System.out.println("Introduzca la consola:");
            String console = input.nextLine();

            Videogame videogame = new Videogame(sku, title, year, edition, rating, console);
            try {
                this.videogamesList.add(videogame);
                this.data.add("videogame", this.videogamesList);
                this.data.guardar();
                System.out.println("El videojuego se actualizó correctamente.");
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("SKU no existente. Primero necesita agregar el juego.");
        }
    }

    public void removeVideogame() throws Exception {
        System.out.println("Introduzca el SKU del videojuego:");
        String sku = input.nextLine();
        int index = this.searchVideogame(sku);

        if (index != -1) {
            try {
                this.videogamesList.remove(index);
                this.data.add("videogame", this.videogamesList);
                this.data.guardar();
                System.out.println("El videojuego se eliminó correctamente.");
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("SKU no existente.");
        }
    }
}
