package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.modules.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {

    @Autowired
    CoinRepository cnrepos;


    //http://localhost:2019/total <- print contents to console and return OK
    /*
    1 Quarter
    1 Dime
    5 Dollars
    3 Nickels
    7 Dimes
    1 Dollar
    10 Pennies
    The piggy bank holds 7.3
    */
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listTotalCoins() {

        double totalCoins = 0;
        List<Coin> myList = new ArrayList<>();
        cnrepos.findAll().iterator().forEachRemaining(myList::add);
        for (Coin c : myList) {
            if (c.getQuantity() > 1) {
                System.out.println(c.getQuantity() + " " + c.getNamePlural());
            } else {
                System.out.println(c.getQuantity() + " " + c.getName());
            }
            totalCoins = totalCoins + c.getValue() * c.getQuantity();

        }





        System.out.println("The piggy bank holds " + totalCoins);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
