package StrukturData;

import java.util.Scanner;

// Nama : Fadil Biyan Eka Satria
// NIM : 048634082
// Prodi : Sistem Informasi
// UPBJJ : Semarang

// Soal

// 1. Buatlah sebuah program searching (algoritma sequential search) dengan menggunakan bahasa Java. 
// Adapun data yang dimasukkan yaitu (a1, a2, a3, a4, a5) silahkan tentukan sendiri nilai dari a1 sampai a5, lakukan pencarian angka n (tentukan sendiri) pada data tersebut.

// Berikan penjelasan tahap demi tahap proses searching tersebut, gambarkan dengan rinci prosesnya.

// 2. Buatlah sebuah program searching (algoritma binary search) dengan menggunakan bahasa Java. 
// Adapun data yang dimasukkan yaitu (a1, a2, a3, a4, a5) silahkan tentukan sendiri nilai dari a1 sampai a5, lakukan pencarian angka n (tentukan sendiri) pada data tersebut.

// Berikan penjelasan tahap demi tahap proses searching tersebut, gambarkan dengan rinci prosesnya.

public class TugasTiga {
    public static void main(String[] args) {
        // Mencari secara sequential
        System.out.println("Memulai pencarian sequential...");

        int[] sequentialData = {12,35,24,21,43};
        System.out.println("Masukkan angka yang dicari : ");
        Scanner scanner = new Scanner(System.in);
        int keyword = scanner.nextInt();
        
        int hasilSequentialSearch = sequentialSearch(sequentialData, keyword);
        // Cek apakah data ditemukan atau tidak dan menampilkan hasilnya
        if (hasilSequentialSearch == 0) {
            System.out.println("Data yang dicari tidak ditemukan");
        } else {
            System.out.println("Data ditemukan : " + hasilSequentialSearch);
        }
        System.out.println("Akhir pencarian sequential");


        // Mencari secara binary
        System.out.println("Memulai pencarian binary...");

        int[] binaryData = {12,13,14,15,16};
        System.out.println("Masukkan angka yang dicari : ");
        Scanner scannerBinary = new Scanner(System.in);
        int keywordBinary = scanner.nextInt();
        
        int hasilBinarySearch = binarySearch(binaryData, keywordBinary);
        // Cek apakah data ditemukan atau tidak dan menampilkan hasilnya
        if (hasilBinarySearch == 0) {
            System.out.println("Data yang dicari tidak ditemukan");
        } else {
            System.out.println("Data ditemukan : " + hasilBinarySearch);
        }
        System.out.println("Akhir pencarian binary");
    }

    // Membuat fungsi untuk mencari seacara sequential
    // terdapat 2 parameter yaitu data yang akan dicari dan array datanya
    static int sequentialSearch(int[] data, int keyword) {
        // Melakukan perulangan untuk mencari data secara sequential atau urut
        for (int i = 0; i < data.length; i++) {
            // Dilakukan pengecekan jika data sama dengan yang dicari, maka akan mengembalikan nilai data tersebut
            if (data[i] == keyword) {
                return data[i];
            }
        }
        return 0;
    }

    // Membuat fungsi untuk mencari secara binary
    // terdapat 2 parameter yaitu data yang akan dicari dan array datanya
    static int binarySearch(int[] data, int keyword) {
        // Menentukan nilai low dan high
        int low = 0;
        int high = data.length - 1;

        // Melakukan perulangan ketika nilai low tidak lebih dari sama dengan high
        while (low <= high) {
            int mid = (low + high) / 2;

            // Melakukan prosws pencarian dari mid, low, high
            if (data[mid] == keyword) {
                // Mengembalikan nilai midd
                return data[mid];
            } else if (data[mid] < keyword) {
                // Mengset nilai low menjadi + 1
                low =  mid + 1;
            } else {
                // Mengset nilai high - 1
                high = mid - 1;
            }
        }
        // return 0 jika data tidak ditemukan
        return 0;
    }

}
