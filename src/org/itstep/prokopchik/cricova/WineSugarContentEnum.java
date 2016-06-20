package org.itstep.prokopchik.cricova;

public enum WineSugarContentEnum {

    BRUTE_WINE("brute"),
    DRY_WINE("dryWine"),
    SEMIDRY_WINE("semidryWine"),
    SEMISWEETE_WINE("semisweetWine"),
    SWEETE_WINE("sweetWine");

    private String value;

    private WineSugarContentEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
