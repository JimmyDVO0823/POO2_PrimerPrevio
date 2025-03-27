/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Utilities.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import Utilities.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author borisperezg
 */
public class MascotaDAO implements IDAO {

    @Override
    public void agregar(IObjetoDTO dto) throws Exception {
        // Abrir el archivo

        // Buscar la última del archivo
        // Insertar la mascota
        MascotaDTO dtoMascota = (MascotaDTO) dto;

        String linea = dtoMascota.getId() + ";" + dtoMascota.getNombre() + ";"
                + dtoMascota.getRaza() + ";" + dtoMascota.getEdad() + ";";

        if (dtoMascota.getDto() != null) {
            linea += dtoMascota.getDto().getId();
        } else {
            linea += "null";
        }

        System.out.println(linea);
        // Abrir el archivo en modo append (true) para añadir al final
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Paths.MASCOTAS, true))) {
            bw.write(linea); // Escribir la nueva línea
            bw.newLine();         // Añadir salto de línea
            System.out.println("Cuenta añadida exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

    }

    @Override
    public IObjetoDTO buscar(String id) throws Exception {
        // Esto no se hace así. Debe buscar
        // dentro del archivo el registro
        // que corresponda con el ID, y 
        // crear el objeto y llenarlo.
        MascotaDTO dto = new MascotaDTO();

        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        // Se abre el archivo para leer
        try (BufferedReader br = new BufferedReader(new FileReader(Paths.MASCOTAS))) {
            String linea;
            // Se lee el contenido de la línea
            while ((linea = br.readLine()) != null && !encontrado) {
                // Se divide la linea en sus partes: numerocuenta | saldo | tipocuenta
                String[] partes = linea.split(";");

                // Saco el número de la cuenta para poder actualizar el saldo
                String idDB = partes[0];

                if (idDB.equals(id)) {

                    dto.setId(partes[0]);
                    dto.setNombre(partes[1]);
                    dto.setRaza(partes[2]);
                    dto.setEdad(Integer.parseInt(partes[3]));
                    //if(partes[4] != null)dto.setDto(partes[4]);

                    encontrado = true;
                }
                // Se van consolidando las lineas en un ArrayList.
                // Esto se hace para luego escribirlas en un archivo.
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }

        if (!encontrado) {
            System.out.println("Número de cuenta no encontrado.");
            JOptionPane.showMessageDialog(null, "Mascota no Encontrada", "Busqueda Fallida", JOptionPane.ERROR_MESSAGE);
        }

//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Paths.MASCOTAS))) {
//            for (String linea : lineas) {
//                bw.write(linea);
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            System.err.println("Error al escribir el archivo: " + e.getMessage());
//        }
        System.out.println(dto);
        return dto;
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actiualizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<IObjetoDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
