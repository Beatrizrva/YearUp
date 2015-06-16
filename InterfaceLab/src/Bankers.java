
public class Bankers implements ITaxPayer {

	private double m_income;
	boolean m_donePayingTaxes = false;

	public Bankers(double income)
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
			System.out.println("Banker has filed tax return.");
		}
		else
		{
			System.out.println("Banker has not yet filed taxes, return will be filed later.");
		}
	}

	public static void main(String[] args) 
	{
		Bankers blankfein = new Bankers(120000);
		blankfein.PayTaxes(.33);
		blankfein.FileTaxReturn();

		SchoolTeachers doblar = new SchoolTeachers(30000);
		doblar.PayTaxes(.23);
		doblar.FileTaxReturn();

		Scientists hawking = new Scientists(90000);
		hawking.PayTaxes(.28);
		hawking.FileTaxReturn();


		TaxAuditor tom = new TaxAuditor();
		tom.Audit(blankfein);
		tom.Audit(doblar);
		tom.Audit(hawking);
	}

}
