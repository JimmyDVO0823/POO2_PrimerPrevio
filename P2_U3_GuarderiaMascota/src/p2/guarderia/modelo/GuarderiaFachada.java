/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

/**
 *
 * @author Boris Perez
 */
public class GuarderiaFachada {
 
    private IDAO idao;
    
    public void agregarMascota(String id, String nombre, 
            String edad, String raza) throws Exception{
        
        idao = new MascotaDAO();
        
        
        MascotaDTO dto = new MascotaDTO(id, nombre);
        
        idao.agregar(dto);
        
    }
    
    public void asignarPropietarioMascota(String idMascota, 
            String idPersona) throws Exception{
        
        idao = new MascotaDAO();
        MascotaDTO dtoM = (MascotaDTO)idao.buscar(idMascota);
        
        idao = new PersonaDAO();
        PersonaDTO dtoP = (PersonaDTO) idao.buscar(idPersona);
        
        dtoM.setDto(dtoP);
        
        // Actualizar!!
        
    }
    
    public void buscarMascota(String idMascota) throws Exception{
        idao = new MascotaDAO();
        MascotaDTO dtoM = (MascotaDTO)idao.buscar(idMascota);
        
        idao = new PersonaDAO();
        PersonaDTO dtoP = (PersonaDTO) idao.buscar(dtoM.getDto().getId());
        
        dtoM.setDto(dtoP);
        
    }
    
}
