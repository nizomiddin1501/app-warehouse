package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Client;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface ClientService {

    //get clients
    List<Client> getClients();

    //get client
    Client getClient(Integer id);

    //post
    Result addClient(Client client);

    //put
    Result editClient(Integer id, Client client);

    //delete
    Result deleteClient(Integer id);

}
