package solid.cours.services.tranfert;


import solid.cours.entities.CompteAvecRetrait;
import solid.cours.enums.MobileMoney;

public class TranfertOM implements Tranfert {

    @Override
    public void process(CompteAvecRetrait compte, Double mnt,String numero) {
        Double mntFrais=MobileMoney.OM.getIndex()*mnt;
        compte.retrait(mnt+mntFrais);
        System.out.println("Transaction effectee  par OM sur le "+numero+" et le solde restant "+compte.getSolde());
    }
    
}
