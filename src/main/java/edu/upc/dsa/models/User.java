package edu.upc.dsa.models;

public class User {
    //private String id;
    private String name;
    private String password;
    private String email;
    private String character_name;
    private Character character;

    public User(){

    }
    public User(String name, String password, String email, String character_name){
        this();
        //setId(id);
        setName(name);
        setPassword(password);
        setEmail(email);
        setCharacter_name(character_name);
    }
    public User(String username, String password){
        this();
        setName(username);
        setPassword(password);
    }

    public void setName(String name){this.name=name;}
    public String getName(){return this.name;}

    public void setPassword(String password){this.password=password;}
    public String getPassword(){return this.password;}

    //public void setId(String id){this.id=id;}
    //public String getId(){return this.id;}

    public void setEmail(String email){this.email=email;}
    public String getEmail(){return this.email;}

    public void setCharacter(Character c){this.character=c;}
    public Character getCharacter(){return this.character;}

    public void setCharacter_name(String c){this.character_name =c;}
    public String getCharacter_name(){return this.character_name;}

    public int compareTo(User c)
    {
        int res = (int) (this.getCharacter().getPoints()-c.getCharacter().getPoints());
        return res;
    }
}
