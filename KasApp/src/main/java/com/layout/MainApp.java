/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.layout;

/**
 *
 * @author LENOVO
 */
public class MainApp {

    public static void main(String[] args) {
        LoginLayout lg = new LoginLayout();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(LoginLayout.EXIT_ON_CLOSE);
    }
}
