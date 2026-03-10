package lab1;

public class Application {
    public static void main()
    {
        String alfabet = "";
        for (char i = 'a'; i <= 'z'; i++) {
            alfabet += i;
        }

        System.out.println(alfabet.toLowerCase());

        System.out.println(alfabet.toUpperCase());


            String[] arraySectiuni = new String[5];

        int indexArray = 0;
        String grupareCurenta = "";

        for (int i = 0; i < alfabet.length(); i++) {
            char c = alfabet.charAt(i);

            boolean esteVocala = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');

            if (esteVocala && !grupareCurenta.isEmpty()) {
                arraySectiuni[indexArray] = grupareCurenta;
                indexArray++;
                grupareCurenta = "";
            }

            grupareCurenta += c;
        }

        if (!grupareCurenta.isEmpty()) {
            arraySectiuni[indexArray] = grupareCurenta;
        }

        for (int i = 0; i < arraySectiuni.length; i++) {
            System.out.println(arraySectiuni[i]);
        }

    }
}
