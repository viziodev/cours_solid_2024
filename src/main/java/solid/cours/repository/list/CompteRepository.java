package solid.cours.repository.list;

import java.util.ArrayList;
import java.util.List;

import solid.cours.entities.Compte;
import solid.cours.repository.interfaces.ICompteRepository;

public class CompteRepository implements ICompteRepository {
    List<Compte> comptes=new ArrayList<>();

    @Override
   public Compte findByNumero(String numero){
        return comptes.stream().filter(c->c.getNumero().compareToIgnoreCase(numero)==0).findFirst().orElse(null);
    }

    @Override
    public void save(Compte client){
        comptes.add(client);
   }

   @Override
    public List<Compte> findByAll(){
    return comptes;
    }

    
}
