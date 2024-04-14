package solid.cours.services.tranfert;

import solid.cours.entities.Compte;

public interface Tranfert {
     void  process(Compte compte ,Double mnt,String numero);
} 