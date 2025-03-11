# Домашнее задание
## Приложение в docker-образ и запушить его на Dockerhub

## Цель:
Обернуть приложение в docker-образ и запушить его на Dockerhub.


## Описание/Пошаговая инструкция выполнения домашнего задания:

- Шаг 1. Создать минимальный сервис, который отвечает на порту 8000 , имеет http-метод: GET /health/  RESPONSE: {"status": "OK"}

- Шаг 2. Cобрать локально образ приложения в докер контенер под архитектуру AMD64.

- Запушить образ в dockerhub


### На выходе необходимо предоставить
- имя репозитория и тэг на Dockerhub 
- ссылку на github c Dockerfile, либо приложить Dockerfile в ДЗ

Обратите внимание, что при сборке на m1 при запуске вашего контейнера на стандартных платформах будет ошибка такого вида:

standard_init_linux.go:228: exec user process caued: exec format error


Для сборки рекомендую указать тип платформы linux/amd64:

docker build --platform linux/amd64 -t tag

## Этапы выполнения:
1) собрать jar файл hw02/hw02-0.0.1-SNAPSHOT.jar
2) выполнить docker build --platform linux/amd64 -t alexadubinina87/dockertest:v02
3) docker push alexadubinina87/dockertest:v02 

## alexadubinina87/dockertest - это имя репозитория docker registry в docker hub
