CREATE TABLE task(
    id int PRIMARY KEY AUTO_INCREMENT,
    content TEXT,
    todo_id INTEGER,
    deleted BOOLEAN default false,
    FOREIGN KEY (todo_id) REFERENCES todo(id)
);
