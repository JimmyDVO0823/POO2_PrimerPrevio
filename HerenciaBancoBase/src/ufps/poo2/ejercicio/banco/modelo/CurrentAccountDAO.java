/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

import Utilerias.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO LOQ
 */
public class CurrentAccountDAO implements IDAO {

    private String ruta;

    public CurrentAccountDAO() {
        this.ruta = Util.CURRENT_ACCOUNTS;
    }

    @Override
    public void add(Account dto) {
        String nuevaLinea = String.join(";", String.valueOf(dto.getAccountNumber()), "" + dto.getBalance());
        System.out.println(nuevaLinea);
        // Abrir el archivo en modo append (true) para añadir al final
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
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

    }

    @Override
    public void update(String numeroCuenta, Account dto) {

        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;
        String[] nuevaLinea = {dto.getAccountNumber() + "", +dto.getBalance() + "" };

        // Se abre el archivo para leer
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            // Se lee el contenido de la línea
            while ((linea = br.readLine()) != null) {
                // Se divide la linea en sus partes: numerocuenta | saldo | tipocuenta
                String[] partes = linea.split(";");

                // Saco el número de la cuenta para poder actualizar el saldo
                String numCuenta = partes[0];

                if (numCuenta.equals(numeroCuenta)) {

                    // Se asigna el saldo en la posicion correspondiente del arreglo
                    partes = nuevaLinea;
                    // En caso de que el valor lleve decimales muchos decimales, 
                    // el valor se puede formatear a String con solo dos decimales.
                    // partes[1] = String.format("%.2f", nuevoSaldo);

                    // Se usa la función String.join para unir las partes de un arreglo
                    // y separarlas con el caracter indicado.
                    linea = String.join(";", partes);

                    /*
                        Otra forma de hacerlo hubiera sido:
                        linea = partes[0]+";"+partes[1]+";"+partes[2];
                        Pero, si eventualmente el arreglo de String se crece, tocaría
                        hacer la adición de forma manual. En cambio la función join
                        se encarga de eso automáticamente.
                     */
                    encontrado = true;
                }
                // Se van consolidando las lineas en un ArrayList.
                // Esto se hace para luego escribirlas en un archivo.
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (!encontrado) {
            System.out.println("Número de cuenta no encontrado.");
            return;
        }

        //  Escribir de nuevo el archivo con las modificaciones
        /*  Importante: Se reescribe todo el archivo usando new FileWriter(archivo), 
            que borra el contenido original antes de escribir la nueva versión.
            Si se quisiera agregar contenido al final del archivo, se tendría que usar
            el constructor FileWriter(archivo, boolean append).
            Esto será útil para cuando se creen nuevas cuentas.
         */
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    @Override
    public Account find(int numeroCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Account> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

/*
 public static void añadirCuenta(String archivo, String numeroCuenta, double saldo, String tipoCuenta) {
    // Formatear el saldo a dos decimales (opcional, pero recomendado)
    String saldoFormateado = String.format("%.2f", saldo);
    
    // Crear la nueva línea con el formato: numeroCuenta;saldo;tipoCuenta
    String nuevaLinea = String.join(";", numeroCuenta, saldoFormateado, tipoCuenta);
    
    // Abrir el archivo en modo append (true) para añadir al final
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
        bw.write(nuevaLinea); // Escribir la nueva línea
        bw.newLine();         // Añadir salto de línea
        System.out.println("Cuenta añadida exitosamente.");
    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo: " + e.getMessage());
    }
}
 */
