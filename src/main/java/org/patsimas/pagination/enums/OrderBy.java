package org.patsimas.pagination.enums;

public enum OrderBy {


    ID("id"),
    USERID("userId");

    private String code;

    OrderBy(String v) {code = v;}

    public String code() {return code;}

    public static OrderBy fromCode(String v) {
        for (OrderBy c: OrderBy.values()) {
            if (c.code == v) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.valueOf(v));
    }
}
