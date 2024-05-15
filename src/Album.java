import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un álbum de música.
 */
public class Album {

    private String nombre;
    private int añoLanzamiento;
    private String disquera;
    private List<Cancion> canciones;
    private List<String> artistas;

    /**
     * Constructor vacío de la clase Album.
     */
    public Album() {
    }

    /**
     * Constructor de la clase Album.
     *
     * @param nombre El nombre del álbum.
     * @param añoLanzamiento El año de lanzamiento del álbum.
     * @param disquera La disquera del álbum.
     * @param artistas La lista de artistas del álbum.
     */
    public Album(String nombre, int añoLanzamiento, String disquera,
            List<String> artistas) {
        this.nombre = nombre;
        this.añoLanzamiento = añoLanzamiento;
        this.disquera = disquera;
        this.canciones = new ArrayList<>();
        this.artistas = artistas;
    }

    /**
     * Obtiene el nombre del álbum.
     *
     * @return El nombre del álbum.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el año de lanzamiento del álbum.
     *
     * @return El año de lanzamiento del álbum.
     */
    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    /**
     * Obtiene la disquera del álbum.
     *
     * @return La disquera del álbum.
     */
    public String getDisquera() {
        return disquera;
    }

    /**
     * Obtiene la lista de canciones del álbum.
     *
     * @return La lista de canciones del álbum.
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Obtiene la lista de artistas del álbum.
     *
     * @return La lista de artistas del álbum.
     */
    public List<String> getArtistas() {
        return artistas;
    }
}
