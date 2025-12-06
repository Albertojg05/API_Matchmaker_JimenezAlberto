/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import daos.ProfileDAO;
import dtos.ProfileDTO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Random;

/**
 * REST Web Service
 *
 * @author Alberto Jimenez
 */
@Path("perfiles")
@RequestScoped
public class PerfilResource {
    
    private ProfileDAO perfilDAO;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PerfilResource
     */
    public PerfilResource() {
        perfilDAO = new ProfileDAO();
    }

    /**
     * Retrieves representation of an instance of api.PerfilResource
     * @param edad
     * @param pais
     * @param genero
     * @return an instance of dtos.ProfileDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileDTO getJson(@QueryParam("edad") int edad, @QueryParam("pais") String pais, @QueryParam("genero") String genero) {
        
        List<ProfileDTO> perfilDTO = perfilDAO.buscarPorCriterios(edad, pais, genero);

        if (perfilDTO.isEmpty()) {
            return null;
        }

        if (perfilDTO.size() > 1) {
            Random r = new Random();
            int numeroRandom = r.nextInt(3);

            return perfilDTO.get(numeroRandom);
        }
        return perfilDTO.get(0);
    }

    /**
     * PUT method for updating or creating an instance of PerfilResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ProfileDTO content) {
        perfilDAO.agregar(content);
    }
}
