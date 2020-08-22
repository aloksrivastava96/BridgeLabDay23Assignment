import java.util.Random;
public class empwagecompjava{
	public static void main (String[] args){
		System.out.println("Welcome to Employee Wage Computaion Program.");
		int check = attendaceCheck();
		if(check==1) {
			System.out.println("Employee is present");
		}
		else {
			System.out.println("Employee is absent");
		}
	}
	public static int attendaceCheck() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
}
