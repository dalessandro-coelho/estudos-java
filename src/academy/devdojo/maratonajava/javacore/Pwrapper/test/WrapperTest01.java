package academy.devdojo.maratonajava.javacore.Pwrapper.test;

public class WrapperTest01 {
    public static void main(String[] args) {
        byte byteP = 1;
        short shortP = 1;
        int intP = 1;
        long longP = 10L;
        float floatP = 10F;
        double doubleP = 10D;
        char charP = 'W';
        boolean booleanP = false;

        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1; // autoboxing
        Long longW = 10L;
        Float floatW = 10F;
        Double doubleW = 10D;
        Character charW = 'W';
        Boolean booleanW = false;

        int i = intW; // unboxing
        Integer  intW2 = Integer.parseInt("1");
        boolean verdadeiro = Boolean.parseBoolean("truE");
        System.out.println(verdadeiro);

        System.out.println(Character.isDigit('A')); // Verifica se o caractere é um dígito (0-9).
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('!')); // Verifica se o caractere é uma letra ou dígito.
        System.out.println(Character.isUpperCase('A')); // Verifica se o caractere está em maiúsculas.
        System.out.println(Character.isLowerCase('a')); // Verifica se o caractere está em minúsculas.
        System.out.println(Character.toUpperCase('a')); // Converte o caractere para maiúsculas.
        System.out.println(Character.toLowerCase('A')); // Converte o caractere para minúsculas.
    }
}
