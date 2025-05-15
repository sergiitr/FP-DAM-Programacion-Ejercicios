CREATE TABLE IF NOT EXISTS "usuarios"
(
    [id] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    [nombre] NVARCHAR(160)  NOT NULL,
    [numero] INTEGER(9)  NOT NULL,
    [correo] NVARCHAR(160)  NOT NULL
);
INSERT INTO usuarios (nombre, numero, correo) VALUES ('aaa','111','aaa');
