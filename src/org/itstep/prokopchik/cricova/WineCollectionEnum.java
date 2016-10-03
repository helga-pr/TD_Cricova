package org.itstep.prokopchik.cricova;

public enum WineCollectionEnum {
    //('KRUGHEVA','CRAMELE','PAPIRUS','STAROCRICOVSKOE','NONE')
    KRUGHEVA("Krugheva"),
    CRAMELE("Cramele"),
    PAPIRUS("Papirus"),
    PREMIERE("Premiere"),
    NONE("none"),
    STAROCRICOVSKOE("Starocricovskoe");


    private String value;

    private WineCollectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getConstant(String value) {

        for (WineCollectionEnum val : WineCollectionEnum.values()) {
            //System.out.println("=> " + val.toString() + " -> " + val.getValue());

            if (val.getValue().equals(value)) {
                return val.toString();
            }
        }
        return null;
    }
}
