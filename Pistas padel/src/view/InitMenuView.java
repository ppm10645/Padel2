/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.InitMenuController;
import java.util.Scanner;
import persistence.PlayerDB;

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
    
    /**
     * Menu de inicio de sesion
     * @return 
     */
    public boolean showLoginMenu() {
        System.out.println("Introduzca o id de usuario para iniciar sesión, deixe baleiro para sair da aplicación");
        
        String loginpasswrd;
        String loginid = scanner.nextLine();
        
        if(loginid.isEmpty()){
            return true;
        } else {
            System.out.println("Introduzca o contrasinal");
            loginpasswrd = scanner.nextLine();
            controller.login(loginid, loginpasswrd);
        }
        return false;  
    }
    
    
    
}
