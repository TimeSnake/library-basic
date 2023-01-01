/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util.chat;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.util.Index;

import java.util.List;

public class ExTextColor implements TextColor {

    public static final ExTextColor BLACK = new ExTextColor(NamedTextColor.BLACK);
    public static final ExTextColor QUICK_INFO = new ExTextColor("quick_info", NamedTextColor.DARK_GRAY);
    public static final ExTextColor DARK_BLUE = new ExTextColor(NamedTextColor.DARK_BLUE);
    public static final ExTextColor DARK_GREEN = new ExTextColor(NamedTextColor.DARK_GREEN);
    public static final ExTextColor DARK_AQUA = new ExTextColor(NamedTextColor.DARK_AQUA);
    public static final ExTextColor DARK_RED = new ExTextColor(NamedTextColor.DARK_RED);
    public static final ExTextColor DARK_PURPLE = new ExTextColor(NamedTextColor.DARK_PURPLE);
    public static final ExTextColor GOLD = new ExTextColor(NamedTextColor.GOLD);
    public static final ExTextColor GRAY = new ExTextColor(NamedTextColor.GRAY);
    public static final ExTextColor VALUE = new ExTextColor("value", NamedTextColor.GRAY);
    public static final ExTextColor DARK_GRAY = new ExTextColor(NamedTextColor.DARK_GRAY);
    public static final ExTextColor BLUE = new ExTextColor(NamedTextColor.BLUE);
    public static final ExTextColor GREEN = new ExTextColor(NamedTextColor.GREEN);
    public static final ExTextColor AQUA = new ExTextColor(NamedTextColor.AQUA);
    public static final ExTextColor RED = new ExTextColor(NamedTextColor.RED);
    public static final ExTextColor WARNING = new ExTextColor("warning", NamedTextColor.RED);
    public static final ExTextColor LIGHT_PURPLE = new ExTextColor(NamedTextColor.LIGHT_PURPLE);
    public static final ExTextColor YELLOW = new ExTextColor(NamedTextColor.YELLOW);
    public static final ExTextColor PERSONAL = new ExTextColor("personal", NamedTextColor.YELLOW);
    public static final ExTextColor WHITE = new ExTextColor(NamedTextColor.WHITE);
    public static final ExTextColor PUBLIC = new ExTextColor("public", NamedTextColor.WHITE);

    public static final List<ExTextColor> VALUES = List.of(BLACK, QUICK_INFO, DARK_BLUE, DARK_GREEN, DARK_AQUA, DARK_RED,
            DARK_PURPLE, GOLD, GRAY, VALUE, DARK_GRAY, BLUE, GREEN, AQUA, RED, WARNING, LIGHT_PURPLE, YELLOW, PERSONAL,
            WHITE, PUBLIC);

    public static final Index<String, ExTextColor> NAMES = Index.create(ExTextColor::getName, VALUES);

    private final NamedTextColor color;
    private final String name;

    public ExTextColor(NamedTextColor color) {
        this.color = color;
        this.name = color.toString();
    }

    public ExTextColor(String name, NamedTextColor color) {
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int value() {
        return this.color.value();
    }

    @Override
    public String toString() {
        return this.color.toString();
    }
}
