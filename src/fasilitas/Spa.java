/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasilitas;

/**
 *
 * @author HP
 */
public class Spa extends Fasilitas {
    private final String namaFasilitas = "SPA";
    private final Double harga = 50000.0;
    
    
    public Spa(){
        
    }
    
    @Override
    public void info() {
        System.out.println("\n|| DETAIL FASILITAS ||");
        System.out.println("Nama Fasilitas : " + this.namaFasilitas);
        System.out.println("Harga          : " + this.cetakRupiah(this.harga));
    }
    
    public Double getHarga(){
        return this.harga;
    }
    
    public String getNamaFasilitas(){
        return this.namaFasilitas;
    }
    
}
