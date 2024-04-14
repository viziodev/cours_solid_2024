package solid.cours.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
    private Long id;
    private static Long nbreCompte=0L;
    private String numero;
    private String nomComplet;

    public Client() {
        id=++nbreCompte;

    }

    @Override
    public String toString() {
        System.out.println("----------------------------------------------------------------");
        return "Client [id=" + id + ", numero=" + numero + ", nomComplet=" + nomComplet + "]";
    }
}
