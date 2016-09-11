package org.itstep.prokopchik.cricova;

public enum WineCollectionEnum {
    //('KRUGHEVA','CRAMELE','PAPIRUS','STAROCRICOVSKOE','NONE')
    KRUGHEVA("Krugheva"),
    CRAMELE("Cramele"),
    PAPIRUS("Papirus"),
    PREMIERE("Premiere"),
    NONE("-"),
    STAROCRICOVSKOE("Starocricovskoe");


    private String value;

    private WineCollectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
