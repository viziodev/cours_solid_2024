package solid.cours.repository.list;

import java.util.ArrayList;
import java.util.List;

import solid.cours.entities.Client;
import solid.cours.repository.interfaces.IClientRepository;

public class ClientRepository  implements IClientRepository{
   
    List<Client> clients=new ArrayList<>();


    @Override
    public Client findByNumero(String numero){
        return clients.stream().filter(c->c.getNumero().compareToIgnoreCase(numero)==0).findFirst().orElse(null);
    }
    @Override
    public void save(Client client){
       
         clients.add(client);
    }
    @Override
    public List<Client> findByAll(){
        return clients;
    }
}
