package com.example.services.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IInputValidatorService {

    Integer readInt(String prompt);

    LocalDate readLocalDate(String prompt);

    LocalTime readLocalTime(String prompt);

    void clearBuffer();
}
