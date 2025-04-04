/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

import Utilities.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO LOQ
 */
public class PersonaDAO implements IDAO {

    @Override
    public void agregar(IObjetoDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public IObjetoDTO buscar(String id) throws Exception {
        PersonaDTO dto = new PersonaDTO();

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.PERSONAS))) {
            String linea;

            while ((linea = br.readLine()) != null && !encontrado) {

                String[] partes = linea.split(";");

                //Id de cad linea para compararlo con el id que mandan
                String idDB = partes[0];

                if (idDB.equals(id)) {
                    

                    dto.setId(partes[0]);
                    dto.setNombre(partes[1]);
                    
                    System.out.println("El dueño es " + partes[1]);

                    encontrado = true;
                }

                //lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }

        if (!encontrado) {
            System.out.println("Número de cuenta no encontradooooooooo.");
            JOptionPane.showMessageDialog(null, "Mascota no Encontrada", "Busqueda Fallida", JOptionPane.ERROR_MESSAGE);
        }

        //System.out.println("EL NOMBRE DE LA PERSONA ES: " + dto.getNombre());
        return dto;

    }

    @Override
    public void eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actiualizar(String id, IObjetoDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<IObjetoDTO> listar() {
        ArrayList<IObjetoDTO> personas = new ArrayList<>();
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.PERSONAS))) {
            String linea;

            while ((linea = br.readLine()) != null && !encontrado) {
                //System.out.println(linea);
                PersonaDTO dto = new PersonaDTO();
                PersonaDTO persona = new PersonaDTO();

                String[] partes = linea.split(";");


                dto.setId(partes[0]);
                dto.setNombre(partes[1]);
                


                personas.add(dto);

                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }
        return personas;
    }

}
