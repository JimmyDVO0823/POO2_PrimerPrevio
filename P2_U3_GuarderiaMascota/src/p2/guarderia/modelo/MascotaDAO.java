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
        MascotaDTO dto = new MascotaDTO();

        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.MASCOTAS))) {
            String linea;

            while ((linea = br.readLine()) != null && !encontrado) {

                String[] partes = linea.split(";");

                String idDB = partes[0];

                if (idDB.equals(id)) {
                    PersonaDTO personadto = new PersonaDTO();
                    personadto.setId(id);

                    dto.setId(partes[0]);
                    dto.setNombre(partes[1]);
                    dto.setRaza(partes[2]);
                    dto.setEdad(Integer.parseInt(partes[3]));
                    dto.setDto(personadto);

                    encontrado = true;
                }

                //lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }

        if (!encontrado) {
            System.out.println("Número de cuenta no encontrado.");
            JOptionPane.showMessageDialog(null, "Mascota no Encontrada", "Busqueda Fallida", JOptionPane.ERROR_MESSAGE);
        }

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
        MascotaDTO dto = new MascotaDTO();
        PersonaDTO persona = new PersonaDTO();
        ArrayList<MascotaDTO> mascotas = new ArrayList<>();
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.MASCOTAS))) {
            String linea;

            while ((linea = br.readLine()) != null && !encontrado) {

                String[] partes = linea.split(";");

                persona.setId(partes[4]);
                
                dto.setId(partes[0]);
                dto.setNombre(partes[1]);
                dto.setRaza(partes[2]);
                dto.setEdad(Integer.parseInt(partes[3]));
                dto.setDto(persona);
                
                String idDB = partes[0];
                
                lineas.add(linea);
            }
            throw new UnsupportedOperationException("Not supported yet.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }

    }
