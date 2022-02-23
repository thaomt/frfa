package exercise_1;

import java.util.Date;

public class Visit {
	private Customer cusCustomer;
	private Date date;
	private double serviceExpense;
	private double productExpense;

	public Visit(String name, Date date) {
		this.date = date;
		this.cusCustomer = new Customer(name);
	}

	public double getTotalExpense() {
		String type = cusCustomer.getMemberType();
		double serviceDiscount = DiscountRate.getServiceDiscountRate(type);
		double productDiscount = DiscountRate.getProductDiscountRate(type);
		double service_Expense = serviceExpense - (serviceExpense * serviceDiscount);
		double product_Expense = productExpense - (productExpense * productDiscount);
		double total = service_Expense + product_Expense;
		return total;

	}

	public String getName() {
		return cusCustomer.getName();
	}

	public double getServiceExpense() {
		return serviceExpense;
	}

	public void setServiceExpense(double serviceExpense) {
		this.serviceExpense = serviceExpense;
	}

	public void setCusCustomer(Customer cusCustomer) {
		this.cusCustomer = cusCustomer;
	}

	public double getProductExpense() {
		return productExpense;
	}

	public void setProductExpense(double productExpense) {
		this.productExpense = productExpense;
	}

	@Override
	public String toString() {
		return "Visit infomation: " + "\nDate: " + date + "\nService purchases : " + serviceExpense+" $"
				+ "\nProduct purchases : " + productExpense+" $" ;
	}

}
