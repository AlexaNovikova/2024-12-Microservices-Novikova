## Приложение авторизации/аутентификации

Приложение отвечает на порут 8001

### Сборка проекта:
````
mvn clean package
````

### Сборка docker images:
````shell
docker build -t alexadubinina87/hw-06-auth-app:v01 .
````

### Запуск docker образа:
````shell
docker run --name hw06-auth -p 8001:8001 -e spring.datasource.url='jdbc:postgresql://postgres:5432/postgres' --network=hw-networks -d alexadubinina87/hw-06-auth-app:v06
````

### Проверка network:
````shell
docker network ls
````