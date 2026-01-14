package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        Date date = new Date(1765496704378L);
        date.setTime(date.getTime() + 3_600_000); //Adicionando 1h há mais
        System.out.println(date);
    }
}