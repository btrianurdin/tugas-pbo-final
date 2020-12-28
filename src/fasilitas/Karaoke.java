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
public class Karaoke extends Fasilitas {
    private final String namaFasilitas = "Karaoke";
    private final Double harga = 120000.0;
    
    
    public Karaoke(){
        
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
