/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class LogConfig {

  private final Logger logger = LogManager.getLogger("logger.config");

  private final Properties properties;

  public LogConfig(File file) {
    this.properties = new Properties();
    try {
      InputStream is = new FileInputStream(file);
      this.properties.load(is);
    } catch (FileNotFoundException e) {
      this.logger.warn("Config file '{}' does not exists", file.getName());
    } catch (IOException e) {
      this.logger.warn("Failed to read config file: {}", e.getMessage());
    }
  }

  public void apply() {
    for (Map.Entry<Object, Object> entry : this.properties.entrySet()) {
      String logger = ((String) entry.getKey());
      String level = ((String) entry.getValue());

      Configurator.setAllLevels(logger, Level.getLevel(level));
      this.logger.info("Updated log-level of '{}' to {}", logger, Level.getLevel(level).name().toLowerCase());
    }
  }
}
