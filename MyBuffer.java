package com.company.DS1_Ghoudan_Bari;

import java.io.Serializable;
import java.util.LinkedList;

public class MyBuffer implements Serializable {

    private int size ;
    LinkedList<String> data = new LinkedList<String>();

    public MyBuffer(int size) {
        this.size = size;
    }

    public void addWord(String s){
        this.data.add(s);
    }

}
