package AlgoritmaDanPemrograman;

import java.util.Scanner;

public class TugasTiga {

    public static void main(String[] args) {

        System.out.println("SELAMAT DATANG");
        System.out.println("==============================");
        int[] arrayGaji = new int[]{5000000, 6500000, 9500000};
        int[] arrayPersenLembur = new int[]{30,32,34,36,38};

        Scanner scanner = new Scanner(System.in);
        int gaji = 0;

        System.out.println("Masukkan Golongan Anda (A/B/C) : ");
        String golongan = scanner.next().toUpperCase();
        if (golongan.trim().equals("A")) {
            gaji = arrayGaji[0];
        }

        if (golongan.trim().equals("B")) {
            gaji = arrayGaji[1];
        }

        if (golongan.trim().equals("C")) {
            gaji = arrayGaji[2];
        }

        System.out.println("Masukkan jumlah jam lembur Anda : ");
        int jamLembur = scanner.nextInt();
        double pendapatanLembur = 0;

        if (jamLembur == 1) {
            pendapatanLembur = (double) arrayPersenLembur[0] / 100 * gaji;
        }
        if (jamLembur == 2) {
            pendapatanLembur = (double) arrayPersenLembur[1] / 100 * gaji;
        }
        if (jamLembur == 3) {
            pendapatanLembur = (double) arrayPersenLembur[2] / 100 * gaji;
        }
        if (jamLembur == 4) {
            pendapatanLembur = (double) arrayPersenLembur[3] / 100 * gaji;
        }
        if (jamLembur >= 5) {
            pendapatanLembur = (double) arrayPersenLembur[4] / 100 * gaji;
        }

        System.out.println("Gaji Anda : Rp. " + gaji);
        System.out.println("Jumlah Lembur Anda : " + jamLembur + " jam");
        System.out.println("Pendapatan Lembur : Rp. " + pendapatanLembur + "\n");
        System.out.println("Total keseluruhan : Rp. " + (int) (gaji + pendapatanLembur));
        System.out.println("==============================");
    }

}
