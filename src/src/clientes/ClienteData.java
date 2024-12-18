package clientes;

public class ClienteData {

    String nombre;
    String apellido;
    String fechaNacimiento;
    String numeroTel;
    String correo;
    String nacinalidad;


    public ClienteData(String nombre, String apellido, String fechaNacimiento, String numeroTel, String correo, String nacinalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTel = numeroTel;
        this.correo = correo;
        this.nacinalidad = nacinalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNacinalidad() {
        return nacinalidad;
    }

    public void setNacinalidad(String nacinalidad) {
        this.nacinalidad = nacinalidad;
    }
}
