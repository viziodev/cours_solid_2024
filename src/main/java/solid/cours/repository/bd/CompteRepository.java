package solid.cours.repository.bd;


import java.util.List;

import solid.cours.entities.Compte;
import solid.cours.repository.interfaces.ICompteRepository;
import solid.cours.repository.interfaces.ICompteRepositotyBd;

public class CompteRepository implements ICompteRepository,ICompteRepositotyBd {
   

    @Override
   public Compte findByNumero(String numero){
    System.out.println("Recheche dans BD");
    return null;
    }

    @Override
    public void save(Compte client){
        System.out.println("Insert dans BD");
   }

   @Override
    public List<Compte> findByAll(){
        System.out.println("Recheche All dans BD");
      return null;
    }

@Override
public List<Compte> findByClient(String numeroClient) {
    System.out.println("Recheche des compte d'un client dans BD");
      return null;
}

}
