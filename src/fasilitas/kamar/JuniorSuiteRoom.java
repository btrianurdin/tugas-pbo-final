/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasilitas.kamar;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class JuniorSuiteRoom extends Kamar {
   private final Double harga = 500000.0;
    private final String namaKamar = "Junior Suite Room";
    private final Integer defaultSisaKamar = 10;
    private Integer sisaKamar = 10;
    private Boolean withParam = false;
    private final String[] include = {"AC", "Single Bed", "Shower","Dll"};
    
    public JuniorSuiteRoom(){
        this.withParam = false;
    }
    
    public JuniorSuiteRoom(String tgl_cekin, String tgl_cekout){
        super(tgl_cekin, tgl_cekout);
        withParam = true;
    }

    @Override
    public void info() {
        System.out.println("\n|| DETAIL KAMAR ("+this.namaKamar+") ||");
        System.out.println("Kamar Tersedia : " + this.sisaKamar);
        for (int i = 0; i < include.length; i++) {
            if (i == 0) {
                System.out.println("Fasilitas Kamar : - " + this.include[i]);
            } else {
                System.out.println("                  - " + this.include[i]);
            }
        }
        System.out.println("Harga Permalam : " + this.cetakRupiah(this.harga));
    }

    @Override
    public Double hitungTotalHarga() {
        if (withParam){
            return super.getLamaInap() * this.harga;
        }
        return 0.0;
    }
    
    @Override
    public void kurangSisaKamar(){
        if (this.sisaKamar > 0) {
            this.sisaKamar -= 1;
        }
        System.out.println("Kamar penuh");
    }

    @Override
    public void tambahSisaKamar() {
        if(!Objects.equals(this.sisaKamar, this.defaultSisaKamar)){
            this.sisaKamar += 1;
        }
    }

    @Override
    public String getNamaKamar() {
        return namaKamar;
    }
    
    @Override
    public Integer getSisaKamar() {
        return this.sisaKamar;
    }

}
