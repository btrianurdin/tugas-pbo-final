/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasilitas;

import java.text.DecimalFormat;

/**
 *
 * @author HP
 */
public abstract class Fasilitas {
    
    public Fasilitas(){
        
    }
    
    public abstract void info();
    
    protected String cetakRupiah(Double total){
       DecimalFormat totalRP = (DecimalFormat) DecimalFormat.getCurrencyInstance();
       
       return totalRP.format(total).replace(",", ".").replace("IDR", "Rp");
    }
}
