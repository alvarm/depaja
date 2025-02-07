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

/**
 * Class that represents a customer order for a new truck.<br>
 * Instances of this class will be created using the <b>Builder</b> design pattern.
 *
 * @author alvarm
 * @version 1.0
 * @see Truck
 */
public class Order {
    private final Model truckModel;
    private final Engine engine;
    private final Wheel wheel;
    private final Colors baseColor;
    private final boolean automaticTransmission;
    private final boolean ergonomicSeats;
    private final boolean longTripEquipment;
    private final boolean drivingAssistance;

    /**
     * Private constructor that creates a new order using the values in the builder.<br>
     * Having this, an only one, constructor private is part of the <b>Builder</b> design pattern.
     *
     * @param builder A builder containing the user options.
     * @see Builder
     * @since 1.0
     */
    private Order(Builder builder) {
        this.truckModel = builder.truckModel;
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.baseColor = builder.baseColor;
        this.automaticTransmission = builder.automaticTransmission;
        this.ergonomicSeats = builder.ergonomicSeats;
        this.drivingAssistance = builder.drivingAssistance;
        this.longTripEquipment = builder.longTripEquipment;
    }

    /**
     * Returns the base model for this order.
     *
     * @return The truck model for this order.
     * @see Truck
     * @since 1.0
     */
    public Model getTruckModel() {
        return truckModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel getWheel() {
        return wheel;
    }

    /**
     * Returns the color for this order.
     *
     * @return The color for this order.
     * @see Colors
     * @since 1.0
     */
    public Colors getBaseColor() {
        return baseColor;
    }

    /**
     * Tells is customer asked for a truck with automatic transmission installed.
     *
     * @return <i>true</i>, if customer asked for automatic transmission installed.<br>
     * <i>false</i>, otherwise.
     * @since 1.0
     */
    public boolean hasAutomaticTransmission() {
        return automaticTransmission;
    }

    /**
     * Tells is customer asked for a truck with ergonomic seats installed.
     *
     * @return <i>true</i>, if customer asked for a truck with ergonomic seats installed.<br>
     * <i>false</i>, otherwise.
     * @since 1.0
     */
    public boolean hasErgonomicSeats() {
        return ergonomicSeats;
    }

    /**
     * Tells is customer asked for a truck with long trip equipment installed.
     *
     * @return <i>true</i>, if customer asked for a truck with long trip equipment installed.<br>
     * <i>false</i>, otherwise.
     * @since 1.0
     */
    public boolean hasLongTripEquipment() {
        return longTripEquipment;
    }

    /**
     * Tells is customer asked for a truck with driving assistance installed.
     *
     * @return <i>true</i>, if customer asked for a truck with driving assistance installed.<br>
     * <i>false</i>, otherwise.
     * @since 1.0
     */
    public boolean hasDrivingAssistance() {
        return drivingAssistance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{")
                .append("truckModel=").append(truckModel)
                .append(", engine=").append(engine)
                .append(", wheel=").append(wheel)
                .append(", baseColor=").append(baseColor)
                .append(", automaticTransmission=").append(automaticTransmission)
                .append(", ergonomicSeats=").append(ergonomicSeats)
                .append(", longTripEquipment=").append(longTripEquipment)
                .append(", drivingAssistance=").append(drivingAssistance)
                .append('}');
        return sb.toString();
    }

    /**
     * Builder helper class to create customer orders.<br>
     * This inner class is part of the <b>Builder</b> design pattern.
     *
     * @author alvarm
     * @version 1.0
     */
    public static class Builder {
        private Model truckModel;
        private Engine engine;
        private Wheel wheel;
        private Colors baseColor;
        private boolean automaticTransmission;
        private boolean ergonomicSeats;
        private boolean longTripEquipment;
        private boolean drivingAssistance;

        /**
         * Creates an empty builder.
         *
         * @since 1.0
         */
        public Builder() {

        }

        /**
         * Sets the Truck Model for the to be built order.
         *
         * @param brand The selected truck brand name.
         * @param model The selected truck model name.
         * @return <code>this</code>.
         * @see Model
         * @since 1.0
         */
        public Builder withTruckModel(String brand, String model) {
            this.truckModel = new Model(brand, model);
            return this;
        }

        /**
         * Sets the selected engine for the new truck.
         *
         * @param engineManufacturer The selected engine manufacturer.
         * @param engineModel        The selected engine model.
         * @param enginePower        The selected engine power.
         * @return <code>this</code>.
         * @see Engine
         * @since 1.0
         */
        public Builder withEngine(String engineManufacturer, String engineModel, int enginePower) {
            this.engine = new Engine(new Model(engineManufacturer, engineModel), enginePower);
            return this;
        }

        /**
         * Sets the wheel for the new truck.
         *
         * @param wheelManufacturer The selected wheel manufacturer name.
         * @param wheelModel        The selected wheel model name.
         * @param wheelSize         The selected wheel size.
         * @return <code>this</code>.
         * @see Wheel
         * @since 1.0
         */
        public Builder withWheel(String wheelManufacturer, String wheelModel, int wheelSize) {
            this.wheel = new Wheel(new Model(wheelManufacturer, wheelModel), wheelSize);
            return this;
        }

        /**
         * Sets the Color for the to be built order.
         *
         * @param color The customer selected color.
         * @return <code>this</code>.
         * @see Colors
         * @since 1.0
         */
        public Builder withBaseColor(Colors color) {
            this.baseColor = color;
            return this;
        }

        /**
         * Sets if customer wants a truck with automatic transmission.
         *
         * @param automaticTransmission A boolean flag that states if customer asked for a truck with automatic transmission.
         * @return <code>this</code>.
         * @since 1.0
         */
        public Builder withAutomaticTransmission(boolean automaticTransmission) {
            this.automaticTransmission = automaticTransmission;
            return this;
        }

        /**
         * Sets if customer wants a truck with ergonomic seats installed.
         *
         * @param ergonomicSeats A boolean flag that states if customer asked for a truck with ergonomic seats installed.
         * @return <code>this</code>.
         * @since 1.0
         */
        public Builder withErgonomicSeats(boolean ergonomicSeats) {
            this.ergonomicSeats = ergonomicSeats;
            return this;
        }

        /**
         * Sets if customer wants a truck with long trip equipment installed.
         *
         * @param longTripEquipment A boolean flag that states if customer asked for a truck with long trip equipment installed.
         * @return <code>this</code>.
         * @since 1.0
         */
        public Builder withLongTripEquipment(boolean longTripEquipment) {
            this.longTripEquipment = longTripEquipment;
            return this;
        }

        /**
         * Sets if customer wants a truck with driving assistance installed.
         *
         * @param drivingAssistance A boolean flag that states if customer asked for a truck with driving assistance equipment installed.
         * @return <code>this</code>.
         * @since 1.0
         */
        public Builder withDrivingAssistance(boolean drivingAssistance) {
            this.drivingAssistance = drivingAssistance;
            return this;
        }

        /**
         * Finalizes the building process and creates a new order based on customer preferences.
         *
         * @return A new order based on customer preferences.
         * @see Order
         * @since 1.0
         */
        public Order build() {
            return new Order(this);
        }
    }
}
