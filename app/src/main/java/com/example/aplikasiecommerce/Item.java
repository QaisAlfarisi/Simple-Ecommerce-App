package com.example.aplikasiecommerce;

public class Item {

    String produk;
    String tanggal;
    String harga;
    int image;

    public Item(String produk, String tanggal, String harga, int image) {
        this.produk = produk;
        this.tanggal = tanggal;
        this.harga = harga;
        this.image = image;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
