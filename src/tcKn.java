import java.util.Scanner;

public class tcKn {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		long tckn = 0;

		boolean isNumber = true;
		
		System.out.print("TC Kimlik Numaranýzý Giriniz : " );
	
			do {
				
				if (input.hasNextLong()) {
					
					tckn = input.nextLong();
					
					System.out.println(isValidTckn(tckn));
					
					if(isValidTckn(tckn))
						isNumber = true;
					else
						isNumber= false;
					
				} else {
					
					System.out.println("TC kimlik numaralarý sadece rakam içermelidir.");
					
					isNumber = false;
					
					input.next();
				} 
				
			} while (!(isNumber));
			
		System.out.println(tckn);
		
		input.close();
		
	}
	private static boolean isValidTckn(Long tckn) {

		try {
			String tmp = tckn.toString();
	 
			if (tmp.length() == 11) {
				int totalOdd = 0;
	 
				int totalEven = 0;
	 
				for (int i = 0; i < 9; i++) {
					int val = Integer.valueOf(tmp.substring(i, i + 1));
	 
					if (i % 2 == 0) {
						totalOdd += val;
					} else {
						totalEven += val;
					}
				}
	 
				int total = totalOdd + totalEven + Integer.valueOf(tmp.substring(9, 10));
	 
				int lastDigit = total % 10;
	 
				if (tmp.substring(10).equals(String.valueOf(lastDigit))) {
					int check = (totalOdd * 7 - totalEven) % 10;
	 
					if (tmp.substring(9, 10).equals(String.valueOf(check))) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			//LOGGER.catching(e);
		}
	 
		return false;
	}
	
	
}
