/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Indicates that this class or method is experimental.
 * <p>
 * So, it is not stable, can be changed in future or can be removed completely in the future.
 */
@Retention(RetentionPolicy.SOURCE)
public @interface Experimental {

  String[] hints() default {};
}
