package abstractClasses;

public abstract class Decorator extends Product {
	protected Product product;

	public Decorator(Product product) {
		this.product = product;
	}

	@Override
	public abstract String getDescription();

}
