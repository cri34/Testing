package DomainEntities;

public class User {
    private String name;
    private String password;//hash con salt
    private String salt;//canvian por usuario
    //
    public User(){
       this("Tomeu","secret");
    }
    public User(String name,String password){
        this.name=name;
        this.salt=PasswordUtilis.genSalt();
        this.password =PasswordUtilis.hashedPassword(password,this.salt);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public boolean verifyPassword(String passwordEntered){
        return PasswordUtilis.verifyUserPassword(passwordEntered,salt,password);
    }

    public void setPassword(String password) {
        this.password = PasswordUtilis.hashedPassword(password,salt);
    }

}
