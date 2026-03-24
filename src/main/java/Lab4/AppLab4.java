package Lab4;
import java.util.HashMap;
import java.util.Map;

public class AppLab4 {
    static void main() {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor", "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai", "Cisnadie","Daniela", "Sibiu");
        // Afisarea continutului initial al instantei 'varste'
        System.out.println("Continut initial varste: " + varste);
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        // Afisarea continutului dupa adaugare
        System.out.println("Continut varste dupa adaugare: " + varste);
        // c) Declararea noii instante de tip HashMap
        HashMap<String, Tineri> tineri = new HashMap<>();
        // Parcurgerea instantei 'varste'
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            String nume = entry.getKey();
            int varsta = entry.getValue();
            // Cautam adresa in map-ul 'adrese' pe baza numelui
            String adresa = adrese.get(nume);
            // Instantiem obiectul Tineri
            Tineri tanarNou = new Tineri(nume, varsta, adresa);
            tineri.put(nume, tanarNou);
        }
        // d) Afisarea in consola
        System.out.println("Continutul instantei tineri: ");
        System.out.println(tineri);
    }
}
