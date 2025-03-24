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
        
        String linea = dtoMascota.getId()+";"+dtoMascota.getNombre()+";"+
                dtoMascota.getRaza()+";"+dtoMascota.getEdad()+";";
        
        if(dtoMascota.getDto()!=null)
            linea += dtoMascota.getDto().getId();
        else
            linea += "null";
                
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
        
        // Encuentra la linea
        // Split -> String[]
        
        dto.setId("");
        dto.setNombre("");
        dto.setEdad(1);
        dto.setRaza("");
        
        PersonaDTO dtoP = new PersonaDTO();
        dtoP.setId("");
        
        dto.setDto(dtoP);
        
        
        
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
