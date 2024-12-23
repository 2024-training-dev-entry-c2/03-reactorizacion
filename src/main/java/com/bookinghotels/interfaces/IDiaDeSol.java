package com.bookinghotels.interfaces;

import java.time.LocalDate;

public interface IDiaDeSol {
    boolean tieneDiaDeSol();
    void mostrarInfoDiaDeSol(Integer cantPersonas, LocalDate fechaInicio);
}
