import java.util.Scanner;

public class TaskA {
    public static final int[] ARRAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static class myDate {
        int YY;
        int MM;
        int DD;
        int hh;
        int mm;
        int ss;

        public myDate(String[] arr) {
            YY = Integer.parseInt(arr[0]);
            MM = Integer.parseInt(arr[1]);
            DD = Integer.parseInt(arr[2]);
            hh = Integer.parseInt(arr[3]);
            mm = Integer.parseInt(arr[4]);
            ss = Integer.parseInt(arr[5]);
        }

        private int getYearDif(myDate end) {
            return end.YY - YY;
        }

        private int getDayDiff(myDate end) {
            if (end.MM < MM) end.YY--;
            if (end.MM == MM) return 0;
            int days = ARRAY[MM - 1] - DD;
            for (int i = 0; i < (end.MM + 12 - MM - 1) % 12; i++) {
                days += ARRAY[(MM + i + 12) % 12];
            }
            days += end.DD;
            return days;
        }

        private int getHourDiff(myDate end) {
            if (end.hh < hh) end.DD--;
            return (end.hh + 24 - hh) % 24;
        }

        private int getSecDiff(myDate end) {
            if (end.ss < ss) end.mm--;
            return (end.ss + 60 - ss) % 60;
        }

        private int getMinDiff(myDate end) {
            if (end.mm < mm) end.hh--;
            return (end.mm + 60 - mm) % 60;
        }

        public void getRes(myDate end) {
            long seconds = getSecDiff(end) + getMinDiff(end) * 60 + getHourDiff(end) * 3600;
            long days = getDayDiff(end) + getYearDif(end) * 365;
            System.out.print(days + " " + seconds);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        myDate startDate = new myDate(sc.nextLine().split(" "));
        myDate endDate = new myDate(sc.nextLine().split(" "));

        startDate.getRes(endDate);
    }
}
