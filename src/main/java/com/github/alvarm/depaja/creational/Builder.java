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

import com.github.alvarm.depaja.model.Order;
import com.github.alvarm.depaja.model.enums.Colors;

import java.io.Console;
import java.util.Arrays;

public class Builder {

    public static Console reader = System.console();

    public static void main(String[] args) {
        System.out.println("""
                Builder Pattern Example:
                We are going to set up an order for a new truck:
                Please, introduce the brand name and model:""");
        System.out.print("Brand: ");
        final String manufacturerName = reader.readLine();

        System.out.print("Model: ");
        final String truckModelName = reader.readLine();

        System.out.println();
        System.out.println("Please, now introduce the selected engine:");
        System.out.print("Manufacturer: ");
        final String engineManufacturer = reader.readLine();
        System.out.print("Model: ");
        final String engineModelName = reader.readLine();
        System.out.print("Power: ");
        final int enginePower = Integer.parseInt(reader.readLine());

        System.out.println();
        System.out.println("Please, now introduce the selected wheel:");
        System.out.print("Manufacturer: ");
        final String wheelManufacturer = reader.readLine();
        System.out.print("Model: ");
        final String wheelModelName = reader.readLine();
        System.out.print("Size: ");
        final int wheelSize = Integer.parseInt(reader.readLine());

        System.out.println();
        System.out.println("Now select the truck color: ");
        Arrays.stream(Colors.values()).forEach(System.out::println);
        System.out.print("Choose one color: ");
        final Colors selectedColor = Colors.valueOf(reader.readLine().toUpperCase());

        System.setProperty("yes", "true");

        System.out.println();
        System.out.print("Would you like to have driving assistance? [yes|no]: ");
        final boolean withDrivingAssistance = Boolean.getBoolean(reader.readLine());

        System.out.println();
        System.out.print("Would you like to have long trip equipment? [yes|no]: ");
        final boolean withLongTripEquipment = Boolean.getBoolean(reader.readLine());

        System.out.println();
        System.out.print("Would you like to have automatic transmission? [yes|no]: ");
        final boolean withAutomaticTransmission = Boolean.getBoolean(reader.readLine());

        System.out.println();
        System.out.print("Would you like to have ergonomic seats? [yes|no]: ");
        final boolean withErgonomicSeats = Boolean.getBoolean(reader.readLine());

        System.out.println();
        System.out.println("Setting up the order...");

        Order.Builder builder = new Order.Builder()
                .withBaseColor(selectedColor)
                .withAutomaticTransmission(withAutomaticTransmission)
                .withDrivingAssistance(withDrivingAssistance)
                .withErgonomicSeats(withErgonomicSeats)
                .withLongTripEquipment(withLongTripEquipment)
                .withWheel(wheelManufacturer, wheelModelName, wheelSize)
                .withEngine(engineManufacturer, engineModelName, enginePower)
                .withTruckModel(manufacturerName, truckModelName);

        Order o = builder.build();
        System.out.println(o);
    }
}
