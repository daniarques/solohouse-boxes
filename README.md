# Solo House boxes

## Overview

This repository contains an example for Solo House's boxes.

## Guidelines

1. Clone this repository
2. `cd src/main/resources/docker`
3. `docker compose up`
4. From project's root: `mvn spring-boot:run`
5. Go to http://localhost:8080/swagger-ui/index.html

[comment]: <> (### For testing kafka producer/consumer:)

[comment]: <> (1. Run ` curl --header "Content-Type: application/json" \)
[comment]: <> (--request POST \)
[comment]: <> (--data '{ "id": 100, "name": "Endurance", "show": "Interstellar" }' \)
[comment]: <> (http://localhost:8080/spaceship`)
[comment]: <> (2. Check logs in order to see log.info)
