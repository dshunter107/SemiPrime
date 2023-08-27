package math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Start2 {
	public static boolean fastMode = false;
	public static BigDecimal sqRt2 = BigDecimal.valueOf(2L);

	public static void main(String[] args) {
		
		BigDecimal semiPrime = new BigDecimal("6600703");
		MathContext mc = new MathContext(30);
		
		BigDecimal semiPrimeRoot = semiPrime.sqrt(mc);
		BigDecimal bigNumber = new BigDecimal(semiPrimeRoot.toString());
		BigDecimal bigSquared = BigDecimal.ZERO;
		
		
		bigNumber = bigNumber.setScale(0,RoundingMode.CEILING);
		BigDecimal counter = BigDecimal.ONE;
		
		
		BigDecimal lower = BigDecimal.ZERO;
		BigDecimal semiPrimeCheck = BigDecimal.ZERO;
		BigDecimal smallNumber = BigDecimal.ZERO;
		BigDecimal smallSquared = BigDecimal.ZERO;
		
		BigDecimal squaredDifference = BigDecimal.ZERO;
		boolean squaresFound = false;
		BigDecimal sqRt2 = BigDecimal.valueOf(2L);
		
		BigDecimal upper = BigDecimal.ZERO;

		sqRt2 = sqRt2.sqrt(mc);		
		bigSquared = bigNumber.pow(2);
		smallSquared = smallNumber.pow(2);
		squaredDifference = bigSquared.subtract(smallSquared);
		
	
		
		
		while (bigNumber.compareTo(semiPrime) <= 0 && !squaresFound) {
			
			
			while(squaredDifference.compareTo(semiPrime) >= 0 && !squaresFound) {
				
				if(Start.DEBUG) {
					System.out.println("");
					System.out.println("Big Number: " + bigNumber);
					System.out.println("Small Number: " + smallNumber);
					System.out.println("Semi Prime: " + semiPrime);
					System.out.println("Squared difference: " + squaredDifference);
					System.out.println("");
				}
				
				
				if(squaredDifference.compareTo(semiPrime) == 0) {
					squaresFound = true;
				}
				
				smallNumber = smallNumber.add(counter);
				smallSquared = smallNumber.pow(2);
				squaredDifference = bigSquared.subtract(smallSquared);
			}
			
			bigNumber = bigNumber.add(counter);
			bigSquared = bigNumber.pow(2);
			
			if(!squaresFound && fastMode) {	
				smallNumber = smallNumber.subtract(counter);
				smallNumber =smallNumber.multiply(sqRt2);
				smallNumber = smallNumber.setScale(0,RoundingMode.FLOOR);
				smallSquared =smallNumber.pow(2);
			}
			
			squaredDifference = bigSquared.subtract(smallSquared);
			
			if(Start.DEBUG) {
				System.out.println("");
				System.out.println("Big Number: " + bigNumber);
				System.out.println("Small Number: " + smallNumber);
				System.out.println("Semi Prime: " + semiPrime);
				System.out.println("Squared difference: " + squaredDifference);
				System.out.println("");
			}
		}
		
		bigNumber = bigNumber.subtract(counter);
		smallNumber = smallNumber.subtract(counter);
		
		upper = bigNumber.add(smallNumber);
		lower = bigNumber.subtract(smallNumber);
		
		semiPrimeCheck = upper.multiply(lower);
		
		if(semiPrime.compareTo(semiPrimeCheck) == 0) {
			System.out.println("");
			System.out.println("Prime Numbers Found");
			System.out.println("");
		}
		
		System.out.println("Upper: " + upper);
		System.out.println("Lower: " + lower);
		
		if(Start.DEBUG) {
			System.out.println("");
			System.out.println("Big Number: " + bigNumber);
			System.out.println("Small Number: " + smallNumber);
			System.out.println("Semi Prime: " + semiPrime);
			System.out.println("Semi Prime Check: " + semiPrimeCheck);
			System.out.println("");
		}
		
	}

}
