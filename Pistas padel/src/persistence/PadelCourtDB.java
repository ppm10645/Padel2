/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.util.ArrayList;
import model.PadelCourt;

/**
 *
 * @author joao.pedro.pereira
 */
public class PadelCourtDB {
    
    /**
     * Devolve un ArrayList con todas as pistas da base de datos
     * @return 
     */
    public static ArrayList<PadelCourt> getAllCourts() {
        
        return PadelManagerDB.getCourts();
    } 
    
}
