package pro.antonshu.spring.repository;

import org.springframework.stereotype.Repository;
import pro.antonshu.spring.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<Product>();
        productList.add(new Product(1, "Milk", new BigDecimal(50)));
        productList.add(new Product(2, "Water", new BigDecimal(30)));
        productList.add(new Product(3, "Bread", new BigDecimal(40)));
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Product getProductById(long id) {
        Product product = null;
        for (Product product1 : productList) {
            if (product1.getId()==id) {
                product = product1;
            }
        }
        return product;
    }
}
