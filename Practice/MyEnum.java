package Practice;

public class MyEnum
{
    public enum Week_day
    { Mon(1), Tue(2), Wed(3), Thur(4), Fri(5), Sat(6);

        private int day;

        private Week_day(int d)
        {
            this.day = d;
        }

        public int getDay()
        {
            return this.day;
        }
    }

    public static void main(String[] args)
    {
        Week_day d = Week_day.Mon;
        System.out.println(d);
        System.out.println(d.getDay());
    }
}
