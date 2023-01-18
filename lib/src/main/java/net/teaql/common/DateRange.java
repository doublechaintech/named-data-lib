package net.teaql.common;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class DateRange {
    private Date startDate;
    private Date endDate;
    private int timezone =0;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public static DateRange newInstance() {
        DateRange dateRange=new DateRange();
        return dateRange;
    }
    public static DateRange with(Date start, Date end) {
        DateRange dateRange=newInstance();
        dateRange.setStartDate(start);
        dateRange.setEndDate(end);
        return dateRange;
    }

    public static DateRange with(Date start, Date end, int offsetHours) {
        DateRange dateRange=newInstance();
        dateRange.setStartDate(start);
        dateRange.setEndDate(end);
        dateRange.setTimezone(offsetHours);
        return dateRange;
    }
    public  DateRange yesterday(){
        return offsetDay(-1);
    }

    public  DateRange today(){
        return offsetDay(0);
    }

    public  DateRange tomorrow(){
        return offsetDay(1);
    }

    public  DateRange lastTwoDays(){
        return lastNDays(2);
    }

    public  DateRange lastThreeDays(){
        return lastNDays(3);
    }

    public  DateRange lastFourDays(){
        return lastNDays(4);
    }

    public  DateRange lastFiveDays(){
        return lastNDays(5);
    }

    public  DateRange lastNDays(int n){
        if (n <=0 ) {
            return null;
        }
        DateTime yesterday = DateUtil.yesterday();
        this.setStartDate(DateUtil.beginOfDay(DateUtil.offsetDay(yesterday, 1-n)));
        this.setEndDate(DateUtil.endOfDay(yesterday));
        return this;
    }

    public  DateRange nextTwoDays(){
        return nextNDays(2);
    }

    public  DateRange nextThreeDays(){
        return nextNDays(3);
    }

    public  DateRange nextFourDays(){
        return nextNDays(4);
    }

    public  DateRange nextFiveDays(){
        return nextNDays(5);
    }

    public  DateRange nextNDays(int n){
        if (n <=0 ) {
            return null;
        }
        DateTime tomorrow = DateUtil.tomorrow();
        this.setStartDate(DateUtil.beginOfDay(tomorrow));
        this.setEndDate(DateUtil.endOfDay(DateUtil.offsetDay(tomorrow, n-1)));
        return this;
    }

    public DateRange offsetDay(int n) {
        DateTime theDay = DateUtil.offsetDay(DateUtil.date(), n);
        this.setStartDate(DateUtil.beginOfDay(theDay));
        this.setEndDate(DateUtil.endOfDay(theDay));
        return this;
    }

    public  DateRange lastHour(){
        return offsetHour(-1);
    }
    public  DateRange thisHour(){
        return offsetHour(0);
    }
    public  DateRange nextHour(){
        return offsetHour(1);
    }

    public  DateRange lastTwoHours(){
        return nextNHours(2);
    }

    public  DateRange lastThreeHours(){
        return nextNHours(3);
    }

    public  DateRange lastFourHours(){
        return nextNHours(4);
    }

    public  DateRange lastFiveHours(){
        return lastNHours(5);
    }

    public  DateRange lastNHours(int n){
        if (n<=0) {
            return null;
        }
        DateTime lastHour = DateUtil.offsetHour(DateUtil.date(), -1);
        this.setStartDate(DateUtil.beginOfHour(DateUtil.offsetHour(lastHour, 1-n)));
        this.setEndDate(DateUtil.endOfHour(lastHour));
        return this;
    }

    public DateRange nextTwoHours() {
        return nextNHours(2);
    }

    public DateRange nextThreeHours() {
        return nextNHours(3);
    }

    public DateRange nextFourHours() {
        return nextNHours(4);
    }

    public DateRange nextFiveHours() {
        return nextNHours(5);
    }

    public DateRange nextNHours(int n) {
        if (n <= 0) {
            return null;
        }
        DateTime nextHour = DateUtil.offsetHour(DateUtil.date(), 1);
        this.setStartDate(DateUtil.beginOfHour(nextHour));
        this.setEndDate(DateUtil.endOfHour(DateUtil.offsetHour(nextHour, n-1)));
        return this;
    }

    public DateRange offsetHour(int n) {
        DateTime theHour = DateUtil.offsetHour(DateUtil.date(), n);
        this.setStartDate(DateUtil.beginOfHour(theHour));
        this.setEndDate(DateUtil.endOfHour(theHour));
        return this;
    }

    public DateRange thisWeek() {
        return offsetWeek(0);
    }

    public DateRange lastWeek() {
        return offsetWeek(-1);

    }

    public DateRange nextWeek() {
        return offsetWeek(1);
    }

    public DateRange lastTwoWeeks() {
        return lastNWeeks(2);

    }

    public DateRange lastThreeWeeks() {
        return lastNWeeks(3);

    }

    public DateRange lastFourWeeks() {
        return lastNWeeks(4);

    }

    public DateRange lastFiveWeeks() {
        return lastNWeeks(5);
    }

    public DateRange lastNWeeks(int n) {
        if (n <= 0) {
            return null;
        }
        DateTime lastWeek = DateUtil.lastWeek();
        this.setStartDate(DateUtil.beginOfWeek(DateUtil.offsetWeek(lastWeek, 1-n)));
        this.setEndDate(DateUtil.endOfWeek(lastWeek));
        return this;
    }

    public DateRange nextTwoWeeks() {
        return nextNWeeks(2);
    }

    public DateRange nextThreeWeeks() {
        return nextNWeeks(3);
    }

    public DateRange nextFourWeeks() {
        return nextNWeeks(4);
    }

    public DateRange nextFiveWeeks() {
        return nextNWeeks(5);
    }
    public DateRange nextNWeeks(int n) {
        if (n <= 0) {
            return null;
        }
        DateTime nextWeek = DateUtil.nextWeek();
        this.setStartDate(DateUtil.beginOfWeek(nextWeek));
        this.setEndDate(DateUtil.endOfWeek(DateUtil.offsetWeek(nextWeek, n-1)));
        return this;
    }

    public DateRange offsetWeek(int n) {
        DateTime theWeek = DateUtil.offsetWeek(DateUtil.date(), n);
        this.setStartDate(DateUtil.beginOfWeek(theWeek));
        this.setEndDate(DateUtil.endOfWeek(theWeek));
        return this;
    }

    public DateRange nextNMonths(int n) {
        if (n <= 0) {
            return null;
        }
        DateTime nextMonth = DateUtil.nextMonth();
        this.setStartDate(DateUtil.beginOfMonth(nextMonth));
        this.setEndDate(DateUtil.endOfMonth(DateUtil.offsetMonth(nextMonth, n-1)));
        return this;
    }

    public DateRange lastNMonths(int n) {
        if (n <= 0) {
            return null;
        }
        DateTime lastMonth = DateUtil.lastMonth();
        this.setStartDate(DateUtil.beginOfMonth(DateUtil.offsetMonth(lastMonth, 1-n)));
        this.setEndDate(DateUtil.endOfMonth(lastMonth));
        return this;
    }

    public DateRange offsetMonth(int n) {
        DateTime theMonth = DateUtil.offsetMonth(DateUtil.date(), n);
        this.setStartDate(DateUtil.beginOfMonth(theMonth));
        this.setEndDate(DateUtil.endOfMonth(theMonth));
        return this;
    }

    public DateRange thisMonth() {
        return offsetMonth(0);
    }

    public DateRange lastMonth() {
        return offsetMonth(-1);
    }

    public DateRange nextMonth() {
        return offsetMonth(1);
    }

    public DateRange lastTwoMonths() {
        return lastNMonths(2);
    }

    public DateRange lastThreeMonths() {
        return lastNMonths(3);
    }

    public DateRange lastFourMonths() {
        return lastNMonths(4);
    }

    public DateRange lastFiveMonths() {
        return lastNMonths(5);
    }

    public DateRange nextTwoMonths() {
        return nextNMonths(2);
    }

    public DateRange nextThreeMonths() {
        return nextNMonths(3);
    }

    public DateRange nextFourMonths() {
        return nextNMonths(4);
    }

    public DateRange nextFiveMonths() {
        return nextNMonths(5);
    }

    public DateRange nextNQuarters(int n) {
        if (n <= 0) {
            return null;
        }
        DateTime nextQuarter = DateUtil.offsetMonth(DateUtil.date(), 3);
        this.setStartDate(DateUtil.beginOfQuarter(nextQuarter));
        this.setEndDate(DateUtil.endOfQuarter(DateUtil.offsetMonth(nextQuarter, 3*(n-1))));
        return this;
    }

    public DateRange lastNQuarters(int n) {
        if (n <= 0) {
            return null;
        }
        DateTime lastQuarter = DateUtil.offsetMonth(DateUtil.date(), -3);
        this.setStartDate(DateUtil.beginOfQuarter(DateUtil.offsetMonth(lastQuarter, 3*(1-n))));
        this.setEndDate(DateUtil.endOfQuarter(lastQuarter));
        return this;
    }

    public DateRange offsetQuarter(int n) {
        DateTime theQuarter = DateUtil.offsetMonth(DateUtil.date(), 3*n);
        this.setStartDate(DateUtil.beginOfQuarter(theQuarter));
        this.setEndDate(DateUtil.endOfQuarter(theQuarter));
        return this;
    }

    public DateRange thisQuarter() {
        return offsetQuarter(0);
    }

    public DateRange lastQuarter() {
        return offsetQuarter(-1);
    }

    public DateRange nextQuarter() {
        return offsetQuarter(1);
    }

    public DateRange lastTwoQuarters() {
        return lastNQuarters(2);
    }

    public DateRange lastThreeQuarters() {
        return lastNQuarters(3);
    }

    public DateRange lastFourQuarters() {
        return lastNQuarters(4);
    }

    public DateRange lastFiveQuarters() {
        return lastNQuarters(5);
    }

    public DateRange nextTwoQuarters() {
        return nextNQuarters(2);
    }

    public DateRange nextThreeQuarters() {
        return nextNQuarters(3);
    }

    public DateRange nextFourQuarters() {
        return nextNQuarters(4);
    }

    public DateRange nextFiveQuarters() {
        return nextNQuarters(5);
    }

    public DateRange nextNYears(int n) {
        if (n <= 0) {
            return null;
        }
        DateTime nextYear = DateUtil.offsetMonth(DateUtil.date(), 12);
        this.setStartDate(DateUtil.beginOfYear(nextYear));
        this.setEndDate(DateUtil.endOfYear(DateUtil.offsetMonth(nextYear, 12*(n-1))));
        return this;
    }

    public DateRange lastNYears(int n) {
        if (n <= 0) {
            return null;
        }
        DateTime lastYear = DateUtil.offsetMonth(DateUtil.date(), -12);
        this.setStartDate(DateUtil.beginOfYear(DateUtil.offsetMonth(lastYear, 12*(1-n))));
        this.setEndDate(DateUtil.endOfYear(lastYear));
        return this;
    }

    public DateRange offsetYear(int n) {
        DateTime theYear = DateUtil.offsetMonth(DateUtil.date(), 12*n);
        this.setStartDate(DateUtil.beginOfYear(theYear));
        this.setEndDate(DateUtil.endOfYear(theYear));
        return this;
    }

    public DateRange thisYear() {
        return offsetYear(0);
    }

    public DateRange lastYear() {
        return offsetYear(-1);
    }

    public DateRange nextYear() {
        return offsetYear(1);
    }

    public DateRange nextTwoYears() {
        return nextNYears(2);
    }

    public DateRange nextThreeYears() {
        return nextNYears(3);
    }

    public DateRange nextFourYears() {
        return nextNYears(4);
    }

    public DateRange nextFiveYears() {
        return nextNYears(5);
    }

    public DateRange lastTwoYears() {
        return lastNYears(2);
    }

    public DateRange lastThreeYears() {
        return lastNYears(3);
    }

    public DateRange lastFourYears() {
        return lastNYears(4);
    }

    public DateRange lastFiveYears() {
        return lastNYears(5);
    }

    public static void main(String[] args) {
        System.out.println(new DateRange().nextYear().getStartDate());
        System.out.println(new DateRange().nextYear().getEndDate());
    }

}