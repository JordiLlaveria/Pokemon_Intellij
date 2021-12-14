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
import java.util.List;


@Api(value ="/object", description = "Endpoint to Pokemon BBDD")
@Path("/object")
public class ServerObjects {
    private Manager manager;

    public ServerObjects() {
        this.manager = ManagerImpl.getInstance();
    }

    @GET
    @ApiOperation(value = "get object BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Objects.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/select/{objectname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjectBBDD(@PathParam("objectname") String name){
        if(name!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(Objects.class,name);
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
    @ApiOperation(value = "insert object BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Objects.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertObjectBBDD(Objects o){
        if(o!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.save(o);
            if (o!=null){
                return Response.status(201).entity(o).build();
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
    @ApiOperation(value = "update object BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Objects.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateObjectBBDD(Objects o){
        if(o!=null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.update(o);
            if (o!=null){
                return Response.status(201).entity(o).build();
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
    @ApiOperation(value = "delete object BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Objects.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/delete/{objectname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteObjectBBDD(@PathParam ("objectname") String name){
        if(name!=null){
            Objects u = new Objects();
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
    @ApiOperation(value = "get all objects BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Objects.class, responseContainer="LinkedList"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/selectall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllObjectsBBDD(){
        LinkedList<Objects> objects = null;
        if(objects==null){
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            objects = sess.findAll(Objects.class);
            GenericEntity<LinkedList<Objects>> entity = new GenericEntity<LinkedList<Objects>>(objects) {};
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
