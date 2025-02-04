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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class TruckTest {

    private Truck testedTruck;

    @BeforeEach
    void setUp() {
        Model truckModel = new Model("Global Truck", "Test Truck");
        Engine truckEngine = new Engine(new Model("Global Truck", "v22-Revo"),
                500);
        Wheel truckWheels = new Wheel(new Model("RubberRun", "RoadRunner"), 20);
        testedTruck = new TestTruck(truckModel, truckEngine, truckWheels);
    }

    @Test
    @DisplayName("Testing Prototype pattern...")
    void testClone() {
        Truck clonedTruck = testedTruck.clone();
        assertNotSame(testedTruck, clonedTruck,
                "Cloned object should not be anther reference to original object");
        assertEquals(testedTruck, clonedTruck,
                "equals(Object) method should return true for an unmodified cloned object.");
        assertEquals(testedTruck.hashCode(), clonedTruck.hashCode(),
                "hashCode() method should return the same number for an unmodified cloned object.");
        assertEquals(testedTruck.getClass(), clonedTruck.getClass(),
                "Cloned object should be of the same class as original one.");
    }


    public static class TestTruck extends Truck {
        protected TestTruck(Model modelName, Engine motor, Wheel wheel) {
            super(modelName, motor, wheel);
        }
    }
}