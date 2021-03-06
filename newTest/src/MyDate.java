/*
 * This code was generated by ojc.
 */
import GeneticAlgorithm.InstrumentCode.*;


public class MyDate
{

    private int month;

    private int year;

    private int day;

    public MyDate()
    {
        trace.add( new java.lang.Integer( 1 ) );
    }

    public MyDate( int month, int day, int year )
    {
        trace.add( new java.lang.Integer( 2 ) );
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setMonth( int month )
    {
        trace.add( new java.lang.Integer( 3 ) );
        this.month = month;
    }

    public void setDay( int day )
    {
        trace.add( new java.lang.Integer( 4 ) );
        this.day = day;
    }

    public void setYear( int year )
    {
        trace.add( new java.lang.Integer( 5 ) );
        this.year = year;
    }

    public void setAsLastDayOfFebruaryInLeapYear()
    {
        trace.add( new java.lang.Integer( 6 ) );
        this.month = 2;
        this.year = 2000;
        this.day = 29;
    }

    public void setAsLastDayOfFebruaryInNonLeapYear()
    {
        trace.add( new java.lang.Integer( 7 ) );
        this.month = 2;
        this.year = 2001;
        this.day = 28;
    }

    public void setAsLastDayOfYear()
    {
        trace.add( new java.lang.Integer( 8 ) );
        this.month = 12;
        this.day = 31;
    }

    public int getDay()
    {
        trace.add( new java.lang.Integer( 9 ) );
        return this.day;
    }

    public int getMonth()
    {
        trace.add( new java.lang.Integer( 10 ) );
        return this.month;
    }

    public int getYear()
    {
        trace.add( new java.lang.Integer( 11 ) );
        return this.year;
    }

    public boolean isLeapYear()
    {
        trace.add( new java.lang.Integer( 12 ) );
        return this.year % 400 == 0 || this.year % 4 == 0 && this.year % 100 != 0;
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
