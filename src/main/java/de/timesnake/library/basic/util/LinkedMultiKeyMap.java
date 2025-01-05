/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.LinkedHashMap;

public class LinkedMultiKeyMap<K1, K2, V> extends MultiKeyMap<K1, K2, V> {

  public LinkedMultiKeyMap() {
    super(new LinkedHashMap<>(), new LinkedHashMap<>());
  }
}
