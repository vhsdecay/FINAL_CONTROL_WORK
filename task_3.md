# Задание 3

Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

#### Скачиваем последнюю версию файла конфигурации:
```
wget sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb
```
#### Добовляем репозиторий:
```
sudo dpkg -i mysql-apt-config_0.8.23-1_all.deb
```
#### Обновляем пакеты:
```
sudo apt-get update
```
#### Устанавливаем MySQL
```
sudo apt-get install mysql-server
```