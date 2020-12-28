/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservasi;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Reservasi extends DBReservasi{
    
    public Reservasi() {
        System.out.println("\nReservasi diproses :)\n");
    }

    public void setBiodata(String noId, String nama, String alamat, String nohp) {
        super.addNoIdentitas(noId);
        super.addNamaTamuList(nama);
        super.addAlamat(alamat);
        super.addNoHp(nohp);
    }
    
    public void setDetailPesanan(
        String jeniskamar, 
        String cekIn, 
        String cekOut, 
        Integer lamaInp,
        Double hrgFasilitas,
        String exFasilitas
    ){
        super.addJenisKamar(jeniskamar);
        super.addCekIn_CekOut(cekIn, cekOut);
        super.addLamaInap(lamaInp);
        super.addExtraFasilitas(exFasilitas);
        super.addHargaFasilitas(hrgFasilitas);
    }
    
    public void hitungTotalHarga(Double hargaKamar, Double hargaExFasilitas){
        super.addTotalHarga((hargaKamar + hargaExFasilitas));
    }

    public void detailTagihan(String noId) {
        try{
            super.getDetailTagihan(noId);
        }
        catch(Exception e) {
            System.out.println("\n!! Tagihan Tidak Di Temukan !!"); 
        }
        
    }
    
}
