/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

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
        
        file.writeln(linea);
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
        
        dto.setId(arreglo[0]);
        dto.setNombre(arreglo[1]);
        dto.setEdad(arreglo[2]);
        dto.setRaza(arreglo[3]);
        
        PersonaDTO dtoP = new PersonaDTO();
        dtoP.setId(arreglo[4]);
        
        dto.setDto(dtoP);
        
        
        
        return dto;
    }
    
}
