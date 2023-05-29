import java.util.Date;
public class data_mhs {
    public String NIM;
    public String Nama;
    private String Alamat;
    private Date Born;
    private String Tlp;
    public String Gender;
    
    public data_mhs(String NIM, String Nama, String Alamat, Date Born, String Tlp, String Gender){
    this.Alamat = Alamat;
    this.Born = Born;
    this.Tlp = Tlp;
    }
    public String getAlamat(){
    return this.Alamat;
    }
    public void setAlamat(String Alamat){
    this.Alamat = Alamat;
    }
    public Date getBorn(Date Born){
    return this.Born;
    }
    public void setBorn(Date Born){
    this.Born = Born;
    }

    @Override
    public String toString(){
    return "Nama : " + Nama + 
            "NIM : " + NIM +
            "Gender : " + Gender +
            "Tanggal Lahir : " + this.Born +
            "Telepon : " + this.Tlp +
            "Alamat : " + this.Alamat;
    }  
}
