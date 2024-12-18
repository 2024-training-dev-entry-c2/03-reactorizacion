package alojamientos;

public class Finca extends Alojamiento implements IDiaDeSol{

    private DiaDeSolData diaDeSol;

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



    public DiaDeSolData getDiaDeSol() {
        return diaDeSol;
    }

    public void setDiaDeSol(DiaDeSolData diaDeSol) {
        this.diaDeSol = diaDeSol;
    }

}
