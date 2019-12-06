package Negocios;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Bienvenido a la tienda");
        System.out.println("Elija el apartado: \n1) Música\n2) Vídeos\n3) Videojuegos\ns) Salir");
        MusicManager musicManager_object = new MusicManager();
        VideoManager videoManager_object = new VideoManager();
        VideogameManager videogameManager_object = new VideogameManager();
        String option = input.nextLine();

        while (!(option.equals("s") || option.equals("S"))) {

            System.out.println("\nElija la opción a realizar:\n1) Agregar\n2) Leer\n3) Actualizar\n4) Eliminar\ns) Salir");
            String optionCrud = input.nextLine();

            if (option.equals("1")) {
                if (optionCrud.equals("1")) {
                    musicManager_object. addMusic();
                } else if (optionCrud.equals("2")) {
                    musicManager_object.readMusic();
                } else if (optionCrud.equals("3")) {
                    musicManager_object.updateMusic();
                } else if (optionCrud.equals("4")) {
                    musicManager_object.removeMusic();
                }
            }

            if (option.equals("2")) {
                if (optionCrud.equals("1")) {
                    videoManager_object.addVideo();
                } else if (optionCrud.equals("2")) {
                    videoManager_object.readVideo();
                } else if (optionCrud.equals("3")) {
                    videoManager_object.updateVideo();
                } else if (optionCrud.equals("4")) {
                    videoManager_object.removeVideo();
                }
            }

            if (option.equals("3")) {
                if (optionCrud.equals("1")) {
                  videogameManager_object.addVideogame();
                } else if (optionCrud.equals("2")) {
                    videogameManager_object.readVideogame();
                } else if (optionCrud.equals("3")) {
                    videogameManager_object.updateVideogame();
                } else if (optionCrud.equals("4")) {
                    videogameManager_object.removeVideogame();
                }
            }
            System.out.println("\nElija el apartado: \n1) Música\n2) Vídeos\n3) Videojuegos\ns) Salir");
            option = input.nextLine();
        }
    }
}