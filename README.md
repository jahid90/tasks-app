[![service](https://github.com/jahid90/tasks-app/actions/workflows/service.yml/badge.svg)](https://github.com/jahid90/tasks-app/actions/workflows/service.yml)
[![ClientCI](https://github.com/jahid90/tasks-app/actions/workflows/client.yml/badge.svg)](https://github.com/jahid90/tasks-app/actions/workflows/client.yml)

# Tasks App

A web app to manage tasks and task boards.

The frontend is written in ReactJS. The frontend communicates with a backend REST API. The backend is written using Spring Boot.

The API spec is written in OpenAPI 3.0 format and is available in the `/spec` path. The project also includes an embedded swagger server to view and interact with the API.

## Setup

Clone the project.

```sh
$ git clone git@github.com:jahid90/tasks-app.git
```

Setup a `traefik` docker container as a proxy and attach it to a `bridge` network named `traefik`.

```sh
$ cd traefik-proxy
$ cat docker-compose.yml
version: '3.9'

networks:
  traefik:
    name: traefik
    driver: bridge

services:
  traefik:
    image: traefik:2.5
    command:
      - --api=true
      - --providers.docker
      ...
    networks:
      - traefik
    ...
```

Create a dns entry for `tasks.jahiduls.mint`

```sh
$ cat /etc/hosts
...
127.0.0.1       tasks.jahiduls.mint
```

Launch the project

```sh
$ cd tasks-app
$ docker-compose up -d
```

The OpenAPI server should be available at: https://tasks.jahiduls.mint/openapi and the app itself at https://tasks.jahiduls.mint. If SSL/TLS is not enabled for the `traefik proxy`, use `http` instead. If the service, client and openapi spec servers are served under separate domains, the service will have to be updated to allow `CORS`.
