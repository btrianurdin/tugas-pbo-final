/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasilitas.kamar;

import fasilitas.Fasilitas;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author HP
 */
public abstract class Kamar extends Fasilitas {
    private String tglCekin;
    private String tglcekout;
    private Integer lamaInap;
    private final Boolean withParam;
    
    public Kamar() {
        this.withParam = false;
    }
    
    public Kamar(String tgl_cekin, String tgl_cekout){
        this.tglCekin = tgl_cekin;
        this.tglcekout = tgl_cekout;
        this.withParam = true;
    }
    
    private void hitungLamaInap(){
        // 23-12-2020
        LocalDate cekIn = LocalDate.of(Integer.parseInt(this.tglCekin.substring(6)), 
                Integer.parseInt(this.tglCekin.substring(3,5)), Integer.parseInt(this.tglCekin.substring(0,2)));
        
        LocalDate cekOut = LocalDate.of(Integer.parseInt(this.tglcekout.substring(6)), 
                Integer.parseInt(this.tglcekout.substring(3,5)), Integer.parseInt(this.tglcekout.substring(0,2)));
        
        Period selisih = Period.between(cekIn, cekOut);
        
        this.lamaInap = selisih.getDays();
    }   
    
    @Override
    public abstract void info();
    public abstract Double hitungTotalHarga();
    public abstract void kurangSisaKamar();
    public abstract void tambahSisaKamar();
    public abstract String getNamaKamar();
    public abstract Integer getSisaKamar();

    public Integer getLamaInap() {
        if (withParam) {
            this.hitungLamaInap();
            return lamaInap;
        }
        return 0;
    }
}
