/*
 * MIT License
 * Copyright 2025 Àlvar Mercadé Ibáñez
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the “Software”), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.github.alvarm.depaja;

import com.github.alvarm.depaja.creational.Builder;
import com.github.alvarm.depaja.creational.Prototype;
import com.github.alvarm.depaja.creational.Singleton;

import java.io.Console;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main {

    public static final List<Class<?>> implementedMains = List.of(Singleton.class,
            Prototype.class, Builder.class);

    public static Console reader = System.console();

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int selectedPattern;
        System.out.println("""
                Welcome to Design Patterns in (modern) Java!
                List of test programs:""");
        listAvailablePatterns();
        do {
            System.out.print("Please, select which method do you want to execute: ");
            selectedPattern = Integer.parseInt(reader.readLine());
        } while (selectedPattern < 0 || implementedMains.size() <= selectedPattern);
        launchMethod(selectedPattern);
    }

    private static void listAvailablePatterns() {
        int i = 0;
        for (Class<?> c : implementedMains) {
            final String className = c.getName();
            final int lastDotPosition = className.lastIndexOf(".");
            System.out.printf("%2d: %s Pattern%n",
                    i++,
                    className.substring(lastDotPosition + 1));
        }
    }

    private static void launchMethod(int selectedPattern) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> selectedClass = implementedMains.get(selectedPattern);
        Method mainMethod = selectedClass.getMethod("main", String[].class);
        mainMethod.setAccessible(true);
        mainMethod.invoke(null, new String[1]);
    }

    public static String greeting() {
        return "Hello, World!";
    }
}
