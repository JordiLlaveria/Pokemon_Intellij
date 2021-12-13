package edu.upc.dsa.services;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Character;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value ="/BBDD", description = "Endpoint to Pokemon BBDD")
@Path("/BBDD")
public class ServerBBDD {
    private Manager manager;

    public ServerBBDD() {
        this.manager = ManagerImpl.getInstance();
        //manager.registerUser(new User("Joana", "hola", "joana@email.com", "tijuana"));
        //manager.addCharacter(new Character("tijuana", "may", 135., 500., "Charmander", "Squirtle", "Bulbasaur", "Potion", "Pokeball", "Superball"));

    }

    //Obtenir user BBDD
    @GET
    @ApiOperation(value = "get user BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/user/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserBBDD(@PathParam("username") String name){
        if(name!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(User.class,name);
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
    //Obtenir character BBDD
    @GET
    @ApiOperation(value = "get character BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Character.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/character/{charactername}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacterBBDD(@PathParam("charactername") String name){
        if(name!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(Character.class,name);
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

    @GET
    @ApiOperation(value = "get enemy BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Enemy.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/enemy/{enemyname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnemyBBDD(@PathParam("enemyname") String name){
        if(name!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(Enemy.class,name);
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
    @GET
    @ApiOperation(value = "get object BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Objects.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/objects/{objectname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjectBBDD(@PathParam("objectname") String name){
        if(name!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(Objects.class,name);
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

    //Insert user BBDD
    @POST
    @ApiOperation(value = "insert user BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertUserBBDD(User u){
        if(u!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.save(u);
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

}
