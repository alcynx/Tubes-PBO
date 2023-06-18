import java.util.Date;

public class Kas {
    private float Pengeluaran;
    private float Pemasukan;
    private int NoTransaksi;
    public Date TglTransaksi;
    private float Saldo;
    private String Keterangan;
    
    // Constructors
    public Kas(float Pengeluaran, float Pemasukan,int NoTransaksi,Date TglTransaksi, float Saldo, String Keterangan){
        this.Pengeluaran = Pengeluaran;
        this.Pemasukan = Pemasukan;
        this.NoTransaksi = NoTransaksi;
        this.Saldo = Saldo;
        this.Keterangan = Keterangan;
    }

    // Method Setter Getter
    public float getPengeluaran(){
        return this.Pengeluaran;
    }
    public void setPengeluaran(float Pengeluaran){
        this.Pengeluaran = Pengeluaran;
    }
    public float getPemasukan(){
        return this.Pemasukan;
    }
    public void setPemasukan(float Pemasukan){
        this.Pemasukan = Pemasukan;
    }
    public int getNoTransaksi(){
        return this.NoTransaksi;
    }
    public void setNoTransaksi(int NoTransaksi){
        this.NoTransaksi = NoTransaksi;
    }
    public float getSaldo(){
        return this.Saldo;
    }
    public void setSaldo(float Saldo){
        this.Saldo = Saldo;
    }
    public String getKeterangan(){
        return this.Keterangan;
    }
    public void setKeterangan(String Keterangan){
        this.Keterangan = Keterangan;
    }

   // Method Tambah
    public void TambahKas (float Pengeluaran, float Pemasukan,int NoTransaksi,Date TglTransaksi, float Saldo, String Keterangan){
        this.Pengeluaran = Pengeluaran;
        this.Pemasukan = Pemasukan;
        this.NoTransaksi = NoTransaksi;
        this.TglTransaksi = TglTransaksi;
        this.Saldo = Saldo;
        this.Keterangan = Keterangan;
        System.out.println("Kas berhasil ditambahkan!");
    }

   // method Hapus
    public void HapusKas() {
        this.Pengeluaran = 0;
        this.Pemasukan = 0;
        this.NoTransaksi = 0;
        this.TglTransaksi = null;
        this.Saldo = 0;
        this.Keterangan = "";
        System.out.println("Kas berhasil dihapus!");
    }

    // method edit
    public void editData(float Pengeluaran, float Pemasukan,int NoTransaksi,Date TglTransaksi, float Saldo, String Keterangan){
        this.Pengeluaran = Pengeluaran;
        this.Pemasukan = Pemasukan;
        this.NoTransaksi = NoTransaksi;
        this.TglTransaksi = TglTransaksi;
        this.Saldo = Saldo;
        this.Keterangan = Keterangan; 
        System.out.println("Kas berhasil diperbarui!");
    }



}
