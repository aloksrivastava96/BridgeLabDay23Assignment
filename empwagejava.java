import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class empwagejava{
		static int EMP_WAGE_PER_HR=0;
                int EMP_FULL_DAY_HR=0;
                int EMP_PART_DAY_HR=0;
                int NO_OF_WORK_DAY=0;
                int MAX_MONTH_HR=100;
		int compcount=0;
		int totalEmpHr=0;
                int totalWorkDay=0;
                int isFullTime=0;
                static int EMP_DAY_HR=0;
                static int check = 0;
                int totalWage=0;
	public static void main (String[] args){
		empwagejava empy = new empwagejava();
		System.out.println("Welcome to Employee Wage Computaion Program.");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of companies: ");
		empy.compcount=sc.nextInt();
		System.out.println();
		for (int i = 0; i < empy.compcount; i++){
			System.out.println("Enter the detail of Company "+(i+1));
			System.out.println("Enter the Employee wage per hour:");
			empwagejava.EMP_WAGE_PER_HR=sc.nextInt();
			System.out.println("Enter the number of days per month:");
			empy.NO_OF_WORK_DAY=sc.nextInt();
			System.out.println("Enter the employee full day hour for a day:");
			empy.EMP_FULL_DAY_HR=sc.nextInt();
			System.out.println("Enter the employee half day hour for a day:");
			empy.EMP_PART_DAY_HR=sc.nextInt();
			while ((empy.totalEmpHr<empy.MAX_MONTH_HR)&&(empy.totalWorkDay<empy.NO_OF_WORK_DAY)) {
				Random r = new Random();
				empy.isFullTime=r.nextInt(2);
				empwagejava.check=attendaceCheck();
				empwagejava.EMP_DAY_HR=(getWorkingHr(empwagejava.check, empy.isFullTime, empy.EMP_FULL_DAY_HR, empy.EMP_PART_DAY_HR));
				empy.totalEmpHr+=EMP_DAY_HR;
				System.out.println("Employee wage for Day"+(empy.totalWorkDay+1)+" is ");
				empWageBuilder();
				empy.totalWorkDay++;
			}
			empy.totalWage=(empy.totalEmpHr*empwagejava.EMP_WAGE_PER_HR);
			System.out.println("Total Working Hour for this month of Company "+(i+1)+" is:"+empy.totalEmpHr);
			System.out.println("Total wage of the employee for this month of company "+(i+1)+" is:"+empy.totalWage);
			System.out.println();
		}
	}
	public static int attendaceCheck() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
	public static void empWageBuilder() {
		 System.out.println(empwagejava.check*empwagejava.EMP_DAY_HR*empwagejava.EMP_WAGE_PER_HR);
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
