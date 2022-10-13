package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Currency;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {

    //get all
    List<Currency> getCurrencies();

    //get by id
    Currency getCurrency(Integer id);

    //post
    Result addCurrencyService(Currency currency);

    //put
    Result editCurrency(Integer id, Currency currency);

    //delete
    Result deleteCurrency(Integer id);
}
