package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.appwarehouse.entity.Client;
import uz.developers.appwarehouse.entity.Currency;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.service.CurrencyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping
    public List<Currency> getCurrencies(){
        return currencyService.getCurrencies();
    }
    @GetMapping("/{id}")
    public Currency getCurrency(@PathVariable Integer id){
       return currencyService.getCurrency(id);
    }

    @PostMapping
    public Result addCurrency(@RequestBody Currency currency){
       return currencyService.addCurrencyService(currency);
    }

    @PutMapping("/{id}")
    public Result editCurrensy(@PathVariable Integer id, @RequestBody Currency currency){
       return currencyService.editCurrency(id,currency);
    }

    @DeleteMapping("/{id}")
    public Result deleteCurrency(@PathVariable Integer id){
       return currencyService.deleteCurrency(id);
    }

}
