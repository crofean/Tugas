package PemrogramanBerbasisDesktop.Tugas3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Pesanan {

    private ArrayList<ItemPesanan> daftarPesanan = new ArrayList<>();

    public void tambahPesanan(MenuItem item, int jumlah) {
        daftarPesanan.add(new ItemPesanan(item, jumlah));
    }

    public void tampilkanStruk() {
        double totalHarga = 0;
        double totalDiskon = 0;
        StringBuilder struk = new StringBuilder();

        struk.append("\n----- STRUK PEMESANAN -----\n");
        System.out.println("\n----- STRUK PEMESANAN -----");

        for (ItemPesanan itemPesanan : daftarPesanan) {
            MenuItem item = itemPesanan.getItem();
            int jumlah = itemPesanan.getJumlah();
            double hargaItem = item.getHarga() * jumlah;

            if (item instanceof Diskon diskonItem) {
                double diskon = hargaItem * diskonItem.getDiskon();
                totalDiskon += diskon;
                hargaItem -= diskon;
            }

            totalHarga += hargaItem;

            String line = item.getNama() + " - " + jumlah + " x Rp. " + item.getHarga() +
                    " = Rp. " + hargaItem + (item instanceof Diskon ? " (Diskon)" : "") + "\n";
            System.out.print(line);
            struk.append(line);
        }

        double pajak = totalHarga * 0.1;
        totalHarga += pajak;

        struk.append("\nSubtotal: Rp. ").append(totalHarga - pajak)
            .append("\nPajak (10%): Rp. ").append(pajak);
        if (totalDiskon > 0) {
            struk.append("\nTotal Diskon: Rp. ").append(totalDiskon);
        }
        struk.append("\nTotal Bayar: Rp. ").append(totalHarga)
            .append("\n----------------------------\n");

        System.out.println("\nSubtotal: Rp. " + (totalHarga - pajak));
        System.out.println("Pajak (10%): Rp. " + pajak);
        if (totalDiskon > 0) {
            System.out.println("Total Diskon: Rp. " + totalDiskon);
        }
        System.out.println("Total Bayar: Rp. " + totalHarga);
        System.out.println("----------------------------");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("struk.txt"))) {
            writer.write(struk.toString());
            System.out.println("\nStruk berhasil disimpan ke struk.txt");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan struk ke file: " + e.getMessage());
        }
    }
}
