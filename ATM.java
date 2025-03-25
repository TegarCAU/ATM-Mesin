import java.util.Scanner;

public class ATM {
    private double saldo;

    public ATM(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    public void cekSaldo() {
        System.out.println("Saldo Anda: Rp " + saldo);
    }

    public void setorTunai(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Berhasil menyetor Rp " + jumlah);
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0!");
        }
    }

    public void tarikTunai(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Berhasil menarik Rp " + jumlah);
        } else {
            System.out.println("Penarikan gagal! Pastikan saldo cukup dan jumlah valid.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(100000); // Saldo awal Rp 100.000

        while (true) {
            System.out.println("\n==== ATM Sederhana ====");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    atm.cekSaldo();
                    break;
                case 2:
                    System.out.print("Masukkan jumlah setoran: Rp ");
                    double setor = scanner.nextDouble();
                    atm.setorTunai(setor);
                    break;
                case 3:
                    System.out.print("Masukkan jumlah penarikan: Rp ");
                    double tarik = scanner.nextDouble();
                    atm.tarikTunai(tarik);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan ATM.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }
    }
}