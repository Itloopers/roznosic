package products.decorators;

import java.math.BigDecimal;
import abstractClasses.Decorator;
import abstractClasses.Product;

public class BananaOatmeal extends Decorator {

	public BananaOatmeal(Product product) {
		super(product);
	}

	@Override
	public String getDescription() {
		return product.getDescription() + ", banana";
	}

	@Override
	public BigDecimal price() {
		return product.price().add(new BigDecimal(3.20)).setScale(2,6);
	}

}
