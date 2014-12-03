CREATE TABLE posts
(id SERIAL PRIMARY KEY,
 title VARCHAR(250),
 slug VARCHAR(250),
 body TEXT,
 is_published BOOLEAN,
 created_at TIMESTAMP,
 updated_at TIMESTAMP);
