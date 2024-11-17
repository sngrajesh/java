package Day8.home.first;

import java.util.Comparator;

public class Date implements Comparable{
    private int year;
    private int month;

    public Date(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return year + "/" + month;
    }

    @Override
    public int compareTo(Object o) {
        Date date = (Date) o;
        if (this.year == date.getYear()) {
            return this.month - date.getMonth();
        } else {
            return this.year - date.getYear();
        }
    }
}


class DateComparator implements Comparator<Date> {
    @Override
    public int compare(Date o1, Date o2) {
        if (o1.getYear() == o2.getYear()) {
            return o1.getMonth() - o2.getMonth();
        } else {
            return o1.getYear() - o2.getYear();
        }
    }
}