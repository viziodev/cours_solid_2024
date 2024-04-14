package solid.cours.repository.json;

import java.util.List;

import solid.cours.entities.Client;
import solid.cours.repository.interfaces.IClientRepository;

public class ClientRepository implements IClientRepository{

    @Override
    public Client findByNumero(String numero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNumero'");
    }

    @Override
    public void save(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Client> findByAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAll'");
    }
    
}
