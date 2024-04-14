package solid.cours.entities;

import solid.cours.enums.TypeCompte;

public class Simple extends CompteAvecRetrait {
    //Simple
    private final Double decouvert=50000D;
   
    public Simple() {
        type=TypeCompte.SIMPLE;
      }
    @Override
    public void depot(Double mnt) {
        if(mnt<=0) throw new IllegalArgumentException("Le Montant est positif");
        solde+= mnt;  
    } 
    @Override
    public void retrait(Double mnt){
        if(mnt<=0 || mnt>solde+decouvert ) throw new IllegalArgumentException("Le Montant Invalide");
        solde-=mnt; 
        }
        
    
}
