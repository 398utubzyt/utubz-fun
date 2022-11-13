package com.utubz.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class Text {
    public static Component parse(String msg) {
        return Component.text(msg);
    }

    public static Component colorize(String msg, TextColor color) {
        return Component.text(msg, color);
    }
    
    public static Component colorize(Component msg, TextColor color) {
        return msg.color(color);
    }

    public static Component colorizeBlank(Component msg, TextColor color) {
        return msg.colorIfAbsent(color);
    }

    public static Component black(String msg) { return Component.text(msg, NamedTextColor.BLACK); }
    public static Component darkBlue(String msg) { return Component.text(msg, NamedTextColor.DARK_BLUE); }
    public static Component darkGreen(String msg) { return Component.text(msg, NamedTextColor.DARK_GREEN); }
    public static Component darkAqua(String msg) { return Component.text(msg, NamedTextColor.DARK_AQUA); }
    public static Component darkRed(String msg) { return Component.text(msg, NamedTextColor.DARK_RED); }
    public static Component darkPurple(String msg) { return Component.text(msg, NamedTextColor.DARK_PURPLE); }
    public static Component gold(String msg) { return Component.text(msg, NamedTextColor.GOLD); }
    public static Component gray(String msg) { return Component.text(msg, NamedTextColor.GRAY); }
    public static Component darkGray(String msg) { return Component.text(msg, NamedTextColor.DARK_GRAY); }
    public static Component blue(String msg) { return Component.text(msg, NamedTextColor.BLUE); }
    public static Component green(String msg) { return Component.text(msg, NamedTextColor.GREEN); }
    public static Component aqua(String msg) { return Component.text(msg, NamedTextColor.AQUA); }
    public static Component red(String msg) { return Component.text(msg, NamedTextColor.RED); }
    public static Component purple(String msg) { return Component.text(msg, NamedTextColor.LIGHT_PURPLE); }
    public static Component yellow(String msg) { return Component.text(msg, NamedTextColor.YELLOW); }
    public static Component white(String msg) { return Component.text(msg, NamedTextColor.WHITE); }

    public static Component black(Component msg) { return msg.color(NamedTextColor.BLACK); }
    public static Component darkBlue(Component msg) { return msg.color(NamedTextColor.DARK_BLUE); }
    public static Component darkGreen(Component msg) { return msg.color(NamedTextColor.DARK_GREEN); }
    public static Component darkAqua(Component msg) { return msg.color(NamedTextColor.DARK_AQUA); }
    public static Component darkRed(Component msg) { return msg.color(NamedTextColor.DARK_RED); }
    public static Component darkPurple(Component msg) { return msg.color(NamedTextColor.DARK_PURPLE); }
    public static Component gold(Component msg) { return msg.color(NamedTextColor.GOLD); }
    public static Component gray(Component msg) { return msg.color(NamedTextColor.GRAY); }
    public static Component darkGray(Component msg) { return msg.color(NamedTextColor.DARK_GRAY); }
    public static Component blue(Component msg) { return msg.color(NamedTextColor.BLUE); }
    public static Component green(Component msg) { return msg.color(NamedTextColor.GREEN); }
    public static Component aqua(Component msg) { return msg.color(NamedTextColor.AQUA); }
    public static Component red(Component msg) { return msg.color(NamedTextColor.RED); }
    public static Component purple(Component msg) { return msg.color(NamedTextColor.LIGHT_PURPLE); }
    public static Component yellow(Component msg) { return msg.color(NamedTextColor.YELLOW); }
    public static Component white(Component msg) { return msg.color(NamedTextColor.WHITE); }


    public static Component bold(String msg) { return Component.text(msg, null, TextDecoration.BOLD); }
    public static Component italic(String msg) { return Component.text(msg, null, TextDecoration.ITALIC); }
    public static Component underlined(String msg) { return Component.text(msg, null, TextDecoration.UNDERLINED); }
    public static Component strikethrough(String msg) { return Component.text(msg, null, TextDecoration.STRIKETHROUGH); }
    public static Component obfuscated(String msg) { return Component.text(msg, null, TextDecoration.OBFUSCATED); }

    public static Component bold(Component msg) { return msg.decorate(TextDecoration.BOLD); }
    public static Component italic(Component msg) { return msg.decorate(TextDecoration.ITALIC); }
    public static Component underlined(Component msg) { return msg.decorate(TextDecoration.UNDERLINED); }
    public static Component strikethrough(Component msg) { return msg.decorate(TextDecoration.STRIKETHROUGH); }
    public static Component obfuscated(Component msg) { return msg.decorate(TextDecoration.OBFUSCATED); }


    public static Component decorate(String msg, TextDecoration... decoration) {
        return Component.text(msg).decorate(decoration);
    }

    public static Component decorate(Component msg, TextDecoration... decoration) {
        return msg.decorate(decoration);
    }


    public static Component format(String msg, TextColor color, TextDecoration... decoration) {
        return Component.text(msg, color, decoration);
    }

    public static Component format(Component msg, TextColor color, TextDecoration... decoration) {
        return msg.color(color).decorate(decoration);
    }

    public static Component style(String msg, Style style) {
        return Component.text(msg, style);
    }

    public static Component style(Component msg, Style style) {
        return msg.style(style);
    }

    public static Component combine(Component a, Component b) {
        return a.append(b);
    }

    public static Component combine(String a, Component b) {
        return Component.text(a).append(b);
    }

    public static Component combine(Component a, String b) {
        return a.append(Component.text(b));
    }

    public static Component combine(String a, String b) {
        return Component.text(a).append(Component.text(b));
    }

    public static Component combine(Component a, Component b, Component c) {
        return a.append(b).append(c);
    }

    public static Component combine(Component a, String b, String c) {
        return a.append(Component.text(b)).append(Component.text(c));
    }

    public static Component combine(String a, Component b, String c) {
        return Component.text(a).append(b).append(Component.text(c));
    }

    public static Component combine(String a, String b, Component c) {
        return Component.text(a).append(Component.text(b)).append(c);
    }

    public static Component combine(Component a, Component b, String c) {
        return a.append(b).append(Component.text(c));
    }

    public static Component combine(String a, Component b, Component c) {
        return Component.text(a).append(b).append(c);
    }

    public static Component combine(Component a, String b, Component c) {
        return a.append(Component.text(b)).append(c);
    }

    public static Component combine(String a, String b, String c) {
        return Component.text(a).append(Component.text(b)).append(Component.text(c));
    }

    public static Component combine(String a, String b, String c, String d) {
        return Component.text(a).append(Component.text(b)).append(Component.text(c)).append(Component.text(d));
    }

    public static Component combine(Component... components) {
        if (components.length == 0)
            return null;
        
        for (int i = 1; i < components.length; i++)
            components[0] = components[0].append(components[i]);
        return components[0];
    }
}
