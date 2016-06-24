package org.itstep.prokopchik.cricova;

public enum WineCollectionEnum {

    KRUGHEVA_COLLECTION("KrughevaCollection"),
    CRAMELE_COLLECTION("CrameleCollection"),
    PAPIRUS_COLLECTION("PapirusCollection"),
    NONE("-"),
    STAROCRICOVSKOE_COLLECTION("StarocricovskoeCollection");


    private String value;

    private WineCollectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
