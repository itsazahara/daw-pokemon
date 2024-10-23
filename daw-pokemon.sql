CREATE TABLE pokemon (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    numero_pokedex INT NOT NULL,
    tipo1 VARCHAR(30) NOT NULL,
    tipo2 VARCHAR(30) NOT NULL,
    puntos_salud INT NOT NULL,
    fecha_captura DATETIME,
    capturado ENUM('POKEBALL', 'SUPERBALL', 'ULTRABALL')
);
