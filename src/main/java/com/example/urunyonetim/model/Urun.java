package com.example.urunyonetim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isim;
    private double fiyat;
    private int stok;
    private String kategori;

    public Urun() {}

    public Urun(String isim, double fiyat, int stok, String kategori ) {
        this.isim = isim;
        this.fiyat = fiyat;
        this.stok = stok;
        this.kategori = kategori;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIsim() { return isim; }
    public void setIsim(String isim) { this.isim = isim; }
    public double getFiyat() { return fiyat; }
    public void setFiyat(double fiyat) { this.fiyat = fiyat; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }
    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }
}