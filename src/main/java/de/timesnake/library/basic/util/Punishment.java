/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Punishment implements Serializable {

  private UUID uuid;
  private PunishType type;
  private LocalDateTime date;
  private Duration duration;
  private String byName;
  private String reason;

  public Punishment(UUID uuid, PunishType type, LocalDateTime date, Duration duration, String byName, String reason) {
    this.uuid = uuid;
    this.type = type;
    this.date = date;
    this.duration = duration;
    this.byName = byName;
    this.reason = reason;
  }

  public LocalDateTime getDate() {
    return this.date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public Duration getDuration() {
    return duration;
  }

  public void setDuration(Duration duration) {
    this.duration = duration;
  }

  public PunishType getType() {
    return this.type;
  }

  public void setType(PunishType type) {
    this.type = type;
  }

  public String getByName() {
    return this.byName;
  }

  public void setByName(String byName) {
    this.byName = byName;
  }

  public String getReason() {
    return this.reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public UUID getUuid() {
    return this.uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public boolean isExpired() {
    if (this.date == null) return true;
    if (this.duration == null) return false;
    return this.date.plusSeconds(duration.toSeconds()).isBefore(LocalDateTime.now());
  }

  @Override
  public String toString() {
    return "Punishment{" +
        "uuid=" + uuid +
        ", type=" + type +
        ", date=" + date +
        ", duration=" + duration +
        ", byName='" + byName + '\'' +
        ", reason='" + reason + '\'' +
        '}';
  }
}
