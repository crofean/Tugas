package AlgoritmaDanPemrograman;

import java.util.Scanner;

public class TugasDua {

    public static void main(String[] args) {

        int A = 5000000;
        int B = 6500000;
        int C = 9500000;

        Scanner scanner = new Scanner(System.in);

        int gaji = 0;

        System.out.println("Selamat Datang di Program Perhitungan Gaji");
        System.out.println("==========================================");
        System.out.println("Golongan A = Rp." + A);
        System.out.println("Golongan B = Rp." + B);
        System.out.println("Golongan C = Rp." + C);
        System.out.println("Masukkan golongan Anda (A,B,C) : ");
        String golongan = scanner.next();

        if (golongan.equals("A")) {
            gaji = A;
        } else if (golongan.equals("B")) {
            gaji = B;
        } else if (golongan.equals("C")) {
            gaji = C;
        }

        System.out.println("Gaji pokok Anda yaitu Rp." + gaji);
        double jumlahLembur = 0;

        System.out.println("Masukkan jumlah jam lembur Anda (jumlah jam) : ");
        int jumlah = scanner.nextInt();

        if (jumlah == 1) {
            jumlahLembur = 0.30 * gaji;
        } else if (jumlah == 2) {
            jumlahLembur = 0.32 * gaji;
        } else if (jumlah == 3) {
            jumlahLembur = 0.34 * gaji;
        } else if (jumlah == 4) {
            jumlahLembur = 0.36 * gaji;
        } else if (jumlah >= 5) {
            jumlahLembur = 0.38 * gaji;
        }

        System.out.println("Jumlah lembur Anda yaitu Rp. " + jumlahLembur);
        int totalGaji = (int) (gaji + jumlahLembur);

        System.out.println("Jumlah gaji Anda yaitu");
        System.out.println("Rp. " + totalGaji);
        System.out.println("=========================================");

    }

}
