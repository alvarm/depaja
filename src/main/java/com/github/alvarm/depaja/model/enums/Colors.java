/*
 * MIT License
 * Copyright 2025 Àlvar Mercadé Ibáñez
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the “Software”), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.alvarm.depaja.model.enums;

import java.awt.*;

public enum Colors {
    MIDNIGHT_BLACK(new Color(0x00, 0x00, 0x00)),
    NAVY_BLUE(new Color(0x00, 0x00, 0x80)),
    ROYAL_BLUE(new Color(0x41, 0x69, 0xE1)),
    AQUA_BLUE(new Color(0x00, 0xFF, 0xFF)),
    METAL_GREY(new Color(0x70, 0x80, 0x90)),
    LIGHT_GREY(new Color(0xD3, 0xD3, 0xD3)),
    LAWN_GREEN(new Color(0x7C, 0xFC, 0x00)),
    SPRING_GREEN(new Color(0x00, 0xFF, 0x7F)),
    LIME_GREEN(new Color(0x32, 0xCD, 0x32)),
    FUCHSIA(new Color(0xFF, 0x00, 0xFF)),
    DARK_ORCHID(new Color(0x8B, 0x00, 0x8B)),
    DEEP_PINK(new Color(0xFF, 0x14, 0x93)),
    PEACH_PUFF(new Color(0xFF, 0xDA, 0xB9)),
    ORANGE(new Color(0xFF, 0xA5, 0x00)),
    ORANGE_RED(new Color(0xFF, 0x45, 0x00)),
    RED(new Color(0xFF, 0x00, 0x00)),
    DARK_RED(new Color(0x8B, 0x00, 0x00)),
    LEMON_CHIFFON(new Color(0xFF, 0xFA, 0xCD)),
    YELLOW(new Color(0xFF, 0xFF, 0x00)),
    GOLD(new Color(0xFF, 0xD7, 0x00)),
    SNOW(new Color(0xFF, 0xFA, 0xFA)),
    GHOST_WHITE(new Color(0xF8, 0xF8, 0xFF)),
    WHITE(new Color(255, 255, 255));

    private final Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
