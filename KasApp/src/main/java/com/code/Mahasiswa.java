package com.code;

import com.layout.MahasiswaLayout;
public class Mahasiswa extends MahasiswaLayout{
    public String NIM;
    public String Nama;
    private String Alamat;
    private String Born;
    private String Tlp;
    public String Gender;
    
    // Constructors
    public Mahasiswa(String NIM, String Nama, String Alamat, String Born, String Tlp, String Gender){
        this.NIM = NIM;
        this.Nama = Nama;
        this.Alamat = Alamat;
        this.Born = Born;
        this.Tlp = Tlp;
        this.Gender = Gender;
    }

    // Method Setter Getterr
    public String getNIM(){
        return NIM;
    }
    public void setNIM(String NIM){
        this.NIM = NIM;
    }
    
    public String getNama(){
        return Nama;
    }
    public void setNama(String Nama){
        this.Nama = Nama;
    }
    
    public String getAlamat(){
        return Alamat;
    }
    public void setAlamat(String Alamat){
        this.Alamat = Alamat;
    }
    
    public String getBorn(String Born){
        return Born;
    }
    public void setBorn(String Born){
        this.Born = Born;
    }
    
    public String getTlp(){
        return Tlp;
    }
    public void setTlp(String Tlp){
        this.Tlp = Tlp;
    }
    
    public String getGender(){
        return Gender;
    }
    public void setGender(){
        this.Gender = Gender;
    }

    // Method Tambah
    public void tambahData(String NIM, String Nama, String Alamat, String Born, String Tlp, String Gender) {
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
    this.NIM = null;
    this.Nama = null;
    this.Alamat = null;
    this.Born = null;
    this.Tlp = null;
    this.Gender = null;
    System.out.println("Data berhasil dihapus!");
    }

    // Method Edit
    public void editData(String NIM, String Nama, String Alamat, String Born, String Tlp, String Gender) {
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
