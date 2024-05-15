import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que representa una lista de álbumes de música.
 */
public class ListaAlbum {

    private Map<String, Album> albums;

    /**
     * Constructor de la clase ListaAlbum.
     */
    public ListaAlbum() {
        this.albums = new HashMap<>();
    }
    
    /**
     * Agrega un álbum a la lista.
     *
     * @param album El álbum a agregar.
     */
    public void addAlbum(Album album) {
        albums.put(album.getNombre(), album);
        System.out.println("Álbum: '" + album.getNombre()
                + "' agregado correctamente");
    }

    /**
     * Agrega una canción a un álbum existente en la lista.
     *
     * @param nombreAlbum El nombre del álbum al que se agregará la canción.
     * @param cancion La canción a agregar.
     */
    public void addCancion(String nombreAlbum, Cancion cancion) {
        Album album = albums.get(nombreAlbum);
        if (album != null) {
            if (!album.getCanciones().contains(cancion)) {
                album.getCanciones().add(cancion);
                System.out.println("Canción: '" + cancion.getTitulo()
                        + "' agregada correctamente");
            } else {
                System.out.println("Error: La canción '" + cancion.getTitulo()
                        + "' ya existe en el álbum '" + nombreAlbum);
            }
        } else {
            System.out.println("Error: No se encontró el álbum: '"
                    + nombreAlbum + "'");
        }
    }

    /**
     * Muestra la lista de canciones de un álbum.
     *
     * @param nombreAlbum El nombre del álbum del que se mostrarán las canciones.
     */
    public void listaCanciones(String nombreAlbum) {
        Album album = albums.get(nombreAlbum);
        if (album != null) {
            System.out.println("Lista de canciones del álbum '"
                    + nombreAlbum + "':");
            for (Cancion cancion : album.getCanciones()) {
                System.out.println("- " + cancion.getTitulo()
                        + " -- Duración: " + cancion.getDuracion());
            }
        } else {
            System.out.println("Error: No se encontró el álbum: '"
                    + nombreAlbum + "'");
        }
    }

    /**
     * Busca álbumes lanzados en un año específico.
     *
     * @param año El año de lanzamiento a buscar.
     */
    public void buscarAlbum(int año) {
        System.out.println("Álbumes lanzados en el año '" + año + "':");
        boolean encontrado = false;
        for (Album album : albums.values()) {
            if (album.getAñoLanzamiento() == año) {
                encontrado = true;
                System.out.println("- " + album.getNombre());
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron álbumes lanzados en ese año :(");
        }
    }

    /**
     * Muestra información detallada de un álbum.
     *
     * @param nombreAlbum El nombre del álbum del que se mostrará la información.
     */
    public void mostrarInformacionAlbum(String nombreAlbum) {
        Album album = albums.get(nombreAlbum);
        if (album != null) {
            System.out.println("Información del álbum '" + nombreAlbum + "':");
            System.out.println("Nombre: " + album.getNombre());
            System.out.println("Año de Lanzamiento: " + album.getAñoLanzamiento());
            System.out.println("Disquera: " + album.getDisquera());
            System.out.println("Artistas:");
            for (String artista : album.getArtistas()) {
                System.out.println("- " + artista);
            }
            System.out.println("Canciones:");
            List<Cancion> canciones = album.getCanciones();
            if (!canciones.isEmpty()) {
                for (Cancion cancion : canciones) {
                    System.out.println("- " + cancion.getTitulo() + " (" + cancion.getDuracion() + " minutos)");
                }
            } else {
                System.out.println("Este álbum no tiene canciones.");
            }
        } else {
            System.out.println("Error: No se encontró el álbum '" + nombreAlbum + "'.");
        }
    }
}
