package solid.cours.repository.interfaces;

import java.util.List;

import solid.cours.entities.Compte;

public interface ICompteRepositotyBd {
    List<Compte> findByClient(String numeroClient);
    
} 