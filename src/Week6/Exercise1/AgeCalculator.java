package Week6.Exercise1;

import java.time.LocalDate;

public class AgeCalculator {
    private LocalDate cur = LocalDate.now();
    public int calAge(Person P) {
        int year = cur.getYear();
        int month = cur.getMonthValue();
        int day = cur.getDayOfMonth();
        int a = P.birthYear - cur.getYear() - 1;
        if(month < P.birthMonth) {
            a++;
        } else if(month == P.birthMonth && day <= P.birthDay) {
            a++;
        }
        return a;
    }

    public int isOlder(Person p1, Person p2) {
        if(calAge(p1) > calAge(p2)) return 1;
        else if(calAge(p1) == calAge(p2)) return 0;
        else return -1;
    }
}
