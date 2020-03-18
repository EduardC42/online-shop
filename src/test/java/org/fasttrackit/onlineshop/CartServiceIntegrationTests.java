package org.fasttrackit.onlineshop;
import org.fasttrackit.onlineshop.domain.Customer;
import org.fasttrackit.onlineshop.domain.Product;
import org.fasttrackit.onlineshop.service.CartService;
import org.fasttrackit.onlineshop.steps.CustomerTestSteps;
import org.fasttrackit.onlineshop.steps.ProductTestSteps;
import org.fasttrackit.onlineshop.transfer.cart.AddProductToCartRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class CartServiceIntegrationTests {
    @Autowired
    private CartService cartService;


    @Autowired
    private CustomerTestSteps customerTestSteps;
    @Autowired
    private ProductTestSteps productTestSteps;

    @Test
    void addProductsToCart_whenNewCart_thenCartIsCreated() {
        Customer customer = customerTestSteps.createCustomer();
        Product product = productTestSteps.createProduct();
        AddProductToCartRequest cartRequest = new AddProductToCartRequest();
        cartRequest.setCustomerId(customer.getId());
        cartRequest.setProductIds(Collections.singletonList(product.getId()));
        cartService.addProductsToCart(cartRequest);

    }
}
