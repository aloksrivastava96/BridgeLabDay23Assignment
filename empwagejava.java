import java.util.Random;
import java.util.Arrays;
public class empwagecompjava{
	public static void main (String[] args){
		int EMP_WAGE_PER_HR=20;
		int EMP_FULL_DAY_HR=8;
		int EMP_PART_DAY_HR=4;
		int NO_OF_WORK_DAY=7;
		int totalEmpHr=0;
		int totalWorkDay=0;
		int isFullTime=0;
		int EMP_DAY_HR=0;
		System.out.println("Welcome to Employee Wage Computaion Program.");
		int check = 0;
		int totalWage=0;
		while (totalWorkDay<NO_OF_WORK_DAY) {
			Random r = new Random();
			isFullTime=r.nextInt(2);
			if (isFullTime==1) {
				EMP_DAY_HR=EMP_FULL_DAY_HR;
			}
			else {
				EMP_DAY_HR=EMP_PART_DAY_HR;
			}
			check=attendaceCheck();
			totalEmpHr+=(check*EMP_DAY_HR);
			System.out.println("Employee wage for Day"+(totalWorkDay+1)+" is ");
			System.out.println(getDailyEmpWage(totalWorkDay, check, EMP_DAY_HR, EMP_WAGE_PER_HR));
			totalWorkDay++;
		}
		totalWage=(totalEmpHr*EMP_WAGE_PER_HR);
		System.out.println("Total wage of the employee is:"+totalWage);
	}
	public static int attendaceCheck() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
	public static int getDailyEmpWage(int tworkday, int attendace, int dayhr, int wagehr) {
		 return (attendace*dayhr*wagehr);
	}
}
