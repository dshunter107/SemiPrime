package math;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Start {
	public static final boolean DEBUG = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal change = BigDecimal.ZERO; 
		BigDecimal counter = new BigDecimal(1);
		BigDecimal delta;
		BigDecimal deltaX;
		BigDecimal deltaXSquared;
		boolean deltaFound = false;
		BigDecimal error = BigDecimal.ZERO;
		BigDecimal increaseBy;
		BigDecimal lower;
		BigDecimal multiply2 = new BigDecimal(2);
		
		MathContext mc = new MathContext(30);
	
		BigDecimal upper;
		BigDecimal semiPrime = new BigDecimal("2783065541");
		BigDecimal semiPrimeCheck;
		BigDecimal squarable;
		BigDecimal squareRoot;
		BigDecimal wholeNumber;
		BigDecimal x = semiPrime.sqrt(mc);
		
		if(DEBUG) {
			System.out.println("x before rounding: " + x);
		}
		
		x = x.setScale(0,RoundingMode.CEILING);
		
		if(DEBUG) {
			System.out.println("x: " + x);
		}
		
		for(delta = BigDecimal.ZERO ; delta.compareTo(semiPrime) < 0 && !deltaFound; delta = delta.add(counter)) {
			deltaX = delta.add(x);
			deltaXSquared = deltaX.pow(2);
			squarable = deltaXSquared.subtract(semiPrime);
			squareRoot = squarable.sqrt(mc);
			
			wholeNumber =squareRoot.setScale(0,RoundingMode.FLOOR);
			if(squareRoot.compareTo(wholeNumber) == 0) {
				deltaFound = true;
				change = squareRoot;
				
			}
			if(DEBUG) {
				System.out.println("");
				System.out.println("delta: " + delta);
				System.out.println("delta x: " + deltaX);
				System.out.println("Squareable:" + squarable);
				System.out.println("Square Root: " + squareRoot);
				System.out.println("wholeNumber: " + wholeNumber);
				System.out.println("");
			}
		}
		
		delta = delta.subtract(counter);
		
		if(DEBUG) {
			System.out.println("delta found: " + deltaFound);
			System.out.println("delta: " + delta);
			System.out.println("change: " + change);
		}
		
		if (deltaFound) {
			change = change.subtract(delta);
			delta = delta.multiply(multiply2);
		}
		lower = x.subtract(change);
		increaseBy = delta.add(change);
		upper = x.add(increaseBy);
		
		semiPrimeCheck = lower.multiply(upper);
		if(semiPrimeCheck.compareTo(semiPrime) == 0) {
			System.out.println("");
			System.out.println("Prime Numbers Found");
			System.out.println("Lower: " + lower);
			System.out.println("Upper: " + upper);
		}
		else {
			System.out.println("");
			error = semiPrime.subtract(semiPrimeCheck);
			System.out.println("Prime Numbers not Found");
			System.out.println("semi Prime Check: " + semiPrimeCheck); 
			System.out.println("semi Prime: " + semiPrime);
			System.out.println("Error: " + error);
			System.out.println("Lower: " + lower);
			System.out.println("Upper: " + upper);
			System.out.println("");
			
		}
	}

}
