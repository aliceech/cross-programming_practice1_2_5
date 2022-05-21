package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {

    public static String getString(){
        Scanner in=new Scanner(System.in);
        System.out.print("Введите строку для записи: ");
        String str=in.nextLine();
        return str;
    }

    public static void main(String[] args){
        String string=getString();
        File file=new File("file1.txt");
        try(FileWriter nFile=new FileWriter(file,false)){
            nFile.write(string+"\n");
            nFile.flush();
            nFile.close();

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        Scanner in=new Scanner(System.in);
        System.out.println("Вывести содержимое файла? [0/1]?");
        int checkOutput=in.nextInt();
        if(checkOutput==1){
            try(FileReader reader=new FileReader(file)) {
                System.out.println("Содержимое файла:\n");
                int c;
                while((c=reader.read())!=-1){
                    System.out.print((char)c);
                }
            } catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Удалить файл? [0/1]?");
        int checkDelete=in.nextInt();
        if(checkDelete==1){
            file.delete();
        }


    }

}
