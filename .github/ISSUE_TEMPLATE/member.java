import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable { //changed class name member to Member - Pavan

	private String lastName; // change LN to lastName - Pavan
	private String firstName; // change FN to firstName - Pavan
	private String email; // change EM to email - Pavan
	private int phoneNo; // change PN to phoneNo - Pavan
	private int id; // change ID to id - Pavan
	private double fines; // change FINES to fines - Pavan

	private Map<int, Loan> lns; //changed loan to Loan and LNS to lns- Pavan


	public Member(String lastName, String firstName, String email, int phoneNo, int id) { // changed memeber to Member - pavan
		this.lastName = lastName; // changed LN to lastname -pavan
		this.firstName = firstName; // changed Fn to firstName -Pavan
		this.email = email; // changed EM to email -pavan
		this.phoneNo = phoneNo; // changed PN to phoneNo- pavan
		this.id = id; // changed ID to id -pavan

		this.lns = new HashMap<>(); //changed LNS to lns - pavan
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(getId).append("\n")  //change ID to getId - Pavan
		  .append("  Name:  ").append(getLastName).append(", ").append(getFirstName).append("\n") //  change LN to getLastName  - Pavan // change FN to getFirstName -Pavan
		  .append("  Email: ").append(getEmail).append("\n") // change EM to email - Pavan
		  .append("  Phone: ").append(getPhoneNo) // change PN to getPhoneNo - Pavan
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", this.fines)) // change FINES to fines - Pavan
		  .append("\n");

		for (Loan loan : getLoans()) { // change LoAn to loan and LNS.values to getLoans - Pavan
			sb.append(loan).append("\n"); // change LoAn to loan - Pavan
		}
		return sb.toString();
	}


	public int getId() { // change GeT_ID to getId - Pavan
		return this.id; // change ID to id - Pavan
	}


	public List<Loan> getLoans() { // change GeT_LoAnS to getLoans - Pavan
		return new ArrayList<Loan>(this.lns.getValues()); //changed  LNS to lns and loan to Loan - Pavan
	}


	public int numberOfCurrentLoans() { // change Number_Of_Current_Loans to numberOfCurrentLoans - Pavan
		return this.lns.size(); //changed object calling to this .lns -pavan
	}


	public double getFines() { // change Fines_OwEd to getFines - Pavan
		return this.fines; // change FINES to this.fines - Pavan
	}


	public void takeOutLoan(Loan loan) { // change Take_Out_Loan to takeOutLoan - Pavan
		if (!this.lns.containsKey(loan.getLoanId())) { // changed LNS to this.lns and ID to getLoanId - Pavan
			this.lns.put(loan.getLoanId(), loan); // changed object calling LNS to this.lns and ID to getLoanId -Pavan
		}
		else {
			throw new RuntimeException("Duplicate loan added to member");
		}
	}


	public String getLastName() { // change Get_LastName to getLastName - Pavan
		return this.lastName; // change LN to this.lastName - Pavan
	}


	public String getFirstName() { // change Get_FirstName to getFirstName - Pavan
		return this.firstName; // change FN to this.firstName - Pavan
	}


	public void addFine(double fine) { // change Add_Fine to addFine - Pavan
		this.fines += fine; // change FINES to this.fines - pavan
	}

	public double payFine(double amount) { // change payFine to payFine - Pavan // change AmOuNt to amount - Pavan
		if (amount < 0) { // change AmOuNt to amount - Pavan
			throw new RuntimeException("Member.payFine: amount must be positive");
		}
		double change = 0;
		if (amount > this.fines) { // change AmOuNt to amount - Pavan. // change FINES to fines - pavan
			change = amount - this.fines; // change AmOuNt to amount - Pavan. // change FINES to fines - Pavan
			this.fines = 0;  // change FINES to this.fines - Pavan
		}
		else {
			this.fines -= amount;  // change FINES to this.fines - Pavan. // change AmOuNt to amount - pavan.
		}
		return change;
	}


	public void dischargeLoan(Loan loan) { // change dIsChArGeLoAn to dischargeLoan - Pavan
		if (this.lns.containsKey(loan.getLoanId())) { // change LoAn to getLoanId - Pavan
			this.lns.remove(loan.getLoanId()); // change LoAn to getloanId - Pavan
		}
		else {
			throw new RuntimeException("No such loan held by member");
		}
	}

}
