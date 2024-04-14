package solid.cours.services.tranfert;

import solid.cours.entities.Compte;
import solid.cours.enums.MobileMoney;

public class TranfertKPay implements Tranfert {

    @Override
    public void process(Compte compte, Double mnt,String numero) {
        Double mntFrais=MobileMoney.KPAY.getIndex()*mnt;
        compte.retrait(mnt+mntFrais);
        System.out.println("Transaction effectee  par Kpay sur le "+numero+" et le solde restant "+compte.getSolde());
    }
    
}
