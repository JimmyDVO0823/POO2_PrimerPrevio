/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

/**
 *
 * @author LENOVO LOQ
 */
public interface IDAO {
    
    void add(Account dto);
    
    void delete(String numeroCuenta);
    
    void update(String numeroCuenta, Account dto);
    
    ArrayList<Account> list();
    
    Account find(int numeroCuenta);
    
}
