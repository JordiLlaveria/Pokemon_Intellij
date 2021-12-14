package edu.upc.dsa.services;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.character;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;


@Api(value ="/character", description = "Endpoint to Pokemon BBDD")
@Path("/character")
public class ServerCharacter {
    private Manager manager;

    public ServerCharacter() {
        this.manager = ManagerImpl.getInstance();
    }

    @GET
    @ApiOperation(value = "get character BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = character.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/select/{charactername}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjectBBDD(@PathParam("charactername") String name){
        if(name!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(character.class,name);
            //Character character = this.manager.getCharacter(name);
            if (u!=null){
                return Response.status(201).entity(u).build();
            }
            else{
                return Response.status(404).build();
            }
        }
        else{
            return Response.status(404).build();
        }
    }

    @POST
    @ApiOperation(value = "insert character BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = character.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertObjectBBDD(character c){
        if(c!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.save(c);
            if (c!=null){
                return Response.status(201).entity(c).build();
            }
            else{
                return Response.status(404).build();
            }
        }
        else{
            return Response.status(404).build();
        }
    }

    @PUT
    @ApiOperation(value = "update character BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = character.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserBBDD(character c){
        if(c!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.update(c);
            if (c!=null){
                return Response.status(201).entity(c).build();
            }
            else{
                return Response.status(404).build();
            }
        }
        else{
            return Response.status(404).build();
        }
    }

    @PUT
    @ApiOperation(value = "delete character BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = character.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/delete/{charactername}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserBBDD(@PathParam ("charactername") String name){
        if(name!=null){
            character c = new character();
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.delete(c, name);
            if (name!=null){
                return Response.status(201).build();
            }
            else{
                return Response.status(404).build();
            }
        }
        else{
            return Response.status(404).build();
        }
    }

    @GET
    @ApiOperation(value = "get all characters BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = character.class, responseContainer="LinkedList"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/selectall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCharacterBBDD(){
        LinkedList<character> characters = null;
        if(characters==null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            characters = sess.findAll(character.class);
            GenericEntity<LinkedList<character>> entity = new GenericEntity<LinkedList<character>>(characters) {};
            if (entity!=null){
                return Response.status(201).entity(entity).build();
            }
            else{
                return Response.status(404).build();
            }
        }
        else{
            return Response.status(404).build();
        }
    }

}
