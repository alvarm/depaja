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

/**
 * <b>Singleton</b> class that contains reference vehicles.<br>
 * It is implemented using a lazy loaded thread-safe pattern.<br>
 *
 * @author alvarm
 * @version 1.0
 */
public class Catalogue {
    // Start of list of reference vehicles.
    private final Truck basicTruck;
    // End of list of reference vehicles.

    /**
     * Only constructor for this class.<br>
     * We prevent users from creating further instances of this class by making the constructor method private.
     *
     * @since 1.0
     */
    private Catalogue() {
        basicTruck = new EuropeanTruck(new Model("Global Truck", "Test Truck"),
                new Engine(new Model("Global Truck", "v22-Revo"), 500),
                new Wheel(new Model("RubberRun", "RoadRunner"), 20));
    }

    /**
     * Returns the only available instance for this class.<br>
     * If it is the first method invocation, the JVM will instantiate an instance before returning.
     *
     * @return The only instance for this class.
     * @since 1.0
     */
    public static Catalogue getCatalogue() {
        return CatalogueHolder.INSTANCE;
    }

    /**
     * Returns a basic Truck, that can serve as a template.
     *
     * @return A basic, template truck
     * @see Truck
     * @since 0.1
     */
    public Truck getBasicTruck() {
        return basicTruck;
    }

    /**
     * The sole purpose of this inner class is to contain the single instance of the outer class (in this case the Catalogue).<br>
     * This class will be initialised, in turn initialising the INSTANCE field, the first time this class is invoked, i.e. on the first invocation of the <code>Catalogue.getCatalogue()</code> method.
     *
     * @author alvarm
     * @version 1.0
     * @see Catalogue#getCatalogue()
     */
    private static class CatalogueHolder {
        private static final Catalogue INSTANCE = new Catalogue();
    }
}
