package org.patsimas.pagination.enums;

public enum Direction {

    ASCENDING("ASC"),
    DESCENDING("DESC");

    private final String code;

    Direction(String v) {code = v;}

    public String code() {return code;}

    public static Direction fromCode(String v) {
        for (Direction c: Direction.values()) {
            if (c.code == v) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.valueOf(v));
    }
}
