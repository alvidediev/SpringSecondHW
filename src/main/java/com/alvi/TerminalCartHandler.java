package com.alvi;

import com.alvi.entity.Cart;
import com.alvi.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("com.alvi")
public class TerminalCartHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new AnnotationConfigApplicationContext(TerminalCartHandler.class);
        ProductRepository product = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);
        System.out.println("Содержимое корзины");
        System.out.println(product.findAll());
        while (true) {
            System.out.println("Хотите добавить в корзину что то?\nВведите Да или Нет");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals("Да")) {
                System.out.print("Введите id товара");
                System.out.println();
                int itemId = scanner.nextInt();
                product.addToCart(itemId);
            }
            if (userAnswer.equals("Нет")) {
                break;
            }
        }
    }
}
