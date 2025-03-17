# Домашнее задание
# Инфраструктурные паттерны

## Цель:
В этом ДЗ вы создадите простейший RESTful CRUD.


## Описание/Пошаговая инструкция выполнения домашнего задания:
- Сделать простейший RESTful CRUD по созданию, удалению, просмотру и обновлению пользователей.

Пример API - https://app.swaggerhub.com/apis/otus55/users/1.0.0


- Добавить базу данных для приложения.

- Конфигурация приложения должна хранится в Configmaps.

- Доступы к БД должны храниться в Secrets.

- Первоначальные миграции должны быть оформлены в качестве Job-ы, если это требуется.

- Ingress-ы должны также вести на url arch.homework/ (как и в прошлом задании)


- На выходе должны быть предоставлена ссылка на директорию в github, где находится директория с манифестами кубернетеса
инструкция по запуску приложения.
команда установки БД из helm, вместе с файлом values.yaml.
команда применения первоначальных миграций
команда kubectl apply -f, которая запускает в правильном порядке манифесты кубернетеса
Postman коллекция, в которой будут представлены примеры запросов к сервису на создание, получение, изменение и удаление пользователя. Важно: в postman коллекции использовать базовый url - arch.homework.
- Проверить корректность работы приложения используя созданную коллекцию newman run коллекция_постман и приложить скриншот/вывод исполнения корректной работы

### Задание со звездочкой

Добавить шаблонизацию приложения в helm чартах.

## Порядок выполнения:
- Собрать jar файл (maven package)
- собрать образ docker docker build --platform linux/amd64 -t tag .
- docker push tag
- файлы для миграции БД разместить в папке migration
- Собрать образ для миграции БД (Dockerfile.migration) 
docker image build -f Dockerfile.migration --platform linux/amd64 -t  tag .
- docker push tag
- выполнить helm create otus-users
- разместить в папке templates манифесты
- в Chart.yaml нужно указать зависимость для postgres
  dependencies:
    - name: postgresql
      version: 16.x.x
      repository: oci://registry-1.docker.io/bitnamicharts
- Для того, чтобы зависимость скачать - перейти в папку otus-users и выполнить команду helm dependency build
- в values.yaml указать нужные значения переменных
- выполнить helm install otus-users
- minikube tunnel
- коллекция для запросов postman - в папке postman со скринами выполнения
- в файле "C:\Windows\System32\drivers\etc\hosts" (для Windows) добавить 127.0.0.1 arch.homework
- установить newman для запуска запросов postman коллекций из командной строки  npm install -g newman
-  newman run Test_my_app.postman_collection.json


