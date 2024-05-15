import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que contiene el método main para ejecutar la aplicación.
 */
public class Main {

    /**
     * Método principal que ejecuta la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no utilizado en esta aplicación).
     */
    public static void main(String[] args) {
        ListaAlbum listaAlbum = new ListaAlbum();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== Menú =====");
            System.out.println("1. Agregar álbum");
            System.out.println("2. Agregar canción a álbum");
            System.out.println("3. Mostrar lista de canciones de un álbum");
            System.out.println("4. Buscar álbumes por año");
            System.out.println("5. Mostrar información de un álbum");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarAlbum(sc, listaAlbum);
                    break;
                case 2:
                    agregarCancion(sc, listaAlbum);
                    break;
                case 3:
                    mostrarCanciones(sc, listaAlbum);
                    break;
                case 4:
                    buscarPorAño(sc, listaAlbum);
                    break;
                case 5:
                    mostrarInformacionAlbum(sc, listaAlbum);
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    // Método para agregar un álbum
    private static void agregarAlbum(Scanner sc, ListaAlbum listaAlbum)
    {
        System.out.println("\n====Agregar Album====");
        System.out.println("Ingrese el nombre del album: ");
        String nombAlb= sc.nextLine();
        System.out.println("Ingrese el año del album: ");
        int añoLanza= sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la disquera del album: ");
        String disquera= sc.nextLine();
        System.out.println("Ingrese los artistas del album "
                + "(separados por ','):");
        String [] artistasArray = sc.nextLine().split(",");
        List<String> artistas = new ArrayList<>();
        for(String artista: artistasArray)
        {
            artistas.add(artista);
        }
        Album album = new Album(nombAlb, añoLanza, disquera, 
                artistas);
        listaAlbum.addAlbum(album);
    }

    // Método para agregar una canción a un álbum
    private static void agregarCancion(Scanner scanner, ListaAlbum listaAlbum) {
        System.out.println("\n===== Agregar Canción =====");
        System.out.println("Ingrese el nombre del álbum:");
        String nombreAlbum = scanner.nextLine();
        System.out.println("Ingrese el título de la canción:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese la duración de la canción (en formato mm:ss):");
        String duracionInput = scanner.nextLine();

        // Parsear la duración en minutos y segundos
        String[] partesDuracion = duracionInput.split(":");
        if (partesDuracion.length != 2) {
            System.out.println("Formato de duración incorrecto. Use el formato mm:ss.");
            return;
        }

        try {
            int minutos = Integer.parseInt(partesDuracion[0]);
            int segundos = Integer.parseInt(partesDuracion[1]);
            double duracion = minutos + segundos / 60.0; // Convertir segundos a minutos
            // Crear la canción y agregarla al álbum
            listaAlbum.addCancion(nombreAlbum, new Cancion(titulo, duracion));
        } catch (NumberFormatException e) {
            System.out.println("Formato de duración incorrecto. Use solo números en mm:ss.");
        }
    }

    // Método para mostrar la lista de canciones de un álbum
    private static void mostrarCanciones(Scanner scanner, ListaAlbum listaAlbum) {
        System.out.println("\n===== Mostrar Canciones =====");
        System.out.println("Ingrese el nombre del álbum:");
        String nombreAlbum = scanner.nextLine();
        // Mostrar las canciones del álbum
        listaAlbum.listaCanciones(nombreAlbum);
    }

    // Método para buscar álbumes por año
    private static void buscarPorAño(Scanner scanner, ListaAlbum listaAlbum) {
        System.out.println("\n===== Buscar Álbumes por Año =====");
        System.out.println("Ingrese el año:");
        int año = scanner.nextInt();
        // Buscar álbumes por año
        listaAlbum.buscarAlbum(año);
    }

    // Método para mostrar información detallada de un álbum
    private static void mostrarInformacionAlbum(Scanner scanner, ListaAlbum listaAlbum) {
        System.out.println("\n===== Mostrar Información del Álbum =====");
        System.out.println("Ingrese el nombre del álbum:");
        String nombreAlbum = scanner.nextLine();
        // Mostrar información del álbum
        listaAlbum.mostrarInformacionAlbum(nombreAlbum);
    }
}
