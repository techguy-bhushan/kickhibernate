package com.kickhibernate;

public enum GenderType {
    MALE( 'M' ),
    FEMALE( 'F' );
    private final char code;

    GenderType(char code) {
        this.code = code;
    }

    public static GenderType fromCode(char code) {
        if ( code == 'M' || code == 'm' ) {
            return MALE;
        }
        if ( code == 'F' || code == 'f' ) {
            return FEMALE;
        }
        throw new UnsupportedOperationException(
                "The code " + code + " is not supported!"
        );
    }

    public char getCode() {
        return code;
    }
}
