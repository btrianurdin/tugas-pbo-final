/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in th e editor.
 */
package hotel;

import fasilitas.Gym;
import fasilitas.Karaoke;
import fasilitas.Spa;
import fasilitas.kamar.DeluxeRoom;
import fasilitas.kamar.JuniorSuiteRoom;
import fasilitas.kamar.Kamar;
import fasilitas.kamar.PremiereRoom;
import java.util.Scanner;
import reservasi.Reservasi;

/**
 *
 * @author HP
 */
public class Hotel implements InterfaceHotel{ 
    static Integer menu,menu1_1,inputKosong;
    String[] dataTemp = new String[15];
    Scanner input = new Scanner(System.in);
    Reservasi reservasi = new Reservasi();
    Kamar DR = new DeluxeRoom();
    Kamar PR = new PremiereRoom();
    Kamar JSR = new JuniorSuiteRoom();
    Spa spa = new Spa();
    Karaoke karaoke = new Karaoke();
    Gym gym = new Gym();
    
    public static void main(String[] args){
        Hotel hotel = new Hotel();
        String inputString;
        
        do{
            hotel.menuAwal();
            switch(menu ){   
                case 1:
                    do{
                       hotel.menuDataKamar();
                       
                        switch(menu1_1){
                            case 1:
                                hotel.cetakInfoKamar(1);
                                System.out.println("\nTekan enter untuk kembali ke menu");
                                hotel.inputKosong();
                                break;
                            case 2:
                                hotel.cetakInfoKamar(2);
                                System.out.println("\nTekan enter untuk kembali ke menu");
                                hotel.inputKosong();
                                break;
                            case 3:
                                hotel.cetakInfoKamar(3);
                                System.out.println("\nTekan enter untuk kembali ke menu");
                                hotel.inputKosong();
                                break;
                            default:
                               break;
                       }
                    } while(menu1_1 != 4);
                    break;
                case 2:
                    hotel.prosesPemesanan();
                    break;
                case 3:
                    hotel.menuTagihanPesanan();
                    break;
                default:
                    break;
            }
        } while(menu != 4);
    }
    
    @Override
    public void menuAwal(){
        System.out.println("\n==============================");
        System.out.println("== HOTEL ALEXIS RESERVATION ==");
        System.out.println("==============================");
        System.out.println("1. Data Kamar");
        System.out.println("2. Pemesanan Kamar");
        System.out.println("3. Tagihan Pembayaran");
        System.out.println("4. Keluar");
        System.out.print("Masukkan menu: ");
        menu = Integer.parseInt(input.nextLine());
    }
    
    private void menuTagihanPesanan(){
        String noId;
        
        System.out.println("\n=======================");
        System.out.println("== MENU DATA TAGIHAN ==");
        System.out.println("=======================");
        System.out.println("Masukkan");
        System.out.print("No. Identitas : ");
        noId = input.nextLine();
        
        this.cariDataTagihan(noId);
    }
    
    private void cariDataTagihan(String noId){
        reservasi.detailTagihan(noId);
        
        System.out.println("\nTekan enter untuk kembali");
        input.nextLine();
    }
    
    @Override
    public void menuDataKamar(){
        System.out.println("\n=====================");
        System.out.println("== MENU DATA KAMAR ==");
        System.out.println("=====================");
        System.out.println("1. Deluxe Room");
        System.out.println("2. Junior Suite Room");
        System.out.println("3. Premiere Room");
        System.out.println("4. Menu Utama");
        System.out.print("Masukkan pilihan: ");
        menu1_1 = Integer.parseInt(input.nextLine());
    }
    
    private void cetakInfoKamar(Integer nomor){
        switch(nomor){
            case 1:
                DR.info();
                break;
            case 2:
                JSR.info();
                break;
            case 3:
                PR.info();
                break;
            default:
                break;
        }
    }
    
    @Override
    public void headerPesanKamar(){
        System.out.println("\n=====================");
        System.out.println("== PEMESANAN KAMAR ==");
        System.out.println("=====================");
    }
    
    private void prosesPemesanan(){
        Integer pilihKamar;
        Boolean pilihKamarTemp;
        
        this.headerPesanKamar();
        System.out.print("Masukkan No. Identitas : ");
        dataTemp[0] = input.nextLine(); // No Identitas
        System.out.print("Masukkan nama : ");
        dataTemp[1] = input.nextLine(); // Nama Tamu
        System.out.print("Masukkan No. Handphone : ");
        dataTemp[2] = input.nextLine(); // No. HP
        System.out.print("Masukkan Alamat : ");
        dataTemp[3] = input.nextLine(); // Alamat
        System.out.println(">>>>>>>>>>>>>");
        System.out.println("== Pilih Kamar ==");
        System.out.println("1. Premiere Room");
        System.out.println("2. Deluxe Room");
        System.out.println("3. Junior Suite Room") ;
        System.out.print("Pilih: ");

        pilihKamar = Integer.parseInt(input.nextLine());

        pilihKamarTemp = this.prosesPilihKamar(pilihKamar);
        if (pilihKamarTemp) {
            this.prosesInputData();
        } else {
            System.out.println("\n!! KAMAR PENUH !!");
            System.out.println("\nTekan enter untuk ke menu!");
            input.nextLine();
        }
    }
    
    private Boolean prosesPilihKamar(Integer noMenu){
        switch(noMenu){
            case 1:
                if (PR.getSisaKamar() == 0){
                    return false;
                }
                
                this.prosesInputCekinCekout();
                this.prosesPilihFasilitas();
                
                Kamar premiere = new PremiereRoom(dataTemp[4], dataTemp[5]);
                dataTemp[8] = premiere.getNamaKamar();
                dataTemp[9] = premiere.getLamaInap().toString(); // Lama Inap
                dataTemp[10] = premiere.hitungTotalHarga().toString(); // Total harga kamar
                premiere.kurangSisaKamar();
                PR.kurangSisaKamar();
                break;
            case 2:
                if (DR.getSisaKamar() == 0){
                    return false;
                }
                
                this.prosesInputCekinCekout();
                this.prosesPilihFasilitas();
                
                Kamar deluxe = new DeluxeRoom(dataTemp[4], dataTemp[5]);
                dataTemp[8] = deluxe.getNamaKamar();
                dataTemp[9] = deluxe.getLamaInap().toString(); // Lama Inap
                dataTemp[10] = deluxe.hitungTotalHarga().toString(); // Total harga kamar
                deluxe.kurangSisaKamar();
                DR.kurangSisaKamar();
                break;
            case 3:
                if (JSR.getSisaKamar() == 0){
                    return false;
                }
                
                this.prosesInputCekinCekout();
                this.prosesPilihFasilitas();
                
                Kamar junior = new JuniorSuiteRoom(dataTemp[4], dataTemp[5]);
                dataTemp[8] = junior.getNamaKamar();
                dataTemp[9] = junior.getLamaInap().toString(); // Lama Inap
                dataTemp[10] = junior.hitungTotalHarga().toString(); // Total harga kamar
                junior.kurangSisaKamar();
                JSR.kurangSisaKamar();
                break;
            default:
                break;
        }
        
        return true;
    }
    
    private void prosesInputCekinCekout(){
        System.out.println("\n>>>>>>>>>>>>>>");
        System.out.println("ex: 23/12/2020");
        System.out.print("Tanggal Cek-in: ");
        dataTemp[4] = input.nextLine(); // tgl Cekin
        System.out.print("Tanggal Cek-out: ");
        dataTemp[5] = input.nextLine(); // tgl cekout
    }
    
    private void prosesPilihFasilitas(){
        Integer pilihFasilitas;
        
        System.out.println("\n>>>>>>>>>>>>>>>");
        System.out.println("== Pilih Fasilitas ==");
        System.out.println("1. GYM");
        System.out.println("2. Karaoke");
        System.out.println("3. SPA");
        System.out.print("Pilih: ");
        pilihFasilitas = Integer.parseInt(input.nextLine());
        
        switch(pilihFasilitas){
            case 1:
                dataTemp[6] = gym.getNamaFasilitas(); // nama fasilitas
                dataTemp[7] = gym.getHarga().toString(); // harga fasilitas
                dataTemp[11] = gym.getHarga().toString();
                break;
            case 2:
                dataTemp[6] = karaoke.getNamaFasilitas(); // nama fasilitas
                dataTemp[7] = karaoke.getHarga().toString(); // harga fasilitas
                dataTemp[11] = karaoke.getHarga().toString();
                break;
            case 3:
                dataTemp[6] = spa.getNamaFasilitas(); // nama fasilitas
                dataTemp[7] = spa.getHarga().toString(); // harga fasilitas
                dataTemp[11] = spa.getHarga().toString();
                break;
            default:
                break;
        }
    }
    
    private void prosesInputData(){
        reservasi.setBiodata(dataTemp[0], dataTemp[1], dataTemp[2], dataTemp[3]);
        reservasi.setDetailPesanan(
                dataTemp[8], 
                dataTemp[4], 
                dataTemp[5], 
                Integer.parseInt(dataTemp[9]),
                Double.parseDouble(dataTemp[11]),
                dataTemp[6]
        );
        reservasi.hitungTotalHarga(Double.parseDouble(dataTemp[10]), Double.parseDouble(dataTemp[7]));
        System.out.println("\n-------------------------------");
        System.out.println("-- PROSES PEMESANAN BERHASIL --");
        System.out.println("-------------------------------\n");
        System.out.println("Tekan enter untuk kembali ke menu!");
        input.nextLine();
    }
    
    private void inputKosong(){
        input.nextLine();
    }
    
    
}
