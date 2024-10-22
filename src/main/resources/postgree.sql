-- buat tabel accounts
CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL
);

-- Contoh Insert Data ke Tabel `account`
INSERT INTO accounts (username, password, email, status)
VALUES
('john_doe', 'hashed_password1', 'john.doe@example.com', 'ACTIVE'),
('jane_smith', 'hashed_password2', 'jane.smith@example.com', 'SUSPENDED');