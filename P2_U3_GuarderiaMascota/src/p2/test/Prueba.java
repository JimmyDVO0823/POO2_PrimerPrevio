/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.test;

import javax.swing.JOptionPane;
import p2.guarderia.modelo.GuarderiaFachada;

/**
 *
 * @author borisperezg
 */
public class Prueba {
    public static void main(String[] args)  {
        GuarderiaFachada gf = new GuarderiaFachada();
        
        try{
            gf.agregarMascota("101", "Juanchita", "4", "French poodle");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
