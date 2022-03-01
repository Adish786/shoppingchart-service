package com.common.retail.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.common.retail.model.Shopping;
import com.common.retail.service.ShoppingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class ShoppingController {

	@Autowired
    private ShoppingService service;
	
	@Autowired
	private RestTemplate restTemplate;

    @PostMapping("/addShopping")
    public Shopping addShopping(@RequestBody Shopping shopping) {
        return service.saveShopping(shopping);
    }

    @PostMapping("/addShoppings")
    public List<Shopping> addShoppings(@RequestBody List<Shopping> shoppings) {
        return service.saveShoppings(shoppings);
    }

    @GetMapping("/shoppings")
    public List<Shopping> findAllShoppings() {
        return service.getShoppings();
    }
    
    @HystrixCommand(fallbackMethod = "welcomeFlaBackMethod")
    @GetMapping("/shoppingwelcome")
    public String Welcome() {
    	String url="http://PRODUCT-SERVICE/welcome";
    	return restTemplate.getForObject(url, String.class);
    }
    
    //When welcome getapi are down then call the welcomeFlaBackMethod and return the value
    public String welcomeFlaBackMethod() {
    	return "Welcome To welcomeFlaBackMethod";
    }
    

    @GetMapping("/shoppingById/{id}")
    public Shopping findShoppingById(@PathVariable int id) {
        return service.getShoppingById(id);
    }

    @GetMapping("/shopping/{name}")
    public Shopping findShoppingname(@PathVariable String name) {
        return service.getShoppingname(name);
    }

    @PutMapping("/update")
    public Shopping updateShopping(@RequestBody Shopping shopping) {
        return service.updateShopping(shopping);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteShopping(@PathVariable int id) {
        return service.deleteShopping(id);
    }

}
