package solid.cours.entities;


import lombok.Getter;
import lombok.Setter;
import solid.cours.enums.MobileMoney;
import solid.cours.enums.TypeCompte;

@Getter
@Setter
public class Compte {
    private static Long nbreCompte=0L;
    private Long id;
    private String numero;
    private Double solde; 
    private TypeCompte type;
    private Boolean locked;
    //Epargne
    private  final Double taux=0.07;
    //Payant
    private  final Double Frais=0.05;
    //Simple
    private final Double decouvert=50000D;

    private final Double FraisOM=0.008;
    private final Double FraisWave=0.01;
 

    private Client client;
    

    @Override
    public String toString() {
        System.out.println("-------------------------------------------------------------------------------");
        return " Client= " + client.getNomComplet()+"\nCompte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", type=" + type.name()  + "]";
    }

    public Compte() {
        id=++nbreCompte;

    }

    public void depot(Double mnt){
        if(mnt<=0) throw new IllegalArgumentException("Le Montant est positif");
        if (type==TypeCompte.EPARGNE) {
            Double mntTaux=mnt*taux;
            solde+= mnt+mntTaux;  
        }
        else if (type==TypeCompte.SIMPLE) {
            solde+= mnt;  
        } else if(type==TypeCompte.PAYANT)  {
            Double mntFrais=mnt*Frais;
            solde+= mnt-mntFrais; 
        }else{
            throw new IllegalArgumentException("Le Type de Compte n'existe pas");
        }
    
       }

    public void retrait(Double mnt){
          if(mnt<=0 ) throw new IllegalArgumentException("Le Montant Invalide");
            if (type==TypeCompte.EPARGNE) {
              throw new IllegalArgumentException("Pas de Retrait sur ce compte");
            }
           if(mnt<=solde+decouvert){
            if(type==TypeCompte.SIMPLE)  {
                  solde-=mnt; 
            }else{
               if(mnt<=solde){
                if(type==TypeCompte.PAYANT)  {
                    Double mntFrais=mnt*Frais;
                    solde-= mnt+mntFrais; 
                }else{
                  throw new IllegalArgumentException("Le Type de Compte n'existe pas");
                }
               }
            }
          }
        
     }
   
      public void transfert(Double mnt,String numero,MobileMoney mobileMoney){
        if(mnt<=0 ||mnt>solde ) throw new IllegalArgumentException("Le Montant Invalide");       
        if (type==TypeCompte.EPARGNE)  throw new IllegalArgumentException("Pas de Retrait sur ce compte");
       if (mobileMoney==MobileMoney.OM) {
               Double mntFrais=FraisOM*mnt;
              this.retrait(mnt+mntFrais);
            System.out.println("Transaction effectee  par OM sur le "+numero+" et le solde restant "+solde);
        } else if (mobileMoney==MobileMoney.WAVE) {
            Double mntFrais=FraisWave*mnt;
            this.retrait(mnt+mntFrais);
            System.out.println("Transaction effectee  par OM sur le "+numero+" et le solde restant "+solde);
        } else {
            throw new IllegalArgumentException("Le Type de Transaction n'existe pas");
        }
       }
}
