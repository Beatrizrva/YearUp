
public class ChineseNewYear {
	

	public static void main(String[] args) 
		// TODO Auto-generated method stub
	{
		ChineseNewYear animal = new ChineseNewYear();
		animal.EvaluateChineseNewYear(1996);
	}
	
	
		public void EvaluateChineseNewYear(int unknownYear) 
		{		
		
		int s_knownYear = 1996;
		int yearDifference = unknownYear - s_knownYear;
		int remainder = yearDifference % 12;

		switch (remainder)
		{
		
		case 0: 
			System.out.println(unknownYear + " This is the year of the Rat.");
			break;
		case 1:
			System.out.println(unknownYear + " This is the year of the Ox.");
			break;
		case 2: 
			System.out.println(unknownYear + " This is the year of the Tiger.");
			break;
		case 3: 
			System.out.println(unknownYear + " This is the year of the Rabbit.");
			break;
		case 4:
			System.out.println(unknownYear + " This is the year of the Dragon.");
			break;
		case 5:
			System.out.println(unknownYear + " This is the year of the Snake.");
			break;
		case 6:
			System.out.println(unknownYear + " This is the year of the Horse.");
			break;
		case 7: 
			System.out.println(unknownYear + " This is the year of the Goat.");
			break;
		case 8:
			System.out.println(unknownYear + " This is the year of the Monkey.");
			break;
		case 9:
			System.out.println(unknownYear + " This is the year of the Rooster.");
			break;
		case 10:
			System.out.println(unknownYear + " This is the year of the Dog.");
			break;
		case 11:
			System.out.println(unknownYear + " This is the year of the Pig.");
			break;
		}
}


		private void s_knownYear() {
			// TODO Auto-generated method stub
			
		}}
	
		


