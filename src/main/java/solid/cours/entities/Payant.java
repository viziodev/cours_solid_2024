package solid.cours.entities;

import solid.cours.enums.TypeCompte;

public class Payant extends CompteAvecRetrait {
     //Payant
      private  final Double Frais=0.05; 

      public Payant() {
        type=TypeCompte.EPARGNE;
      }
     @Override
     public void depot(Double mnt){
        if(mnt<=0) throw new IllegalArgumentException("Le Montant est positif");
        Double mntFrais=mnt*Frais;
        solde+= mnt-mntFrais;   
       }
       @Override
       public void retrait(Double mnt){
           if(mnt<=0 || mnt>solde ) throw new IllegalArgumentException("Le Montant Invalide");
           Double mntFrais=mnt*Frais;
           solde-= mnt+mntFrais; 
        }

        
}
