package org.itstep.prokopchik.cricova;

public enum WineAgeEnum {

    ORDINARY_WINE("ordinaryWine"),
    OLD_WINE("oldWine"),
    COLLECTION_WINE("collectionWine");

    private String value;

    private WineAgeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
