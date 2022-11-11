/*
 * timesnake.library-basic.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
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

    public static final Map<String, Logger> LOGGER_BY_NAME = new HashMap<>();

    public static Logger getLogger(String name) {
        return getLogger(name, Level.WARNING);
    }

    public static Logger getLogger(String name, Level defaultLevel) {
        Logger logger = Logger.getLogger(name);
        logger.setUseParentHandlers(true);
        logger.setLevel(defaultLevel);
        LOGGER_BY_NAME.put(name, logger);
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

            return String.format(format, date, record.getLevel().getName(), record.getLoggerName(), "", message, "");
        }
    }
}
