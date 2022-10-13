package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.appwarehouse.entity.Client;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> getClients(){
       return clientService.getClients();
    }
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Integer id){
       return clientService.getClient(id);
    }

    @PostMapping
    public Result addClientController(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    public Result editClient(@PathVariable Integer id,@RequestBody Client client){
        return clientService.editClient(id,client);
    }
    @DeleteMapping("/{id}")
    public Result deleteClient(@PathVariable Integer id){
       return clientService.deleteClient(id);
    }

}
