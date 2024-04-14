package solid.cours.services.tranfert;


import solid.cours.entities.CompteAvecRetrait;

public interface Tranfert {
     void  process(CompteAvecRetrait compte ,Double mnt,String numero);
} 