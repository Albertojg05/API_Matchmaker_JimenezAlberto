/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dtos.ProfileDTO;
import entitys.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Alberto Jimenez
 */
public class ProfileDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Matchmaker");

    public void agregar(ProfileDTO perfilDTO) {

        EntityManager em = emf.createEntityManager();
        try {
            Profile perfil = mapToEntity(perfilDTO);
            em.getTransaction().begin();
            em.persist(perfil);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<ProfileDTO> buscarPorCriterios(int edad, String pais, String genero) {
        EntityManager em = emf.createEntityManager();
        try {
            // 1. La consulta sigue siendo sobre la Entidad "Perfil"
            String jpql = "SELECT p FROM Perfil p WHERE p.edad = :edad AND p.pais = :pais AND p.genero = :genero";

            TypedQuery<Profile> query = em.createQuery(jpql, Profile.class);

            query.setParameter("edad", edad);
            query.setParameter("pais", pais);
            query.setParameter("genero", genero);

            // 2. Obtenemos la lista de Entidades
            List<Profile> listaEntidades = query.getResultList();

            // 3. Convertimos la lista de Entidades a lista de DTOs
            return listaEntidades.stream()
                    .map(entidad -> mapToDTO(entidad))
                    .collect(Collectors.toList());

        } finally {
            em.close();
        }
    }

    private ProfileDTO mapToDTO(Profile perfil) {
        return new ProfileDTO(
                perfil.getNombre(),
                perfil.getApellidoPaterno(),
                perfil.getApellidoMaterno(),
                perfil.getFechaDeNacimiento(),
                perfil.getFoto(),
                perfil.getEmail(),
                perfil.getGenero(),
                perfil.getPais(),
                perfil.getTelefono(),
                perfil.getCelular(),
                perfil.getDireccion(),
                perfil.getEdad()
        );
    }

    /**
     * Convierte un DTO (datos que vienen del API/Usuario) a una Entidad
     * (formato BD).
     *
     * @param dto El objeto de transferencia de datos.
     * @return La entidad lista para ser persistida.
     */
    private Profile mapToEntity(ProfileDTO dto) {
        if (dto == null) {
            return null;
        }

        Profile perfil = new Profile();

        perfil.setNombre(dto.getNombre());
        perfil.setApellidoPaterno(dto.getApellidoPaterno());
        perfil.setApellidoMaterno(dto.getApellidoMaterno());
        perfil.setFechaDeNacimiento(dto.getFechaDeNacimiento());
        perfil.setFoto(dto.getFoto());
        perfil.setEmail(dto.getEmail());
        perfil.setGenero(dto.getGenero());
        perfil.setPais(dto.getPais());
        perfil.setTelefono(dto.getTelefono());
        perfil.setCelular(dto.getCelular());
        perfil.setDireccion(dto.getDireccion());
        perfil.setEdad(dto.getEdad());

        return perfil;
    }

    public void cerrarFactory() {
        if (emf != null) {
            emf.close();
        }
    }

}
