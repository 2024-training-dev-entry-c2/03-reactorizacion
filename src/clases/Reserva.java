package clases;

public class Reserva<T> {
 private Cliente cliente;
 private T alojamiento;
 private Integer cantidadHabitaciones;
 private Habitacion habitacion;
 private String fechaInicio;
 private String fechaFin;
 private String horaLlegada;

 public Reserva() {}

 public Reserva(Cliente cliente, T alojamiento, Habitacion habitacion, Integer cantidadHabitaciones, String fechaInicio, String fechaFin, String horaLlegada) {
  this.cliente = cliente;
  this.alojamiento = alojamiento;
  this.habitacion = habitacion;
  this.cantidadHabitaciones = cantidadHabitaciones;
  this.fechaInicio = fechaInicio;
  this.fechaFin = fechaFin;
  this.horaLlegada = horaLlegada;
 }

 public Cliente getCliente() {
  return cliente;
 }

 public T getAlojamiento() {
  return alojamiento;
 }

 public void setAlojamiento(T alojamiento) {
  this.alojamiento = alojamiento;
 }


 public Habitacion getHabitacion() {
  return habitacion;
 }

 public void setHabitacion(Habitacion habitacion) {
  this.habitacion = habitacion;
 }

 public String getFechaInicio() {
  return fechaInicio;
 }

 public String getFechaFin() {
  return fechaFin;
 }

 public void setFechaInicio(String fechaInicio) {
  this.fechaInicio = fechaInicio;
 }

 public void setHoraLlegada(String horaLlegada) {
  this.horaLlegada = horaLlegada;
 }

 public void setCliente(Cliente cliente) {
  this.cliente = cliente;
 }

 public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
  this.cantidadHabitaciones = cantidadHabitaciones;
 }

 public void setFechaFin(String fechaFin) {
  this.fechaFin = fechaFin;
 }

 public String getHoraLlegada() {
  return horaLlegada;
 }
}
