package solid.cours.repository;

import java.util.ArrayList;
import java.util.List;

import solid.cours.entities.Client;

public class ClientRepository {
   
    List<Client> clients=new ArrayList<>();

    public Client findByNumero(String numero){
        return clients.stream().filter(c->c.getNumero().compareToIgnoreCase(numero)==0).findFirst().orElse(null);
    }

    public void save(Client client){
         clients.add(client);
    }

    public List<Client> findByAll(){
        return clients;
    }
}
