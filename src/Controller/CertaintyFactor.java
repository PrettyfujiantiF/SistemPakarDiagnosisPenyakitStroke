/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Excel;
import java.util.ArrayList;

public class CertaintyFactor {
    ArrayList<String> hasil = new ArrayList<>();
    ArrayList<Double> bobot = new ArrayList<>();
    Excel ex = new Excel();
    
    public ArrayList<String> get_hasil (){
        return hasil ;
    }
    
    public ArrayList<Double> get_bobot(){
        return bobot;
    }
    
    public void do_certainty_factor(ArrayList<ArrayList>data_uji){
        String file_bobot = System.getProperty("user.dir")+"/Data/data certainty factor.xlsx";
 
        hasil = new ArrayList<>();
        bobot = new ArrayList<>();
        ArrayList<ArrayList>bobot_gejala_penyakit = ex.load_excel(file_bobot);
        for(int i=0; i<data_uji.size();i++){
            double p1 = 0.0;
            double p2 = 0.0;
            double langkah = 0;
            for (int j=0; j<data_uji.get(i).size()-1;j++){
                if(Double.parseDouble(data_uji.get(i).get(j).toString())==1.0){
                    if(langkah==0){
                        if(bobot_gejala_penyakit.get(j).get(1).toString().toLowerCase().contains("p1")){
                            p1=Double.parseDouble(bobot_gejala_penyakit.get(j).get(2).toString());
                            langkah++;
                        }
                        if(bobot_gejala_penyakit.get(j).get(1).toString().toLowerCase().contains("p2")){
                            p2=Double.parseDouble(bobot_gejala_penyakit.get(j).get(3).toString());
                            langkah++;
                        }
                    }
                    else{
                        if(bobot_gejala_penyakit.get(j).get(1).toString().toLowerCase().contains("p1")){
                            p1=p1+(Double.parseDouble(bobot_gejala_penyakit.get(j).get(2).toString())*(1-p1));
                            langkah++;
                        }
                        if(bobot_gejala_penyakit.get(j).get(1).toString().toLowerCase().contains("p2")){
                            p2=p2+(Double.parseDouble(bobot_gejala_penyakit.get(j).get(3).toString())*(1-p2));
                            langkah++;
                        }
                        
                    }
                }
            }
            if(p1>=p2){
                hasil.add("P1");
                bobot.add(p1*100);
            }
            else if(p2>=p1){
                hasil.add("P2");
                bobot.add(p2*100);
            }
        }
    }
    
    public void do_certainty_factor(ArrayList<ArrayList>data_uji,ArrayList<ArrayList> nilai_keyakinan){
        String file_bobot = System.getProperty("user.dir")+"/Data/data certainty factor.xlsx";
 
        hasil = new ArrayList<>();
        bobot = new ArrayList<>();
        ArrayList<ArrayList>bobot_gejala_penyakit = ex.load_excel(file_bobot);
        for(int i=0; i<data_uji.size();i++){
            double p1 = 0.0;
            double p2 = 0.0;
            double langkah = 0;
            for (int j=0; j<data_uji.get(i).size()-1;j++){
                if(Double.parseDouble(data_uji.get(i).get(j).toString())==1.0){
                    if(langkah==0){
                        if(bobot_gejala_penyakit.get(j).get(1).toString().toLowerCase().contains("p1")){
                            p1=Double.parseDouble(bobot_gejala_penyakit.get(j).get(2).toString())*Double.parseDouble(nilai_keyakinan.get(i).get(j).toString());
                            langkah++;
                        }
                        if(bobot_gejala_penyakit.get(j).get(1).toString().toLowerCase().contains("p2")){
                            p2=Double.parseDouble(bobot_gejala_penyakit.get(j).get(3).toString())*Double.parseDouble(nilai_keyakinan.get(i).get(j).toString());
                            langkah++;
                        }
                    }
                    else{
                        if(bobot_gejala_penyakit.get(j).get(1).toString().toLowerCase().contains("p1")){
                            p1=p1+((Double.parseDouble(bobot_gejala_penyakit.get(j).get(2).toString())*Double.parseDouble(nilai_keyakinan.get(i).get(j).toString()))*(1-p1));
                            langkah++;
                        }
                        if(bobot_gejala_penyakit.get(j).get(1).toString().toLowerCase().contains("p2")){
                            p2=p2+((Double.parseDouble(bobot_gejala_penyakit.get(j).get(3).toString())*Double.parseDouble(nilai_keyakinan.get(i).get(j).toString()))*(1-p2));
                            langkah++;
                        }
                        
                    }
                }
            }
            if(p1>=p2){
                hasil.add("P1");
                bobot.add(p1*100);
            }
            else if(p2>=p1){
                hasil.add("P2");
                bobot.add(p2*100);
            }
        }
    }
}
