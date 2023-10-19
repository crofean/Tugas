package StrukturData;
// Nama : Fadil Biyan Eka Satria
// NIM : 048634082
// Prodi : Sistem Informasi
// UPBJJ : Semarang

// Soal
// 1. Buatlah sebuah deklarasi variabel dengan tipe data integer yang bernama ‘nilai’? 
// 2. Buatlah sebuah deklarasi variabel dengan tipe data string yang bernama ‘kata’ yang berisi kata ‘struktur’? 
// 3. Buatlah pendeklarasian array satu dimensi dengan nama array adalah ‘arraySatu’, tipe data integer, yang berisi angka (12, 10, 40)? Pendeklarasian tersebut dengan menggunakan bahasa pemrograman Java. 
// 4. Buatlah pendeklarasian array dua dimensi dengan nama array adalah ‘arrayDua’, tipe data integer, yang terdiri dari dua baris dan tiga kolom, seperti pada matrik berikut: 
//          12   10   40 
//           13  11   41 
//           14  12   42 
//     Pendeklarasian tersebut dengan menggunakan bahasa pemrograman Java. 
// 5. Buatlah deklarasi linked list yang memiliki list (10, 20, 30, 40, 50)? 
// Pendeklarasian tersebut dengan menggunakan bahasa pemrograman Java. 

import java.util.LinkedList;

public class TugasSatu {
    public static void main(String args[]) {
        // Nomor 1
        int nilai;
        System.out.println("Nomor 1\nVariabel nilai\n");

        // Nomor 2
        String kata = "struktur";
        System.out.println("Nomor 2\n"+kata+"\n");

        // Nomor 3
        int[] arraySatu = {12,10,40};
        System.out.println("Nomor 3\n"+arraySatu[0]+","+arraySatu[1]+","+arraySatu[2]+"\n");

        // Nomor 4
        int[][] arrayDua = {
            {12,10,40},
            {13,11,41},
            {14,12,42}
        };
        System.out.println("Nomor 4\n"+
            arrayDua[0][0]+" "+arrayDua[0][1]+" "+arrayDua[0][2]+"\n"+
            arrayDua[1][0]+" "+arrayDua[1][1]+" "+arrayDua[1][2]+"\n"+
            arrayDua[2][0]+" "+arrayDua[2][1]+" "+arrayDua[2][2]+"\n"
        );

        // Nomor 5
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        System.out.println("Nomor 5\n"+linkedList+"\n");
    }
}
