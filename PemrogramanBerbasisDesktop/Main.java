package PemrogramanBerbasisDesktop;

import java.util.Scanner;

// Tugas 1
// Fadil Biyan Eka Satria
// 048634082
// Sistem Informasi
public class Main {
    // Daftar menu makanan dan minuman
    static Menu[] menu = new Menu[] {
        // Makanan
        new Menu("Nasi Geprek", 25000, "Makanan"),
        new Menu("Nasi Ikan Nila", 30000, "Makanan"),
        new Menu("Mie Godog", 20000, "Makanan"),
        new Menu("Nasi Megono", 20000, "Makanan"),

        // Minuman
        new Menu("Teh/Es Teh", 15000, "Minuman"),
        new Menu("Jeruk/Es Jeruk", 25000, "Minuman"),
        new Menu("Kopi Hitam", 20000, "Minuman"),
        new Menu("Kopi Susu", 20000, "Minuman")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Input menu restoran
        System.out.println("Menu Makanan:");
        System.out.println("1. Nasi Geprek - Rp " + menu[0].harga);
        System.out.println("2. Nasi Ikan Nila - Rp " + menu[1].harga);
        System.out.println("3. Mie Godog - Rp " + menu[2].harga);
        System.out.println("4. Nasi Megono - Rp " + menu[3].harga);

        System.out.println("\nMenu Minuman:");
        System.out.println("5. Teh/Es Teh - Rp " + menu[4].harga);
        System.out.println("6. Jeruk/Es Jeruk - Rp " + menu[5].harga);
        System.out.println("7. Kopi Hitam - Rp " + menu[6].harga);
        System.out.println("8. Kopi Susu - Rp " + menu[7].harga);

        double totalBiaya = 0;
        int jumlahMakanan = 0, jumlahMinuman = 0;

        // Pemesanan
        System.out.print("\nMasukkan makanan yang dipilih (1-4): ");
        int pilihanMakanan = scanner.nextInt();
        System.out.print("Masukkan jumlah yang dipesan: ");
        int jumlahMakananPesanan = scanner.nextInt();

        switch (pilihanMakanan) {
            case 1:
                totalBiaya += menu[0].harga * jumlahMakananPesanan;
                break;
            case 2:
                totalBiaya += menu[1].harga * jumlahMakananPesanan;
                break;
            case 3:
                totalBiaya += menu[2].harga * jumlahMakananPesanan;
                break;
            case 4:
                totalBiaya += menu[3].harga * jumlahMakananPesanan;
                break;
            default:
                System.out.println("Menu tidak ada.");
                break;
        }

        System.out.print("\nMasukkan minuman yang dipilih (5-8): ");
        int pilihanMinuman = scanner.nextInt();
        System.out.print("Masukkan jumlah yang dipesan: ");
        int jumlahMinumanPesanan = scanner.nextInt();

        switch (pilihanMinuman) {
            case 5:
                totalBiaya += menu[4].harga * jumlahMinumanPesanan;
                break;
            case 6:
                totalBiaya += menu[5].harga * jumlahMinumanPesanan;
                break;
            case 7:
                totalBiaya += menu[6].harga * jumlahMinumanPesanan;
                break;
            case 8:
                totalBiaya += menu[7].harga * jumlahMinumanPesanan;
                break;
            default:
                System.out.println("Menu tidak ada.");
                break;
        }

        // Menghitung total biaya
        double pajak = totalBiaya * 0.10; 
        double biayaPelayanan = 20000; 

        double diskon = 0;
        if (totalBiaya > 100000) {
            diskon = totalBiaya * 0.10;
        }

        double penawaran = 0;
        if (totalBiaya > 50000) {
            if (jumlahMinumanPesanan > 0) {
                penawaran = menu[pilihanMinuman-1].harga; 
            }
        }

        double totalSetelahDiskon = totalBiaya - diskon - penawaran;
        double totalAkhir = totalSetelahDiskon + pajak + biayaPelayanan;

        // Mencetak struk
        System.out.println("\n--- Struk Pesanan ---");
        if (jumlahMakananPesanan > 0) {
            System.out.println(menu[pilihanMakanan - 1].nama + " x " + jumlahMakananPesanan + " - Rp " + (menu[pilihanMakanan - 1].harga * jumlahMakananPesanan));
        }
        if (jumlahMinumanPesanan > 0) {
            System.out.println(menu[pilihanMinuman - 1].nama + " x " + jumlahMinumanPesanan + " - Rp " + (menu[pilihanMinuman - 1].harga * jumlahMinumanPesanan));
        }

        System.out.println("\nSubtotal: Rp " + totalBiaya);
        System.out.println("Pajak (10%): Rp " + pajak);
        System.out.println("Biaya Pelayanan: Rp " + biayaPelayanan);
        
        if (diskon > 0) {
            System.out.println("Diskon (10%): Rp " + diskon);
        }
        
        if (penawaran > 0) {
            System.out.println("Penawaran Beli Satu Gratis Satu Minuman: Rp " + penawaran);
        }

        System.out.println("\nTotal Biaya: Rp " + totalAkhir);
        scanner.close();
    }
}
