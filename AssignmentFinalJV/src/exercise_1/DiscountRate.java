package exercise_1;

public class DiscountRate {
	private static final double SERVICE_DISCOUNT_PREMIUM = 2.0;
	private static final double SERVICE_DISCOUNT_GOLD = 0.15;
	private static final double SERVICE_DISCOUNT_SILVER = 0.1;
	private static final double PRODUCT_DISCOUNT_PREMIUM = 0.1;
	private static final double PRODUCT_DISCOUNT_GOLD = 0.1;
	private static final double PRODUCT_DISCOUNT_SILVER = 0.1;
	
	static final String MEMBER_TYPE_1="Premium";
	static final String MEMBER_TYPE_2="Gold";
	static final String MEMBER_TYPE_3="Silver";

	public static double getServiceDiscountRate(String type){		
		switch (type) {
			case MEMBER_TYPE_1:
				return SERVICE_DISCOUNT_PREMIUM;
			case MEMBER_TYPE_2:
				return SERVICE_DISCOUNT_GOLD;
			case MEMBER_TYPE_3:
				return SERVICE_DISCOUNT_SILVER;
			default:
				return 0.0;
			}		
	}
	public static double getProductDiscountRate(String type){			
		switch (type) {
			case MEMBER_TYPE_1:
				return PRODUCT_DISCOUNT_PREMIUM;
			case MEMBER_TYPE_2:
				return PRODUCT_DISCOUNT_GOLD;
			case MEMBER_TYPE_3:
				return PRODUCT_DISCOUNT_SILVER;
			default:
				return 0.0;
			}
		
	}
}
