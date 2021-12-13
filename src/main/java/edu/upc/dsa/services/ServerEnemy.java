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


@Api(value ="/enemy", description = "Endpoint to Pokemon BBDD")
@Path("/enemy")
public class ServerEnemy {
    private Manager manager;

    public ServerEnemy() {
        this.manager = ManagerImpl.getInstance();
    }

    @GET
    @ApiOperation(value = "get enemy BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Enemy.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/select/{enemyname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnemyBBDD(@PathParam("enemyname") String name){
        if(name!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(Enemy.class,name);
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
    @ApiOperation(value = "insert enemy BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Enemy.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertEnemyBBDD(Enemy e){
        if(e!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.save(e);
            if (e!=null){
                return Response.status(201).entity(e).build();
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
    @ApiOperation(value = "update enemy BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Enemy.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEnemyBBDD(Enemy e){
        if(e!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.update(e);
            if (e!=null){
                return Response.status(201).entity(e).build();
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
    @ApiOperation(value = "delete enemy BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Enemy.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/delete/{enemyname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEnemyBBDD(@PathParam ("enemyname") String name){
        if(name!=null){
            Enemy e = new Enemy();
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.delete(e, name);
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
    @ApiOperation(value = "get all enemies BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Enemy.class, responseContainer="LinkedList"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/selectall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEnemiesBBDD(){
        LinkedList<Enemy> enemies = null;
        if(enemies==null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            enemies = sess.findAll(Enemy.class);
            GenericEntity<LinkedList<Enemy>> entity = new GenericEntity<LinkedList<Enemy>>(enemies) {};
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
