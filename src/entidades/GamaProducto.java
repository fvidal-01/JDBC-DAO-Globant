package entidades;

public class GamaProducto {
    private int idGama;
    private String gama;
    private String descripcionTexto;
    private String descripcionHTML;
    private String imagen;
    
    public GamaProducto() {
        
    }

    public GamaProducto(int idGama, String gama, String descripcionTexto, String descripcionHTML, String imagen) {
        this.idGama = idGama;
        this.gama = gama;
        this.descripcionTexto = descripcionTexto;
        this.descripcionHTML = descripcionHTML;
        this.imagen = imagen;
    }

    public int getIdGama() {
        return idGama;
    }

    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getDescripcionHTML() {
        return descripcionHTML;
    }

    public void setDescripcionHTML(String descripcionHTML) {
        this.descripcionHTML = descripcionHTML;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "GamaProducto [ID: " + idGama + ", Gama: " + gama + ", Descripcion: " + descripcionTexto
                + ", Descripcion (HTML): " + descripcionHTML + ", Imagen: " + imagen + "]";
    }

    
}