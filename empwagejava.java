import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class empwagejava{
	public static void main (String[] args){
		int EMP_WAGE_PER_HR=0;
		int EMP_FULL_DAY_HR=0;
		int EMP_PART_DAY_HR=0;
		int NO_OF_WORK_DAY=0;
		int MAX_MONTH_HR=100;
		System.out.println("Welcome to Employee Wage Computaion Program.");
		int compcount=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of companies: ");
		compcount=sc.nextInt();
		System.out.println();
		for (int i = 0; i < compcount; i++){
			System.out.println("Enter the detail of Company "+(i+1));
			System.out.println("Enter the Employee wage per hour:");
			EMP_WAGE_PER_HR=sc.nextInt();
			System.out.println("Enter the number of days per month:");
			NO_OF_WORK_DAY=sc.nextInt();
			System.out.println("Enter the employee full day hour for a day:");
			EMP_FULL_DAY_HR=sc.nextInt();
			System.out.println("Enter the employee half day hour for a day:");
			EMP_PART_DAY_HR=sc.nextInt();
			int totalEmpHr=0;
                	int totalWorkDay=0;
                	int isFullTime=0;
                	int EMP_DAY_HR=0;
			int check = 0;
                	int totalWage=0;
			while ((totalEmpHr<MAX_MONTH_HR)&&(totalWorkDay<NO_OF_WORK_DAY)) {
				Random r = new Random();
				isFullTime=r.nextInt(2);
				check=attendaceCheck();
				EMP_DAY_HR=(getWorkingHr(check, isFullTime, EMP_FULL_DAY_HR, EMP_PART_DAY_HR));
				totalEmpHr+=EMP_DAY_HR;
				System.out.println("Employee wage for Day"+(totalWorkDay+1)+" is ");
				System.out.println(getDailyEmpWage(totalWorkDay, check, EMP_DAY_HR, EMP_WAGE_PER_HR));
				totalWorkDay++;
			}
			totalWage=(totalEmpHr*EMP_WAGE_PER_HR);
			System.out.println("Total Working Hour for this month of Company "+(i+1)+" is:"+totalEmpHr);
			System.out.println("Total wage of the employee for this month of company "+(i+1)+" is:"+totalWage);
			System.out.println();
		}
	}
	public static int attendaceCheck() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
	public static int getDailyEmpWage(int tworkday, int attendace, int dayhr, int wagehr) {
		 return (attendace*dayhr*wagehr);
	}
	public static int getWorkingHr(int att, int ishr, int fd, int hd) {
		int empHr=0;
		switch(ishr) {
		case 0:
			empHr=(att*hd);
			break;
		case 1:
			empHr=(att*fd);
			break;
		}
		return empHr;
	}
}
