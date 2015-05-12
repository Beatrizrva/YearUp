
public class Main {

	public static void main(String [] args) 
	{
		Circle bigCircle = new Circle(10);
		double bigCircleArea = bigCircle.CalculateArea();
		System.out.println("Big circle's area is: " + bigCircleArea);
		bigCircle.PrintColor();
		
		Circle smallCircle = new Circle (5, "red");
		double smallCircleArea = smallCircle.CalculateArea();
		System.out.println("Small Circle's area is: " + smallCircleArea);
		smallCircle.PrintColor();
	}
	
}
