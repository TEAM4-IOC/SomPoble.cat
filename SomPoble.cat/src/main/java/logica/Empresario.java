
package logica;


public class Empresario extends Persona{
    
    private int id_empresario;
    private String nombreNegocio;
    private String direccion;
    private String sector;
    private String CIF_NIF;

    public Empresario() {
    }

    public Empresario(int id_empresario, String nombreNegocio, String direccion, String sector, String CIF_NIF, String nombre, String apellidos, String email, String contraseña, String teléfono) {
        super(nombre, apellidos, email, contraseña, teléfono);
        this.id_empresario = id_empresario;
        this.nombreNegocio = nombreNegocio;
        this.direccion = direccion;
        this.sector = sector;
        this.CIF_NIF = CIF_NIF;
    }

    public int getId_empresario() {
        return id_empresario;
    }

    public void setId_empresario(int id_empresario) {
        this.id_empresario = id_empresario;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCIF_NIF() {
        return CIF_NIF;
    }

    public void setCIF_NIF(String CIF_NIF) {
        this.CIF_NIF = CIF_NIF;
    }

    
    
    
}