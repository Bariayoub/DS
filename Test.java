package com.company.DS1_Ghoudan_Bari;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {

        String f = "C:\\Users\\TheShadow\\IdeaProjects\\complexe\\src\\com\\company\\ttf.txt";
        String f2 = "C:\\Users\\TheShadow\\IdeaProjects\\complexe\\src\\com\\company\\tt.txt";
        MyBuffer buffer = new MyBuffer(100);
         new Procssor("Thread1",buffer).start();
         new Procssor("Thread2",buffer).start();
       Lecteur l1= new Lecteur(f,"Thread1",buffer);
       Lecteur l2 =new Lecteur(f2,"Thread1",buffer);
       l1.start();
       l2.start();

    }
}
