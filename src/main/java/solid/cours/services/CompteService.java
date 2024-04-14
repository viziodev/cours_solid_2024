package solid.cours.services;

import java.util.List;

import solid.cours.entities.Client;
import solid.cours.entities.Compte;
import solid.cours.repository.interfaces.IClientRepository;
import solid.cours.repository.interfaces.ICompteRepository;
import solid.cours.repository.list.CompteRepository;
import solid.cours.services.tranfert.Tranfert;

public class CompteService {
     ICompteRepository compteRepository=new CompteRepository();
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
    
    public void transfert(Compte compte ,Double mnt,String numero,Tranfert mobileTranfert){
        if(mnt<=0 ||mnt>compte.getSolde() ) throw new IllegalArgumentException("Le Montant Invalide");       
        mobileTranfert.process(compte,mnt,numero);
    }
}
