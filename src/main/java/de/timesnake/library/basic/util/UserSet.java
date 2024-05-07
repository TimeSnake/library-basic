/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.Collection;
import java.util.HashSet;

public class UserSet<User> extends HashSet<User> {

  public static final HashSet<UserSet<?>> SETS = new HashSet<>();

  public UserSet() {
    SETS.add(this);
  }

  public UserSet(Collection<? extends User> collection) {
    super(collection);
    SETS.add(this);
  }

  public boolean removeAuto(Object user) {
    boolean removed = super.remove(user);
    if (removed) {
      this.onAutoRemove((User) user);
    }
    return removed;
  }

  public void onAutoRemove(User user) {

  }
}
