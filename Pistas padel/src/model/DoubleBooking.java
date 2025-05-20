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
public class DoubleBooking extends Booking{

    private Player[][] teams;
    
    public DoubleBooking(Date date, String hour, PadelCourt court) {
        super(date, hour, court);
        teams = new Player[2][2];
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public boolean isCompleted() {
        for(int i = 0; i < teams.length; i++) {
            for(int j =0; j < teams[i].length; j++) {
                if(teams[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean containsPlayer(String id) {
        for(int i = 0; i < teams.length; i++) {
            for(int j =0; j < teams[i].length; j++) {
                if(teams[i][j].getId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        
        StringBuilder desc = new StringBuilder(super.getDescription() + " Xogadores: ");
        
            for(int i = 0; i < teams.length; i++) {
                desc.append("\nEquipo ").append(i + 1).append(": ");
                for(int j= 0; j < teams[i].length; j++) {
                    if(teams[i][j] != null) {
                        desc.append(teams[i][j].getName()).append(" ");
                    } else {
                        desc.append("[Vacante]");
                    }
                }
            }
            
            return desc.toString();
    }
    
    /**
     * Engade un xogador ao array de teams pedindo o numero do equipo ao que se quere engadir o xogador
     * @param player xogador que se quere engadir
     * @param team equipo no que se quere engadir
     */
    public void addPlayer(Player player, int team) {
        for(int i = 0; i < teams[team].length; i++) {
            if(teams[team][i] == null) {
                teams[team][i] = player;
                return;
            }
        }
    }
    
    
}
