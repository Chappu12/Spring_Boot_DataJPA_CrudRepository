package com.example.runner;

import com.example.entity.Product;
import com.example.exception.ProductNotFoundException;
import com.example.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private ProductRepository proRepo;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(proRepo.getClass().getName());
        Product p1 = new Product(4000.0,"Laptop", 10);
        Product p2 = new Product(5000.0,"Mouse", 11);
        Product p3 = new Product(6000.0,"Keyboard", 12);
        Product p4 = new Product(6500.0,"JoyStick", 13);
//        proRepo.save(p1);
//        proRepo.save(p2);
//        proRepo.save(p3);
        proRepo.saveAll(Arrays.asList(p1, p2, p3, p4));

        Iterable<Product> data = proRepo.findAll();

//        for(Product pob : data){
//            System.out.println(pob);
//        }
        data.forEach(System.out::println);

        System.out.println(proRepo.existsById(12));
        System.out.println(proRepo.existsById(69));

        System.out.println("Number of rows present in Database : "+proRepo.count());

        //fetch one row by ID
        Optional<Product> opt = proRepo.findById(15);
        if(opt.isPresent()){
            Product p = opt.get();
            System.out.println(p);
        }
        else {
            System.out.println("Product not found...");
        }

        //Mostly used structure
        Product p = proRepo.findById(11)
                .orElseThrow(() -> new ProductNotFoundException("Not Exist"));
        System.out.println(p);

        Iterable<Product> list = proRepo.findAllById(Arrays.asList(11, 12, 15));
        list.forEach(System.out::println);
    }
}
