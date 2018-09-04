package abstractClasses;

import java.math.BigDecimal;

public abstract class Product {
	protected String description;

	public String getDescription() {
		return description;
	}

	public abstract BigDecimal price();

	@Override
	public String toString() {
		return "Product: " + getDescription() + ", price:" + price();
	}

}
