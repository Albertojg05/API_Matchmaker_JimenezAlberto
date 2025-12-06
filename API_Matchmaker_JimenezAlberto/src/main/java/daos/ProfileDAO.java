/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dtos.ProfileDTO;
import entitys.Perfil;
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

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MatchmakerPU");

    public void agregar(ProfileDTO perfilDTO) {

        EntityManager em = emf.createEntityManager();
        try {
            Perfil perfil = mapToEntity(perfilDTO);
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
            String jpql = "SELECT p FROM Perfil p WHERE p.edad = :edad AND p.pais = :pais AND p.genero = :genero";

            TypedQuery<Perfil> query = em.createQuery(jpql, Perfil.class);

            query.setParameter("edad", edad);
            query.setParameter("pais", pais);
            query.setParameter("genero", genero);

            List<Perfil> listaEntidades = query.getResultList();

            return listaEntidades.stream()
                    .map(entidad -> mapToDTO(entidad))
                    .collect(Collectors.toList());

        } finally {
            em.close();
        }
    }

    private ProfileDTO mapToDTO(Perfil perfil) {
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

    private Perfil mapToEntity(ProfileDTO perfilDTO) {
        if (perfilDTO == null) {
            return null;
        }

        Perfil perfil = new Perfil();

        perfil.setNombre(perfilDTO.getNombre());
        perfil.setApellidoPaterno(perfilDTO.getApellidoPaterno());
        perfil.setApellidoMaterno(perfilDTO.getApellidoMaterno());
        perfil.setFechaDeNacimiento(perfilDTO.getFechaDeNacimiento());
        perfil.setFoto(perfilDTO.getFoto());
        perfil.setEmail(perfilDTO.getEmail());
        perfil.setGenero(perfilDTO.getGenero());
        perfil.setPais(perfilDTO.getPais());
        perfil.setTelefono(perfilDTO.getTelefono());
        perfil.setCelular(perfilDTO.getCelular());
        perfil.setDireccion(perfilDTO.getDireccion());
        perfil.setEdad(perfilDTO.getEdad());

        return perfil;
    }

    public void cerrarFactory() {
        if (emf != null) {
            emf.close();
        }
    }

}
