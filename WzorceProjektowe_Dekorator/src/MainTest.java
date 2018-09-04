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
		assertEquals(new BigDecimal(4.5).setScale(2), oatmeal.price());
	}

	@Test
	void blueberriesOatmealPrice() {
		oatmeal = new BlueberriesOatmeal(oatmeal);
		assertTrue(new BigDecimal(7.0).compareTo(oatmeal.price())==0);
	}

	@Test
	void blueberriesRaisinsOatmealPrice() {
		oatmeal = new BlueberriesOatmeal(oatmeal);
		oatmeal = new RaisinsOatmeal(oatmeal);
		assertEquals(new BigDecimal(10).setScale(2), oatmeal.price());
	}

	@Test
	void blueberriesRaisinsBananaOatmealPrice() {
		oatmeal = new BlueberriesOatmeal(oatmeal);
		oatmeal = new RaisinsOatmeal(oatmeal);
		oatmeal = new BananaOatmeal(oatmeal);
		assertEquals(new BigDecimal(13.2).setScale(2,6), oatmeal.price());
	}
	@Test
	void mealDiscount10Percent() {
		int discount = 10;
		oatmeal = new BlueberriesOatmeal(oatmeal);
		oatmeal = new RaisinsOatmeal(oatmeal);
		oatmeal = new BananaOatmeal(oatmeal);
		oatmeal = new Discount(oatmeal, discount);
		assertEquals(new BigDecimal(11.88).setScale(2,6), oatmeal.price());
	}

}
