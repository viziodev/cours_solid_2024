package solid.cours.repository.interfaces;

import java.util.List;

import solid.cours.entities.Compte;

public interface ICompteRepository {
    Compte findByNumero(String numero) ;
    void save(Compte client);
    List<Compte> findByAll();
  
}
