package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Test_Add_Product_To_Cart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

@Test
public void search_a_product(){
    homePage = new HomePage(driver);
    homePage.acceptCoockies();
    productsPage = new ProductsPage(driver);

    homePage.searchBox().search("Laptop");
    Assert.assertTrue(productsPage.isOnProductPage(),"Not on products page");
}
    @Test
    public void select_a_product(){
    productDetailPage = new ProductDetailPage(driver);
    productsPage.selectProduct(5);
    Assert.assertTrue(productDetailPage.isOnProductDetailPage(),"No on product detail page");

    }
    @Test
    public void add_product_to_cart(){
    productDetailPage.addToCart();
    Assert.assertTrue(homePage.isProductCountUp(),
            "Product count did not increase"); //ana sayfada ki sepetim butonundaki rakamın artıp artmadığını kontrol eder


    }
    @Test
    public void go_to_cart(){
    cartPage = new CartPage(driver);
    homePage.goToCart();
    Assert.assertTrue(cartPage.checkIfProductAdded(),
            "Product was not to cart");

    }
}
