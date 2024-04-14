package solid.cours;



import java.util.Scanner;

import solid.cours.entities.Client;
import solid.cours.entities.Compte;
import solid.cours.entities.CompteAvecRetrait;
import solid.cours.entities.Epargne;
import solid.cours.entities.Payant;
import solid.cours.entities.Simple;
import solid.cours.enums.MobileMoney;
import solid.cours.services.ClientService;
import solid.cours.services.CompteService;
import solid.cours.services.tranfert.Tranfert;
import solid.cours.services.tranfert.TranfertKPay;
import solid.cours.services.tranfert.TranfertOM;
import solid.cours.services.tranfert.TranfertWave;


public class Main {
  
    public static void main(String[] args) {
        
        ClientService clientService=new ClientService();
        CompteService compteService =new CompteService();
         Scanner scanner=new Scanner(System.in);
         int choix;
         Compte compte;
         Client client;
         
         do {
            System.out.println("1-Ajouter un Client");
            System.out.println("2-Ajouter un Compte");
            System.out.println("3-Lister Les Compte");
            System.out.println("4-Faire une Transaction");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1->{
                   client=new Client(); 
                   System.out.println("Entrer le Nom et le Prenpm");
                   client.setNomComplet(scanner.nextLine());
                   clientService.add(client);
                   System.out.println("Liste des Clients");
                   clientService.getAll().forEach(System.out::println);
                }
                case 2->{
                    
                     System.out.println("Entrer le Numero du client");
                     String num=scanner.nextLine();
                     client=clientService.getByNumero(num);
                    if (client==null) {
                        System.out.println("Ce Client n'existe pas"); 
                     } else {
                        System.out.println("Entrer le Type du compte");
                        System.out.println("1-Epargne");
                        System.out.println("2-Payant");
                        System.out.println("3-Simple");
                        int typeCompte=scanner.nextInt();
                       if(typeCompte==1){
                          compte=new Epargne();
                        }else if(typeCompte==2){
                          compte=new Payant();
                        }else{
                             compte=new Simple();
                        }
                        System.out.println("Entrer le Solde");
                        compte.setSolde(scanner.nextDouble());
                      
                        compteService.add(compte,client);

                    }
                  }
                    
                  case 3->{
                  
                    compteService.getAll().forEach(System.out::println);
                  }
                  case 4->{
                    System.out.println("Entrer le Numero du Compte");
                    String numero=scanner.nextLine();
                     compte=compteService.getByNumero(numero);
                    if (compte==null) {
                        System.out.println("Ce Compte n'existe pas");
                    } else {
                        System.out.println("Entrer le Montant");
                        Double mnt=scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Entrer l'operation");
                        System.out.println("1-Depot");
                        System.out.println("2-Retrait");
                        System.out.println("3-Transfert");
                        int type=scanner.nextInt();
                        if (type==1) {
                            System.out.println("Avant");
                            System.out.println(compte);
                            compte.depot(mnt); 
                            System.out.println("Apres"); 
                            System.out.println(compte);   
                        } else if(type==2) {
                            if(compte instanceof CompteAvecRetrait ){
                                System.out.println("Avant");
                                System.out.println(compte);
                                ((CompteAvecRetrait) compte).retrait(mnt);
                                System.out.println("Apres"); 
                                System.out.println(compte); 
                             }else{
                                System.out.println("retrait impossible");
                             }
                          
                          
                        }else{
                             scanner.nextLine();
                             System.out.println("Entrer le Numero du Telephone");
                             String tel=scanner.nextLine();
                             System.out.println("Entrer Mobile Money ");
                             System.out.println("1-Wave");
                             System.out.println("2-OM");
                             System.out.println("3-Kpay");
                            type=scanner.nextInt();
                            Tranfert mobileTranfert;
                            if(compte instanceof CompteAvecRetrait ){
                             if (type==1) {
                                mobileTranfert=new TranfertWave();   
                             }else{
                                if(type==2){
                                    mobileTranfert=new TranfertOM();    
                                }else{
                                        mobileTranfert=new TranfertKPay();       
                                }
                            }
                            compteService.transfert((CompteAvecRetrait) compte,mnt,tel, mobileTranfert);
                          }else{
                              System.out.println("retrait impossible");
                          }
                        }
                    }
                    
                  }
            
                default ->{

                }
            }
         } while (choix!=5);
         scanner.close();

    }
}