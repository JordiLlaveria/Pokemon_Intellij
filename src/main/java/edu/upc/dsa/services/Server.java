package edu.upc.dsa.services;

import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.Object;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Api(value ="/endpoint", description = "Endpoint to Track Service")
@Path("/endpoint")
public class Server {
    private Manager manager;
    public Server(){
        this.manager = ManagerImpl.getInstance();
        manager.registerUser(new User("Joana","hola","joana@email.com","tijuana"));

    }
    /*
    @GET
    @ApiOperation(value = "get list of objects", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Object.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/objects")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjects(){

        GenericEntity<List<Object>> entity = null;
        return Response.status(200).entity(entity).build();
    }
    @GET
    @ApiOperation(value = "get list of pokemons", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Pokemons.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/pokemons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemons(){
        List <Pokemons> pokemons = this.manager.getPokemons();
        GenericEntity<List<Pokemons>> entity = new GenericEntity<List<Pokemons>>(pokemons) {};
        return Response.status(200).entity(entity).build();
    }
    @GET
    @ApiOperation(value = "get list of maps", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Map.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/maps")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMaps(){
        LinkedList<edu.upc.dsa.models.Map> maps = this.manager.getMaps();
        GenericEntity<List<Map>> entity = null;
        return Response.status(200).entity(entity).build();
    }
    @GET
    @ApiOperation(value = "get list of ranked users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/ranking")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRankedUsers(){
        List <User> rankedusers = this.manager.getRanking();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(rankedusers) {};
        return Response.status(200).entity(entity).build();
    }
    @POST
    @ApiOperation(value = "Register operation", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 500, message = "Error")
    })

    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Register(User u) {
        if (u.getCharacter()!=null && u.getEmail()!=null && u.getPassword()!= null && u.getName()!=null){
            this.manager.registerUser(u);
            return Response.status(201).entity(u.getName()).build();
        }
        else{
            return Response.status(500).entity(u.getName()).build();
        }
    }
    */
    @POST
    @ApiOperation(value = "Login operation", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Credentials.class),
            @ApiResponse(code = 404, message = "Not found")
    })

    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Credentials u) {
        //punt parada
        if (u.getUsername()!= null && u.getPassword()!=null){
            User user = this.manager.loginUser(u.getUsername(), u.getPassword());
            return Response.status(201).entity(u).build();
        }
        else{
            return Response.status(404).build();
        }
    }
}

