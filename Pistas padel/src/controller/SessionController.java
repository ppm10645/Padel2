/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Booking;
import model.DoubleBooking;
import model.PadelCourt;
import model.Player;
import model.SingleBooking;
import persistence.BookingDB;
import persistence.PadelCourtDB;
import view.SessionView;

/**
 *
 * @author joao.pedro.pereira
 */
public class SessionController {

    private SessionView view;
    private Player sessionPlayer;

    public Player getSessionPlayer() {
        return sessionPlayer;
    }

    public void setSessionPlayer(Player sessionPlayer) {
        this.sessionPlayer = sessionPlayer;
    }
    
    

    /**
     * Constructor do sessionController
     *
     * @param sessionPlayer usuario da sesion actual
     */
    public SessionController(Player sessionPlayer) {
        this.sessionPlayer = sessionPlayer;
        this.view = new SessionView(this);
    }

    /**
     * Obten as reservas do dia actual do usuario e inicia sesion con esas
     * reservas
     */
    public void loadSession() throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date today = calendar.getTime();

        ArrayList<Booking> mybookings = BookingDB.findByUserAndDate(sessionPlayer.getName(), today);
        view.showSessionMenu(mybookings);
    }

    /**
     * Crea unha nova reserva
     *
     * @param data data de cando se quere reservar unha pista
     */
    public void createBooking(Date data) throws ParseException {
        ArrayList<PadelCourt> courts = PadelCourtDB.getAllCourts();
        ArrayList<Booking> bookings = BookingDB.findByDate(data);
        view.selectCourtAndHour(data, courts, bookings);
    }

    /**
     *Crea unha reserva e engade o xogador actual a reserva
     * @param data data da reserva
     * @param hour hora da reserva
     * @param court pista da reserva
     */
    public void completeBooking(Date data, String hour, PadelCourt court) throws ParseException {
        Booking booking = null;

        if (court.getType() == PadelCourt.SINGLE) {
            booking = new SingleBooking(data, hour, court);
        } else if (court.getType() == PadelCourt.DOUBLE) {
            booking = new DoubleBooking(data, hour, court);
        }
            addPlayerToBooking(data);
            BookingDB.save(booking);
            loadSession();

    }

    /**
     * Engade o xogador da sesion a unha reserva
     * @param data
     */
    public void addPlayerToBooking(Date data) throws ParseException {
        loadSession();
    }
}
