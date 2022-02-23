/*
 * This code was generated by ojc.
 */
import GeneticAlgorithm.InstrumentCode.*;


public class NextDate
{

    private int month;

    private int day;

    private int year;

    public NextDate( int m, int d, int y )
    {
        trace.add( new java.lang.Integer( 1 ) );
        this.month = m;
        this.day = d;
        this.year = y;
    }

    public java.lang.String nextDate()
    {
        trace.add( new java.lang.Integer( 2 ) );
        if (day < 1 || month < 1 || month > 12 || day > 31 || year < 1) {
            trace.add( new java.lang.Integer( 3 ) );
            return "invalid Input Date";
        } else {
            trace.add( new java.lang.Integer( 4 ) );
        }
        int tomorrowDay = day;
        int tomorrowMonth = month;
        int tomorrowYear = year;
        if (isThirtyOneDayMonth( month )) {
            trace.add( new java.lang.Integer( 5 ) );
            if (day < 31) {
                trace.add( new java.lang.Integer( 6 ) );
                tomorrowDay = day + 1;
            } else {
                trace.add( new java.lang.Integer( 7 ) );
                tomorrowDay = 1;
                tomorrowMonth = month + 1;
            }
        } else {
            trace.add( new java.lang.Integer( 8 ) );
            if (isThirtyDayMonth( month )) {
                trace.add( new java.lang.Integer( 9 ) );
                if (day < 30) {
                    trace.add( new java.lang.Integer( 10 ) );
                    tomorrowDay = day + 1;
                } else {
                    trace.add( new java.lang.Integer( 11 ) );
                    if (day == 30) {
                        trace.add( new java.lang.Integer( 12 ) );
                        tomorrowDay = 1;
                        tomorrowMonth = month + 1;
                    } else {
                        trace.add( new java.lang.Integer( 13 ) );
                        return "Invalid Input Date";
                    }
                }
            } else {
                trace.add( new java.lang.Integer( 14 ) );
                if (isDecember( month )) {
                    trace.add( new java.lang.Integer( 15 ) );
                    if (day <= 31) {
                        trace.add( new java.lang.Integer( 16 ) );
                        tomorrowDay = day + 1;
                    } else {
                        trace.add( new java.lang.Integer( 17 ) );
                        tomorrowDay = 1;
                        tomorrowMonth = 1;
                        tomorrowYear = year + 1;
                    }
                } else {
                    trace.add( new java.lang.Integer( 18 ) );
                    if (isFebruary( month )) {
                        trace.add( new java.lang.Integer( 19 ) );
                        if (day < 28) {
                            trace.add( new java.lang.Integer( 20 ) );
                            tomorrowDay = day + 1;
                        } else {
                            trace.add( new java.lang.Integer( 21 ) );
                            if (day == 28) {
                                trace.add( new java.lang.Integer( 22 ) );
                                if (isLeapYear( year )) {
                                    trace.add( new java.lang.Integer( 23 ) );
                                    tomorrowDay = 29;
                                } else {
                                    trace.add( new java.lang.Integer( 24 ) );
                                    tomorrowDay = 1;
                                    tomorrowMonth = 3;
                                }
                            } else {
                                trace.add( new java.lang.Integer( 25 ) );
                                if (day == 29) {
                                    trace.add( new java.lang.Integer( 26 ) );
                                    if (isLeapYear( year )) {
                                        trace.add( new java.lang.Integer( 27 ) );
                                        tomorrowDay = 1;
                                        tomorrowMonth = 3;
                                    } else {
                                        trace.add( new java.lang.Integer( 28 ) );
                                        return "Invalid Input Date";
                                    }
                                } else {
                                    trace.add( new java.lang.Integer( 29 ) );
                                    if (day > 29) {
                                        trace.add( new java.lang.Integer( 30 ) );
                                        return "Invalid Input Date";
                                    } else {
                                        trace.add( new java.lang.Integer( 31 ) );
                                    }
                                }
                            }
                        }
                    } else {
                        trace.add( new java.lang.Integer( 32 ) );
                    }
                }
            }
        }
        return tomorrowMonth + "/" + tomorrowDay + "/" + tomorrowYear;
    }

    private boolean isThirtyOneDayMonth( int month )
    {
        trace.add( new java.lang.Integer( 33 ) );
        return month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10;
    }

    private boolean isThirtyDayMonth( int month )
    {
        trace.add( new java.lang.Integer( 34 ) );
        return month == 4 || month == 6 || month == 9 || month == 11;
    }

    private boolean isDecember( int month )
    {
        trace.add( new java.lang.Integer( 35 ) );
        return month == 12;
    }

    private boolean isFebruary( int month )
    {
        trace.add( new java.lang.Integer( 36 ) );
        return month == 2;
    }

    private boolean isLeapYear( int year )
    {
        trace.add( new java.lang.Integer( 37 ) );
        if (year % 100 == 0) {
            trace.add( new java.lang.Integer( 38 ) );
            return year % 400 == 0;
        } else {
            trace.add( new java.lang.Integer( 39 ) );
            return year % 4 == 0;
        }
    }

    public void setDay( int d )
    {
        trace.add( new java.lang.Integer( 40 ) );
        this.day = d;
    }

    public void setMonth( int m )
    {
        trace.add( new java.lang.Integer( 41 ) );
        this.month = m;
    }

    public void setYear( int y )
    {
        trace.add( new java.lang.Integer( 42 ) );
        this.year = y;
    }

    public void setYearAsLeapYear()
    {
        trace.add( new java.lang.Integer( 43 ) );
        this.year = 2000;
    }

    public void setMonthAsFebruary()
    {
        trace.add( new java.lang.Integer( 44 ) );
        this.month = 2;
    }

    
    static java.util.Set trace = new java.util.HashSet();

    
    public static void newTrace()
    {
        trace = new java.util.HashSet();
    }

    
    public static java.util.Set getTrace()
    {
        return trace;
    }

}
