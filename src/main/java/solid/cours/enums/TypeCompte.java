package solid.cours.enums;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum TypeCompte {
    EPARGNE(1)
    ,PAYANT(2),
     SIMPLE(3);
    private final long index;
    public static TypeCompte getValue(int index) {
            return TypeCompte.values()[index-1];
    }
}
