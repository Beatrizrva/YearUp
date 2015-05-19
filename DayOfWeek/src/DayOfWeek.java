import java.util.Scanner;

public class DayOfWeek {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a new day of week:\n");
		String day = scanner.next();
		System.out.println("I read this day of week " + day);
		
		DayOfWeek dayOfWeekEvaluator = new DayOfWeek();
		dayOfWeekEvaluator.EvaluateDayOfWeek(day);
		
		scanner.close();
	}

	void EvaluateDayOfWeek(String dayOfWeek)
	{
		if (dayOfWeek != null)
		{
			if (dayOfWeek.equalsIgnoreCase("Saturday")
				|| dayOfWeek.equalsIgnoreCase("Sunday"))
				{
				System.out.println(dayOfWeek + " is the weekend!");
				}
			else if (dayOfWeek.equalsIgnoreCase("Monday")
					||dayOfWeek.equalsIgnoreCase("Tuesday")
					||dayOfWeek.equalsIgnoreCase("Wednesday")
					||dayOfWeek.equalsIgnoreCase("Thursday")
					||dayOfWeek.equalsIgnoreCase("Friday"))
					{
				System.out.println(dayOfWeek + " is a weekday, I have to go to work.");
					}
			else
			{
				System.out.println(dayOfWeek + "is not even a valid day!");
			}
		}
	}
}
