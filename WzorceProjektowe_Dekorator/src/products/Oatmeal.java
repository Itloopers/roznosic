package products;

import java.math.BigDecimal;

import abstractClasses.Product;

public class Oatmeal extends Product {

	public Oatmeal() {
		super.description = "Classic Oatmeal";
	}

	@Override
	public BigDecimal price() {
		return new BigDecimal(4.5);
	}

}
