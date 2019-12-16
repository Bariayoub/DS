package com.company.DS1_Ghoudan_Bari;

import java.io.*;

public class Lecteur extends Thread{

   private String fileName;
    private String threadName;
    private  MyBuffer buffer;

    public Lecteur(String fileName, String threadName, MyBuffer buffer) {
        this.fileName = fileName;
        this.threadName = threadName;
        this.buffer = buffer;
    }

    public String readWord() throws IOException {
        File f = new File(this.fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line;
        while ((line = reader.readLine())!=null){
            String fin =  line.replace(";.!?", " ");
            System.out.println(line);
        }
        return line;
    }
    public synchronized   void run(){
        System.out.println("---------->Lecteur IN");
        File f = new File(this.fileName);
        BufferedInputStream bufferedInputStream = null;
        try {
            System.out.println("---------->Lecteur Working");
            bufferedInputStream = new BufferedInputStream(new FileInputStream(f));
            byte[] buf=  new  byte[10];
            int n = 0;
            while ((n=bufferedInputStream.read(buf))>=0){
                for (int i=0;i<n;i++) {
                     if (n>this.buffer.data.size()){
                         System.out.print("Garage Full Working on Empty One place!!\n");
                         new Procssor().Processe();
                     }
                     this.buffer.addWord(String.valueOf(((char) buf[i])));
                 }
            }
            System.out.println("File Are readable : \n\r");readWord();
            bufferedInputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("---------->Lecteur out");
    }

}
