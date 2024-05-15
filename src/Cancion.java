/**
 * Clase que representa una canción.
 */
public class Cancion {

    private String titulo;
    private double duracion;

    /**
     * Constructor de la clase Cancion.
     *
     * @param titulo El título de la canción.
     * @param duracion La duración de la canción en minutos.
     */
    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    /**
     * Obtiene el título de la canción.
     *
     * @return El título de la canción.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la duración de la canción.
     *
     * @return La duración de la canción en minutos.
     */
    public double getDuracion() {
        return duracion;
    }
}
