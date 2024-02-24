import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data diri
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        String jenisKelaminInput = scanner.nextLine();
        String jenisKelamin = (jenisKelaminInput.equalsIgnoreCase("L")) ? "Laki-laki" : "Perempuan";

        LocalDate tanggalLahir = null;
        boolean formatTanggalValid = false;
        while (!formatTanggalValid) {
            try {
                System.out.print("Masukkan tanggal lahir (YYYY-MM-DD): ");
                String tanggalLahirString = scanner.nextLine();
                tanggalLahir = LocalDate.parse(tanggalLahirString);
                formatTanggalValid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Format tanggal salah. Mohon masukkan tanggal dengan format YYYY-MM-DD.");
            }
        }

        // Menghitung umur
        LocalDate tanggalSekarang = LocalDate.now();
        int umur = Period.between(tanggalLahir, tanggalSekarang).getYears();

        // Menampilkan data diri dan umur
        System.out.println("\nData Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Tanggal Lahir: " + tanggalLahir);
        System.out.println("Umur: " + umur + " tahun");

        scanner.close();
    }
}