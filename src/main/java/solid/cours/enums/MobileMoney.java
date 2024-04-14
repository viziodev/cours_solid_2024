package solid.cours.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum MobileMoney {
    OM(0.008),WAVE(0.01);
   public static MobileMoney getValue(int index) {
    return MobileMoney.values()[index-1];
    }

     private final double index; 
}
