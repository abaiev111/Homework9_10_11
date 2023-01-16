DROP DATABASE IF EXISTS appledb;
CREATE DATABASE appledb;

USE appledb;

DROP TABLE IF EXISTS appleFactory;
CREATE TABLE appleFactory (
        factoryId INT AUTO_INCREMENT PRIMARY KEY,
        country VARCHAR(255) DEFAULT NULL)
ENGINE=INNODB;

DROP TABLE IF EXISTS iphone;
CREATE TABLE iphone (
        iphoneId INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        color VARCHAR(255) NOT NULL,
        price VARCHAR(255) DEFAULT NULL,
        fk_iphone INT REFERENCES appleFactory(factoryId) ON DELETE CASCADE)
ENGINE=INNODB;

#   логін і пароль до БД в папці resources/application.properties
#
#   http://localhost:8080/api/iphone/create : створення сутності 1 POST ->
# {
#     "name": "iphone135",
#     "color": "black",
#     "price": "23.000",
#     "fkIphone": 3
# }
#
#   http://localhost:8080/api/iphone/2 отримати элемент сутності 1 GET
#
#   http://localhost:8080/api/iphone/update/1 : оновити элемент сутності 1 PUT ->
# {
#     "name": "iphone122222",
#     "color": "white",
#     "price": "40.000",
#     "fkIphone": 2
# }
#
#   http://localhost:8080/api/iphone/delete/1 : видалити элемент сутності 1 DELETE
#
#   http://localhost:8080/api/iphone/_search : пошук елемента сутності 1 по двом полям з постраничником : POST ->
# {
#     "name": "iphone13",
#     "color": "black",
#     "from": 0,
#     "size": 5
# }
#
#   http://localhost:8080/api/factory/getAll : отримати список елементів сутності 2


