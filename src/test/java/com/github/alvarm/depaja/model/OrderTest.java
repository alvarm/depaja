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

package com.github.alvarm.depaja.model;

import com.github.alvarm.depaja.model.enums.Colors;
import com.github.alvarm.depaja.model.records.Engine;
import com.github.alvarm.depaja.model.records.Model;
import com.github.alvarm.depaja.model.records.Wheel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    public static final String TRUCK_BRAND = "TruckBrand";
    public static final String TRUCK_MODEL = "TruckModel";
    public static final String ENGINE_MANUF = "EngineManuf";
    public static final String ENGINE_MODEL = "EngineModel";
    public static final int ENGINE_POWER = 127;
    public static final String WHEEL_MANUF = "WheelManuf";
    public static final String WHEEL_MODEL = "WheelModel";
    public static final int WHEEL_SIZE = 20;
    public static final Colors FUCHSIA = Colors.FUCHSIA;
    public static final boolean DRIVING_ASSISTANCE = false;
    public static final boolean AUTOMATIC_TRANSMISSION = false;
    public static final boolean LONG_TRIP_EQUIPMENT = true;
    public static final boolean ERGONOMIC_SEATS = true;
    private Order orderToTest;

    @BeforeEach
    void setUp() {
        orderToTest = new Order.Builder()
                .withErgonomicSeats(ERGONOMIC_SEATS)
                .withLongTripEquipment(LONG_TRIP_EQUIPMENT)
                .withAutomaticTransmission(AUTOMATIC_TRANSMISSION)
                .withDrivingAssistance(DRIVING_ASSISTANCE)
                .withBaseColor(FUCHSIA)
                .withWheel(WHEEL_MANUF, WHEEL_MODEL, WHEEL_SIZE)
                .withEngine(ENGINE_MANUF, ENGINE_MODEL, ENGINE_POWER)
                .withTruckModel(TRUCK_BRAND, TRUCK_MODEL)
                .build();
    }

    @Test
    void getTruckModel() {
        assertEquals(new Model(TRUCK_BRAND, TRUCK_MODEL), orderToTest.getTruckModel());
    }

    @Test
    void getEngine() {
        assertEquals(new Engine(new Model(ENGINE_MANUF, ENGINE_MODEL), ENGINE_POWER),
                orderToTest.getEngine());
    }

    @Test
    void getWheel() {
        assertEquals(new Wheel(new Model(WHEEL_MANUF, WHEEL_MODEL), WHEEL_SIZE),
                orderToTest.getWheel());
    }

    @Test
    void getBaseColor() {
        assertEquals(FUCHSIA, orderToTest.getBaseColor());
    }

    @Test
    void hasAutomaticTransmission() {
        assertEquals(AUTOMATIC_TRANSMISSION, orderToTest.hasAutomaticTransmission());
    }

    @Test
    void hasErgonomicSeats() {
        assertEquals(ERGONOMIC_SEATS, orderToTest.hasErgonomicSeats());
    }

    @Test
    void hasLongTripEquipment() {
        assertEquals(LONG_TRIP_EQUIPMENT, orderToTest.hasLongTripEquipment());
    }

    @Test
    void hasDrivingAssistance() {
        assertEquals(DRIVING_ASSISTANCE, orderToTest.hasDrivingAssistance());
    }
}