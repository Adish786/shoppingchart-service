package com.common.retail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.retail.model.Shopping;
import com.common.retail.repository.ShoppingRepo;


@Service
public class ShoppingService {
	@Autowired
    private ShoppingRepo repository;

    public Shopping saveShopping(Shopping shopping) {
        return repository.save(shopping);
    }

    public List<Shopping> saveShoppings(List<Shopping> shoppings) {
        return repository.saveAll(shoppings);
    }

    public List<Shopping> getShoppings() {
        return repository.findAll();
    }

    public Shopping getShoppingById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Shopping getShoppingname(String name) {
        return repository.findByShoppingname(name);
    }

    public String deleteShopping(int id) {
        repository.deleteById(id);
        return "Shopping removed !! " + id;
    }
/*
    public Shopping updateShopping(Shopping shopping) {
    	Shopping existingShopping = repository.findById(shopping.getId()).orElse(null);
    	
    	existingShopping.setId(shopping.getId());
    	existingShopping.setShoppingname(shopping.getShoppingname());
    	existingShopping.setShoppingtype(shopping.getShoppingtype());
    	existingShopping.setTotalshopping(shopping.getTotalshopping());
        return repository.save(existingShopping);
    }
*/
   /*
    public Shopping updateShopping(Shopping shopping) {
    	Shopping outShopping = null;

        if (shopping.getShoppingname() != null && shopping.getShoppingtype() != null) {
        	Shopping existingShopping = repository.findById(shopping.getId()).orElse(null);
        	existingShopping.setShoppingname(shopping.getShoppingname());
        	existingShopping.setShoppingtype(shopping.getShoppingtype());
        	outShopping = repository.save(existingShopping);
        } else if (shopping.getShoppingtype() != null && shopping.getTotalshopping() > 0) {
        	Shopping existingShopping = repository.findById(shopping.getId()).orElse(null);
        	existingShopping.setShoppingtype(shopping.getShoppingtype());
            existingShopping.setTotalshopping(shopping.getTotalshopping());
            outShopping = repository.save(existingShopping);
        }else if (shopping.getShoppingname() != null && shopping.getTotalshopping() > 0) {
        	Shopping existingShopping = repository.findById(shopping.getId()).orElse(null);
        	existingShopping.setShoppingname(shopping.getShoppingname());
        	existingShopping.setTotalshopping(shopping.getTotalshopping());
        	outShopping = repository.save(existingShopping);
        }  else if (shopping.getShoppingtype() != null) {
        	Shopping existingShopping = repository.findById(shopping.getId()).orElse(null);
        	existingShopping.setShoppingtype(shopping.getShoppingtype());
        	outShopping = repository.save(existingShopping);
        }   else if (shopping.getShoppingname() != null) {
        	Shopping existingShopping = repository.findById(shopping.getId()).orElse(null);
        	existingShopping.setShoppingname(shopping.getShoppingname());
        	outShopping = repository.save(existingShopping);
        } else if (shopping.getTotalshopping() != 0.0) {
        	Shopping existingShopping = repository.findById(shopping.getId()).orElse(null);
        	existingShopping.setTotalshopping(shopping.getTotalshopping());
        	outShopping = repository.save(existingShopping);
        }
        return outShopping;
    }
    
    */

}
