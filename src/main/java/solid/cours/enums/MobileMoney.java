package solid.cours.enums;



public enum MobileMoney {
    OM,WAVE;
   public static MobileMoney getValue(int index) {
    return MobileMoney.values()[index-1];
}
}
