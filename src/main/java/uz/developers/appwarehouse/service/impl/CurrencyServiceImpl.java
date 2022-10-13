package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Currency;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.CurrencyRepository;
import uz.developers.appwarehouse.service.CurrencyService;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public List<Currency> getCurrencies() {
       return currencyRepository.findAll();
    }

    @Override
    public Currency getCurrency(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
           return optionalCurrency.get();
        }
        return new Currency();
    }

    @Override
    public Result addCurrencyService(Currency currency) {
        boolean existsByName = currencyRepository.existsByName(currency.getName());
        if (existsByName) {
            return new Result("There is such element",false);
        }
        currencyRepository.save(currency);
        return new Result("Currensy is saved",true);
    }

    @Override
    public Result editCurrency(Integer id, Currency currency) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isEmpty()) {
            return new Result("There is not such currency",false);
        }
        boolean existsByNameAndIdNot = currencyRepository.existsByNameAndIdNot(currency.getName(), id);
        if (existsByNameAndIdNot) {
            return new Result("There is such element",false);
        }
        Currency savedCurrency = optionalCurrency.get();
        savedCurrency.setName(currency.getName());
        currencyRepository.save(savedCurrency);
        return new Result("Currensy is edited",true);
    }

    @Override
    public Result deleteCurrency(Integer id) {
        currencyRepository.deleteById(id);
        return new Result("Currency is deleted",true);
    }
}
