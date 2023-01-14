package net.teaql.common;


import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class DateRange {
    private Date startDate;
    private Date endDate;
    private int offsetHours=0;

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

    public int getOffsetHours() {
        return offsetHours;
    }

    public void setOffsetHours(int offsetHours) {
        this.offsetHours = offsetHours;
    }
    public DateRange offsetHours(int offsetHours) {
        this.offsetHours = offsetHours;
        return this;
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
        dateRange.setOffsetHours(offsetHours);
        return dateRange;
    }
    public  DateRange yesterday(){

        //Date date=DateUtil.endOfDay(DateUtil.yesterday());
        this.setStartDate(DateUtil.beginOfDay(DateUtil.yesterday()));
        this.setEndDate(DateUtil.endOfDay(DateUtil.yesterday()));
        return this;
    }
    public  DateRange lastMonth(){
        Date lastMonthDay=DateUtil.lastMonth();
        this.setStartDate(DateUtil.beginOfMonth (lastMonthDay));
        this.setEndDate(DateUtil.endOfMonth(lastMonthDay));
        return this;
    }
    public  DateRange lastYear(){
        Date lastYearDay=DateUtil.offsetMonth(DateUtil.date(),-12);
        this.setStartDate(DateUtil.beginOfYear (lastYearDay));
        this.setEndDate(DateUtil.endOfYear(lastYearDay));
        return this;
    }


}