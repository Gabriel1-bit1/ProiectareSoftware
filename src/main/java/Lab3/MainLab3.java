package Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MainLab3 {

    public static void main(String[] args) {
        String inputFile = "in.txt";
        String outputFile = "out.txt";

        try {
            // Citim tot conținutul fișierului într-un singur String
            String continutFisier = Files.readString(Paths.get(inputFile));

            List<String> liniiText = Arrays.asList(continutFisier.split("\\r?\\n"));

            StringBuilder rezultatA = new StringBuilder();
            StringBuilder rezultatB = new StringBuilder();

            System.out.println("=== Rezultat Punctul a) ===");
            // a) Parcurgem fiecare linie și adăugăm încă un newline la final
            for (String linie : liniiText) {
                String linieModificataA = linie + "\n";
                rezultatA.append(linieModificataA).append("\n");
                System.out.print(linieModificataA + "\n");
            }

            System.out.println("=== Rezultat Punctul b) ===");
            // b) Parcurgem fiecare linie și adăugăm un newline (\n) după fiecare punct (.)
            for (String linie : liniiText) {
                String linieModificataB = linie.replace(".", ".\n");
                rezultatB.append(linieModificataB).append("\n");

                System.out.print(linieModificataB + "\n");
            }

            // c) Salvăm în fișierul out.txt rezultatul modificărilor de la a) și b)
            salvareInFisier(outputFile, rezultatA.toString(), rezultatB.toString());

        } catch (IOException e) {
            System.out.println("Eroare la procesarea fișierelor: " + e.getMessage());
        }
    }

    private static void salvareInFisier(String numeFisier, String dateA, String dateB) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(numeFisier))) {
            writer.println("--- Modificări de la punctul a) ---");
            writer.print(dateA);

            writer.println("\n--- Modificări de la punctul b) ---");
            writer.print(dateB);

            System.out.println("\nDatele au fost salvate cu succes in " + numeFisier);
        } catch (IOException e) {
            System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }
}