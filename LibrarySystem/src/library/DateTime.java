/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author adamt
 */
public class DateTime {

    private int minutes;
    private int hours;
    private int day;
    private int month;
    private int year;

    
    public DateTime(int day, int month, int year) {
        if ((year > -1500) && (year < 2099) && (month > 0) && (month < 13) && (day > 0) && (day < 32)) {//if statement to limit the days, months, years as you can't have 99/99/9999 as an example of a date.

            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Not correct date entered");

        }

    }
    
    public DateTime(int hours, int minutes) {
        if ((hours >= 0) && (hours < 24) && (minutes >= 0) && (minutes < 60)) {//if statement to create a 24 hour time.

            this.hours = hours;
            this.minutes = minutes;
            
        } else {
            System.out.println("Not correct time entered");

        }

    }
    
    public int getMinutes() {

        return minutes;
    } 
    
    public int getHour() {

        return hours;
    }    

    public int getDay() {

        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getDate() {

        String dateStr = String.format("%02d/%02d/%04d", day, month, year);//converts the integers to a string with the format 2 digits for the days, 2 digits for the months and 4 digits for the years.
        return dateStr;
    }
    
    public void setDay(int day) {
        if ((day > 0) && (day < 32)) {
            this.day = day;
        } else {
            System.out.println("Day entered isn't within the correct range");
        }
    }

    public void setMonth(int month) {

        if ((month > 0) && (month < 13)) {
            this.month = month;
        } else {
            System.out.println("Month enterd isn't within the correct range");
        }
    }

    public void setYear(int year) {
        if ((year > -1500) && (year < 2099)) {
            this.year = year;
        } else {
            System.out.println("Year entered isn't within the correct range");
        }
    }

    
    public void setTime(int hours, int minutes) {
        if ((hours >= 0) && (hours < 24) && (minutes >= 0) && (minutes < 60)) {

            this.hours = hours;
            this.minutes = minutes;
            
        } else {
            System.out.println("Time entered isn't correct time");

        }
    }
    
    
    
    public String toString() {
        String dateStr = String.format("%02d/%02d/%04d", day, month, year);
        String timeStr = String.format("%02d:%02d", hours, minutes);
        return dateStr + timeStr;

    }
    
    
    
}
