/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserMap<User, Value> extends HashMap<User, Value> {

  public static final ArrayList<UserMap<?, ?>> MAPS = new ArrayList<>();

  public UserMap() {
    MAPS.add(this);
  }

  public UserMap(Map<? extends User, Value> map) {
    super(map);
    MAPS.add(this);
  }

  public Value removeAuto(Object user) {
    Value value = super.remove(user);
    if (value != null) {
      this.onAutoRemove((User) user, value);
    }
    return value;
  }

  public void onAutoRemove(@NotNull User user, @NotNull Value value) {

  }
}
