# Villa Amelia App
Application for Villa Amelia Business


# Dev env

## Docker Project
`docker build -t villa-amelia-docker .`

### Run docker container
`docker run -p 8080:8080 villa-amelia-docker`
## Docker PostgreSQL Database

### Build docker image
`docker build -t villa-amelia-db ./db`

### Run docker container
`docker run -p 8080:8080 villa-amelia-docker`
## Docker PostgreSQL Database

### Build and run database
`docker-compose up db`
