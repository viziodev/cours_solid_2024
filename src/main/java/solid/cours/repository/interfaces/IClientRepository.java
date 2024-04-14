package solid.cours.repository.interfaces;

import java.util.List;

import solid.cours.entities.Client;

public interface IClientRepository {
   Client findByNumero(String numero) ;
   void save(Client client);
   List<Client> findByAll();
}
