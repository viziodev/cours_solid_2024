package solid.cours.repository;

import java.util.ArrayList;
import java.util.List;

import solid.cours.entities.Compte;

public class CompteRepository {
    List<Compte> comptes=new ArrayList<>();

   public Compte findByNumero(String numero){
        return comptes.stream().filter(c->c.getNumero().compareToIgnoreCase(numero)==0).findFirst().orElse(null);
    }

    public void save(Compte client){
        comptes.add(client);
   }

    public List<Compte> findByAll(){
    return comptes;
    }
}
