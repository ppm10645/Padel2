/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.SessionController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.Booking;
import model.PadelCourt;

/**
 *
 * @author joao.pedro.pereira
 */
public class SessionView {

    private SessionController controller;
    private Scanner scanner;

    public SessionView(SessionController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Mostra o menu principal
     *
     * @param bookings
     * @throws ParseException
     */
    public void showSessionMenu(ArrayList<Booking> bookings) throws ParseException {
        System.out.println("Benvindo a aplicacion de padel " + controller.getSessionPlayer().getName());
        System.out.println("Saldo actual: " + controller.getSessionPlayer().getBalance());
        System.out.println("Reservas recibidas:");

        for (Booking bk : bookings) {
            System.out.println(bk.getDescription());
        }

        System.out.println("\nOpcions: ");
        System.out.println("1. Crear unha reserva");
        System.out.println("2. Apuntarse a un partido");
        System.out.println("3. Pechar sesion");

        int option = -1;
        while (option < 1 || option > 3) {
            System.out.println("Seleciona unha opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option == 1 || option == 2) {
                    Date date = null;
                    while (date == null) {
                        try {
                            System.out.println("Introduce a data do partido (dd/MM/yyyy): ");
                            String dateStr = scanner.nextLine();
                            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                        } catch (Exception e) {
                            System.out.println("Data non valida. Introduce de novo");
                        }
                    }
                    if (option == 1) {
                        controller.createBooking(date);
                    } else if (option == 2) {
                        controller.addPlayerToBooking(date);
                    }
                } else if (option == 3) {
                    System.out.println("Pechando session");
                    break;
                } else {
                    System.out.println("Opción non permitida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Numero non valido, introduzca de novo");
            }
        }

    }

    /**
     *
     * @param data
     * @param courts
     * @param bookings
     */
    public void selectCourtAndHour(Date data, ArrayList<PadelCourt> courts, ArrayList<Booking> bookings) throws ParseException {
        System.out.println("Pistas disponibles:");

        for (PadelCourt court : courts) {
            System.out.println("Pista " + court.getNumber() + " (" + (court.getType() == PadelCourt.SINGLE ? "Individual" : "Doble") + ")");
        }

        System.out.print("Seleccione el número de la pista: ");
        int courtNumber = scanner.nextInt();
        scanner.nextLine();

        PadelCourt selectedCourt = null;
        for (PadelCourt court : courts) {
            if (court.getNumber() == courtNumber) {
                selectedCourt = court;
                break;
            }
        }

        if (selectedCourt == null) {
            System.out.println("Pista no válida. Vuelve a intentarlo.");
            return;
        }

        System.out.println("Horas disponibles:");
        for (String hour : selectedCourt.getBookingHours()) {
            boolean booked = false;
            for (Booking existingBooking : bookings) {
                if (existingBooking.getHour().equals(hour) && existingBooking.getCourt().getNumber() == courtNumber) {
                    booked = true;
                    break;
                }
            }
            if (!booked) {
                System.out.println(hour);
            }
        }

        System.out.print("Seleccione una hora: ");
        String selectedHour = scanner.nextLine();

        controller.completeBooking(data, selectedHour, selectedCourt);
    }
}
