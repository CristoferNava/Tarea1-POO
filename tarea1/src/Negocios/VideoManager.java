package Negocios;

import Datos.DataArchivo;

import java.util.LinkedList;
import java.util.Scanner;

public class VideoManager {
    private LinkedList<Video> videosList = new LinkedList<>();
    private DataArchivo data;
    private Scanner input = new Scanner(System.in);

    public VideoManager() throws Exception {
        try {
            this.data = DataArchivo.getInstancia();
            this.data.cargar();
            if (this.data.get("video") != null) {
                this.videosList = (LinkedList<Video>) this.data.get("video");
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void addVideo() throws Exception {
        System.out.println("Introduzca el SKU:");
        String sku = input.nextLine();

        if (this.searchVideo(sku) == -1) {
            System.out.println("Introduzca el artista:");
            String artist = input.nextLine();
            System.out.println("Introduzca el título:");
            String title = input.nextLine();
            System.out.println("Introduzca el año:");
            String year = input.nextLine();
            System.out.println("Introduzca la clasificación:");
            String rating = input.nextLine();
            System.out.println("Introduzca el tipo: (DVD o Bluray)");
            String type = input.nextLine();

            Video video = new Video(sku, title, year, artist, rating, type);
            try {
                this.videosList.add(video);
                this.data.add("video", this.videosList);
                this.data.guardar();
                System.out.println("El vídeo se agregó correctamente.");
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("SKU existente. No se ha podido agregar el vídeo.");
        }
    }

    public void readVideo() {
        System.out.println("Introduzca el SKU del vídeo a consultar:");
        String sku = input.nextLine();

        int index = this.searchVideo(sku);

        if (index != -1) {
            System.out.println(this.videosList.get(index));
        } else {
            System.out.println("Vídeo no encontrado.");
        }
    }

    private int searchVideo(String sku) {
        for (int i = 0; i <= this.videosList.size() - 1; i++) {
            if (this.videosList.get(i).getSku().equals(sku)) {
                return i;
            }
        }
        return -1;
    }

    public void updateVideo() throws Exception {
        System.out.println("Introduzca el SKU del vídeo a actualizar:");
        String sku = input.nextLine();
        int index = this.searchVideo(sku);

        if (index != -1) {
            System.out.println("Introduzca el título:");
            String title = input.nextLine();
            System.out.println("Introduzca el año:");
            String year = input.nextLine();
            System.out.println("Introduzca el artista:");
            String artist = input.nextLine();
            System.out.println("Introduzca la clasificación:");
            String rating = input.nextLine();
            System.out.println("Introduzca el tipo:");
            String type = input.nextLine();

            Video video = new Video(sku, title, year, artist, rating, type);
            try {
                this.videosList.add(video);
                this.data.add("video", this.videosList);
                this.data.guardar();
                System.out.println("El vídeo se actualizó correctamente.");
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("SKU no existente. Primero necesita agregar el vídeo.");
        }
    }

    public void removeVideo() throws Exception {
        System.out.println("Introduzca el SKU del vídeo:");
        String sku = input.nextLine();
        int index = this.searchVideo(sku);

        if (index != -1) {
            try {
                this.videosList.remove(index);
                this.data.add("video", this.videosList);
                this.data.guardar();
                System.out.println("El vídeo se eliminó correctamente.");
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("SKU no existente.");
        }
    }
}
