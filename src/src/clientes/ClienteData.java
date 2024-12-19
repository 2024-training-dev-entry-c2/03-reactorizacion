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

    public ClienteData() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

}
