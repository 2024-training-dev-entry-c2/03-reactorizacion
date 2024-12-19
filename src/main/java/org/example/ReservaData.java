    package org.example;

    import java.time.LocalDate;

    public class ReservaData {
        private Cliente cliente;
        private LocalDate fechaIngreso;
        private LocalDate fechaSalida;
        private Habitacion habitacion;
        private Alojamientos alojamiento;

        public ReservaData(Cliente cliente, LocalDate fechaIngreso, LocalDate fechaSalida, Habitacion habitacion, Alojamientos alojamiento) {
            this.cliente = cliente;
            this.fechaIngreso = fechaIngreso;
            this.fechaSalida = fechaSalida;
            this.habitacion = habitacion;
            this.alojamiento = alojamiento;
        }
        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public LocalDate getFechaIngreso() {
            return fechaIngreso;
        }

        public void setFechaIngreso(LocalDate fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
        }

        public Habitacion getHabitacion() {
            return habitacion;
        }

        public void setHabitacion(Habitacion habitacion) {
            this.habitacion = habitacion;
        }

        public LocalDate getFechaSalida() {
            return fechaSalida;
        }

        public void setFechaSalida(LocalDate fechaSalida) {
            this.fechaSalida = fechaSalida;
        }

        public Alojamientos getAlojamiento() {
            return alojamiento;
        }

        public void setAlojamiento(Alojamientos alojamiento) {
            this.alojamiento = alojamiento;
        }

    }
