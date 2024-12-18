package alojamientos;

public class Apartamento extends Alojamiento implements IDiaDeSol{

    private Integer piso;
    private String numeroApartamento;

    @Override
    public Double calcularPrecioBase() {
        return 0.0;
    }

    @Override
    public void mostrarInformacion() {

    }

    @Override
    public Boolean estaDisponible() {
        return true;
    }

    @Override
    public Boolean tieneDiaDeSol() {
        return true;
    }

    @Override
    public void mostrarInfoDiaDeSol() {

    }

    @Override
    public double calcularPrecioBaseDiaSol() {
        return 0;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }
}
