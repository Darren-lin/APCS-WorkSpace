/**
 * prints the name, age, gender, id number, gpa, year, and major of a college
 * student Prints out the college students info
 *
 * @author Darren Lin
 * @version Oct 21, 2019
 * @author Period: 4
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: none
 */
public class CollegeStudent extends Student
{
    private String myMajor;

    private int myYear;


    /**
     * @param myName name of student
     * @param myAge age of student
     * @param myGender gender of student
     * @param myIdNum idnum of student
     * @param myGPA gpa of student
     * @param myYear year of student
     * @param myMajor major of student
     */
    CollegeStudent(
        String myName,
        int myAge,
        String myGender,
        String myIdNum,
        double myGPA,
        int myYear,
        String myMajor )
    {
        super( myName, myAge, myGender, myIdNum, myGPA );
        this.myYear = myYear;
        this.myMajor = myMajor;
    }


    /**
     * returns the myYear
     * 
     * @return myYear the year of the student
     */
    public int getYear()
    {
        return myYear;

    }


    /**
     * gets the year and sets it to myYear
     * 
     * @param year
     *            the year of the student
     */
    public void setYear( int year )
    {
        myYear = year;
    }


    /**
     * returns myMajor
     * 
     * @return myMajor which is the major of the student
     */
    public String getMajor()
    {
        return myMajor;
    }


    /**
     * sets the major of the student to myMajor
     * 
     * @param major
     *            the major of the student
     */
    public void setMajor( String major )
    {
        myMajor = major;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: " + myMajor;
    }
}
