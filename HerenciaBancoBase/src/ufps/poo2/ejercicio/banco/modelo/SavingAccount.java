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
public class SavingAccount extends Account {

    SavingAccountDAO dao;
    private double interest;

    public SavingAccount(int accnum, double interest) {
        super(accnum);
        this.interest = interest;
        dao = new SavingAccountDAO();
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public void withdraw(double sum) throws Exception {
        if (sum > super.getBalance()) {
            throw new Exception("Cuenta " + super.getAccountNumber() + ": No puede retirar valores mayores al saldo disponible");
        }
        super.withdraw(sum);
        dao.update(getAccountNumber() + "", this);
    }

    @Override
    public void deposit(double sum) throws Exception {

        double newVal = super.getBalance() * interest + sum;

        super.deposit(newVal);
        dao.update(getAccountNumber() + "", this);
    }

    @Override
    public void add() {
        dao.add(this);
    }

    @Override
    public String toString() {
        return "Num: " + getAccountNumber() + " Bal: " + getBalance() + " Int: " + getInterest();
    }
    
    

}
