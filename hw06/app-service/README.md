## Приложение пользователей

Приложение отвечает на порут 8002

### Сборка проекта:
````
mvn clean package
````

### Сборка docker images:
````shell
docker build -t alexadubinina87/hw-06-service:v02 .
````

### Запуск docker образа:
````shell
docker run --name hw06-service -p 8002:8002 -e spring.datasource.url='jdbc:postgresql://postgres:5432/postgres' --network=hw-networks -d alexadubinina87/hw-06-service:v05
````

### Проверка network:
````shell
docker network ls
````