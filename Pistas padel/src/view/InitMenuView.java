/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.InitMenuController;
import java.util.Scanner;

/**
 *
 * @author joao.pedro.pereira
 */
public class InitMenuView {
    
    private InitMenuController controller;
    private Scanner scanner = new Scanner(System.in);

    public InitMenuView(InitMenuController controller) {
        this.controller = controller;
    }

    /**
     * Mostra unha mensaxe por pantalla indicando que as credencias introducidas non son correctas
     */
    public void showInvalidUser(){
        System.out.println("Os datos introducidos non son correctos");
    }
    
    public boolean showLoginMenu() {
        System.out.println("Introduzca o id de usuario");
        String id = scanner.nextLine();
        
        if(id == null) {
            return true;
        } else {
            System.out.println("Introduzca o contrasinal");
            String pass = scanner.nextLine().System.console().readPassword().toString();
        }
        
        return false;
    }
    
    
    
}
