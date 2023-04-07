import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class phonebill {

    static double money;
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开始年：");
        int bYear = sc.nextInt();
        System.out.println("请输入开始月：");
        int bMonth = sc.nextInt();
        System.out.println("请输入开始日：");
        int bDay = sc.nextInt();
        //后续判断需要用到“小时”，此处单独输入，下同
        System.out.println("请输入开始时：");
        int bHour = sc.nextInt();
        System.out.println("请输入开始时分秒：");
        String bTime = sc.next();
        System.out.println("请输入截止日：");
        int eDay = sc.nextInt();
        System.out.println("请输入截止时：");
        int eHour = sc.nextInt();
        System.out.println("请输入截止时分秒：");
        String eTime = sc.next();

        //计算开始时间与截止时间的差值
        SimpleDateFormat dfs = new SimpleDateFormat("HH:mm:ss");
        Date begin = dfs.parse(bTime);
        Date end = dfs.parse(eTime);
        double between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
        double min = between / 60;
        //不足一分钟的按一分钟计算
        if (between % 60 > 0) {
            min = min + 1;
        }

        //System.out.print(min);

        //判断是否转换
        int week;
        week = Judge.Week(bYear, bMonth, bDay);
        if (week == 7) {
            if (bHour <= 2 && eHour >= 3) {
                min = Judge.Trans1(bMonth, bDay, min);
            }
            if (bHour <= 3 && eHour >= 2) {
                min = Judge.Trans2(bMonth, bDay, min);
            }
        }

        //System.out.println("时间" + min);

        if (between < 0 || between > 10800) {
            System.out.println("输入错误");
        } else {
            System.out.println("电话费用为" + Money(min) + "美元");
        }

    }

    public static double Money(double min) {
        //计费
        if (min < 1 && min >= 0) {
            money = 0.05;
        } else if (min <= 20) {
            money = 0.05 * min;
        } else {
            money = 0.1 * min - 1;
        }
        return money;
    }
}


class Judge {
//    public static void main(String[] args) {
//        System.out.println(Week(2023,3,26));
//    }

    //判断某年某月某日为星期几
    public static int Week(int year, int month, int day) {
        // 使用Calendar类计算星期几
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);  // 注意，Calendar类的月份从0开始
        int weekday = cal.get(Calendar.DAY_OF_WEEK);
        int[] weekdays={7,1,2,3,4,5,6};
        return weekdays[weekday-1];
    }

    //春夏转换
    public static double Trans1(int month, int day, double min) {
        if (month == 3) {
            min = min - 60;
        }
        return min;
    }

    //夏秋转换
    public static double Trans2(int month, int day, double min) {
        if (month == 11) {
            if (day >= 1 && day <= 7) {
                min = min + 60;
            }
        }
        return min;
    }
}






