package solid.cours.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum MobileMoney {
    OM(0.008),
    WAVE(0.01),
    WU(0.02),
    KPAY(0.0);
   public static MobileMoney getValue(int index) {
    return MobileMoney.values()[index-1];
    }

     private final double index; 
}
