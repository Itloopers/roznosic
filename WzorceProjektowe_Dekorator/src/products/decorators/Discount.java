package products.decorators;

import java.math.BigDecimal;

import abstractClasses.Decorator;
import abstractClasses.Product;

public class Discount extends Decorator {
	public int discount;

	public Discount(Product product,int discount) {
		super(product);
		this.discount = discount;
	}

	@Override
	public String getDescription() {
		return product.getDescription() + " with: " + discount + "% discount";
	}

	@Override
	public BigDecimal price() {
		BigDecimal rabate = product.price().divide(new BigDecimal(discount));
		return product.price().subtract(rabate );
	}

}
