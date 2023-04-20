import java.util.Scanner;
public class Main
{
 
  public static void main (String[]args)
  {
      Scanner sc = new Scanner (System.in);
    System.out.println ("Enter the sentence to be identified:");
    String a =sc.nextLine().toLowerCase();


    if (a.contains ("not") || a.contains ("n't")||a.contains ("sad") ||a.contains ("never"))
      {
	System.out.println (a+" : Negative");
      }
    
    else if (a.contains ("happy"))
      {
	System.out.println (a+" : positive");
      }
    else
      {
	System.out.println (a+" : Neutral");
      }

  }
}
