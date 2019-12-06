package Negocios;

import Datos.DataArchivo;

import java.util.LinkedList;
import java.util.Scanner;

public class MusicManager {
    private LinkedList<Music> musicList = new LinkedList<>();
    private DataArchivo data;
    private Scanner input = new Scanner(System.in);

    public MusicManager() throws Exception {
        try {
            this.data = DataArchivo.getInstancia();
            this.data.cargar();
            if (this.data.get("music") != null) {
                this.musicList = (LinkedList<Music>) this.data.get("music");
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void addMusic() throws Exception {
        System.out.println("Introduzca el SKU:");
        String sku = input.nextLine();

        if (this.searchMusic(sku) == -1) {
            System.out.println("Introduzca el artista:");
            String artist = input.nextLine();
            System.out.println("Introduzca el título:");
            String title = input.nextLine();
            System.out.println("Introduzca el año:");
            String year = input.nextLine();
            System.out.println("Introduzca el género:");
            String genre = input.nextLine();
            System.out.println("Introduzca el tipo (CD o Vinil):");
            String type = input.nextLine();

            Music music = new Music(sku, title, year, artist, genre, type);
            try {
                this.musicList.add(music);
                this.data.add("music", this.musicList);
                this.data.guardar();
                System.out.println("El disco se agregó correctamente.");
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("SKU existente. No se ha podido agregar el disco.");
        }
    }

    public void readMusic() {
        System.out.println("Introduzca el SKU del disco a consultar:");
        String sku = input.nextLine();

        int index = this.searchMusic(sku);

        if (index != -1) {
            System.out.println(this.musicList.get(index));
        } else {
            System.out.println("Disco no encontrado.");
        }
    }

    private int searchMusic(String sku) {
        for (int i = 0; i <= this.musicList.size() - 1; i++) {
            if (this.musicList.get(i).getSku().equals(sku)) {
                return i;
            }
        }
        return -1;
    }

    public void updateMusic() throws Exception {
        System.out.println("Introduzca el SKU del disco a actualizar:");
        String sku = input.nextLine();
        int index = this.searchMusic(sku);

        if (index != -1) {
            System.out.println("Llene los campos con la nueva información");
            System.out.println("Introduzca el título:");
            String title = input.nextLine();
            System.out.println("Introduzca el año:");
            String year = input.nextLine();
            System.out.println("Introduzca el artista:");
            String artist = input.nextLine();
            System.out.println("Introduzca el género:");
            String genre = input.nextLine();
            System.out.println("Introduzca el tipo:");
            String type = input.nextLine();

            Music music = new Music(sku, title, year, artist, genre, type);
            try {
                this.musicList.set(index, music);
                this.data.add("music", this.musicList);
                this.data.guardar();
                System.out.println("El disco se actualizó correctamente.");
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("SKU no existente. Primero necesita agregar el disco.");
        }
    }

    public void removeMusic() throws Exception {
        System.out.println("Introduzca el SKU del disco:");
        String sku = input.nextLine();
        int index = this.searchMusic(sku);

        if (index != -1) {
            try {
                this.musicList.remove(index);
                this.data.add("music", this.musicList);
                this.data.guardar();
                System.out.println("El disco se eliminó correctamente.");
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("SKU no existente.");
        }
    }
}
