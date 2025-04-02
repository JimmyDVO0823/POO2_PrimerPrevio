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

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.MASCOTAS))) {
            String linea;

            while ((linea = br.readLine()) != null && !encontrado) {

                String[] partes = linea.split(";");

                String idDB = partes[0];

                if (idDB.equals(id)) {
                    PersonaDTO personadto = new PersonaDTO();
                    personadto.setId(partes[4]);

                    dto.setId(partes[0]);
                    dto.setNombre(partes[1]);
                    dto.setRaza(partes[2]);
                    dto.setEdad(Integer.parseInt(partes[3]));
                    dto.setDto(personadto);

                    encontrado = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }

        if (!encontrado) {
            System.out.println("Número de cuenta no encontrado.");
            JOptionPane.showMessageDialog(null, "Mascota no Encontrada", "Busqueda Fallida", JOptionPane.ERROR_MESSAGE);
        }

        //System.out.println(dto.getNombre());
        return dto;
    }

    @Override
    public void eliminar(String idMascota) {
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.MASCOTAS))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(";");

                String id = partes[0];

                if (id.equals(idMascota)) {


                    linea = "";

                    encontrado = true;
                }
                
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

        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Paths.MASCOTAS))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void actiualizar(String idMascota, IObjetoDTO dtoF) {
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;
        MascotaDTO dto = (MascotaDTO) dtoF;

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.MASCOTAS))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(";");

                String id = partes[0];

                if (id.equals(idMascota)) {

                    partes[1] = dto.getNombre();
                    partes[2] = dto.getRaza();
                    partes[3] = String.valueOf(dto.getEdad());
                    //if(dto.getDto().getId() != null)partes[4] = dto.getDto().getId();

                    System.out.println("Nombre: " + partes[1] + "\nRaza: " + partes[2]
                    + "\nEdad: " + partes[3] + "\nID: " + partes[4]);
                    linea = String.join(";", partes);

                    encontrado = true;
                }

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

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Paths.MASCOTAS))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }

    }

    @Override
    public ArrayList<IObjetoDTO> listar() {
        ArrayList<IObjetoDTO> mascotas = new ArrayList<>();
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.MASCOTAS))) {
            String linea;

            while ((linea = br.readLine()) != null && !encontrado) {
                //System.out.println(linea);
                MascotaDTO dto = new MascotaDTO();
                PersonaDTO persona = new PersonaDTO();

                String[] partes = linea.split(";");

                persona.setId(partes[4]);

                dto.setId(partes[0]);
                dto.setNombre(partes[1]);
                dto.setRaza(partes[2]);
                dto.setEdad(Integer.parseInt(partes[3]));
                dto.setDto(persona);


                mascotas.add(dto);

                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }
        return mascotas;
    }
}
