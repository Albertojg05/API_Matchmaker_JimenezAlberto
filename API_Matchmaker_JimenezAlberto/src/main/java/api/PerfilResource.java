/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import dtos.ProfileDTO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Alberto Jimenez
 */
@Path("perfiles")
@RequestScoped
public class PerfilResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PerfilResource
     */
    public PerfilResource() {
    }

    /**
     * Retrieves representation of an instance of api.PerfilResource
     * @return an instance of dtos.ProfileDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileDTO getJson() {
        
        //TODO return proper representation object
        return new ProfileDTO("Beto", "Jimenez", "US");
    }

    /**
     * PUT method for updating or creating an instance of PerfilResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ProfileDTO content) {
    }
}
