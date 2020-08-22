import java.util.Random;
import java.util.Arrays;
public class empwagecompjava{
	public static void main (String[] args){
		int EMP_WAGE_PER_HR=20;
		int EMP_FULL_DAY_HR=8;
		int NO_OF_WORK_DAY=7;
		System.out.println("Welcome to Employee Wage Computaion Program.");
		int check = attendaceCheck();
		System.out.println("Employee daily wages are:");
		System.out.println(Arrays.toString(getDailyEmpWage(EMP_WAGE_PER_HR, EMP_FULL_DAY_HR, NO_OF_WORK_DAY)));
	}
	public static int attendaceCheck() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
	public static int[] getDailyEmpWage(int wagehr, int dayhr, int workday) {
		int totalWorkDay=0;
		int dailyWage[] = new int [workday];
		while(totalWorkDay<workday) {
			int attendance = attendaceCheck();
			dailyWage [totalWorkDay++] = (attendance*dayhr*wagehr);
		}
		return dailyWage;
	}
}
