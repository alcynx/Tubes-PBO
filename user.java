public class user{
    private String username;
    private String password;

    public user(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void buat(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void edit(String newUsername, String newPassword){
        this.username = newUsername;
        this.password = newPassword;
    }

    public void hapus(){
        this.username = null;
        this.password = null;
    }
}