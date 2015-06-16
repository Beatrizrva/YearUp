
public class TaxAuditor {
	public void Audit(ITaxPayer taxpayer)
	{
		System.out.println("Audited: " + taxpayer.getClass());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
