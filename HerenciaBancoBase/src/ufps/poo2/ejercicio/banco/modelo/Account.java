package ufps.poo2.ejercicio.banco.modelo;

import Utilerias.Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Account {

    private double bal; // The current balance
    private int accnum; // The account number

    public Account(int accnum) {
        bal = 0.0;
        this.accnum = accnum;
    }

    public void deposit(double sum) throws Exception  {
        if (sum > 0) {
            bal += sum;
        } else {
            throw new Exception("Cuenta " + this.accnum + "::: No puede consignar valores negativos.");
        }
    }

    public void withdraw(double sum) throws Exception {
        if (sum > 0) {
            bal -= sum;
        } else {
            throw new Exception("Cuenta " + this.accnum + "::: No puede retirar valores negativos.");
        }
    }

    
    public static ArrayList<Account> listAccounts() throws Exception{
        ArrayList<Account> cuentas = new ArrayList<>();
        ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();
        ArrayList<SavingAccount> savingAccounts = new ArrayList<>();

        // Se abre el archivo para leer
        try (BufferedReader br = new BufferedReader(new FileReader(Util.CURRENT_ACCOUNTS))) {
            String linea;
            // Se lee el contenido de la línea
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                CurrentAccount cuenta = new CurrentAccount(Integer.parseInt(partes[0]), 0.2);
                cuenta.deposit(Double.parseDouble(partes[1]));
                currentAccounts.add(cuenta);
                //System.out.println("El balance es de " + partes[1]);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        // Se abre el archivo para leer
        try (BufferedReader br = new BufferedReader(new FileReader(Util.SAVING_ACCOUNTS))) {
            String linea;
            // Se lee el contenido de la línea
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                SavingAccount cuenta = new SavingAccount(Integer.parseInt(partes[0]), 0.15);
                cuenta.deposit(Double.parseDouble(partes[1]));
                savingAccounts.add(cuenta);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        cuentas.addAll(currentAccounts);
        cuentas.addAll(savingAccounts);
        
        return cuentas;
    }
    
    public abstract void add();
    
    //GETTERS SETTER Y DEMAS
    public double getBalance() {
        return bal;
    }

    public int getAccountNumber() {
        return accnum;
    }

    @Override
    public String toString() {
        return "Acc " + accnum + ": " + "balance = " + bal;
    }

    public final void print() {
        // Don't override this,
        // override the toString method
        System.out.println(toString());
    }

}
