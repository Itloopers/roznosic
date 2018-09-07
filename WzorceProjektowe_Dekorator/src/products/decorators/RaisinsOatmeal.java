package products.decorators;

import java.math.BigDecimal;

import abstractClasses.Decorator;
import abstractClasses.Product;

public class RaisinsOatmeal extends Decorator {

	public RaisinsOatmeal(Product product) {
		super(product);
	}

	@Override
	public String getDescription() {
		return product.getDescription() + ", raisins";
	}

	@Override
	public BigDecimal price() {
		return product.price().add(new BigDecimal("3"));
	}

}
