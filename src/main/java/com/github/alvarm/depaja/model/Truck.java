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

import java.util.Objects;

public abstract class Truck implements Cloneable {

    private Model modelName;
    private Engine motor;
    private Wheel wheel;

    protected Truck(Model modelName, Engine motor, Wheel wheel) {
        this.modelName = modelName;
        this.motor = motor;
        this.wheel = wheel;
    }

    public Model getModelName() {
        return modelName;
    }

    public void setModelName(Model modelName) {
        this.modelName = modelName;
    }

    public Engine getMotor() {
        return motor;
    }

    public void setMotor(Engine motor) {
        this.motor = motor;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(modelName);
        result = 31 * result + Objects.hashCode(motor);
        result = 31 * result + Objects.hashCode(wheel);
        return result;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Truck truck)) return false;

        return Objects.equals(modelName, truck.modelName) && Objects.equals(motor, truck.motor) && Objects.equals(wheel, truck.wheel);
    }

    @Override
    public Truck clone() {
        try {
            return (Truck) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
