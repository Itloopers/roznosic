package products.decorators;

import java.math.BigDecimal;

import abstractClasses.Decorator;
import abstractClasses.Product;

public class BlueberriesOatmeal extends Decorator {

	public BlueberriesOatmeal(Product product) {
		super(product);
	}

	@Override
	public String getDescription() {
		return product.getDescription() + ", blueberries";
	}

	@Override
	public BigDecimal price() {
		return product.price().add(new BigDecimal(2.5)).setScale(2);
	}

}
