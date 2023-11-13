package StrukturData;

import java.util.Arrays;

// Nama : Fadil Biyan Eka Satria
// NIM : 048634082
// Prodi : Sistem Informasi
// UPBJJ : Semarang

// Soal
// 1. Buatlah coding pengurutan data dari terkecil hingga terbesar dari data berikut (a1, a2, a3, a4, a5, a6)
// tentukan sendiri nilai a1 sampai a6. Urutkan dengan menggunakan algoritma Merge-sort? Kemudian anda analisa kinerja algoritma tersebut?
// 2. Buatlah coding pengurutan data dari terkecil hingga terbesar dari data berikut (a1, a2, a3, a4, a5, a6)
// tentukan sendiri nilai a1 sampai a6. Urutkan dengan menggunakan algoritma Counting-sort? Kemudian anda analisa kinerja algoritma tersebut?

public class TugasDua {

    static class MergerSort {

        // Membuat fungsi merger
        void merge(int array[], int left, int middle, int right) {
            // Membagi dua sisi antara kanan dan kiri
            int leftSide = middle - left + 1;
            int rightSide = right - middle;

            // Memasukkan sisi kanan ke dalam array dan sisi kiri kedalam array
            int arrayLeft[] = new int[leftSide];
            int arrayRight[] = new int[rightSide];

            // arrayLeft menampung data array dari sisi kiri
            // arrayRight menampung data array dari sisi kanan
            for (int i = 0; i < leftSide; ++i)
                arrayLeft[i] = array[left + i];
            for (int j = 0; j < rightSide; ++j)
                arrayRight[j] = array[middle + 1 + j];

            int i = 0, j = 0;

            int k = left;
            // Melakukan perulangan dengan menginisiasi index dari submerger merger
            while (i < leftSide && j < rightSide) {
                if (arrayLeft[i] <= arrayRight[j]) {
                    array[k] = arrayLeft[i];
                    i++;
                } else {
                    array[k] = arrayRight[j];
                    j++;
                }
                k++;
            }

            // Kemudian memasukkan elemen yang sudah diinisiasi kedalam arrayLeft jika ada
            while (i < leftSide) {
                array[k] = arrayLeft[i];
                i++;
                k++;
            }

            // Dan memasukkan elemen yang sudah diinisiasi dalam bentuk array kedalam arrayRight jika ada
            while (j < rightSide) {
                array[k] = arrayRight[j];
                j++;
                k++;
            }
        }

        // Fungsi sorting
        void sort(int array[], int left, int right) {
            if (left < right) {

                // Menentukan titik tengah dari array
                int middle = left + (right - left) / 2;

                // Melakukan sorting untuk yang pertama dan kedua
                sort(array, left, middle);
                sort(array, middle + 1, right);

                // Kemudian hasil sort akan di merger
                merge(array, left, middle, right);
            }
        }
    }

    // Membuat fungsi CountingSort
    static class CountingSort {
        void countSort(int array[], int size) {
            int[] output = new int[size + 1];

            // Mencari elemen terbesar dari array
            int max = array[0];
            for (int i = 1; i < size; i++) {
                if (array[i] > max)
                    max = array[i];
            }
            int[] count = new int[max + 1];

            // Jumlah array dari 0 ke yang terbesar
            for (int i = 0; i < max; ++i) {
                count[i] = 0;
            }

            // Menyimpan count keberapa dari setiap elemen
            for (int i = 0; i < size; i++) {
                count[array[i]]++;
            }

            // Kemudian menyimpan count kumulatif dari setiap elemen
            for (int i = 1; i <= max; i++) {
                count[i] += count[i - 1];
            }

            // Mencari index dari setiap elemen dari array count
            for (int i = size - 1; i >= 0; i--) {
                output[count[array[i]] - 1] = array[i];
                // Menyimpan dalam output array
                count[array[i]]--;
            }

            // Menyimpan array yang disorting kedalam variabel array
            for (int i = 0; i < size; i++) {
                array[i] = output[i];
            }
        }
    }

    public static void main(String args[]) {
        int dataMergerSort[] = {26, 14, 22, 67, 49, 31};

        System.out.println("Data Acak Merger Sort");
        printArray(dataMergerSort);

        TugasDua.MergerSort mergerSort = new TugasDua.MergerSort();
        mergerSort.sort(dataMergerSort, 0, dataMergerSort.length - 1);

        System.out.println();
        System.out.println("Hasil Merger Sort");
        printArray(dataMergerSort);

        System.out.println();

        int[] dataCountingSort = {20, 29, 23, 22, 27, 26};
        int size = dataCountingSort.length;
        System.out.println();
        System.out.println("Data Acak Counting Sort");
        printArray(dataCountingSort);
        System.out.println();

        TugasDua.CountingSort countingSort = new TugasDua.CountingSort();
        countingSort.countSort(dataCountingSort, size);
        System.out.println("Hasil Counting Sort");
        printArray(dataCountingSort);
    }

    static void printArray(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
