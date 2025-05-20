/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author joao.pedro.pereira
 */
public abstract class Booking {
    protected Date date;
    protected String hour;
    protected PadelCourt court;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public PadelCourt getCourt() {
        return court;
    }

    public void setCourt(PadelCourt court) {
        this.court = court;
    }

    public Booking(Date date, String hour, PadelCourt court) {
        this.date = date;
        this.hour = hour;
        this.court = court;
    }
    
    /**
     * Prezo que tenga que pagar cada xogador inscrito na reserva
     * @return prezo
     */
    public abstract double getPrice();
    
    /**
     * Indica se a reserva xa está completa
     * @return 
     */
    public abstract boolean isCompleted();
    
    /**
     * Comproba se un xogador está inscrito nunha reserva
     * @param id do xogador 
     * @return true se está inscrito, false se non está inscrito
     */
    public abstract boolean containsPlayer(String id);
    
    /**
     * Devolve os datos da reserva
     * @return o texto da reserva en String
     */
    public String getDescription(){
        
        
        String text = "Reserva pendente: Data: " + date + " Hora: " + hour + "Pista " + court;
              
        
        return text;
    }
    
}
