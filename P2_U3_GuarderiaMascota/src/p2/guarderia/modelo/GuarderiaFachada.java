/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

import java.util.ArrayList;

/**
 *
 * @author Boris Perez
 */
public class GuarderiaFachada {

    private IDAO idao;

    public void agregarMascota(String id, String nombre, String edad, String raza) throws Exception {
        int edadParseada = Integer.parseInt(edad);

        idao = new MascotaDAO();

        MascotaDTO dto = new MascotaDTO(id, nombre, raza, edadParseada);

        idao.agregar(dto);

    }

    public void eliminarMascota(String id) {
        idao = new MascotaDAO();
        idao.eliminar(id);
    }

    public void actualizarMascota(String id, String nombre, String raza, String edad) {
        int edadMascota = Integer.parseInt(edad);
        MascotaDTO dto = new MascotaDTO(id, nombre, raza, edadMascota);
        idao = new MascotaDAO();
        idao.actiualizar(id, dto);
    }

    public MascotaDTO buscarMascota(String idMascota) throws Exception {
        idao = new MascotaDAO();
        MascotaDTO dtoM = (MascotaDTO) idao.buscar(idMascota);
        //System.out.println("CODIGO DEL DUEÑO:" + dtoM.getDto().getId());

        idao = new PersonaDAO();
        PersonaDTO dtoP = (PersonaDTO) idao.buscar(dtoM.getDto().getId());
        //System.out.println("CODIGO DEL DUEÑO " + dtoP.getId());

        dtoM.setDto(dtoP);

        System.out.println("SE PUDO BUSCARMASCOTA");
        return dtoM;
    }

    public void asignarPropietarioMascota(String idMascota, String idPersona) throws Exception {

        idao = new MascotaDAO();
        MascotaDTO dtoM = (MascotaDTO) idao.buscar(idMascota);
        
        idao = new PersonaDAO();
        PersonaDTO dtoP = (PersonaDTO) idao.buscar(idPersona);

        dtoM.setDto(dtoP);

        idao = new MascotaDAO();
        idao.actiualizar(idMascota, dtoM);
        // Actualizar!!
    }

    public void retirarPropietrioMascota(String id) {
        try {
            PersonaDTO dtoP = new PersonaDTO();
            idao = new MascotaDAO();
            MascotaDTO dto = buscarMascota(id);
            dto.setDto(dtoP);
            System.out.println("ID: " + dto.getId() + "Nombre: " + dto.getNombre() + "Raza: "
                    + dto.getRaza() + "edad: " + dto.getEdad() + "dueño: " + dto.getDto().getId());
            idao = new MascotaDAO();
            idao.actiualizar(id, dto);
        } catch (Exception e) {
            System.out.println("No se pudo retirarPropietarioMascota()");
        }

    }

    public String[] listarPersonas() {
        idao = new PersonaDAO();
        ArrayList<IObjetoDTO> lista;

        lista = idao.listar();
        String[] listaString = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            listaString[i] = lista.get(i).getId() + " - " + lista.get(i).getNombre();
        }
        return listaString;
    }

    public String[] listarMascotas() {
        idao = new MascotaDAO();
        ArrayList<IObjetoDTO> lista;

        lista = idao.listar();
        String[] listaString = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            listaString[i] = lista.get(i).getId() + " - " + lista.get(i).getNombre();
        }
        return listaString;
    }
}
