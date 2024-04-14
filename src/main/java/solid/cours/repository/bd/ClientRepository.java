package solid.cours.repository.bd;

import java.util.List;

import solid.cours.entities.Client;
import solid.cours.repository.interfaces.IClientRepository;

public class ClientRepository implements IClientRepository  {

    @Override
    public Client findByNumero(String numero) {
        System.out.println("Recherche dans une BD");
        return null;
    }

    @Override
    public void save(Client client) {
        System.out.println("Insert dans une BD");
      
    }

    @Override
    public List<Client> findByAll() {
        System.out.println("Recherche All  dans une BD");
        return null;
    }
    
}
