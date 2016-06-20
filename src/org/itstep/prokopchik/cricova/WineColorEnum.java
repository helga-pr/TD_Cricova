package org.itstep.prokopchik.cricova;

public enum WineColorEnum {

    RED_WINE("redWine"),
    WHITE_WINE("whiteWine"),
    ROSE_WINE("roseWine");

    private String value;

    private WineColorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
