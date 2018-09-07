import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import abstractClasses.Product;
import products.Oatmeal;
import products.decorators.BananaOatmeal;
import products.decorators.BlueberriesOatmeal;
import products.decorators.Discount;
import products.decorators.RaisinsOatmeal;

class MainTest {
	Product oatmeal;

	@AfterEach
	void setUp() throws Exception {
		System.out.println(oatmeal);
	}

	@BeforeEach
	void setUpOatmeal() {
		oatmeal = new Oatmeal();
	}

	@Test
	void oatmealPrice() {
		assertTrue(new BigDecimal(4.5).compareTo(oatmeal.price()) == 0);
	}

	@Test
	void blueberriesOatmealPrice() {
		oatmeal = new BlueberriesOatmeal(oatmeal);
		assertTrue(new BigDecimal(7.0).compareTo(oatmeal.price()) == 0);
	}

	@Test
	void blueberriesRaisinsOatmealPrice() {
		oatmeal = new BlueberriesOatmeal(oatmeal);
		oatmeal = new RaisinsOatmeal(oatmeal);
		assertTrue(new BigDecimal(10).compareTo(oatmeal.price()) == 0);
	}

	@Test
	void blueberriesRaisinsBananaOatmealPrice() {
		oatmeal = new BlueberriesOatmeal(oatmeal);
		oatmeal = new RaisinsOatmeal(oatmeal);
		oatmeal = new BananaOatmeal(oatmeal);
		assertTrue(BigDecimal.valueOf(13.2).compareTo(oatmeal.price()) == 0);
	}

	@Test
	void mealDiscount10Percent() {
		int discount = 10;
		oatmeal = new BlueberriesOatmeal(oatmeal);
		oatmeal = new RaisinsOatmeal(oatmeal);
		oatmeal = new BananaOatmeal(oatmeal);
		oatmeal = new Discount(oatmeal, discount);
		assertTrue(new BigDecimal("11.88").compareTo(oatmeal.price()) == 0);
	}

}
