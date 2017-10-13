import java.util.Scanner;

public class Bottles {

	public static void main(String[] args) {
		
		
		int bottles=getBottles();
		doBottles(bottles);

	}
	
	public static void doBottles(int bottles)
	{
		FirstLine(bottles);
		bottles--;
		SecondLine(bottles);
		GapLine();
		
		if (bottles>=0)
			doBottles(bottles);
	}
	
	public static int getBottles()
	{
		int bottles=-1;
		
		while(bottles<0)
		{
			System.out.println("SUPER-AWESOME BOTTLE SONG CODE");
			System.out.print("How many bottles? ");
			
			Scanner keyboard = new Scanner(System.in);
			try
			{
				bottles = keyboard.nextInt();
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.println("Enter a valid number you idiot!");
			}
		}
		
		return bottles;
		
	}
	
	public static void FirstLine(int n)
	{
		if (n>0)
		{
			String s;
			s=Plural(n);
			System.out.println(Num(n)+" bottle"+s+" of beer on the wall, "+Num(n)+" bottle"+s+" of beer.");
		}
		else
			System.out.println("No more bottles of beer on the wall, no more bottles of beer." );
	}
	
	public static void SecondLine(int n)
	{
		if (n>0)
		{
			String s=Plural(n);
			System.out.println("Take one down and pass it around, "+Num(n)+" bottle"+s+" of beer on the wall.");
		}
		else
			System.out.println("Go to the store and buy some more, 99 bottles of beer on the wall.");
	}
	
	public static void GapLine()
	{
		System.out.println("");
	}
	
	public static String Plural(int n)
	{
		String s;
		if (n>1 || n<1)
			s="s";
		else
			s="";
		return s;
	}
	
	public static String Num(int n)
	{
		String output = "";
		if (n>0)
			output = ""+n;
		else
			output = "no more";
		return output;
	}

}
