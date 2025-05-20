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
public class SingleBooking extends Booking{
    
    private Player[] players;

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
    
    

    public SingleBooking(Date date, String hour, PadelCourt court) {
        super(date, hour, court);
        players = new Player[2];
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public boolean isCompleted() {
        for(Player p:players) {
            if(p == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsPlayer(String id) {
        for(Player p:players) {
            if(p.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        
        StringBuilder desc = new StringBuilder(super.getDescription() + " Xogadores: ");
        
            for(int i = 0; i < players.length; i++) {
                if(players[i] != null) {
                    desc.append(players[i].getName()).append(" ");
                } else {
                    desc.append("[Vacante] ");
                }
            } 
            
            return desc.toString();
    }
    
    /**
     * Engade un xogador a unha posición do array que esté dispoñible
     * @param player xogador que se quere engadir
     */
    public void addPlayer(Player player){
        for(int i = 0; i < players.length; i++) {
            if(players[i] == null){
                players[i] = player;
                return; //Preguntar si es necesario hacer un break
            }
        }
    }    
    
    
}
