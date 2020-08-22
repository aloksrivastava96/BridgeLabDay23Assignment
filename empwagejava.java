import java.util.Random;
import java.util.Arrays;
public class empwagejava{
	 int EMP_WAGE_PER_HR=20;
         int EMP_FULL_DAY_HR=8;
         int EMP_PART_DAY_HR=4;
         int NO_OF_WORK_DAY=20;
         int MAX_MONTH_HR=100;
         int totalEmpHr=0;
         int totalWorkDay=0;
         int isFullTime=0;
         int EMP_DAY_HR=0;

	public static void main (String[] args){
		System.out.println("Welcome to Employee Wage Computaion Program.");
		getDailyEmpWage();
	}
	public static int attendaceCheck() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
	public static void getDailyEmpWage() {
		int check = 0;
                int totalWage=0;
		empwagejava emp = new empwagejava();
                while ((emp.totalEmpHr<emp.MAX_MONTH_HR)&&(emp.totalWorkDay<emp.NO_OF_WORK_DAY)) {
                        Random r = new Random();
                        emp.isFullTime=r.nextInt(2);
                        check=attendaceCheck();
                        emp.EMP_DAY_HR=(getWorkingHr(check, emp.isFullTime, emp.EMP_FULL_DAY_HR, emp.EMP_PART_DAY_HR));
                        emp.totalEmpHr+=emp.EMP_DAY_HR;
                        System.out.println("Employee wage for Day"+(emp.totalWorkDay+1)+" is ");
                        System.out.println(check*emp.EMP_DAY_HR*emp.EMP_WAGE_PER_HR);
                        emp.totalWorkDay++;
                }
                totalWage=(emp.totalEmpHr*emp.EMP_WAGE_PER_HR);
                System.out.println("Total Working Hour for this month is:"+emp.totalEmpHr);
                System.out.println("Total wage of the employee for this month is:"+totalWage);
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
