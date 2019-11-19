package pro.antonshu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pro.antonshu.spring.config.AppConfig;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart myCart = context.getBean("cart", Cart.class);

        myCart.printContent();
        myCart.addById(1);
        myCart.addById(3);
        myCart.addById(3);
        myCart.printContent();
        myCart.delById(3);
        myCart.printContent();

        context.close();
    }
}
