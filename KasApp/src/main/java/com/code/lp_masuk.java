import java.util.ArrayList;
import java.util.List;

public class Lp_masuk extends Kas{
    private final List<String>daftarPemasukan;

    public Lp_masuk(double Saldo){
        super(0, Saldo, 0, null, Saldo, "");
        daftarPemasukan = new ArrayList<>();
    }

    public void tambahPemasukan(String keterangan, double jumlah){
        Pemasukan += jumlah;
        saldo += jumlah;
        daftarPemasukan.add(keterangan + "- Rp" + jumlah);
        System.out.println("Pemasukan ditambah!");

    }
    public void tampilkanLaporan(){
        System.out.println("Laporan Pemasukan");
        for (String Pemasukan : daftarPemasukan){
            System.out.println(Pemasukan);
        }
        System.out.println("Saldo : Rp. " + Saldo);
    }
}
