package PemrogramanBerbasisDesktop;

import java.util.ArrayList;
import java.util.Scanner;

// Tugas 2
// Fadil Biyan Eka Satria
// 048634082
// Sistem Informasi
public class Main2 {
    static ArrayList<Menu> menu = new ArrayList<>();
    
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Menu> pesanan = new ArrayList<>();

    static ArrayList<Integer> jumlah = new ArrayList<>();


     public static void main(String[] args) {
        menu.add(new Menu("Nasi Geprek", 25000, "Makanan"));
        menu.add(new Menu("Nasi Ikan Nila", 30000, "Makanan"));
        menu.add(new Menu("Mie Godog", 20000, "Makanan"));
        menu.add(new Menu("Nasi Megono", 20000, "Makanan"));

        menu.add(new Menu("Teh/Es Teh", 15000, "Minuman"));
        menu.add(new Menu("Jeruk/Es Jeruk", 25000, "Minuman"));
        menu.add(new Menu("Kopi Hitam", 20000, "Minuman"));
        menu.add(new Menu("Kopi Susu", 20000, "Minuman"));

        while (true) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Pesan Makanan");
            System.out.println("2. Kelola Menu (Pemilik)");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    pesanMakanan();
                    break;
                case 2:
                    kelolaMenu();
                    break;
                case 3:
                    System.out.println("Terima kasih.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahPemesanan(Menu item, int jumlahItem) {
        pesanan.add(item);
        jumlah.add(jumlahItem);
    }

    public static void tampilkanStruk() {
        double total = 0;
        double totalPajak = 0;
        double biayaPelayanan = 20000;
        boolean adaDiskon = false;

        System.out.println("\n----- STRUK PEMESANAN -----");
        for (int i = 0; i < pesanan.size(); i++) {
            Menu item = pesanan.get(i);
            double itemTotal = item.getHarga() * jumlah.get(i);
            System.out.println(item.getNama() + " (" + pesanan.get(i).getKategori() + ") - " +
                    "Jumlah: " + jumlah.get(i) + " - Harga per item: Rp. " + item.getHarga() + " - Total: Rp. " + itemTotal);
            total += itemTotal;
        }

        totalPajak = (int) (total * 0.1);
        total += totalPajak + biayaPelayanan;

        if (total > 100000) {
            total *= 0.9;
            adaDiskon = true;
        }

        if (total > 50000) {
            for (int i = 0; i < pesanan.size(); i++) {
                if (pesanan.get(i).getKategori().equals("Minuman") && jumlah.get(i) > 1) {
                    total -= pesanan.get(i).getHarga();
                    System.out.println("Penawaran beli satu gratis satu diterapkan pada: " + pesanan.get(i).getNama());
                    break;
                }
            }
        }

        System.out.println("\nTotal Harga: Rp. " + total);
        System.out.println("Pajak 10%: Rp. " + totalPajak);
        System.out.println("Biaya Pelayanan: Rp. " + biayaPelayanan);
        if (adaDiskon) {
            System.out.println("Diskon 10% diterapkan");
        }
        System.out.println("----------------------------");
    }

    public static void pesanMakanan() {
        while (true) {
            tampilkanMenu();
            System.out.print("Masukkan nomor menu untuk dipesan (atau ketik 'selesai' untuk selesai): ");
            String input = scanner.nextLine();

            if (input.equals("selesai")) {
                break;
            }

            try {
                int menuIndex = Integer.parseInt(input) - 1;
                if (menuIndex >= 0 && menuIndex < menu.size()) {
                    System.out.print("Masukkan jumlah yang ingin dipesan: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();
                    tambahPemesanan(menu.get(menuIndex), jumlah);
                } else {
                    System.out.println("Menu tidak ditemukan.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid.");
            }
        }
        tampilkanStruk();
    }

    public static void tampilkanMenu() {
        System.out.println("\n----- DAFTAR MENU -----");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + 1 + ". " + menu.get(i).getNama() + " - Rp. " + menu.get(i).getHarga() + " (" + menu.get(i).getKategori() + ")");
        }
    }

    public static void kelolaMenu() {
        while (true) {
            System.out.println("\n----- MENU PENGELOLAAN -----");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Ubah Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Kembali");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahMenu();
                    break;
                case 2:
                    ubahMenu();
                    break;
                case 3:
                    hapusMenu();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahMenu() {
        System.out.print("Masukkan nama menu: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga menu: ");
        int harga = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan kategori (Makanan/Minuman): ");
        String kategori = scanner.nextLine();
        menu.add(new Menu(nama, harga, kategori));
        System.out.println("Menu berhasil ditambahkan.");
    }

    public static void ubahMenu() {
        tampilkanMenu();
        System.out.print("Masukkan nomor menu yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < menu.size()) {
            System.out.print("Yakin ingin mengubah menu ini? (Ya/Tidak): ");
            String konfirmasi = scanner.nextLine();
            if (konfirmasi.equalsIgnoreCase("Ya")) {
                System.out.print("Masukkan nama baru: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan harga baru: ");
                int harga = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan kategori baru: ");
                String kategori = scanner.nextLine();
                menu.set(index, new Menu(nama, harga, kategori));
                System.out.println("Menu berhasil diubah.");
            }
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }

    public static void hapusMenu() {
        tampilkanMenu();
        System.out.print("Masukkan nomor menu yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < menu.size()) {
            System.out.print("Yakin ingin menghapus menu ini? (Ya/Tidak): ");
            String konfirmasi = scanner.nextLine();
            if (konfirmasi.equalsIgnoreCase("Ya")) {
                menu.remove(index);
                System.out.println("Menu berhasil dihapus.");
            }
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }
}
