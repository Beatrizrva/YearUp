
public class Scientists implements ITaxPayer 
{
	private double m_income;
	boolean m_donePayingTaxes = false;

	public Scientists(double income)
	{
		setIncome(income);
	}

	public double getIncome()
	{
		return m_income;
	}

	private void setIncome(double income)
	{
		m_income = income;
	}

	public void PayTaxes(double taxRate)
	{
		if (!m_donePayingTaxes)
		{
			double taxes = taxRate * getIncome();
			double newIncome = getIncome() - taxes;
			setIncome(newIncome);
			m_donePayingTaxes = true;
		}
		else
		{
			System.out.println("Bankers has already paid taxes for this year.");
		}
	}
	public void FileTaxReturn() 
	{
		if (m_donePayingTaxes)
		{
			System.out.println("Scientist has filed tax return.");
		}
		else
		{
			System.out.println("Scientist has not yet filed taxes, return will be filed later.");
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
