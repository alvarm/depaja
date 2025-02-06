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

/**
 * Abstract class that represents a truck.<br>
 * This class implements the <b>Prototype</b> design pattern.
 *
 * @author alvarm
 * @version 1.0
 * @see Cloneable
 */
public abstract class Truck implements Cloneable {

    private Model modelName;
    private Engine engine;
    private Wheel wheel;

    /**
     * Constructor method the sets up all its attributes.
     *
     * @param modelName The model for the new truck.
     * @param engine    The engine for the new truck.
     * @param wheel     The wheel model for the new truck.
     * @see Model
     * @see Engine
     * @see Wheel
     * @since 1.0
     */
    protected Truck(Model modelName, Engine engine, Wheel wheel) {
        this.modelName = modelName;
        this.engine = engine;
        this.wheel = wheel;
    }

    /**
     * Returns the model name for this truck.
     *
     * @return The model name.
     * @see Model
     * @since 1.0
     */
    public Model getModelName() {
        return modelName;
    }

    /**
     * Sets a new model name for this truck.
     *
     * @param modelName The new model name.
     * @see Model
     * @since 1.0
     */
    protected void setModelName(Model modelName) {
        this.modelName = modelName;
    }

    /**
     * Returns the engine used in this truck.
     *
     * @return The engine used for this model.
     * @see Engine
     * @since 1.0
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Sets a new engine model for this truck.
     *
     * @param engine The new engine for this model.
     * @see Engine
     * @since 1.0
     */
    protected void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * Returns the wheel model used for this truck.
     *
     * @return The wheel model for this truck.
     * @see Wheel
     * @see Wheel
     * @since 1.0
     */
    public Wheel getWheel() {
        return wheel;
    }

    /**
     * Sets a new wheel model for this truck.
     *
     * @param wheel The new wheel model.
     * @see Wheel
     * @since 1.0
     */
    protected void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    /**
     * Calculates a hash code based on the instance fields.
     *
     * @return A hash code for this instance.
     * @see Object#hashCode()
     * @since 1.0
     */
    @Override
    public int hashCode() {
        int result = Objects.hashCode(modelName);
        result = 31 * result + Objects.hashCode(engine);
        result = 31 * result + Objects.hashCode(wheel);
        return result;
    }

    /**
     * Check is a truck is equals to another object.
     *
     * @param o An object to be compared with.
     * @return <i>true</i>, if <code>o</code> is a Truck and has the same attributes.<br>
     * <i>false</i>, otherwise.
     * @since 1.0
     */
    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Truck truck)) return false;

        return Objects.equals(modelName, truck.modelName) && Objects.equals(engine, truck.engine) && Objects.equals(wheel, truck.wheel);
    }

    /**
     * Returns a copy of a truck.
     * This method is part of the <b>Prototype</b> pattern.
     *
     * @return A copy of <code>this</code> truck.
     * @see Object#clone()
     * @since 1.0
     */
    @Override
    public Truck clone() {
        try {
            return (Truck) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
