import java.util.Date;

public class data_kas {
   private float Pengeluaran;
   private float Pemasukan;
   private int NoTransaksi;
   public Date TglTransaksi;
   private float Saldo;
   private String Keterangan;
   
   public data_kas(float pengeluaran, float pemasukan,int NoTransaksi,Date TglTransaksi, float Saldo, String Keterangan){
   this.Pengeluaran = Pengeluaran;
   this.Pemasukan = Pemasukan;
   this.NoTransaksi = NoTransaksi;
   this.Saldo = Saldo;
   this.Keterangan = Keterangan;
   }
   public float getPengeluaran(){
       return this.Pengeluaran;
   }
   public void setPengeluaran(){
       this.Pengeluaran = Pengeluaran;
   }
   public float getPemasukan(){
       return this.Pemasukan;
   }
   public void setPemasukan(){
       this.Pemasukan = Pemasukan;
   }
   public int getNoTransaksi(){
       return this.NoTransaksi;
   }
   public void setNoTransaksi(){
       this.NoTransaksi = NoTransaksi;
   }
   public float getSaldo(){
       return this.Saldo;
   }
   public void setSaldo(){
       this.Saldo = Saldo;
   }
   public String getKeterangan(){
       return this.Keterangan;
   }
   public void setKeterangan(){
       this.Keterangan = Keterangan;
   }

}
