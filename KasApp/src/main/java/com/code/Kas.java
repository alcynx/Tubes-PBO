package com.code;

import com.layout.KasLayout;

public class Kas {
    protected double Pengeluaran;
    protected double Pemasukan;
    private int NoTransaksi;
    public String TglTransaksi;
    protected double Saldo;
    private String Keterangan;
    
    // Constructors
    public Kas(double Pengeluaran, double Pemasukan,int NoTransaksi,String TglTransaksi, double Saldo, String Keterangan){
        this.Pengeluaran = Pengeluaran;
        this.Pemasukan = Pemasukan;
        this.NoTransaksi = NoTransaksi;
        this.Saldo = Saldo;
        this.Keterangan = Keterangan;
    }

    // Method Setter Getter
    public double getPengeluaran(){
        return this.Pengeluaran;
    }
    public void setPengeluaran(double Pengeluaran){
        this.Pengeluaran = Pengeluaran;
    }
    public double getPemasukan(){
        return this.Pemasukan;
    }
    public void setPemasukan(double Pemasukan){
        this.Pemasukan = Pemasukan;
    }
    public int getNoTransaksi(){
        return this.NoTransaksi;
    }
    public void setNoTransaksi(int NoTransaksi){
        this.NoTransaksi = NoTransaksi;
    }
    public double getSaldo(){
        return this.Saldo;
    }
    public void setSaldo(double Saldo){
        this.Saldo = Saldo;
    }
    public String getKeterangan(){
        return this.Keterangan;
    }
    public void setKeterangan(String Keterangan){
        this.Keterangan = Keterangan;
    }

   // Method Tambah
    public void TambahKas (double Pengeluaran, double Pemasukan,int NoTransaksi,String TglTransaksi, double Saldo, String Keterangan){
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
    public void editData(double Pengeluaran, double Pemasukan,int NoTransaksi,String TglTransaksi, double Saldo, String Keterangan){
        this.Pengeluaran = Pengeluaran;
        this.Pemasukan = Pemasukan;
        this.NoTransaksi = NoTransaksi;
        this.TglTransaksi = TglTransaksi;
        this.Saldo = Saldo;
        this.Keterangan = Keterangan; 
        System.out.println("Kas berhasil diperbarui!");
    }



}
