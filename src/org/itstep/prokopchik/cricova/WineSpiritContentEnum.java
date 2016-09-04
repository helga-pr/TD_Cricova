package org.itstep.prokopchik.cricova;

public enum WineSpiritContentEnum {
    SPIRIT_9("9 %об"),
    SPIRIT_9_11("9-11 %об"),
    SPIRIT_16("16 %об");

    private String value;

    private WineSpiritContentEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
