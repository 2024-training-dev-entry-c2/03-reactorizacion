package com.bookinghotels;

import com.bookinghotels.controller.flujo.FlowController;
import com.bookinghotels.utils.ConsolaUtils;


public class Main {

    public static void main(String[] args) {
        ConsolaUtils consolaUtils = new ConsolaUtils();
        FlowController flowController = new FlowController();
        mostrarLogo();
        flowController.iniciarFlujo();

    }

    public static void  mostrarLogo(){
        System.out.println("\n         ___|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|___    ");
        System.out.println("        |                                     |    ");
        System.out.println("        |      Bienvenido(a) a Book Stay      |    ");
        System.out.println("        |_____________________________________|    ");
        System.out.println("               |     |     |     |     |          \n");
    }
}
