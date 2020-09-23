/**
 * Student.java
 * 
 * Stores the following information about students grade name (first and last)
 * Lynbrook id
 * 
 */
public class Student implements Comparable
{
    private String lynbrookId;

    private String firstName;

    private String lastName;

    private int grade;


    public Student( String id, String fName, String lName, int g )
    {
        lynbrookId = id;
        firstName = fName;
        lastName = lName;
        grade = g;
    }


    public Student()
    {
        this( "", "", "", 0 );
    }


    /**
     * returns 0 if grades =, -1 if priority is higher, 1 if priority is lower
     * @param obj
     * @return
     */
    public int compareTo( Object obj )
    {
        if ( this.grade == ( (Student)obj ).grade )
        {
            return this.lynbrookId.compareTo( ( (Student)obj ).lynbrookId );
        }
        else
        {
            return this.grade - ( (Student)obj ).grade;
        }
    }


    public Object clone()
    {
        return new Student( lynbrookId, firstName, lastName, grade );
    }


    public String toString()
    {
        return lynbrookId + " " + firstName + " " + lastName + " " + grade;
    }
}
