/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservasi;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public abstract class DBReservasi {
    private final ArrayList<String> noIndentitas = new ArrayList<String>(30); 
    private final ArrayList<String> namaTamuList = new ArrayList<String>(30);
    private final ArrayList<String> noHp = new ArrayList<String>(30);
    private final ArrayList<String> Alamat = new ArrayList<String>(30);
    private final ArrayList<String> jenisKamar = new ArrayList<String>(30);
    private final ArrayList<String> cekIn_cekOut = new ArrayList<String>(30);
    private final ArrayList<Integer> lamaInap = new ArrayList<Integer>(30);
    private final ArrayList<String> extraFasilitas = new ArrayList<String>(30);
    private final ArrayList<Double> hargaFasilitas = new ArrayList<Double>(30);
    private final ArrayList<Double> totalHarga = new ArrayList<Double>(30);
    
    protected void addNoIdentitas(String noId){
        this.noIndentitas.add(noId);
    }
    
    protected void addNamaTamuList(String namaTamu){
        this.namaTamuList.add(namaTamu);
    }
    
    protected void addNoHp(String noHp){
        this.noHp.add(noHp);
    }
    
    protected void addAlamat(String alamat){
        this.Alamat.add(alamat);
    }
    
    protected void addJenisKamar(String jenisKamar){
        this.jenisKamar.add(jenisKamar);
    }
    
    protected void addCekIn_CekOut(String cekIn, String cekOut){
        String temp = cekIn + " :: " + cekOut; 
        this.cekIn_cekOut.add(temp);
    }
    
    protected void addLamaInap(Integer lamaInap){
        this.lamaInap.add(lamaInap);
    }
    
    protected void addExtraFasilitas(String exFasilitas){
        this.extraFasilitas.add(exFasilitas);
    }
    
    protected void addHargaFasilitas(Double harga){
        this.hargaFasilitas.add(harga);
    }
    
    protected void addTotalHarga(Double totharga){
        this.totalHarga.add(totharga);
    }
    
    public void getDetailTagihan(String noId){
        Integer indexId = this.noIndentitas.indexOf(noId);
        System.out.println("Nama Tamu       : " + this.namaTamuList.get(indexId));
        System.out.println("No. Handphone   : " + this.noHp.get(indexId));
        System.out.println("Alamat          : " + this.Alamat.get(indexId));
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println("Jenis Kamar     : " + this.jenisKamar.get(indexId));
        System.out.println("Lama Inap       : " + this.lamaInap.get(indexId) + " malam");
        System.out.println("Extra Fasilitas : " + this.extraFasilitas.get(indexId));
        System.out.println("Harga Fasilitas : " + this.hargaFasilitas.get(indexId));
        System.out.println("Total Tagihan   : " + this.cetakRupiah(this.totalHarga.get(indexId)));
    }
    
    protected String cetakRupiah(Double total){
       DecimalFormat totalRP = (DecimalFormat) DecimalFormat.getCurrencyInstance();
       
       return totalRP.format(total).replace(",", ".").replace("IDR", "Rp");
    }
   
}
