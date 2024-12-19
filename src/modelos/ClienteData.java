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

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public String getNacionalidadUsuario() {
        return nacionalidadUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public String getNacimientoUsuario() {
        return nacimientoUsuario;
    }

}
