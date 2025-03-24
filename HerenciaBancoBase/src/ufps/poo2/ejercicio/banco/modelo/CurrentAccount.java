/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

/**
 *
 * @author borisperezg
 */
public class CurrentAccount extends Account {

    CurrentAccountDAO dao = new CurrentAccountDAO();
    private double valorSobregiro;

    public CurrentAccount(int accnum, double valorSobregiro) {
        super(accnum);
        this.valorSobregiro = valorSobregiro;
    }

    @Override
    public void deposit(double sum) throws Exception {
        super.deposit(sum); 
        dao.update(getAccountNumber() + "", this);
    }

    @Override
    public void withdraw(double sum) throws Exception {

        if (valorSobregiro == 0) {
            throw new Exception("Cuenta " + super.getAccountNumber() + "::: No tiene valor de sobregiro asignado");
        }

        double valorDisponible = super.getBalance() + valorSobregiro;

        if (valorDisponible > sum) {
            super.withdraw(sum);
        } else {
            throw new Exception("Cuenta " + super.getAccountNumber() + "::: No tiene saldo para retirar");
        }
    }

    public void aniadirCuenta() {
        dao.add(this);

    }

    @Override
    public void add() {
        dao.add(this);
    }

    @Override
    public String toString() {
        return "Num: " + getAccountNumber()  + " Bal: " + getBalance() + " Sobregijo: " + getValorSobregiro();
    }

    public double getValorSobregiro() {
        return valorSobregiro;
    }

    public void setValorSobregiro(double valorSobregiro) {
        this.valorSobregiro = valorSobregiro;
    }

    
    
}
