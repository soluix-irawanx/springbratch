-- buat tabel users
CREATE TABLE usersSource (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15),
    address VARCHAR(255)
);

-- Contoh Insert Data ke Tabel `users`
INSERT INTO usersSource (full_name, phone_number, address)
VALUES
('John Doe', '123456789', '123 Elm St'),
('Jane Smith', '987654321', '456 Oak St'),
('Jhon Smith', '987654322', '456 sandiago St');