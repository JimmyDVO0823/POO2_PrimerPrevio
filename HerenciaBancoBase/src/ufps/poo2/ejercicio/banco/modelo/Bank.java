package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

public class Bank {

    public Bank() {

    }

    /**
     *
     * @param numero
     * @param saldo
     * @param tipo S para SavingAccount, C para CurrentAccount
     * @throws java.lang.Exception
     */
    public void crearCuenta(String numero, String saldo, char tipo) throws Exception {
        Account cuenta = null;

        int numCuenta = 0;

        try {
            numCuenta = Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            throw new Exception("El número de cuenta es numérico");
        }

        double balance = 0;

        try {
            balance = Double.parseDouble(saldo);
        } catch (NumberFormatException e) {
            throw new Exception("El número del saldo es numérico");
        }

        switch (tipo) {
            case 'S':
                cuenta = new SavingAccount(numCuenta, 0.15);
                break;
            case 'C':
                double valorSobregiro = balance * 0.2;
                cuenta = new CurrentAccount(numCuenta, valorSobregiro);
                break;
        }

        try {
            cuenta.deposit(balance);
            cuenta.add();
        } catch (NullPointerException e) {
            throw new Exception("La cuenta no se pudo crear");
        }

    }

    public String depositar(String numeroCuenta, String valor) throws Exception {
        Account cuenta = buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            throw new Exception("No se encontró la cuenta");
        }

        double balance = 0;

        try {
            balance = Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            throw new Exception("El número del saldo es numérico");
        }

        System.out.println("se deposita");
        cuenta.deposit(balance);
        

        return "Cuenta " + numeroCuenta + "::: Nuevo saldo = " + cuenta.getBalance();

    }

    public String retirar(String numeroCuenta, String valor) throws Exception {
        Account cuenta = buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            throw new Exception("No se encontró la cuenta");
        }

        double balance = 0;

        try {
            balance = Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            throw new Exception("El número del saldo es numérico");
        }

        System.out.println("se retira");
        cuenta.withdraw(balance);
        return "Cuenta " + numeroCuenta + "::: Nuevo saldo = " + cuenta.getBalance();
    }

    public ArrayList<Account> listarCuentas() throws Exception {
        ArrayList<Account> cuentas = new ArrayList<>();
        cuentas.addAll(Account.listAccounts());
        return cuentas;
    }

    private Account buscarCuenta(String numeroCuenta) throws Exception {

        ArrayList<Account> cuentas = listarCuentas();
        
        int numCuenta;

        try {
            numCuenta = Integer.parseInt(numeroCuenta);
        } catch (NumberFormatException e) {
            throw new Exception("El número de cuenta es numérico");
        }

        for (Account cuenta : cuentas) {
            if (cuenta.getAccountNumber() == numCuenta) {
                return cuenta;
            }
        }
        return null;
    }

}
