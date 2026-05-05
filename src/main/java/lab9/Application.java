package lab9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {

        //9.3.1
        Random random = new Random();
        // Crearea unei liste de 10 numere intregi aleatoare in intervalul [5..25]
        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());

        // a) Calculati suma elementelor folosind java streams si afisati
        int suma = numere.stream().mapToInt(Integer::intValue).sum();
        System.out.println("a) Suma elementelor: " + suma);

        // b) Calculati valoarea maxima si minima in lista. Afisati
        int max = numere.stream().max(Comparator.naturalOrder()).get();
        int min = numere.stream().min(Comparator.naturalOrder()).get();
        System.out.println("b) Valoarea maxima: " + max + " | Valoarea minima: " + min);

        // c) Parcurgeti lista si creati o alta lista prin pastrarea doar a elementelor in intervalul [10..20]
        List<Integer> listaFiltrata = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("c) Elementele in intervalul [10..20]: " + listaFiltrata);

        // d) Folosind stream transformati (mapati) lista de intregi in alta lista care sa contina valori Double
        List<Double> listaDouble = numere.stream()
                .map(Double::valueOf)
                .collect(Collectors.toList());
        System.out.println("d) Lista transformata in Double: " + listaDouble);

        // e) Afisati daca in lista se gaseste valoarea 12
        boolean contine12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println("e) Lista contine valoarea 12? " + contine12);


        //9.3.2
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));

        // a) parcurgeti si numarati cuvintele ale caror lungime este mai mare sau egala de 5 caractere
        List<String> cuvinteFiltrate = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());
        long numarCuvinte = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .count();
        System.out.println("a) Numarul de cuvinte cu >= 5 caractere: " + numarCuvinte);
        System.out.println("a) Lista filtrata: " + cuvinteFiltrate);

        // b) ordonati lista noua si apoi afisati
        List<String> cuvinteSortate = cuvinteFiltrate.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("b) Lista ordonata: " + cuvinteSortate);

        // c) afisati un element care incepe cu litera 'p'
        Optional<String> cuvantCuP = cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findFirst();

        if (cuvantCuP.isPresent()) {
            System.out.println("c) Am gasit un cuvant care incepe cu 'p': " + cuvantCuP.get());
        } else {
            System.out.println("c) Nu am gasit niciun cuvant care sa inceapa cu 'p'.");
        }

    }
}