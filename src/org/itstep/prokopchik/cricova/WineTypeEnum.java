package org.itstep.prokopchik.cricova;

public enum WineTypeEnum {

    STILL_WINE("still_wine"),
    SPARKLING_WINE("sparkling_wine");

    private String value;

    private WineTypeEnum(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getValueToString() {

        return
                value == "sparkling_wine" ? "Игристое" : "Тихое";

    }

}
