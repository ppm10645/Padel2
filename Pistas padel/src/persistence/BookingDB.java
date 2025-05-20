/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.util.ArrayList;
import java.util.Date;
import model.Booking;

/**
 *
 * @author joao.pedro.pereira
 */
public class BookingDB {
    
    /**
     * Devolve un ArrayList de todas as reservas efectuadas na data recibida
     * @param data 
     * @return 
     */
    public static ArrayList<Booking> findByDate(Date data) {
        
        ArrayList<Booking> bookings = new ArrayList<>();
        
        for(int i = 0; i < PadelManagerDB.getBookings().size(); i++){
            if(PadelManagerDB.getBookings().get(i).getDate().equals(data)){
                bookings.add(PadelManagerDB.getBookings().get(i));
            }
        }
        
        return bookings;
    }
    
    public static ArrayList<Booking> findByUserAndDate(String id, Date data) {
        
        ArrayList<Booking> bookings = new ArrayList<>();
        
        for(int i = 0; i < PadelManagerDB.getBookings().size(); i++){
            if(PadelManagerDB.getBookings().get(i).getDate().equals(data) && PadelManagerDB.getBookings().get(i).containsPlayer(id)){
                bookings.add(PadelManagerDB.getBookings().get(i));
            }
        }
        
        return bookings;
    }
    
    /**
     * 
     * @param booking 
     */
    public static void save(Booking booking) {
        PadelManagerDB.getBookings().add(booking);
    }
}
