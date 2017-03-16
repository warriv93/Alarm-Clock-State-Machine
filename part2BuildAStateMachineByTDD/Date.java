package com.part2;

/**
 * Created by simon on 10/11/16.
 */
public class Date {
    private int year = 2000;
    private enum months { JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC };
    private months currentMonth = months.JAN;
    private int day = 1;

    /**
     * Return the date unchanged if invalid parameter are given
     * @param year
     * @param month
     * @param day
     * @return
     */
    public String dateSet(int year, int month, int day){
        if ( year >= 2000 && year <= 2100 && month >= 1 && month <= 12 && day >= 1 && day <= 31 ){
            this.year = year;
            this.currentMonth = months.values()[month-1];
            this.day = day;
            return showDate();
        }
        return showDate();
    }

    public String showDate(){
        String returnDate = String.valueOf(year) + "-" + String.valueOf(currentMonth) + "-" + String.valueOf(day);
        return returnDate;
    }


}
