package rental;
public class RentalPriceCalculator {

	public static final int MINIMUM_DRIVING_AGE = 18;
	public static final int MINIMUM_AGE_FOR_CLASS1_VEHICLES = 21;
	public static final int COMPACT_CARCLASS = 2;
	public static final int SEASONAL_COEFFICENT = 2;
	public static final int IN_MIDDLE_TWENTIES = 25;
	public static final int FULLSIZE_CARCLASS = 4;
	public static final int MINIMUM_AGE_OF_OWNING_LICENCE_FOR_RENT = 1;
	public static final double RENTAL_PRICE_COEFFICENT = 1.3;
	public static final int STILL_DANGEROUS_GUY_ON_THE_ROAD = 3;
	public static final int ACCIDENT_ADDITIONAL_FEE_FOR_UNDER_THERTHY = 15;
	public static final int MIDDLE_AGE = 30;
	public static final double MAXIMUM_RENTAL_PRICE = 1000.00;

	public void startCounting(int driverAge, int licence, int carClass, boolean causedAccident, boolean partInAccident, boolean highRentSeason) {
        RentalPriceCalculator start = new RentalPriceCalculator();
		start.rentExeptions(driverAge, carClass, licence, causedAccident, highRentSeason );
	}

    public  String rentExeptions (int driverAge, int carClass, int licence,boolean causedAccident, boolean highRentSeason){
		String exeptionalMessage ="";

		if (driverAge < MINIMUM_DRIVING_AGE) {
			exeptionalMessage = "Driver too young - cannot quote the price";
		}

		if (driverAge <= MINIMUM_AGE_FOR_CLASS1_VEHICLES && carClass > COMPACT_CARCLASS) {
			exeptionalMessage = "Drivers 21 y/o or less can only rent Class 1 vehicles";

		}
		if (licence < MINIMUM_AGE_OF_OWNING_LICENCE_FOR_RENT) {
			exeptionalMessage = "Driver must hold driving licence at least for one year. Can not rent a car!";
		}
		else {
            exeptionalMessage="";
		    return  rentalPriceCount(driverAge, licence, carClass, causedAccident, highRentSeason);
        }
        System.out.print(exeptionalMessage);
		return exeptionalMessage;
	}

	public String rentalPriceCount(int driverAge, int licence, int carClass, boolean causedAccident, boolean highRentSeason){

	    double rentalPrice=driverAge;

        if (carClass >= FULLSIZE_CARCLASS && driverAge <= IN_MIDDLE_TWENTIES && highRentSeason != false) {
            rentalPrice = rentalPrice * SEASONAL_COEFFICENT;
        }

        if (licence < STILL_DANGEROUS_GUY_ON_THE_ROAD) {
            rentalPrice = rentalPrice * RENTAL_PRICE_COEFFICENT;
        }

        if (causedAccident == true && driverAge < MIDDLE_AGE) {
            rentalPrice += ACCIDENT_ADDITIONAL_FEE_FOR_UNDER_THERTHY;
        }

        if (rentalPrice > MAXIMUM_RENTAL_PRICE) {
            String maxRentPrice = Double.toString(MAXIMUM_RENTAL_PRICE);
            return maxRentPrice;
        }
        String result=Double.toString(rentalPrice);
        return result;
    }
}