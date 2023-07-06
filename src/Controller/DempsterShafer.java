/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Excel;
import java.util.ArrayList;

public class DempsterShafer {
    ArrayList<String> hasil = new ArrayList<>();
    ArrayList<Double> bobot = new ArrayList<>();
    Excel ex = new Excel();
      public ArrayList<String> get_hasil() {
        return hasil;
    }

   
    public ArrayList<Double> get_bobot() {
        return bobot;
    }
    
    public void do_dempster_shafer(ArrayList<ArrayList> data_uji){
        String file_bobot = System.getProperty("user.dir") + "/Data/data dempster shafer.xlsx";
      
        ArrayList<ArrayList> bobot_gejala_penyakit = ex.load_excel(file_bobot);
        hasil = new ArrayList<>();
        bobot = new ArrayList<>();
        
        for (int i = 0; i < data_uji.size(); i++){
            ArrayList<String> hasil_temp = new ArrayList<>();
            ArrayList<Double> nilai_temp = new ArrayList<>();
            for (int j = 0; j < data_uji.get(i).size() - 1; j++){
                ArrayList<String> temp = new ArrayList<>();
                ArrayList<Double> temps = new ArrayList<>();
                if (hasil_temp.isEmpty() && Double.parseDouble(data_uji.get(i).get(j).toString()) == 1.0) {
                    hasil_temp.add(bobot_gejala_penyakit.get(j).get(1).toString());
                    hasil_temp.add("p0");
                    nilai_temp.add(Double.parseDouble(bobot_gejala_penyakit.get(j).get(2).toString()));
                    nilai_temp.add(Double.parseDouble(bobot_gejala_penyakit.get(j).get(3).toString()));
                } 
                else if (Double.parseDouble(data_uji.get(i).get(j).toString()) == 1.0) {
                    temp.add(bobot_gejala_penyakit.get(j).get(1).toString());
                    temp.add("p0");
                    temps.add(Double.parseDouble(bobot_gejala_penyakit.get(j).get(2).toString()));
                    temps.add(Double.parseDouble(bobot_gejala_penyakit.get(j).get(3).toString()));

                    ArrayList<String> hasils = new ArrayList<>();
                    ArrayList<Double> nilais = new ArrayList<>();
                    double empty=0.0;
                    for (int k = 0; k < hasil_temp.size(); k++) {
                        for (int l = 0; l < temp.size(); l++) {
                            if (hasil_temp.get(k).equals(temp.get(l))) {
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(k))) {
                                        check = true;
                                        index = m;
                                        break;
                                    } else if (hasils.get(m).equals(temp.get(l))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    hasils.add(hasil_temp.get(k));
                                    nilais.add(nilai_temp.get(k) * temps.get(l)/(1-empty));
                                } else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)/(1-empty)));

                                }
                                
                            } 
                            else if (hasil_temp.get(k).equals("p0") && temp.get(l).equals("p0")) {
                               
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(i))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    hasils.add(hasil_temp.get(k));
                                    nilais.add(nilai_temp.get(k) * temps.get(l)/(1-empty));
                                } else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)/(1-empty)));

                                }
                               
                            } 
                            else if (hasil_temp.get(k).contains(temp.get(l)) ) {
                            
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(k))) {
                                        check = true;
                                        index = m;
                                        break;
                                    } 
                                    else if (hasils.get(m).equals(temp.get(l))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    hasils.add(temp.get(l));
                                    nilais.add(nilai_temp.get(k) * temps.get(l)/(1-empty));
                                } 
                                else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)/(1-empty)));

                                }
                               
                            }
                            else if ( temp.get(l).contains(hasil_temp.get(k) ) ) {
                              System.out.println("c");
                                System.out.println(k);
                                System.out.println(l);
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(k))) {
                                        check = true;
                                        index = m;
                                        break;
                                    } 
                                    else if (hasils.get(m).equals(temp.get(l))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    hasils.add(hasil_temp.get(k));
                                    nilais.add(nilai_temp.get(k) * temps.get(l)/(1-empty));
                                } 
                                else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)/(1-empty)));

                                }
                              
                            }
                            else {
                                
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(k))) {
                                        check = true;
                                        index = m;
                                        break;
                                    } 
                                    else if (hasils.get(m).equals(temp.get(l))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    if (hasil_temp.get(k).equals("p0") && !temp.get(l).equals("p0")) {
                                        hasils.add(temp.get(l));
                                        nilais.add(nilai_temp.get(k) * temps.get(l)/(1-empty));
                                    } else if (temp.get(l).equals("p0") && !hasil_temp.get(k).equals("p0")) {
                                        hasils.add(hasil_temp.get(k));
                                        nilais.add(nilai_temp.get(k) * temps.get(l)/(1-empty));
                                    } else {
                                       
                                        empty=empty+(nilai_temp.get(k) * temps.get(l));
                                    }

                                } else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)));

                                }
                               
                            }

                        }
                    }

                    hasil_temp = new ArrayList<>(hasils);
                    nilai_temp = new ArrayList<>(nilais);

                }
                
            }
            ArrayList<Double> nilai_urut = new ArrayList<>(nilai_temp);
            int index_terbaik = nilai_temp.indexOf(nilai_urut.get(0));
            hasil.add(hasil_temp.get(index_terbaik));
            bobot.add(nilai_temp.get(index_terbaik));
            System.out.println("hasil ");
            System.out.println(hasil);
            System.out.println("i ");
            System.out.println(i);
        }
        System.out.println("dempster");
        System.out.println("hasil ");
        System.out.println(hasil);
        System.out.println("bobot ");
        System.out.println(bobot);
    }

    
}
