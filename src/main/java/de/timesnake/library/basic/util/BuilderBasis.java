/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

public interface BuilderBasis {

    static void checkNotNull(Object value, String message) {
        if (value == null) {
            throw new BuilderNotFullyInstantiatedException(message);
        }
    }

    void checkBuild();

    Object build();

}
