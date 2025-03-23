/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO LOQ
 */
public class SavingAccountDAO implements IDAO{

    @Override
    public void add(Account dto) {
        String archivo = "C:\\Users\\LENOVO LOQ\\OneDrive\\Escritorio\\PrimerPrevioPOO\\HerenciaBancoBase\\src\\ufps\\poo2\\ejercicio\\banco\\AccountFiles\\SavingAccounts.txt";

        String nuevaLinea = String.join(";", String.valueOf(dto.getAccountNumber()), "" + dto.getBalance());
        System.out.println(nuevaLinea);
        // Abrir el archivo en modo append (true) para añadir al final
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(nuevaLinea); // Escribir la nueva línea
            bw.newLine();         // Añadir salto de línea
            System.out.println("Cuenta añadida exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String numeroCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String numeroCuenta, Account dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Account> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account find(int numeroCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
