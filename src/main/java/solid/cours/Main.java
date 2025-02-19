package solid.cours;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import solid.cours.entities.Client;
import solid.cours.entities.Compte;
import solid.cours.enums.TypeCompte;


public class Main {
  
    public static void main(String[] args) {
         List<Compte> comptes=new ArrayList<>();
         List<Client> clients=new ArrayList<>();
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
                   client.setNumero("CL00"+client.getId());
                   clients.add(client);
                    System.out.println("Liste des Clients");
                     clients.forEach(System.out::println);
                }
                case 2->{
                    
                     System.out.println("Entrer le Numero");
                     String num=scanner.nextLine();
                     client=clients.stream().filter(c->c.getNumero().compareToIgnoreCase(num)==0).findFirst().orElse(null);
                    if (client==null) {
                        System.out.println("Ce Client n'existe pas"); 
                     } else {
                        compte=new Compte();
                        System.out.println("Entrer le Solde");
                        compte.setSolde(scanner.nextDouble());
                        System.out.println("Entrer le Type du compte");
                        System.out.println("1-Epargne");
                        System.out.println("2-Payant");
                        System.out.println("3-Simple");
                        compte.setType(TypeCompte.getValue(scanner.nextInt()));
                        compte.setNumero("CPT00"+compte.getId());
                        compte.setClient(client);
                        comptes.add(compte);

                    }
                  }
                    
                  case 3->{
                    comptes.forEach(System.out::println);
                  }
                  case 4->{
                    System.out.println("Entrer le Numero");
                    String numero=scanner.nextLine();
                     compte=comptes.stream().filter(c->c.getNumero().compareToIgnoreCase(numero)==0).findFirst().orElse(null);
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
                        } else {
                            System.out.println("Avant");
                            System.out.println(compte);
                            compte.retrait(mnt);
                            System.out.println("Apres"); 
                            System.out.println(compte); 
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