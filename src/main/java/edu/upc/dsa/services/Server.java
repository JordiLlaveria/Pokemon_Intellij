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


@Api(value ="/endpoint", description = "Endpoint to Pokemon Service")
@Path("/endpoint")
public class Server {
    private Manager manager;
    public Server(){
        this.manager = ManagerImpl.getInstance();
        //manager.registerUser(new User("Joana","hola","joana@email.com","tijuana"));
        //manager.addCharacter(new Character("tijuana","Joana","may","level4",135.,500.,"Charmander","Squirtle","Bulbasaur","Potion","Pokeball","Superball"));

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
        List<Pokemons> pokemons = this.manager.getPokemons();
        if(pokemons.size()!=0) {
            GenericEntity<List<Pokemons>> entity = new GenericEntity<List<Pokemons>>(pokemons) {
            };
            return Response.status(200).entity(entity).build();
        }
        else{
            return Response.status(500).build();
        }
    }

    /*


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
    */

    // PETICIÓ OBTENIR CARACTER SEGONS EL NOM
    @GET
    @ApiOperation(value = "get character", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Character.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/character/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacter(@PathParam("name") String name){
        if(name!=null){
            Character character = this.manager.getCharacter(name);
            if (character!=null){
                return Response.status(201).entity(character).build();}
            else{
                return Response.status(500).build();}}
        else{
            return Response.status(500).build();}
    }

    //PETICIÓ REGISTRAR-SE CREAR CARACTER
    @POST
    @ApiOperation(value = "Create new character", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Character.class),
            @ApiResponse(code = 500, message = "Error"),
            @ApiResponse(code = 502, message = "Error, null Character")
    })

    @Path("/character")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCharacter(Character character) {

        if(character.getName()!=null && character.getPokemon1name()!=null){
            int characterAdded = this.manager.addCharacter(character);
            if(characterAdded==0){
                return Response.status(201).entity(character).build();}
            else{
                return Response.status(500).entity(character).build();}}
        else{
            return Response.status(502).entity(character).build();}
    }


    //PETICIÓ REGISTRAR-SE
    @POST
    @ApiOperation(value = "Register operation", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 500, message = "Error")
    })

    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User u) {
        if (u.getCharactername()!=null && u.getEmail()!=null && u.getPassword()!= null && u.getName()!=null){
            int userRegistered = this.manager.registerUser(u);
            if(userRegistered==0) {
                return Response.status(201).entity(u).build();}
            else{
                return Response.status(500).entity(u).build();}
        }
        else{
            return Response.status(500).entity(u).build();
        }
    }

    //PETICIÓ INICIAR SESSIÓ
    @POST
    @ApiOperation(value = "Login operation", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Credentials c) {
        if (c.getUsername()!= null && c.getPassword()!=null){
            User userlogged = this.manager.loginUser(c.getUsername(), c.getPassword());
            if(userlogged!=null){
                return Response.status(201).entity(userlogged).build();
            }
            else{
                return Response.status(404).build();
            }
        }
        else{
            return Response.status(500).build();
        }
    }

    @PUT
    @ApiOperation(value = "update user BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/updateuser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(User u){
        if(u!=null){
            this.manager.updateUser(u);
            return Response.status(201).entity(u).build();
        }
        else{
            return Response.status(404).build();
        }
    }

    // PETICIÓ BOTIGA COMPRAR
    @POST
    @ApiOperation(value = "Buy an object", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Character.class),
            @ApiResponse(code = 500, message = "Not enough money",response = Character.class),
            @ApiResponse(code = 400, message = "User Not Found"),
            @ApiResponse(code = 501, message = "Not enough space",response = Character.class)
    })

    @Path("/Store/Shopping")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response buyObject(ObjectWithCharacter objectWithCharacter) {
        Character character = objectWithCharacter.getCharacter();
        Objects item = objectWithCharacter.getObject();

        if(character.getName()!=null){
            Character ch= manager.getCharacter(character.getName());
            if (ch.getMoney()>=item.getPrice()){
                ch.setMoney(ch.getMoney()-item.getPrice());
                if(ch.getObject1name()==null){
                    ch.setObject1name(item.getName());
                    manager.updateCharacter(ch);
                    return Response.status(201).entity(ch).build();}
                else if(ch.getObject2name()==null){
                    ch.setObject2name(item.getName());
                    manager.updateCharacter(ch);
                    return Response.status(201).entity(ch).build();}
                else if(ch.getObject3name()==null){
                    ch.setObject3name(item.getName());
                    manager.updateCharacter(ch);
                    return Response.status(201).entity(ch).build();}
                else { return Response.status(501).entity(character).build();}
            }
            else {
                return Response.status(500).entity(ch).build();}
        }
        else {
            return Response.status(400).entity(character).build();}
    }

    // PETICIÓ BOTIGA MOSTRAR OBJECTES
    @GET
    @ApiOperation(value = "Show List of Products to buy", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Object.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/Store/ShowProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjects(){
        try {
        GenericEntity<List<Objects>> entity =  new GenericEntity<List<Objects>>(manager.getObjects()) {};
        return Response.status(200).entity(entity).build();
        }catch(Exception e){return Response.status(500).build();}
    }

    @PUT
    @ApiOperation(value = "delete user BBDD", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/delete/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam ("username") String name){
        if(name!=null){
            User user = manager.deleteUser(name);
            if(user != null){
                return Response.status(200).entity(user).build();
            }
            else{
                return Response.status(404).build();
            }
        }
        else{
            return Response.status(500).build();
        }

    }



}

