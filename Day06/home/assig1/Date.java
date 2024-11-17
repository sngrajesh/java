package Day6.home.assig1;

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
        if (this.year == date.year) {
            return this.month - date.month;
        } else {
            return this.year - date.year;
        }
    }
}
