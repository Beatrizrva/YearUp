
public class LargestNumber 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1, 5, 6};
	}
	public void LargestNumberUsingForLoop(int[] inputArray)
	{
		if (inputArray != null) 
		{
			if (inputArray.length > 0)
			{
				int largestNumber = inputArray[0];

				for (int i = 0; i < inputArray.length; i++)
				{
					if (largestNumber < inputArray[i])
					{
						largestNumber = inputArray[i];	
					}
					System.out.println("The largest number that I found is: " + largestNumber);
				}

			}
			else
			{
				System.out.println("This array does not even have any numbers");
			}
			else
			{
				System.out.println("You gave me a null array.");
			}
		}

	}
}

