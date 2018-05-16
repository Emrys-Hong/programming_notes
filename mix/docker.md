# the root website:

create your ubuntu image with docker: https://www.youtube.com/watch?v=JprTjTViaEA

docker cheetsheet: https://jonnylangefeld.github.io/learning/Docker/How%2Bto%2BDocker.html

## get started with docker official website:
https://docs.docker.com/get-started/part3/#docker-composeyml

# docker commands:
```
## List Docker CLI commands
docker
docker container --help

## Display Docker version and info
docker --version
docker version
docker info

## List Docker images
docker image ls

## List Docker containers (running, all, all in quiet mode)
docker container ls
docker container ls --all
docker container ls -aq

## List executed docker containers
docker ps -a

## Change docker name
docker run --name my-hello hello-world

## Remove one docker
docker rm my-hello

## rm all the docker
docker rm $(docker ps -a -f status=exited -q)

## Pass documents to the container; it is like scp
-v [path to local]:[path inside container]
docker run -it --name my-linux-container --rm -v /c/Users/:/my-data ubuntu bash

```

# docker run hello-world
```
Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://cloud.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/engine/userguide/
 ```
 
 # create ubuntu system
```
## Create a ubuntu docker and use bash
docker run -it --name my-linux-container ubuntu bash

## Create a new name from images have downloaded
docker run -it --name my-linux-container-1 ubuntu bash

## Exit the docker
exit

## List all the image we have download so dont have to download again
docker images
```

# dockerfile
```
## Create a file called dockerfile and write the following comand
FROM ubuntu
CMD echo "Hello Jonny" #Yes you can use hashtags as comments here! Just use your name here.
OR
FROM ubuntu
RUN apt-get upgrade && apt-get update && apt-get install -y python3

and then build your images, each line creates a new container, and containers build on top of other containers

## Build your image
docker build -t my-ubuntu-image

## Run the image
docker run my-ubuntu-image

## add -it flag to run interactive 
docker run -it my-ubuntu-image
```
