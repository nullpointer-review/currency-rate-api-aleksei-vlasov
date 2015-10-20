# currency-rate-api

Тестовое задание Java Backed Developer
https://github.com/newpointer/currency-rate-api

Инструкция по сборке и запуску.

1. Клонировать исходники к себе
2. Запустить сборку при помощи Maven используя pom.xml проекта
3. Получившийся архив currencyrate-0.0.1-SNAPSHOT.war задеплоить на app server

Проверено на apache-tomcat-8.0.27 и GlassFish Server Open Source Edition 4.1 (build 13)

1. Запускаете app server
2. Деплоете currencyrate-0.0.1-SNAPSHOT.war

По умолчанию сервис доступен по адресу
http://localhost:8080/currencyrate-0.0.1-SNAPSHOT/currency/api/rate

Context Root можно настроить индивидуально для каждого из серверов и использовать адрес
http://localhost:8080/currency/api/rate

Использование.

Если нужно например узнать курс доллара за определенную дату пишем так:
http://localhost:8080/currency/api/rate/USD/2010-09-24
или, если за текущую, то так:
http://localhost:8080/currency/api/rate/USD

получим похожий ответ JSON:

{"code":"USD","rate":62.162,"date":"2015-10-21"}

---------------
Aleksei Vlasov


