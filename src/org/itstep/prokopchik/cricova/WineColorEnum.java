package org.itstep.prokopchik.cricova;

public enum WineColorEnum {

    RED("red"),
    WHITE("white"),
    ROSE("rose");

    private String value;

    private WineColorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getValueToString() {
        return value == "red" ? "Красное " : (
                value == "white" ? "Белое " : "Розовое ");
    }
}
