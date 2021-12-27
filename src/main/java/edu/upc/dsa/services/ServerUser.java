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


@Api(value ="/user", description = "Endpoint to Pokemon BBDD")
@Path("/user")
public class ServerUser {
    private Manager manager;

    public ServerUser() {
        this.manager = ManagerImpl.getInstance();

    }

    @GET
    @ApiOperation(value = "get user BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/select/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserBBDD(@PathParam("username") String name){
        if(name!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(User.class,name);
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
    @ApiOperation(value = "insert user BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertUserBBDD(User u){
        if(u!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.save(u);
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

    @PUT
    @ApiOperation(value = "update user BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserBBDD(User u){
        if(u!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.update(u);
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

    @PUT
    @ApiOperation(value = "delete user BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/delete/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteObjectBBDD(@PathParam ("username") String name){
        if(name!=null){
            User u = new User();
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.delete(u, name);
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
    @ApiOperation(value = "get all users BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class, responseContainer="LinkedList"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/selectall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsersBBDD(){
        LinkedList<User> Users = null;
        if(Users ==null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Users = sess.findAll(User.class);
            GenericEntity<LinkedList<User>> entity = new GenericEntity<LinkedList<User>>(Users) {};
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
