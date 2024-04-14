package solid.cours.entities;


import solid.cours.enums.TypeCompte;

public class Epargne extends Compte {
     //Epargne
     private  final Double taux=0.07;
     @Override
     public void depot(Double mnt){
        if(mnt<=0) throw new IllegalArgumentException("Le Montant est positif");
        Double mntTaux=mnt*taux;
        solde+= mnt+mntTaux;  
        
       }
       
       public Epargne() {
        type=TypeCompte.EPARGNE;
      }      
}
