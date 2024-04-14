package solid.cours.services;

import java.util.List;

import lombok.RequiredArgsConstructor;
import solid.cours.entities.Client;
import solid.cours.repository.interfaces.IClientRepository;

@RequiredArgsConstructor
public class ClientService {
    private final IClientRepository clientRepository;

    public Client getByNumero(String numero){
        return clientRepository.findByNumero(numero);
    }

    public void add(Client client){
        client.setNumero("CL00"+client.getId());
        clientRepository.save(client);
     }

    public List<Client> getAll(){
        return clientRepository.findByAll();
    }
}
