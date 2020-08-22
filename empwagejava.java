import java.util.*;

interface Iempwagejava{

	public void addempwagejava(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursInMonth);
	public void empwagejava();
	public int getTotalWage(String company);
}

class empwagejava{

	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public int totalEmpWage;

	public empwagejava(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){

		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
		totalEmpWage = 0;
	}

	public void setTotalEmpWage(int totalEmpWage){

		this.totalEmpWage = totalEmpWage;
	}

	@Override
	public String toString(){

		return "Total Emp Wage For Company : "+company + " is : "+totalEmpWage;
	}
}


public class Day23EmpWageComputation implements Iempwagejava {

	public static final int isPartTime = 1;
	public static final int isFullTime = 2;


	private int numOfCompany = 0;

	private LinkedList<empwagejava> empwagejavaList;
	private Map<String,empwagejava> companyToEmpWageMap;

	public Day23EmpWageComputation(){

		empwagejavaList= new LinkedList<>();
		companyToEmpWageMap = new HashMap<>();
	}

	public void addempwagejava(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){

		empwagejava empwagejava = new empwagejava(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		empwagejavaList.add(empwagejava);
		companyToEmpWageMap.put(company, empwagejava);
	}

	public void empwagejava(){

		for (int i= 0; i < empwagejavaList.size(); i++){

			empwagejava empwagejava = empwagejavaList.get(i);
			empwagejava.setTotalEmpWage(this.empwagejava(empwagejava));
			System.out.println(empwagejava);

		}
	}
	@Override
	public int getTotalWage(String company){

		return companyToEmpWageMap.get(company).totalEmpWage;

	}

	public int empwagejava(empwagejava empwagejava){
		int totalEmpHrs = 0, totalEmpWage = 0, totalWorkingDays = 0;
		while ( totalEmpHrs <= empwagejava.maxHoursPerMonth && totalWorkingDays < empwagejava.numOfWorkingDays )
		{
			totalWorkingDays++;
			int empHrs = 0, empWage = 0;
			int empCheck =(int) Math.floor(Math.random() * 10) % 3;
			switch (empCheck)
			{
				case isFullTime:
					empHrs = 8;
					break;
				case isPartTime:
					empHrs = 4;
					break;
				default:
					empHrs = 0;
			}
			totalEmpHrs += empHrs;
			empWage = empHrs * empwagejava.empRatePerHour;
			totalEmpWage += empWage;
			// Initializing a Dictionary
        Dictionary geek = new Hashtable();
	String result="";
result=empWage+":"+totalEmpWage;

        // put() method
        geek.put(totalWorkingDays, result);

        // elements() method :
        for (Enumeration i = geek.elements(); i.hasMoreElements();)
        {
            System.out.println("Value in Dictionary : " + i.nextElement());
        }
			System.out.println("Employee Wage : "+empwagejava.company+" "+empWage);
		}
		System.out.println("Total Employee Wage: " + totalEmpWage);
		return totalEmpHrs*empwagejava.empRatePerHour;

	}

	public static void main(String [] args){

		Iempwagejava empWageBuilder = new Day23EmpWageComputation();
		empWageBuilder.addempwagejava("Dmart",20,2,10);
		empWageBuilder.addempwagejava("Reliance",10,4,20);
		empWageBuilder.empwagejava();


		System.out.println("Total wage for dmart Company : "+empWageBuilder.getTotalWage("Dmart"));
	}

}
