import java.util.ArrayList;
import java.util.List;

public class lp_keluar extends Kas {
    private final List<String> daftarPengeluaran;

    public lp_keluar(double saldo) {
        super(0, saldo, 0, null, saldo, "");
        daftarPengeluaran = new ArrayList<>();
    }

    public void tambahPengeluaran(String keterangan, double jumlah) {
        Pengeluaran += jumlah;
        Saldo -= jumlah;
        daftarPengeluaran.add( keterangan + " - Rp." + jumlah);
        System.out.println("Pengeluaran berhasil ditambahkan!");
         
    }

    public void tampilkanLaporan() {
        System.out.println("Laporan Pengeluaran:");
        for (String pengeluaran : daftarPengeluaran) {
            System.out.println(pengeluaran);
        }
        System.out.println("Saldo: Rp." + Saldo);
    }
}
