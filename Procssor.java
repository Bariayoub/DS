package com.company.DS1_Ghoudan_Bari;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Procssor extends Thread {

    private String Pname;
    public  MyBuffer buff;
    HashMap<String,Integer> wordsCounts = new HashMap<String,Integer>();
    static int i = 0;

    public Procssor() { }

    public Procssor(String pname, MyBuffer buff) {
        i++;
        Pname = pname;
        this.buff = buff;
        wordsCounts.put(buff.data.poll(),i);
    }

    public void run(){
        System.out.println("---------->Procssor IN");
        Set<String> s = this.wordsCounts.keySet();
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            Processe();
            try {
                Thread.sleep(1000);
                System.out.println("---------->Procssor WAITING");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---------->Procssor OUT");
    }

    public void Processe(){
        Set<String> s = this.wordsCounts.keySet();
        Iterator<String> it = s.iterator();
        if (it.hasNext()){
            it.next();
            it.remove();}
    }

    public HashMap<String, Integer> getWordsCounts() {
        return wordsCounts;
    }
}
