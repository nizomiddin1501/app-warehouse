package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Client;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.ClientRepository;
import uz.developers.appwarehouse.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
       return clientRepository.findAll();
    }

    @Override
    public Client getClient(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElseGet(Client::new);
    }

    @Override
    public Result addClient(Client client) {
        boolean existsByPhoneNumber = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (existsByPhoneNumber) {
            return new Result("There is such client",false);
        }
        clientRepository.save(client);
        return new Result("Client is added",true);

    }

    @Override
    public Result editClient(Integer id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty()) {
            return new Result("Such client not found",false);
        }

        boolean existsByPhoneNumber = clientRepository.existsByPhoneNumberAndIdNot(client.getPhoneNumber(),id);
        if (existsByPhoneNumber) {
            return new Result("There is such element",false);
        }

        Client savedClient = optionalClient.get();
        savedClient.setName(client.getName());
        savedClient.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(savedClient);
        return new Result("Client is edited",true);
    }

    @Override
    public Result deleteClient(Integer id) {
        clientRepository.deleteById(id);
        return new Result("Client is deleted",true);
    }
}
