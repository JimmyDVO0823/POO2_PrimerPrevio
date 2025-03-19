package ufps.poo2.ejercicio.banco.modelo;

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

    public double getBalance() {
        return bal;
    }

    public int getAccountNumber() {
        return accnum;
    }

    public String toString() {
        return "Acc " + accnum + ": " + "balance = " + bal;
    }

    public final void print() {
        // Don't override this,
        // override the toString method
        System.out.println(toString());
    }

}
