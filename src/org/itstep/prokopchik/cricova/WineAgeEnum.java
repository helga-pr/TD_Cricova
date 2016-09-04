package org.itstep.prokopchik.cricova;

public enum WineAgeEnum {

    ORDINARY_WINE("ordinary_wine"),
    OLD_WINE("old_wine"),
    COLLECTION_WINE("collection_wine");

    private String value;

    private WineAgeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getValueToString() {
        return value == "ordinary_wine" ? "Ординарное" :
                value == "old_wine" ? "Выдержанное" :
                        value == "collection_wine" ? "Коллекционное" : "";
    }
}
