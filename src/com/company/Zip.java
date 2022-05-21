package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        System.out.print("Введите полное название файла для архивирования: ");
        String filename=in.nextLine();
        String zipname="output.zip";
        try(ZipOutputStream zout =new ZipOutputStream(new FileOutputStream(zipname));
            FileInputStream fis=new FileInputStream(filename);)
        {
            ZipEntry entry1= new ZipEntry("fileToZip.txt");
            zout.putNextEntry(entry1);
            byte[] buffer=new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        try(ZipInputStream zin=new ZipInputStream(new FileInputStream(zipname))) {
            ZipEntry entry;
            String name;
            long size;
            while((entry=zin.getNextEntry())!=null) {

                name=entry.getName();
                size=entry.getSize();
                System.out.println("File name: " + name + "\t" + "File size: " +size+ "\n");

                //unpack
                FileOutputStream fout= new FileOutputStream("C:\\Users\\chemo\\IdeaProjects\\homework1\\new"+name);
                for(int c=zin.read();c!=-1;c=zin.read()){
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Удалить файл? [0/1]?");
        File file=new File("C:\\Users\\chemo\\IdeaProjects\\homework1\\output.zip");
        int checkDelete=in.nextInt();
        if(checkDelete==1){
            file.delete();
        }
        }

    }


