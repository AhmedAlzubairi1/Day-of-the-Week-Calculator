
package dateAnalyzer;

import java.util.*;
public class dateAnalyzer {
	public static void main(String [] args){
		while (true){
		
		Scanner userImput = new Scanner(System.in);
		/*		
		System.out.println("Check year: ");
		int test = userImput.nextInt();
		System.out.println(isLeapYear(test));
		*/	

		System.out.print("Birth Month:");
		int bornMonth = userImput.nextInt();
		System.out.print("Birth Day:");
		int bornDay = userImput.nextInt();
		System.out.print("Birth Year:");
		int bornYear = userImput.nextInt();

		System.out.println(finalMethod(bornDay, bornMonth, bornYear));
		
		System.out.println("Start Again!!!");

		}
	}

	public static String convertNumToDays(int findDay){
		String x = "notghing happened...";
		if ( findDay == 0){
			x = "Sunday";
		}
		if ( findDay == 1){
			x =  "Monday";
		}if ( findDay == 2){
			x = "Tuesday";
		}if ( findDay == 3){
			x = "Wednesday";
		}if ( findDay == 4){
			x = "Thursday";
		}if ( findDay == 5){
			x = "Friday";
		}if ( findDay == 6){
			x = "Saturday";
		} if(findDay == -1){
			x = "yOU MEESSEED UP~";
		}
		return x ;
	}
	
	public static int firstDayOfYear(int bornYear){
		int fdoy = 6;
		//1601
		for (int i = 1601; i <= bornYear; i ++){
			if(isLeapYear(i-1)){
				fdoy= (fdoy+366) % 7;					
			}
			else {
				fdoy= (fdoy+365) % 7;
			}
		}
		return fdoy;
	}

	public static int daysInMonth(int month, int bornYear){
		int x = 31;
		int y = 28;
		int yL = 29;
		int z = 30;
		if ((month == 1)|| (month == 3)||(month == 5)||(month == 7)||(month == 8)|| (month == 10)|| (month == 12)){
			return x;
		}
		else if(month==2 && isLeapYear(bornYear)){
			return yL;
		}
		else if (month == 2 && !isLeapYear(bornYear)){
			return y;
		}
		else{
			return z;

		}
	}

	public static int findDay(int fdom, int bornDay, int daysOfMonth){
		for (int i = 1; i <= 7; i++){
			for (int j = i; j <= daysOfMonth ; j+=7 ){
				if (j == bornDay){
					return (fdom + (i -1))% 7;
				}

			}
		}
		return -1;
	}

	public static int firstDayOfMonth (int fdoy, int bornMonth, int bornYear){
		int janDay = fdoy;
		int febDay = (janDay + 31)% 7;
		int marDay;
		if(isLeapYear(bornYear)){
			marDay = (febDay + 29)% 7;					
		}
		else{
			marDay = (febDay + 28)% 7;
		}
		int aprDay = (marDay + 31)% 7;
		int mayDay = (aprDay + 30)% 7;
		int junDay = (mayDay + 31)% 7;
		int julDay = ( junDay+ 30)% 7;
		int augDay = (julDay + 31)% 7;
		int sepDay = (augDay + 31)% 7;
		int octDay = (sepDay + 30)% 7;
		int novDay = (octDay + 31)% 7;
		int decDay = (novDay + 30)% 7;
		
		if (bornMonth == 1)  return janDay;
		if (bornMonth == 2)  return febDay;
		if (bornMonth == 3)  return marDay;
		if (bornMonth == 4)  return aprDay;
		if (bornMonth == 5)  return mayDay;
		if (bornMonth == 6)  return junDay;
		if (bornMonth == 7)  return julDay;
		if (bornMonth == 8)  return augDay;
		if (bornMonth == 9)  return sepDay;
		if (bornMonth == 10)  return octDay;
		if (bornMonth == 11)  return novDay;
		if (bornMonth == 12)  return decDay;
		
		return -3;
		
	}
	
	public static String finalMethod (int bornDay, int bornMonth, int bornYear){
		int fdoy = firstDayOfYear(bornYear);
		int fdom = firstDayOfMonth(fdoy, bornMonth, bornYear);
		int fD = findDay(fdom, bornDay, daysInMonth(bornMonth, bornYear) );
		String days = convertNumToDays(fD);
		return days;
	}
	
	public static boolean isLeapYear(int bornYear){
	
		
		boolean check = false;
		
		if(bornYear % 4 == 0){
			check = true;
		}
		
		if(bornYear % 100 == 0 && (bornYear/100) %4 !=0 ){
			check = false;					
		}
		
		return check;
	
	}
	
}