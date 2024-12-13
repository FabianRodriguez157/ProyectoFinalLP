package galeria;


public class Obra {
    private int idObra;
    private String titulo;
    private String tipo;
    private String fechaCreacion;
    private String tecnica;
    private String dimensiones;
    private String descripcion;
    private String imagenUrl;

    // Constructor
    public Obra(int idObra, String titulo, String tipo, String fechaCreacion, String tecnica, String dimensiones, String descripcion, String imagenUrl) {
        this.idObra = idObra;
        this.titulo = titulo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.tecnica = tecnica;
        this.dimensiones = dimensiones;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
    }


    // Getters y Setters|
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
