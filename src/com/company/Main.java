package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File dir = new File("C:/");
        // если объект представляет каталог
        if(dir.isDirectory())
        {
            // получаем все вложенные объекты в каталоге
            for(File item : dir.listFiles()){

                if(item.isDirectory()){

                    System.out.println(item.getName() + " - folder");
                }
                else{

                    System.out.println(item.getName() + " -  file");
                }
            }
        }
    }
}
