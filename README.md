# Cave Exploration

Java-based escape-room adventure game built with object-oriented design principles.

Players explore a network of cave rooms, avoid traps, fight enemies, collect items, and progress toward the level exit.

## Overview

Cave Exploration was developed as part of the Object-Oriented Programming 2 course at the University of Strasbourg.

The project focuses on clean Java architecture, modular design, collaborative development, and practical use of object-oriented programming concepts.

## Features

* Room-based cave exploration
* Player movement and combat
* Configurable health and attack attributes
* Multiple enemy types
* Spike traps with instant-death behavior
* Collectible items
* Fireball projectile attacks
* Modular Java package structure
* UML-based design process

## Items

| Item          | Effect                 |
| ------------- | ---------------------- |
| Magic Potion  | Increases attack power |
| Health Potion | Restores health        |
| Fireball      | Allows ranged attacks  |

## Enemies and Hazards

The game includes enemies with different behaviors, including enemies capable of crossing walls.

Environmental hazards such as spike traps add risk and require careful navigation.

## Controls

| Action          | Input              |
| --------------- | ------------------ |
| Move            | `Z`, `Q`, `S`, `D` |
| Launch fireball | Mouse click        |

## Run

Download the latest release:

```text
Cave-Exploration.jar
```

Run the game:

```bash
java -jar Cave-Exploration.jar
```

## Architecture

The codebase is organized around clear responsibilities.

Main design principles:

* Encapsulation
* Inheritance
* Abstraction
* Polymorphism
* Separation of concerns
* Reusable game entities
* Scalable package structure

The implementation uses abstract classes for shared entity behavior and enumerations for consistent item and entity identification.

## Development

The project was developed collaboratively.

UML class and sequence diagrams were used during the design phase to guide implementation and clarify interactions between game objects.

## Academic Context

Course: Object-Oriented Programming 2
University: University of Strasbourg

## Author

Setayesh Ghamat
