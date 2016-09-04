package org.itstep.prokopchik.cricova;

public enum WineSugarContentEnum {

    BRUTE("brute"),
    DRY("dry"),
    SEMIDRY("semidry"),
    SEMISWEETE("semisweet"),
    SWEETE("sweet");

    private String value;

    private WineSugarContentEnum(String value) {
        this.value = value;
    }

    public String getValue() {

        return value;
    }

    public String getValueToString() {

        return value == "brute" ? "Брют" :
                value == "dry" ? "Сухое" :
                        value == "semidry" ? "Полусухое" :
                                value == "semisweet" ? "Полусладкое" :
                                        value == "sweet" ? "Сладкое" : "";
    }
}
