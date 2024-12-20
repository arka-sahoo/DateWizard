import java.util.*;

public class DateWizardOld {
    static String date;
    static int day = 0, month = 0, year = 0, dayOfYear = 0, weekOfYear = 0, l = 0;
    static boolean validMonth = false;
    static boolean validDay = false;
    static boolean validYear = false;
    static boolean validMonthDay = false;
    static boolean leapYear = false;
    static boolean invalidDate = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (invalidDate) {
            System.out.println("Enter a date in mm/dd/yyyy format:");
            date = sc.nextLine();

            validateMonth();
            if (validMonth)
                month = Integer.parseInt(date.substring(0, 2));
            else
                continue;

            validateDay();
            if (validDay)
                day = Integer.parseInt(date.substring(3, 5));
            else
                continue;

            validateYear();
            if (validYear) {
                year = Integer.parseInt(date.substring(6, 10));
                if (year == 0) {
                    validYear = false;
                    continue;
                }
            } else
                continue;

            isLeapYear();

            validateMonthDay();
            if (validMonthDay) {
                invalidDate = false;
            } else
                continue;

        }  // end of while loop

        // all good so far

        // calculate day of the year
        findDayOfYear();

        // calculate week of the year
        findWeekOfYear();


        // calculate day of the week


        System.out.println("Day of the year: " + dayOfYear);
        System.out.println("Week of the year: " + weekOfYear);

        String formattedDate = date.substring(6, 10) + date.substring(0, 2) + date.substring(3, 5);
        System.out.println(formattedDate);

        formattedDate = date.substring(6, 10) + "-" + date.substring(0, 2) + "-" + date.substring(3, 5);
        System.out.println(formattedDate);

        formattedDate = date.substring(6, 10) + "/" + date.substring(0, 2) + "/" + date.substring(3, 5);
        System.out.println(formattedDate);

        formattedDate = date.substring(6, 10) + "." + date.substring(0, 2) + "." + date.substring(3, 5);
        System.out.println(formattedDate);

        formattedDate = date.substring(0, 2) + date.substring(3, 5) + date.substring(6, 10);
        System.out.println(formattedDate);

        formattedDate = date.substring(0, 2) + "-" + date.substring(3, 5) + "-" + date.substring(6, 10);
        System.out.println(formattedDate);

        formattedDate = date.substring(0, 2) + "/" + date.substring(3, 5) + "/" + date.substring(6, 10);
        System.out.println(formattedDate);

        formattedDate = date.substring(0, 2) + "." + date.substring(3, 5) + "." + date.substring(6, 10);
        System.out.println(formattedDate);

        formattedDate = date.substring(3, 5) + date.substring(0, 2) + date.substring(6, 10);
        System.out.println(formattedDate);

        formattedDate = date.substring(3, 5) + "-" + date.substring(0, 2) + "-" + date.substring(6, 10);
        System.out.println(formattedDate);

        formattedDate = date.substring(3, 5) + "/" + date.substring(0, 2) + "/" + date.substring(6, 10);
        System.out.println(formattedDate);

        formattedDate = date.substring(3, 5) + "." + date.substring(0, 2) + "." + date.substring(6, 10);
        System.out.println(formattedDate);

    }   //end of main method

    public static void validateMonth() {

        if (date.substring(0, 2).equals("01") ||
                date.substring(0, 2).equals("02") ||
                date.substring(0, 2).equals("03") ||
                date.substring(0, 2).equals("04") ||
                date.substring(0, 2).equals("05") ||
                date.substring(0, 2).equals("06") ||
                date.substring(0, 2).equals("07") ||
                date.substring(0, 2).equals("08") ||
                date.substring(0, 2).equals("09") ||
                date.substring(0, 2).equals("10") ||
                date.substring(0, 2).equals("11") ||
                date.substring(0, 2).equals("12"))
            validMonth = true;
        else
            validMonth = false;
    }

    public static void validateDay() {

        if (date.substring(3, 5).equals("01") ||
                date.substring(3, 5).equals("02") ||
                date.substring(3, 5).equals("03") ||
                date.substring(3, 5).equals("04") ||
                date.substring(3, 5).equals("05") ||
                date.substring(3, 5).equals("06") ||
                date.substring(3, 5).equals("07") ||
                date.substring(3, 5).equals("08") ||
                date.substring(3, 5).equals("09") ||
                date.substring(3, 5).equals("10") ||
                date.substring(3, 5).equals("11") ||
                date.substring(3, 5).equals("12") ||
                date.substring(3, 5).equals("13") ||
                date.substring(3, 5).equals("14") ||
                date.substring(3, 5).equals("15") ||
                date.substring(3, 5).equals("16") ||
                date.substring(3, 5).equals("17") ||
                date.substring(3, 5).equals("18") ||
                date.substring(3, 5).equals("19") ||
                date.substring(3, 5).equals("20") ||
                date.substring(3, 5).equals("21") ||
                date.substring(3, 5).equals("22") ||
                date.substring(3, 5).equals("23") ||
                date.substring(3, 5).equals("24") ||
                date.substring(3, 5).equals("25") ||
                date.substring(3, 5).equals("26") ||
                date.substring(3, 5).equals("27") ||
                date.substring(3, 5).equals("28") ||
                date.substring(3, 5).equals("29") ||
                date.substring(3, 5).equals("30") ||
                date.substring(3, 5).equals("31"))
            validDay = true;
        else
            validDay = false;
    }

    public static void validateYear() {

        if ((date.substring(6, 7).equals("0") ||
                date.substring(6, 7).equals("1") ||
                date.substring(6, 7).equals("2") ||
                date.substring(6, 7).equals("3") ||
                date.substring(6, 7).equals("4") ||
                date.substring(6, 7).equals("5") ||
                date.substring(6, 7).equals("6") ||
                date.substring(6, 7).equals("7") ||
                date.substring(6, 7).equals("8") ||
                date.substring(6, 7).equals("9")) &&

                (date.substring(7, 8).equals("0") ||
                        date.substring(7, 8).equals("1") ||
                        date.substring(7, 8).equals("2") ||
                        date.substring(7, 8).equals("3") ||
                        date.substring(7, 8).equals("4") ||
                        date.substring(7, 8).equals("5") ||
                        date.substring(7, 8).equals("6") ||
                        date.substring(7, 8).equals("7") ||
                        date.substring(7, 8).equals("8") ||
                        date.substring(7, 8).equals("9")) &&

                (date.substring(8, 9).equals("0") ||
                        date.substring(8, 9).equals("1") ||
                        date.substring(8, 9).equals("2") ||
                        date.substring(8, 9).equals("3") ||
                        date.substring(8, 9).equals("4") ||
                        date.substring(8, 9).equals("5") ||
                        date.substring(8, 9).equals("6") ||
                        date.substring(8, 9).equals("7") ||
                        date.substring(8, 9).equals("8") ||
                        date.substring(8, 9).equals("9")) &&

                (date.substring(9, 10).equals("0") ||
                        date.substring(9, 10).equals("1") ||
                        date.substring(9, 10).equals("2") ||
                        date.substring(9, 10).equals("3") ||
                        date.substring(9, 10).equals("4") ||
                        date.substring(9, 10).equals("5") ||
                        date.substring(9, 10).equals("6") ||
                        date.substring(9, 10).equals("7") ||
                        date.substring(9, 10).equals("8") ||
                        date.substring(9, 10).equals("9")))
            validYear = true;
        else
            validYear = false;
    }

    public static void isLeapYear() {
        if (year % 100 == 0)
            l = year % 400;
        else
            l = year % 4;
        if (l == 0)
            leapYear = true;
        else
            leapYear = false;
    }

    public static void validateMonthDay() {
        switch (month) {
            case 1:
                if (day >= 1 && day <= 31)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 2:
                if (leapYear) {
                    if (day >= 1 && day <= 29)
                        validMonthDay = true;
                    else
                        validMonthDay = false;
                } else if (day >= 1 && day <= 28)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 3:
                if (day >= 1 && day <= 31)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 4:
                if (day >= 1 && day <= 30)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 5:
                if (day >= 1 && day <= 31)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 6:
                if (day >= 1 && day <= 30)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 7:
                if (day >= 1 && day <= 31)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 8:
                if (day >= 1 && day <= 31)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 9:
                if (day >= 1 && day <= 30)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 10:
                if (day >= 1 && day <= 31)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 11:
                if (day >= 1 && day <= 30)
                    validMonthDay = true;
                else
                    validMonthDay = false;
            case 12:
                if (day >= 1 && day <= 31)
                    validMonthDay = true;
                else
                    validMonthDay = false;
        }
    }

    public static void findDayOfYear() {
        switch (month) {
            case 1:
                dayOfYear = day;
                break;
            case 2:
                dayOfYear = 31 + day;
                break;
            case 3:
                dayOfYear = 31 + (leapYear ? 29 : 28) + day;
                break;
            case 4:
                dayOfYear = 62 + (leapYear ? 29 : 28) + day;
                break;
            case 5:
                dayOfYear = 92 + (leapYear ? 29 : 28) + day;
                break;
            case 6:
                dayOfYear = 123 + (leapYear ? 29 : 28) + day;
                break;
            case 7:
                dayOfYear = 153 + (leapYear ? 29 : 28) + day;
                break;
            case 8:
                dayOfYear = 184 + (leapYear ? 29 : 28) + day;
                break;
            case 9:
                dayOfYear = 215 + (leapYear ? 29 : 28) + day;
                break;
            case 10:
                dayOfYear = 245 + (leapYear ? 29 : 28) + day;
                break;
            case 11:
                dayOfYear = 276 + (leapYear ? 29 : 28) + day;
                break;
            case 12:
                dayOfYear = 306 + (leapYear ? 29 : 28) + day;
        }

    }

    public static void findWeekOfYear() {
        int r = dayOfYear % 7;
        int q = dayOfYear / 7;
        if (r == 0)
            weekOfYear = q;
        else
            weekOfYear = q + 1;
    }
}

