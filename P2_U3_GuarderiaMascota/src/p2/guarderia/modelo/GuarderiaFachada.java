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

    public void agregarMascota(String id, String nombre,
            String edad, String raza) throws Exception {
        int edadParseada = Integer.parseInt(edad);

        idao = new MascotaDAO();

        MascotaDTO dto = new MascotaDTO(id, nombre, raza, edadParseada);

        idao.agregar(dto);

    }

    public void eliminarMascota() {

    }

    public MascotaDTO buscarMascota(String idMascota) throws Exception {
        idao = new MascotaDAO();
        MascotaDTO dtoM = (MascotaDTO) idao.buscar(idMascota);
        System.out.println("EL NOMBRE DE LA MASCOTA ES: " + dtoM.getNombre());

        idao = new PersonaDAO();
        PersonaDTO dtoP = (PersonaDTO) idao.buscar(dtoM.getDto().getId());

        dtoM.setDto(dtoP);

        return dtoM;
    }

    public void asignarPropietarioMascota(String idMascota,
            String idPersona) throws Exception {

        idao = new MascotaDAO();
        MascotaDTO dtoM = (MascotaDTO) idao.buscar(idMascota);

        idao = new PersonaDAO();
        PersonaDTO dtoP = (PersonaDTO) idao.buscar(idPersona);

        dtoM.setDto(dtoP);

        // Actualizar!!
    }

    public void retirarPropietrioMascota() {

    }

    public String[] listarMascotas() {
        idao = new MascotaDAO();
        ArrayList<IObjetoDTO> lista;

        lista = idao.listar();
        String[] listaString = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            listaString[i] = lista.get(i).getId();
        }
        return listaString;
    }

    public String[] listarPersonas() {
        idao = new PersonaDAO();
        ArrayList<IObjetoDTO> lista;

        lista = idao.listar();
        String[] listaString = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            listaString[i] = lista.get(i).getId();
        }
        return listaString;
    }

    public void actualizarMascota() {

    }
}
