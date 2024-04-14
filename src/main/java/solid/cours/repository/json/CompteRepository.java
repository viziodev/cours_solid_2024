package solid.cours.repository.json;

import java.util.List;

import solid.cours.entities.Compte;

import solid.cours.repository.interfaces.ICompteRepository;

public class CompteRepository implements ICompteRepository {

    @Override
    public Compte findByNumero(String numero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNumero'");
    }

    @Override
    public void save(Compte client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Compte> findByAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAll'");
    }
    
}
