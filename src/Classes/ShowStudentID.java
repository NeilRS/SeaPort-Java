package Classes;

/**
 * Neil Simmons
 * 1001031670
 */

/**
 * Class to contain my personal student information, and date of the program.
 */
public class ShowStudentID {
    private String name;
    private String id;
    private String course;
    private String month;
    private int day;
    private int year;

    public ShowStudentID() {
        this.name = "Neil Simmons";
        this.id = "1001031670";
        this.course = "CSE 1325-002";
        this.month = "March";
        this.day = 24;
        this.year = 2015;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * Print the student class information
     */
    public void print(){
        System.out.printf("Name: %s\n",this.name);
        System.out.printf("ID: %s\n", this.id);
        System.out.printf("%s\n", this.course);
        System.out.printf("%s %d, %d\n", this.month, this.day, this.year);
    }
    
    
}