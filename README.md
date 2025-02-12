# Learning-OOP-Plane-Management

## Overview

This project was created to help me learn and practice Object-Oriented Programming (OOP). It involves modeling and managing an airplane with various compartments, components, and employees working on the system. The system includes abstract classes for general components, polymorphism for various employee roles, and several methods to ensure the proper functioning of the airplane components.

## Table of Contents
1. [Abstract Classes](#abstract-classes)
2. [Id and Static Functionality](#id-and-static-functionality)
3. [Class `PassengerCompartment`](#class-passengercompartment)
4. [Class `Plane`](#class-plane)
5. [Override of `toString`](#toString)
6. [Polymorphism](#polymorphism)
7. [Abstract Methods](#abstract-methods)
8. [Method Overloading](#method-overloading)
9. [ReadyCheck](#readycheck)
10. [Copy Constructor](#copy-constructor)
11. [Equality Check](#equal)
12. [Segmentation of the Program](#segmentation-of-the-program)

## Abstract Classes
Initially, I decided to define the `Object`, `PlaneComponent`, `PrivateCompartment`, and `Employee` classes as abstract, because they are too general, and their instances don't have real-world representations.

## Id and Static Functionality
I chose to provide each new object with a unique `id` (in subclasses of abstract classes) and a static `count` variable. The reason for not making `id` static is that, for example, with three `Employee` objects, all would have the same `id` if `id` were static.

## Class `PassengerCompartment`
The `PassengerCompartment` class has a constructor with a boolean argument. If the argument is true, it creates an internal `PassengerCompartment`. I avoid creating it inside the constructor to prevent errors and recursive initializations. Instead, I use a helper function that initializes the internal compartment with a `false` argument. The internal compartment is randomized using `Random` to ensure variability.

## Class `Plane`
The `Plane` class is implemented with a constructor that takes two arguments: the plane's name and its capacity. The number of passenger compartments (`numberOfPasComp`) is determined by dividing the capacity by a random number between 50 and 150. I model the passenger compartments and equipment using arrays instead of lists, which would make the implementation unnecessarily complex in this case.

## Override of `toString`
For all non-abstract classes, I override the `toString` method for better object representation. In `PassengerCompartment`, I check if the internal space exists and make the necessary additions. In `CargoBay`, I add the necessary information, as it always contains internal equipment. In `Plane`, I call the `toString` methods of the fields.

## Polymorphism
I use polymorphism in several methods. For example, in the `process` method, instead of having separate methods for each `Employee`, I use an `Employee e` parameter. Through polymorphism, the correct `process` method for a specific employee (e.g., `SecurityEmployee`) is called.

## Abstract Methods
In my abstract classes, I have defined several abstract methods. Since all methods in Java are virtual by default, the overridden method from the subclass is called when the method is invoked.

## Method Overloading
I have used method overloading to define methods with the same name but different parameters. For example, in the `workOn` method, this technique ensures consistency and simplicity in the code.

## ReadyCheck
Each `PlaneComponent` has flags that are checked by `Employees` during their `workOn` method to ensure the component is ready. The `readyCheck` methods return a boolean indicating whether all flags are `true`, meaning the component is ready. The `Plane` class checks the `readyCheck` for all compartments to determine if the plane is ready.

## Copy Constructor
I added a copy constructor to each class because the `clone` method provided by Java carries several risks. In the superclasses, I copied the fields and used `super()` to complete the functionality in subclasses. A special case is the `PassengerCompartment`, where the copy constructor first checks if the source has an internal compartment and then forces the required boolean value.

## Equality Check
I overrode the default `equals` method of `Object` because it only checks if the objects are identical in memory, not if their field values are the same. My `equals` method checks both the field values and whether the objects are identical. This required casting the argument to the appropriate class type.

## Segmentation of the Program
Each class is implemented in its own file, as is customary in Java for better organization and maintainability.

