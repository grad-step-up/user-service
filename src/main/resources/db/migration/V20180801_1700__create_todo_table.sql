CREATE TABLE todo (
    id int PRIMARY KEY AUTO_INCREMENT,
    text TEXT,
    checked BOOLEAN,
    date DATETIME,
    user_id INTEGER NOT NULL ,
    deleted BOOLEAN default false
);