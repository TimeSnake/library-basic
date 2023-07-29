/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class LogHelper {

  private static final boolean DEBUG_MODE = false;

  public static final Map<String, Logger> LOGGER_BY_NAME = new HashMap<>();

  public static Logger getLogger(String name) {
    return DEBUG_MODE ? getLogger(name, Level.INFO) : getLogger(name, Level.WARNING);
  }

  public static Logger getLogger(String name, Level defaultLevel) {
    return getLogger(name, defaultLevel, true);
  }

  public static Logger getLogger(String name, Level defaultLevel, boolean useParentHandlers) {
    Logger logger = Logger.getLogger(name);
    logger.setUseParentHandlers(useParentHandlers);
    logger.setLevel(defaultLevel);
    LOGGER_BY_NAME.put(name.toLowerCase(), logger);
    return logger;
  }

  public static Logger logToFile(Logger logger) {
    Path path = Path.of("plugins", "debug");
    try {
      Files.createDirectories(path);
    } catch (IOException ignored) {
    }

    path = path.resolve("debug.log");

    if (!path.toFile().exists()) {
      try {
        path.toFile().createNewFile();
      } catch (IOException ignored) {
      }
    }

    FileHandler fh = null;
    try {
      fh = new FileHandler("plugins/debug/debug.log");
    } catch (IOException ignored) {
    }
    logger.addHandler(fh);

    CustomFormatter formatter = new CustomFormatter();
    fh.setFormatter(formatter);
    return logger;
  }

  public static class CustomFormatter extends Formatter {

    private static final String format = "%1tH:%<tM:%<tS %2$-7s %3$s (%4$s) %5$s%6$s%n";
    private static final Date date = new Date();

    @Override
    public String format(LogRecord record) {
      date.setTime(record.getMillis());

      String message = formatMessage(record);

      return String.format(format, date, record.getLevel().getName(), record.getLoggerName(), "",
          message, "");
    }
  }
}
