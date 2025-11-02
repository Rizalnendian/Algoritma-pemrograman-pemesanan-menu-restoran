import java.util.Scanner;


class Menu {
    String nama;
    int harga;
    String kategori;

    public Menu(String nama, int harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        Menu[] daftarMenu = {
                new Menu("Karage Ramen", 26000, "Makanan"),
                new Menu("Fishroll Ramen", 24000, "Makanan"),
                new Menu("Katsu Ramen", 27000, "Makanan"),
                new Menu("Niwatori Ramen", 35000, "Makanan"),
                new Menu("Calamary Ramen", 27000, "Makanan"),
                new Menu("Tokyo Banana", 17000, "Minuman"),
                new Menu("Hot Lemon Tea", 10000, "Minuman"),
                new Menu("Matcha latte", 18000, "Minuman"),
                new Menu("Ice Lemon Tea", 17000, "Minuman"),
                new Menu("Air Mineral", 7000, "Minuman"),
        };


        System.out.println("==============================================");
        System.out.println("           RESTORAN RAMEN ICHIRAKU          ");
        System.out.println("==============================================");
        System.out.println("                 DAFTAR MENU                  ");
        System.out.println("----------------------------------------------");
        System.out.println(">> Makanan:");
        System.out.println("1. " + daftarMenu[0].nama + "\t\t\tRp " + daftarMenu[0].harga);
        System.out.println("2. " + daftarMenu[1].nama + "\t\tRp " + daftarMenu[1].harga);
        System.out.println("3. " + daftarMenu[2].nama + "\t\t\tRp " + daftarMenu[2].harga);
        System.out.println("4. " + daftarMenu[3].nama + "\t\tRp " + daftarMenu[3].harga);
        System.out.println("5. " + daftarMenu[4].nama + "\t\tRp " + daftarMenu[4].harga + "\n");
        System.out.println(">> Minuman:");
        System.out.println("5. " + daftarMenu[5].nama + "\t\t\tRp " + daftarMenu[5].harga);
        System.out.println("6. " + daftarMenu[6].nama + "\t\tRp " + daftarMenu[6].harga);
        System.out.println("7. " + daftarMenu[7].nama + "\t\t\tRp " + daftarMenu[7].harga);
        System.out.println("8. " + daftarMenu[8].nama + "\t\tRp " + daftarMenu[8].harga);
        System.out.println("8. " + daftarMenu[9].nama + "\t\t\tRp " + daftarMenu[9].harga);
        System.out.println("==============================================");
        System.out.println("Masukan nama menu dan jumlahnya");
        System.out.println("----------------------------------------------");


        System.out.print("Menu 1: ");
        String menu1 = input.nextLine();
        System.out.print("Jumlah: ");
        int jml1 = input.nextInt(); input.nextLine();

        System.out.print("Menu 2: ");
        String menu2 = input.nextLine();
        System.out.print("Jumlah: ");
        int jml2 = input.nextInt(); input.nextLine();

        System.out.print("Menu 3: ");
        String menu3 = input.nextLine();
        System.out.print("Jumlah: ");
        int jml3 = input.nextInt(); input.nextLine();

        System.out.print("Menu 4: ");
        String menu4 = input.nextLine();
        System.out.print("Jumlah: ");
        int jml4 = input.nextInt(); input.nextLine();


        int total1 = hitungTotal(daftarMenu, menu1, jml1);
        int total2 = hitungTotal(daftarMenu, menu2, jml2);
        int total3 = hitungTotal(daftarMenu, menu3, jml3);
        int total4 = hitungTotal(daftarMenu, menu4, jml4);

        int subtotal = total1 + total2 + total3 + total4;
        double pajak = subtotal * 0.10;
        int biayaPelayanan = 20000;
        double totalSetelahPajak = subtotal + pajak + biayaPelayanan;


        double diskon = 0;
        boolean promoMinuman = false;
        String infoPromo = "-";

        if (subtotal > 100000) {
            diskon = totalSetelahPajak * 0.10;
            infoPromo = "Diskon 10% diberikan.";
        } else if (subtotal > 50000) {
            promoMinuman = true;
            infoPromo = "Promo Beli 1 Gratis 1 Minuman diterapkan.";
        }

        double totalAkhir = totalSetelahPajak - diskon;
        if (promoMinuman) {
            totalAkhir -= 7000;
        }


        System.out.println("\n\n==============================================");
        System.out.println("             STRUK PEMBAYARAN RESTO           ");
        System.out.println("==============================================");
        cetakPesanan(menu1, jml1, total1);
        cetakPesanan(menu2, jml2, total2);
        cetakPesanan(menu3, jml3, total3);
        cetakPesanan(menu4, jml4, total4);
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s Rp %,.0f%n", "Subtotal", (double) subtotal);
        System.out.printf("%-25s Rp %,.0f%n", "Pajak (10%)", pajak);
        System.out.printf("%-25s Rp %,.0f%n", "Biaya Pelayanan", (double) biayaPelayanan);
        if (diskon > 0) {
            System.out.printf("%-25s Rp -%,.0f%n", "Diskon 10%", diskon);
        }
        if (promoMinuman) {
            System.out.printf("%-25s Rp -%,.0f%n", "Gratis Minuman", 7000.0);
        }
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s Rp %,.0f%n", "TOTAL BAYAR", totalAkhir);
        System.out.println("----------------------------------------------");
        System.out.println("Promo: " + infoPromo);
        System.out.println("==============================================");
        System.out.println("  Terima kasih telah memesan di Restoran Kami!");
        System.out.println("==============================================");

        input.close();
    }


    public static int hitungTotal(Menu[] daftar, String namaMenu, int jumlah) {
        int harga = 0;

        // Menggunakan struktur keputusan
        if (namaMenu.equalsIgnoreCase("Karage Ramen")) harga = daftar[0].harga;
        else if (namaMenu.equalsIgnoreCase("Fishroll Ramen")) harga = daftar[1].harga;
        else if (namaMenu.equalsIgnoreCase("Katsu Ramen")) harga = daftar[2].harga;
        else if (namaMenu.equalsIgnoreCase("Niwatori Ramen")) harga = daftar[3].harga;
        else if (namaMenu.equalsIgnoreCase("Calamary Ramen")) harga = daftar[4].harga;
        else if (namaMenu.equalsIgnoreCase("Tokyo Banana")) harga = daftar[5].harga;
        else if (namaMenu.equalsIgnoreCase("Hot Lemon Tea")) harga = daftar[6].harga;
        else if (namaMenu.equalsIgnoreCase("Matcha latte")) harga = daftar[7].harga;
        else if (namaMenu.equalsIgnoreCase("Ice Lemon Tea")) harga = daftar[8].harga;
        else if (namaMenu.equalsIgnoreCase("Air Mineral")) harga = daftar[9].harga;
        else System.out.println("Menu " + namaMenu + " tidak ditemukan!");

        return harga * jumlah;
    }


    public static void cetakPesanan(String nama, int jumlah, int total) {
        System.out.printf("%-15s | x%-2d | Rp %,.0f%n", nama, jumlah, (double) total);
    }
}
