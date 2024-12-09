package PemrogramanBerbasisDesktop.Tugas3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Menu {
    
    private ArrayList<MenuItem> daftarMenu = new ArrayList<>();

    public void tambahMenu(MenuItem item) {
        daftarMenu.add(item);
        simpanKeFile();
    }

    public void hapusMenu(int index) {
        if (index >= 0 && index < daftarMenu.size()) {
            daftarMenu.remove(index);
            simpanKeFile();
        }
    }

    public void tampilkanMenu() {
        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarMenu.get(i).tampilMenu();
        }
    }

    public ArrayList<MenuItem> getDaftarMenu() {
        return daftarMenu;
    }

    public MenuItem cariMenu(String nama) {
        for (MenuItem item : daftarMenu) {
            if (item.getNama().equalsIgnoreCase(nama)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Item tidak ditemukan.");
    }

    public void simpanKeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("menu.txt"))) {
            for (MenuItem item : daftarMenu) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saat menyimpan menu: " + e.getMessage());
        }
    }

    public void muatDariFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("menu.txt"))) {
            String line;
            daftarMenu.clear();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nama = parts[0];
                double harga = Double.parseDouble(parts[1]);
                String kategori = parts[2];
                if (kategori.equalsIgnoreCase("Makanan")) {
                    daftarMenu.add(new Makanan(nama, harga, kategori, "Umum"));
                } else if (kategori.equalsIgnoreCase("Minuman")) {
                    daftarMenu.add(new Minuman(nama, harga, kategori, "Dingin"));
                } else if (kategori.equalsIgnoreCase("Diskon")) {
                    daftarMenu.add(new Diskon(nama, harga, kategori, Double.parseDouble(parts[3])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error saat memuat menu: " + e.getMessage());
        }
    }
}

