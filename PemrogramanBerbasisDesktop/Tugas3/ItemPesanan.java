package PemrogramanBerbasisDesktop.Tugas3;

public class ItemPesanan {
    
    private final MenuItem item;
    private final int jumlah;

    public ItemPesanan(MenuItem item, int jumlah) {
        this.item = item;
        this.jumlah = jumlah;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getJumlah() {
        return jumlah;
    }
}

