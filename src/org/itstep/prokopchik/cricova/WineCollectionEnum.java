package org.itstep.prokopchik.cricova;

public enum WineCollectionEnum {

    KRUGHEVA_COLLECTION("krughevaCollection"),
    CRAMELE_COLLECTION("crameleCollection"),
    PAPIRUS_COLLECTION("papirusCollection"),
    STAROCRICOVSKOE_COLLECTION("starocricovskoeCollection");


    private String value;

    private WineCollectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
