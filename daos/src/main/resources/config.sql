CREATE TABLE 
IF NOT EXISTS 
users(
    id INTEGER 
        PRIMARY KEY 
        AUTOINCREMENT,
    createdat INTEGER
        DEFAULT (strftime('%s','now')),
    updatedat INTEGER
        DEFAULT (strrftime('%s','now'))
    name TEXT 
        NOT NULL,
    cpf TEXT
        NOT NULL
        UNIQUE,
    birthday INTEGER,
    mainphonenumber TEXT
        NOT NULL,
    maincontact TEXT
        NOT NULL,
    phonenumber TEXT,
    contact TEXT,
    email TEXT
        NOT NULL
        UNIQUE,
    zipcode TEXT,
    street TEXT,
    neigborhood TEXT,
    city TEXT,
    hash TEXT,
    passwordhash TEXT
)
CREATE TRIGGER update_users_updatedat
AFTER UPDATE ON users
BEGIN
    UPDATE users 
    SET updatedat = strftime('%s', 'now') 
    WHERE id = NEW.id;
END;
