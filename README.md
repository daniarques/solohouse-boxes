# Solo House boxes

## Overview

This repository contains an example for Solo House's boxes.

## Assumptions

This project follows some business logic assumptions.

- User has no time limit for picking a purchased shirt
- When a shirt is purchased, the picking must be done in the box it was bought in

## Guidelines

1. Clone this repository
2. `cd adapter\src\main\resources\docker`
3. `docker compose up`
4. From project's root: `mvn spring-boot:run`
5. Follow front-end guidelines https://github.com/daniarques/solohouse-spa-boxes

## Pending improvements:

- Add OAuth for user authentication

## App structure diagram

![hexagonal-architecture-modules.png](docs/hexagonal-architecture-modules.png)
