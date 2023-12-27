# Итоговая контрольная работа
#### Задача: необходимо организовать систему учета для питомника в котором живутдомашние и вьючные животные.

#### Решение: короткие задачи выполненны в файле README.md, на объемные задачи сделаны отдельные файлы и также указана ссылка в README.md

## Задания 
1 . Используя команду cat в терминале операционной системы Linux, создатьдва файла Домашние животные (заполнив файл собаками, кошками,хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами иослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека). 
[Задача 1](task_1.md) - подробный файл.


2 . Cоздать директорию, переместить файл туда. 
```
mkdir task_2
mv Human_friends task_2/
```

3 . Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория. [Задача 3](task_3.md) - подробный файл.


4 . Установить и удалить deb-пакет с помощью dpkg.
```
wget https://go.skype.com/skypeforlinux-64.deb
sudo dpkg -i skypeforlinux-64.deb
sudo dpkg -r skypeforlinux
```


5 . Выложить историю команд в терминале ubuntu. [Задача 5](task_5.md) - подробный файл.


6 . Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы). [Задача 6](task_6.png) - подробный файл.


7 . В подключенном MySQL репозитории создать базу данных “Друзья
человека”
.
```
DROP SCHEMA IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;
```


8 . Создать таблицы с иерархией из диаграммы в БД. [Задача 8](task_8.md) - подробный файл.


9 . Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения. [Задача 9](task_9.md) - подробный файл.


10 . Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
```
DELETE FROM KennelAnimal WHERE genius_id = 2;
CREATE TABLE HorseAndDonkey AS
SELECT * from KennelAnimal WHERE genius_id = 1
UNION
SELECT * from KennelAnimal WHERE genius_id = 3;
```


11 . Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.
```
CREATE TABLE YoungAnimals AS
SELECT id, name, birthDate, datediff(curdate(),birthDate) DIV 31 as age, genius_id 
from KennelAnimal WHERE date_add(birthDate, INTERVAL 1 YEAR) < curdate() 
AND date_add(birthDate, INTERVAL 3 YEAR) > curdate();
```


12 . Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
```
SELECT ka.id as "id животного", ka.name as "имя", ka.birthDate as "дата рождения",  
	ka.genius_id, acm.command_id, com.name as "Команды", ag.name as "Тип", agr.name as "Группа", ya.age
FROM kennelanimal ka 
LEFT JOIN animalcommands acm on acm.animal_id = ka.id
LEFT JOIN commands com on com.id = acm.command_id
LEFT JOIN animalgenius ag on ag.id = ka.genius_id
LEFT JOIN animalgroup agr on agr.id = ag.group_id
LEFT JOIN younganimals ya on ya.id = ka.id
```
