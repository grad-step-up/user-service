CREATE TABLE todo (
    id int PRIMARY KEY AUTO_INCREMENT,
    text TEXT,
    checked BOOLEAN,
    date DATETIME,
    deleted BOOLEAN default false
);