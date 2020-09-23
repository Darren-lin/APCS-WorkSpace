import java.util.*;


/**
 * Java Methods Chapter 10 Exercises 2, 6 - 11, 14 - 15, 20 & 22
 * 
 * @author Darren Lin
 * @version 10/8/19
 * 
 * @author Period - 4
 * @author Assignment - Ch10Exercises
 * 
 * @author Sources - none
 */
public class JMCh10Exercises
{
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public JMCh10Exercises( String str )
    {
        scan = new Scanner( str );
    }


    // 10-2(a)
    /**
     * returns true if the string is not empty and ends with *
     * @param s is the string
     * @return true or false
     */
    public boolean endsWithStar( String s )
    {
        if ( s.lastIndexOf( '*' ) == s.length() - 1 && s.length() > 2 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    // 10-2(b)
    /**
     * returns true if the string ends with **
     * @param s is the string
     * @return true or false
     */
    public boolean endsWith2Stars( String s )
    {
        if ( s.lastIndexOf( '*' ) == s.length() - 1
            && s.indexOf( '*', s.length() - 3 ) == s.length() - 2 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    // 10-6
    /**
     * moves the first character to the end
     * @param s is the string
     * @return s new string
     */
    public String scroll( String s )
    {
        String s1 = s.substring( 0, 1 );
        String s2 = s.substring( 1, s.length() );
        s = s2 + s1;
        return s;
    }


    // 10-7
    /**
     * moves the first name to the front
     * @param name is last, first
     * @return s1 + s2 the new name
     */
    public String convertName( String name )
    {
        int indexOfComma = name.indexOf( ',' );
        String s1 = name.substring( indexOfComma + 2, name.length());
        String s2 = name.substring( 0, indexOfComma );
        return s1 + " " + s2;
    }


    // 10-8
    /**
     * converst 0 to 1 and 1 to 0
     * @param str the orginal string
     * @return s3 the new string
     */
    public String negate( String str )
    {
        String s1 = str.replace( '0', '2' );
        String s2 = s1.replace( '1', '0' );
        String s3 = s2.replace( '2', '1' );

        return s3;
    }


    // 10-9
    /**
     * determines if the string is made up of the same character
     * @param s the original string
     * @return isEqual which is true or false
     */
    public boolean isConstant( String s )
    {
        String s1 = s.substring( 0, 1 );
        String s2 = s.substring( 1, s.length() );
        String s3 = s2 + s1;
        boolean isEqual = s.equals( s3 );
        return isEqual;
    }


    // 10-10
    /**
     * removes the comments
     * @param str the original string
     * @return str the new string
     */
    public String removeComment( String str )
    {
        int firstMark = str.indexOf( '/' );
        int secondMark = str.lastIndexOf( '/' );
        if ( str.indexOf( '*' ) == firstMark + 1
            && str.lastIndexOf( '*' ) == secondMark - 1 )
        {
            String s1 = str.substring( 0, firstMark );
            String s2 = str.substring( secondMark + 1, str.length() );
            str = s1 + s2;
            return str;
        }
        else
        {
            return str;
        }
    }


    // 10-11
    /**
     * removes the instance of s2 from s
     * @param s the original string 
     * @param s2 what to remove
     * @return s4 or s if the string s2 is found
     */
    public String cutOut( String s, String s2 )
    {
int n = s.indexOf(s2);
        
        if ( n >= 0 )
        {
            s = s.substring(0, n) + s.substring(n + s2.length());
        }

        return s;
    }


    // 10-14
    /**
     * removes html tags from the string
     * @param str the original string
     * @return str the new string
     */
    public String removeHtmlTags( String str )
    {
        int beg = str.indexOf( '<' );
        int end = str.indexOf( '>' );
        int length = str.length();
        for ( int i = 0; i < length - 1; i++ )
        {
            if ( str.charAt( i ) == '<' )
            {
                if ( str.charAt( i + 2 ) == '>' )
                {
                    beg = i;
                }
                else if ( str.charAt( i + 1 ) == '/'
                    && str.charAt( i + 3 ) == '>' )
                {
                    end = i;
                }
            }
        }
        if ( beg == 0 || end == 0 )
        {
            return str;
        }
        else
        {
            return str.substring( 0, beg ) + str.substring( beg + 3, end )
                + str.substring( end + 4 );
        }
    }


    // 10-15
    /**
     * tests if the string is all digits
     * @param s is the string
     * @return true or false 
     */
    public boolean onlyDigits( String s )
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (!Character.isDigit(s.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }


    // 10-20
    /**
     * tests if isbn is valid
     * @param isbn is the original string
     * @return result true or false if the isbn is valid
     */
    public static boolean isValidISBN( String isbn )
    {
        int num = 10;
        int result = 0;
        
        for (int i = 0; i < isbn.length(); i++)
        {
            int num2;
            if (isbn.charAt( i ) == 'X')
            {
                num2 = 10;
            }
            else
            {
                num2 = Character.digit( isbn.charAt( i ), 10 );
            }
            result += num2 * num;
            num--;
        }
        return result % 11 == 0;
    }


    // 10-22
    /**
     * returns the abc all in random order
     * @param s the original string 
     * @return x the new string
     */
    public String shuffle( String s )
    {
        StringBuffer x = new StringBuffer( s );
        int n = x.length();
        while ( n > 1 )
        {
            int i = (int)( Math.random() * n );
            char ch = x.charAt( n - 1 );
            x.setCharAt( n - 1, x.charAt( i ) );
            x.setCharAt( i, ch );
            n--;
        }
        return x.toString();
    }


    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) 10-2(a) endsWithStar( String s )" );
            System.out.println( "   (2) 10-2(b) endsWith2Stars( String s )" );
            System.out.println( "   (3) 10-6 scroll( String s )" );
            System.out.println( "   (4) 10-7 convertName( String name )" );
            System.out.println( "   (5) 10-8 negate( String str )" );
            System.out.println( "   (6) 10-9 isConstant( String s )" );
            System.out.println( "   (7) 10-10 removeComment( String str )" );
            System.out.println( "   (8) 10-11 cutOut( String s, String s2 )" );
            System.out.println( "   (9) 10-14 removeHtmlTags( String str )" );
            System.out.println( "   (A) 10-15 onlyDigits( String s )" );
            System.out.println( "   (B) 10-20 isValidISBN( String isbn )" );
            System.out.println( "   (C) 10-22 shuffle( String s )" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println( "endsWithStar(" + end1Star + ") = "
                            + exercise.endsWithStar( end1Star ) );
                        String ends0Star = "**endsWith**Star*No";
                        System.out.println( "endsWithStar(" + ends0Star
                            + ") = " + exercise.endsWithStar( ends0Star ) );
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out.println( "endsWith2Stars(" + end2Str
                            + ") = " + exercise.endsWith2Stars( end2Str ) );
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println(
                            "endsWith2Stars(" + endsWith1Star + ") = "
                                + exercise.endsWith2Stars( endsWith1Star ) );
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out
                            .println( "scroll(\"" + scrollStr + "\") --> "
                                + "\"" + exercise.scroll( scrollStr ) + "\"" );
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println(
                            "convertName(\"" + convStr + "\") --> " + "\""
                                + exercise.convertName( convStr ) + "\"" );
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println( "negate(\"" + negStr + "\") --> "
                            + "\"" + exercise.negate( negStr ) + "\"" );
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println( "isConstant(\"" + constStr1
                            + "\") = " + exercise.isConstant( constStr1 ) );
                        System.out.println( "isConstant(\"" + constStr2
                            + "\") = " + exercise.isConstant( constStr2 ) );
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println(
                            "removeComment(\"" + comment + "\") --> " + "\""
                                + exercise.removeComment( comment ) + "\"" );
                        System.out.println( "removeComment(\"" + notComment
                            + "\") --> " + "\""
                            + exercise.removeComment( notComment ) + "\"" );
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println( "cutOut(\"" + cutstr + "\", \""
                            + cutOutstr + "\") --> " + "\""
                            + exercise.cutOut( cutstr, cutOutstr ) + "\"" );
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println(
                            "removeHtmlTags(\"" + htmlStr + "\") --> " + "\""
                                + exercise.removeHtmlTags( htmlStr ) + "\"" );
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println( "onlyDigits(\"" + digitStr
                            + "\") = " + exercise.onlyDigits( digitStr ) );
                        System.out.println( "onlyDigits(\"" + dStr + "\") = "
                            + exercise.onlyDigits( dStr ) );
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println( "isValidISBN(\"" + validISBN
                            + "\") = " + exercise.isValidISBN( validISBN ) );
                        System.out.println( "isValidISBN(\"" + invalidISBN
                            + "\") = " + exercise.isValidISBN( invalidISBN ) );
                        break;
                    case 'C':
                    case 'c':
                        String str = "The quick brown fox";
                        System.out.println( "shuffle(\"" + str + "\") --> "
                            + "\"" + exercise.shuffle( str ) + "\"" );
                        System.out.println( "shuffle(\"" + str + "\") --> "
                            + "\"" + exercise.shuffle( str ) + "\"" );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
