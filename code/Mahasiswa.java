import java.util.Date;
public class Mahasiswa {
    public String NIM;
    public String Nama;
    private String Alamat;
    private Date Born;
    private String Tlp;
    public String Gender;
    
    // Constructors
    public Mahasiswa(String NIM, String Nama, String Alamat, Date Born, String Tlp, String Gender){
    this.Alamat = Alamat;
    this.Born = Born;
    this.Tlp = Tlp;
    }

    // Method Setter Getter
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

    // Method Tambah
    public void tambahData(String NIM, String Nama, String Alamat, Date Born, String Tlp, String Gender) {
    this.NIM = NIM;
    this.Nama = Nama;
    this.Alamat = Alamat;
    this.Born = Born;
    this.Tlp = Tlp;
    this.Gender = Gender;
    System.out.println("Data berhasil ditambahkan!");
    }

    // Method Hapus
    public void hapusData() {
    this.NIM = "";
    this.Nama = "";
    this.Alamat = "";
    this.Born = null;
    this.Tlp = "";
    this.Gender = "";
    System.out.println("Data berhasil dihapus!");
    }

    // Method Edit
    public void editData(String NIM, String Nama, String Alamat, Date Born, String Tlp, String Gender) {
    this.NIM = NIM;
    this.Nama = Nama;
    this.Alamat = Alamat;
    this.Born = Born;
    this.Tlp = Tlp;
    this.Gender = Gender;
    System.out.println("Data berhasil diperbarui!");
    }

    @Override
    public String toString(){
    return "Nama : " + this.Nama + 
            "NIM : " + this.NIM +
            "Gender : " + Gender +
            "Tanggal Lahir : " + this.Born +
            "Telepon : " + this.Tlp +
            "Alamat : " + this.Alamat;
    }  
}
