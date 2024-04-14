package solid.cours.services;

import java.util.List;

import solid.cours.entities.Client;
import solid.cours.entities.Compte;
import solid.cours.enums.MobileMoney;
import solid.cours.repository.CompteRepository;

public class CompteService {
  CompteRepository compteRepository=new CompteRepository();
    public Compte getByNumero(String numero){
        return compteRepository.findByNumero(numero);
    }

    public void add(Compte compte,Client client){
        compte.setNumero("CPT00"+compte.getId());
        compte.setClient(client);
        compteRepository.save(compte);
     }

    public List<Compte> getAll(){
        return compteRepository.findByAll();
    }
    
    public void transfert(Compte compte ,Double mnt,String numero,MobileMoney mobileMoney){
        if(mnt<=0 ||mnt>compte.getSolde() ) throw new IllegalArgumentException("Le Montant Invalide");       
       if (mobileMoney==MobileMoney.OM) {
               Double mntFrais=MobileMoney.OM.getIndex()*mnt;
               compte.retrait(mnt+mntFrais);
               System.out.println("Transaction effectee  par OM sur le "+numero+" et le solde restant "+compte.getSolde());
        } else 
          if (mobileMoney==MobileMoney.WAVE) {
            Double mntFrais=MobileMoney.OM.getIndex()*mnt;
                compte.retrait(mnt+mntFrais);
               System.out.println("Transaction effectee  par OM sur le "+numero+" et le solde restant "+compte.getSolde());
        } else {
            throw new IllegalArgumentException("Le Type de Transaction n'existe pas");
        }
       }
}
