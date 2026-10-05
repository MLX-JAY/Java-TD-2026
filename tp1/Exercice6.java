package tp1;
public class Exercice6 
{
    public static void main (String[] args)
    {
        int a = 0, b = 0;
        //and
        if ( a>0 )
        {
            if ( b>0 )
            {
                System.out.print("and");
            }
        }
        //xor
        if (a>0)
        {
            if (b<0)
            {
                System.out.print("xor");
            }
        }
        else
        {
            if (b>0)
            {
                System.out.print("xor");
            }
        }
    }
}
