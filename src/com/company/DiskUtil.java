package com.company;

import java.io.File;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiskUtil {
    private static DecimalFormat DECIMALFROMAT = new DecimalFormat("#.##");

    //получение информации об использовании диска

    public static void getInfo() {
      //  List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        File[] roots = File.listRoots();//список разделов диска
        for (File file : roots) {
            Map<String, String> map = new HashMap<String, String>();
            System.out.println("Структура диска "+ file.getPath()+"\n");
            if(file.isDirectory())
            {
                // получаем все вложенные объекты в каталоге
                for(File item : file.listFiles()){

                    if(item.isDirectory()){

                        System.out.println(item.getName() + " - folder");
                    }
                    else{

                        System.out.println(item.getName() + " -  file");
                    }
                }
            }

            long freeSpace = file.getFreeSpace();
            long totalSpace = file.getTotalSpace();
            long usableSpace = totalSpace - freeSpace;

            System.out.println("Название логического диска "+ file.getPath()+"\n");
            System.out.println("Свободное пространство " + freeSpace / 1024 / 1024 / 1024 + "Gb\n");
            System.out.println("Доступное пространство "+  usableSpace / 1024 / 1024 / 1024 + "Gb\n");
            System.out.println("Общее пространство "+  totalSpace / 1024 / 1024 / 1024 + "Gb\n");
            System.out.println("проценты "+ DECIMALFROMAT.format(((double) usableSpace / (double) totalSpace) * 100) + "%\n");


        }

    }

    public static void main(String[] args) {

        getInfo();

    }
}

