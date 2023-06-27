package com.regyl.passentrysystem.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class CsvUtils {

    public String getOrDefault(Object obj) {
        if (obj == null) {
            return "";
        }

        return String.valueOf(obj);
    }
}
