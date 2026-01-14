package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Scanner;

class ObterProximoDiaUtil implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int addDays;
        switch (dayOfWeek) {
            case THURSDAY:
                addDays = 4;
                break;
            case FRIDAY:
                addDays = 3;
                break;
            case SATURDAY:
                addDays = 2;
                break;
            default:
                addDays = 1;
        }
        return temporal.plus(addDays, ChronoUnit.DAYS);
    }
}

public class TemporalAdjusterTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(new ObterProximoDiaUtil());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().withDayOfMonth(12).with(new ObterProximoDiaUtil());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().withDayOfMonth(16).with(new ObterProximoDiaUtil());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().withDayOfMonth(17).with(new ObterProximoDiaUtil());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().withDayOfMonth(18).with(new ObterProximoDiaUtil());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Digite sua data (dd/MM/yyyy): ");
//        String data = sc.next();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate now = LocalDate.parse(data, formatter);
//
//        System.out.println("Data Informada: ");
//        System.out.println(now);
//        System.out.println(now.getDayOfWeek());
//
//        LocalDate diaUtil = proximoDiaUtil(now);
//        System.out.println("======================");
//        System.out.println("Próximo dia Útil: ");
//        System.out.println(diaUtil);
//        System.out.println(diaUtil.getDayOfWeek());
//
//        public static LocalDate proximoDiaUtil(LocalDate now){
//            LocalDate proximoDia = now;
//            if (now.getDayOfWeek() == DayOfWeek.THURSDAY) {
//                now = now.plusDays(4);
//                proximoDia = now;
//            } else if (now.getDayOfWeek() == DayOfWeek.FRIDAY) {
//                now = now.plusDays(3);
//            } else if (now.getDayOfWeek() == DayOfWeek.SATURDAY) {
//                now = now.plusDays(2);
//            } else {
//                now = now.plusDays(1);
//            }
//        }
    }
}