package solid.cours.services.tranfert;

import solid.cours.entities.Compte;
import solid.cours.enums.MobileMoney;

public class TranfertWU implements Tranfert {

    @Override
    public void process(Compte compte, Double mnt, String numero) {
        Double mntFrais=MobileMoney.WU.getIndex()*mnt;
        compte.retrait(mnt+mntFrais);
        System.out.println("Transaction effectee  par Wave sur le "+numero+" et le solde restant "+compte.getSolde());
    }
    
}
