/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

public class BuilderNotFullyInstantiatedException extends RuntimeException {

  public BuilderNotFullyInstantiatedException(String message) {
    super(message);
  }
}
