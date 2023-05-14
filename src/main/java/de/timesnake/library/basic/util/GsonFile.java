/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonFile {

    private static final Gson DEFAULT_GSON = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    private final File file;
    private final Gson gson;

    public GsonFile(File file) {
        this.file = file;
        this.gson = DEFAULT_GSON;
    }

    public GsonFile(File file, Gson gson) {
        this.file = file;
        this.gson = gson;
    }

    public boolean createIfNotExists() {
        file.getParentFile().mkdirs();

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public File getFile() {
        return file;
    }

    public Gson getGson() {
        return gson;
    }

    public boolean write(Object object) {
        return this.write(object, false);
    }

    public boolean append(Object object) {
        return this.write(object, true);
    }

    public boolean write(Object object, boolean append) {
        try {
            FileWriter writer = new FileWriter(file, append);
            writer.write(this.gson.toJson(object));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public <T> T read(Class<T> clazz) {
        if (!file.exists()) {
            return null;
        }

        try {
            return this.gson.fromJson(new FileReader(file), clazz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
