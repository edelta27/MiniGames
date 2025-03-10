# Mini Gra Lotto

## Overview
MiniGames is a lottery-style game written in Java, where the player selects 6 numbers out of 99 and compares them with randomly drawn results. The game determines how many numbers the player guessed correctly. The project follows object-oriented programming principles, including SOLID, and is designed to be easily extendable for additional games.

## Features
 - Player selects 6 numbers from a range of 1 to 99.
 - The program randomly generates 6 winning numbers.
 - The game compares the selected numbers with the drawn numbers and displays the number of correct guesses.
 - Modular architecture allows for easy addition of new games.

## Technical Aspects
 - **Programming Language:** Java 17+
 - **Collections:** Uses Set for storing numbers and checking matches.
 - **Interfaces:** Implements a Game interface for easy expansion with new games.
 - **SOLID Principles:** Ensures modular, maintainable, and scalable code.
 - **Unit Testing:** JUnit tests validate core game functionalities.
 - **Build Tool:** Maven for dependency management and project build.
 - **Lombok:** Reduces boilerplate code (e.g., auto-generating getters, setters, toString).
 - **Version Control:** Git for project management and collaboration.

This project was developed as part of the GetProJava course.
