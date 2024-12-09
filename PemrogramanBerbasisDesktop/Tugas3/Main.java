package PemrogramanBerbasisDesktop.Tugas3;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        Pesanan pesanan = new Pesanan();
        Scanner scanner = new Scanner(System.in);

        menu.muatDariFile();

        while (true) {
            System.out.println("\n----- MENU UTAMA -----");
            System.out.println("1. Kelola Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Tambah Pesanan");
            System.out.println("4. Tampilkan Struk");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> kelolaMenu(menu, scanner);
                case 2 -> menu.tampilkanMenu();
                case 3 -> tambahPesanan(menu, pesanan, scanner);
                case 4 -> pesanan.tampilkanStruk();
                case 5 -> {
                    System.out.println("Terima kasih!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void kelolaMenu(Menu menu, Scanner scanner) {
        while (true) {
            System.out.println("\n----- MENU PENGELOLAAN -----");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Ubah Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Tampilkan Menu");
            System.out.println("5. Kembali");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1 -> tambahMenu(menu, scanner);
                case 2 -> ubahMenu(menu, scanner);
                case 3 -> hapusMenu(menu, scanner);
                case 4 -> menu.tampilkanMenu();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    public static void tambahMenu(Menu menu, Scanner scanner) {
        System.out.println("\n----- TAMBAH MENU -----");
        System.out.print("Masukkan nama menu: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Masukkan kategori (Makanan/Minuman/Diskon): ");
        String kategori = scanner.nextLine();

        if (kategori.equalsIgnoreCase("Makanan")) {
            System.out.print("Masukkan jenis makanan: ");
            String jenisMakanan = scanner.nextLine();
            menu.tambahMenu(new Makanan(nama, harga, kategori, jenisMakanan));
        } else if (kategori.equalsIgnoreCase("Minuman")) {
            System.out.print("Masukkan jenis minuman: ");
            String jenisMinuman = scanner.nextLine();
            menu.tambahMenu(new Minuman(nama, harga, kategori, jenisMinuman));
        } else if (kategori.equalsIgnoreCase("Diskon")) {
            System.out.print("Masukkan besaran diskon (persen): ");
            double diskon = scanner.nextDouble() / 100.0;
            menu.tambahMenu(new Diskon(nama, harga, kategori, diskon));
        } else {
            System.out.println("Kategori tidak valid.");
        }
    }

    public static void ubahMenu(Menu menu, Scanner scanner) {
        System.out.println("\n----- UBAH MENU -----");
        menu.tampilkanMenu();
        System.out.print("Masukkan nomor menu yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index >= 0 && index < menu.getDaftarMenu().size()) {
            MenuItem itemLama = menu.getDaftarMenu().get(index);
            System.out.println("Item yang akan diubah:");
            itemLama.tampilMenu();

            System.out.print("Masukkan nama baru: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan harga baru: ");
            double harga = scanner.nextDouble();
            scanner.nextLine(); 

            if (itemLama instanceof Makanan) {
                System.out.print("Masukkan jenis makanan baru: ");
                String jenisMakanan = scanner.nextLine();
                menu.getDaftarMenu().set(index, new Makanan(nama, harga, "Makanan", jenisMakanan));
            } else if (itemLama instanceof Minuman) {
                System.out.print("Masukkan jenis minuman baru: ");
                String jenisMinuman = scanner.nextLine();
                menu.getDaftarMenu().set(index, new Minuman(nama, harga, "Minuman", jenisMinuman));
            } else if (itemLama instanceof Diskon) {
                System.out.print("Masukkan diskon baru (persen): ");
                double diskon = scanner.nextDouble() / 100.0;
                menu.getDaftarMenu().set(index, new Diskon(nama, harga, "Diskon", diskon));
            }
            menu.simpanKeFile();
            System.out.println("Menu berhasil diubah.");
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }

    public static void hapusMenu(Menu menu, Scanner scanner) {
        System.out.println("\n----- HAPUS MENU -----");
        menu.tampilkanMenu();
        System.out.print("Masukkan nomor menu yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index >= 0 && index < menu.getDaftarMenu().size()) {
            System.out.print("Yakin ingin menghapus menu ini? (Ya/Tidak): ");
            String konfirmasi = scanner.nextLine();
            if (konfirmasi.equalsIgnoreCase("Ya")) {
                menu.hapusMenu(index);
                System.out.println("Menu berhasil dihapus.");
            }
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }

    public static void tambahPesanan(Menu menu, Pesanan pesanan, Scanner scanner) {
        while (true) {
            System.out.println("\n----- TAMBAH PESANAN -----");
            menu.tampilkanMenu(); 
            System.out.print("Masukkan nomor item yang ingin dipesan (atau ketik 'selesai' untuk selesai): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("selesai")) {
                break; 
            }

            try {
                int menuIndex = Integer.parseInt(input) - 1; 
                if (menuIndex >= 0 && menuIndex < menu.getDaftarMenu().size()) {
                    MenuItem item = menu.getDaftarMenu().get(menuIndex); 
                    System.out.print("Masukkan jumlah yang ingin dipesan: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine(); 
                    pesanan.tambahPesanan(item, jumlah); 
                    System.out.println("Pesanan berhasil ditambahkan.");
                } else {
                    System.out.println("Nomor menu tidak valid. Coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan nomor item.");
            }
        }

        System.out.println("\nPesanan selesai.");
        pesanan.tampilkanStruk(); 
    }


}
