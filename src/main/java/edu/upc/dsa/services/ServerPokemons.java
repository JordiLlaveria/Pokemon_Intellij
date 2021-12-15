package edu.upc.dsa.services;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;


@Api(value ="/pokemon", description = "Endpoint to Pokemon BBDD")
@Path("/pokemon")
public class ServerPokemons {
    private Manager manager;

    public ServerPokemons() {
        this.manager = ManagerImpl.getInstance();
    }

    @GET
    @ApiOperation(value = "get pokemon BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Pokemons.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/select/{pokemonname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemonBBDD(@PathParam("pokemonname") String name){
        if(name!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(Pokemons.class,name);
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
    @ApiOperation(value = "insert pokemon BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Pokemons.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPokemonBBDD(Pokemons p){
        if(p!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.save(p);
            if (p!=null){
                return Response.status(201).entity(p).build();
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
    @ApiOperation(value = "update pokemon BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Pokemons.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePokemonBBDD(Pokemons p){
        if(p!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.update(p);
            if (p!=null){
                return Response.status(201).entity(p).build();
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
    @ApiOperation(value = "delete pokemon BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Pokemons.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/delete/{pokemonname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePokemonBBDD(@PathParam ("pokemonname") String name){
        if(name!=null){
            Pokemons p = new Pokemons();
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.delete(p, name);
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
    @ApiOperation(value = "get all pokemons BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Pokemons.class, responseContainer="LinkedList"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/selectall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPokemonsBBDD(){
        LinkedList<Pokemons> pokemons = null;
        if(pokemons==null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            pokemons = sess.findAll(Pokemons.class);
            GenericEntity<LinkedList<Pokemons>> entity = new GenericEntity<LinkedList<Pokemons>>(pokemons) {};
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

