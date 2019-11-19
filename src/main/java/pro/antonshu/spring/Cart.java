package pro.antonshu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pro.antonshu.spring.service.ProductService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Cart {

    private ProductService productService;
    private List<Product> cartContent;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    private void initCart() {
        cartContent = new ArrayList<Product>();
    }

    public void addById(long productId) {
        cartContent.add(productService.getProductById(productId));
    }

    public void delById(long productId) {
        cartContent.remove(productService.getProductById(productId));
    }

    public void printContent() {
        BigDecimal totalCost = new BigDecimal(0);
        if (!cartContent.isEmpty()) {
            for (Product product : cartContent) {
                System.out.println(product);
                totalCost = totalCost.add(product.getPrice());
            }
        } else {
            System.out.println("Cart is empty");
        }
        System.out.printf("Total Cost = %s%n", totalCost.toString());
        System.out.println("------------------------------");
    }
}
