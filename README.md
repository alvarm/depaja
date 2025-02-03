# DePaJa

Design Patterns in Java

[![Java CI with Maven (Build and Test)](https://github.com/alvarm/depaja/actions/workflows/maven-build-test.yml/badge.svg)](https://github.com/alvarm/depaja/actions/workflows/maven-build-test.yml)
[![Maven Package](https://github.com/alvarm/depaja/actions/workflows/maven-package.yml/badge.svg)](https://github.com/alvarm/depaja/actions/workflows/maven-package.yml)

## Project description

This project consists in a data model that implements popular design
patterns using (modern) Java.

## Project Structure

The project resides in the `com.github.alvarm.depaja` package that
is made up by the following packages:

1. `model` : Contains a data model where all design patterns will be used.
2. `creational` : Contains a class per each **Creational** design pattern with a
   `public static void main(String args[])` method.
3. `structural` : Contains a class per each **Structural** design pattern with a
   `public static void main(String args[])` method.
4. `behavioural` : Contains a class per each **Behavioural** design pattern with a
   `public static void main(String args[])` method.

## Project Context

The worldwide popular company *Global Truck Co.* is famous for its trucks.
They have several factories around the world and produces several truck models.
Also, depending on the factory site, each produced truck will be aligned with
the security regulations of each site.
