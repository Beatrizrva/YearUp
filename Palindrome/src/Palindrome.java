public class Palindrome
{

	public static void main(String[] args) 
	{
		
		// TODO Auto-generated method stub
		
		String string1 = "race car";
		String string2 = "Beatriz";
		
		boolean isString1Palindrome = IsPalindrome(string1);
		boolean isString2Palindrome = IsPalindrome(string2);
		
		if (isString1Palindrome)
		{
			System.out.println(string1 + " is a palindrome.");
		}
		else
		{
			System.out.println(string1 + " is not a palindrome.");
		}
		if (isString2Palindrome)
		{
			System.out.println(string2 + " is a palindrome.");
		}
		else
		{
			System.out.println(string2 + " is not a palindrome.");
		}
		
	}
	
	public static boolean IsPalindrome(String wordInput)
	{
		boolean isPalindrome = true;
		
		if (wordInput != null)
		{
			String wordInputNoSpaceAndLowerCase = wordInput.replace(" ", "").toLowerCase();
			char[] wordInputChars = wordInputNoSpaceAndLowerCase.toCharArray();
			
			for (int i = 0, k = wordInputChars.length - 1; i < wordInputChars.length/2; i++, k--)
			{
				if (wordInputChars[i] != wordInputChars [k])
				{
					isPalindrome = false;
					break;
					
				}
			}
		}
		else
		{
			System.out.println("You gave me a null string ");
			isPalindrome = false;
		}
		return isPalindrome;
	}
	
}
