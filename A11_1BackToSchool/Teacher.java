/**
 * prints out the info of the teacher Prints the name, age, gender, subject, and
 * salary of the teacher
 *
 * @author Darren Lin
 * @version Oct 21, 2019
 * @author Period: 4
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: none
 */
public class Teacher extends Person
{
    private String mySubject;

    private double mySalary;


    /**
     * @param myName name of teacher
     * @param myAge age of teacher
     * @param myGender gender of teacher 
     * @param mySubject subject of teacher
     * @param mySalary salary of teacher
     */
    Teacher(
        String myName,
        int myAge,
        String myGender,
        String mySubject,
        double mySalary )
    {
        super( myName, myAge, myGender );
        this.mySalary = mySalary;
        this.mySubject = mySubject;
    }


    /**
     * gets the subject
     * 
     * @return mySubject which is the subject
     */
    public String getSubject()
    {
        return mySubject;
    }


    /**
     * sets the subject
     * 
     * @param subject
     *            which is the subject
     */
    public void setSubject( String subject )
    {
        mySubject = subject;
    }


    /**
     * gets mySalary
     * 
     * @return mySalary which is the salary
     */
    public double getSalary()
    {
        return mySalary;
    }


    /**
     * sets the salary
     * 
     * @param salary
     *            which is the salary
     */
    
    public void setSalary( double salary )
    {
        mySalary = salary;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject + ", salary: "
            + mySalary;
    }

}
