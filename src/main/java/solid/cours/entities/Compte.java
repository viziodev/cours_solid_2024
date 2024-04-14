package solid.cours.entities;


import lombok.Getter;
import lombok.Setter;
import solid.cours.enums.TypeCompte;

@Getter
@Setter
public  abstract class Compte implements ICompteDepot {
    private static Long nbreCompte=0L;
    protected Long id;
    protected String numero;
    protected Double solde; 
    protected TypeCompte type;
    protected Boolean locked;
    protected Client client;
  
    @Override
    public String toString() {
        System.out.println("-------------------------------------------------------------------------------");
        return " Client= " + client.getNomComplet()+"\nCompte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", type=" + type.name()  + "]";
    }

    public Compte() {
        id=++nbreCompte;

    }
   
    
   
}
