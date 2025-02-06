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

package com.github.alvarm.depaja.creational;

import com.github.alvarm.depaja.model.Catalogue;
import com.github.alvarm.depaja.model.Model;
import com.github.alvarm.depaja.model.Truck;

import java.util.Scanner;

public class Prototype {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                Prototype Pattern Example:
                First we get a base instance.""");

        Truck originalTruck = Catalogue.getCatalogue().getBasicTruck();

        System.out.printf("""
                Base instance is: %s
                Now we replicate the instance with 'clone()' method.%n""", originalTruck);

        Truck clonedTruck = originalTruck.clone();

        System.out.printf("""
                        Cloned instance is: %s
                        Right now they are equals: clonedTruck.equals(originalTruck) is %s
                        But not the same: clonedTruck != originalTruck is %s.%n""",
                clonedTruck,
                clonedTruck.equals(originalTruck),
                clonedTruck != originalTruck);

        System.out.printf("""
                        However, did not you notice something weird?
                        Original instance: %s
                          Cloned instance: %s
                        They have the same address!
                        So, what would happen if we change something in the cloned instance?
                        For example, provide me a new Manufacturer and Model name:%n""",
                originalTruck,
                clonedTruck);

        final String newManufacturerName = scanner.nextLine();
        final String newModelName = scanner.nextLine();
        Model newModel = new Model(newManufacturerName, newModelName);
        clonedTruck.setModelName(newModel);

        System.out.printf("""
                        Let's check these instances again:
                        Original instance: %s
                          Cloned instance: %s
                        They do not have the same address now!
                        And now there are not equal: clonedTruck.equals(originalTruck) is %s
                        And there are not the same instance: clonedTruck != originalTruck is %s%n""",
                originalTruck,
                clonedTruck,
                clonedTruck.equals(originalTruck),
                clonedTruck != originalTruck);
    }
}
