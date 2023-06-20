<<<<<<< HEAD
package com.code;

import java.util.ArrayList;
import java.util.List;

public class lp_masuk extends Kas{
    private final List<String>daftarPemasukan;

    public lp_masuk(double Saldo){
        super(0, Saldo, 0, null, Saldo, "");
        daftarPemasukan = new ArrayList<>();
    }

    public void tambahPemasukan(String keterangan, double jumlah){
        Pemasukan += jumlah;
        Saldo += jumlah;
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
=======
package com.code;

import java.util.ArrayList;
import java.util.List;

public class lp_masuk extends Kas{
    private final List<String>daftarPemasukan;

    public lp_masuk(double Saldo){
        super(0, Saldo, 0, null, Saldo, "");
        daftarPemasukan = new ArrayList<>();
    }

    public void tambahPemasukan(String keterangan, double jumlah){
        Pemasukan += jumlah;
        Saldo += jumlah;
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
>>>>>>> f3eb44d830921f864b295c80bdd6cf0119962158
