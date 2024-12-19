package modelos;

public class ClienteData {

    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String nacionalidadUsuario;
    private String telefonoUsuario;
    private String nacimientoUsuario;

    public ClienteData(String nombreUsuario, String apellidoUsuario, String nacionalidadUsuario, String correoUsuario, String telefonoUsuario, String nacimientoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.nacionalidadUsuario = nacionalidadUsuario;
        this.correoUsuario = correoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.nacimientoUsuario = nacimientoUsuario;
    }

    // getters and setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getNacionalidadUsuario() {
        return nacionalidadUsuario;
    }

    public void setNacionalidadUsuario(String nacionalidadUsuario) {
        this.nacionalidadUsuario = nacionalidadUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getNacimientoUsuario() {
        return nacimientoUsuario;
    }

    public void setNacimientoUsuario(String nacimientoUsuario) {
        this.nacimientoUsuario = nacimientoUsuario;
    }
}
