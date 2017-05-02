-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-03-20 20:00:37.058

-- tables
-- Table: LIBROS
CREATE TABLE LIBROS (
    Id varchar(50) NOT NULL,
    nombre varchar(100) NOT NULL,
    editorial varchar(100) NOT NULL,
    autor varchar(100) NOT NULL,
    imagen blob NULL,
    latitude double NULL,
    longitude double NULL,
    USUARIOS_email varchar(100) NULL,
    CONSTRAINT LIBROS_pk PRIMARY KEY (Id)
);

-- Table: SOLICITUDES
CREATE TABLE SOLICITUDES (
    fecha date NOT NULL,
    estado bool NOT NULL,
    LIBROS_Id1 varchar(50) NOT NULL,
    Id int NOT NULL,
    LIBROS_Id2 varchar(50) NOT NULL,
    CONSTRAINT SOLICITUDES_pk PRIMARY KEY (Id)
);

-- Table: USUARIOS
CREATE TABLE USUARIOS (
    email varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    nombre varchar(100) NOT NULL,
    celular varchar(100) NOT NULL,
    imagen blob NULL,
    role varchar(50) not null,
    CONSTRAINT USUARIOS_pk PRIMARY KEY (email)
);

-- foreign keys
-- Reference: LIBROS_USUARIOS (table: LIBROS)
ALTER TABLE LIBROS ADD CONSTRAINT LIBROS_USUARIOS FOREIGN KEY LIBROS_USUARIOS (USUARIOS_email)
    REFERENCES USUARIOS (email);

-- Reference: SOLICITUDES_LIBROS (table: SOLICITUDES)
ALTER TABLE SOLICITUDES ADD CONSTRAINT SOLICITUDES_LIBROS FOREIGN KEY SOLICITUDES_LIBROS (LIBROS_Id1)
    REFERENCES LIBROS (Id);

-- Reference: SOLICITUDES_LIBROS (table: SOLICITUDES)
ALTER TABLE SOLICITUDES ADD CONSTRAINT SOLICITUDES_LIBROS2 FOREIGN KEY SOLICITUDES_LIBROS2 (LIBROS_Id2)
    REFERENCES LIBROS (Id);

-- End of file.

INSERT INTO `USUARIOS` (`email`,`password`,`nombre`, `celular`, `imagen`, `role`)
	VALUES
		('alejo@sharebook.com', 'password', 'Administrador Sharebook', '3103101010',LOAD_FILE('http://www.free-icons-download.net/images/administrator-icon-5154.png'), 'ROLE_ADMIN'),
		('admin@sharebook.com', 'password', 'Administrador Sharebook', '3103101010',LOAD_FILE('http://www.free-icons-download.net/images/administrator-icon-5154.png'), 'ROLE_ADMIN'),
        ('diego@sharebook.com', 'password', 'Diego Mendez', '3103101011',LOAD_FILE('https://scontent.fbog2-1.fna.fbcdn.net/v/t1.0-9/14449927_10209799835408003_5714881594361642354_n.jpg?oh=d140e3aadec6daf82b184b59c79699f4&oe=59593946'), 'ROLE_USER');
        
INSERT INTO `LIBROS` (`Id`,`nombre`,`editorial`, `autor`, `imagen`, `latitude`, `longitude`, `USUARIOS_email`)
VALUES
	('1', 'La Biblia', 'Norma', 'Dios', LOAD_FILE('http://www.erroreshistoricos.com/images/stories/articulos/biblia.jpg'), 4.783699, -74.044713, 'admin@sharebook.com'),
    ('2', 'El Alquimista', 'Norma', 'Paulo Coelho', LOAD_FILE('http://2.bp.blogspot.com/-5p69AgxAIc4/VXqRvXlhD7I/AAAAAAAAFIM/V-Pa6DNpZ4w/s1600/El%2BAlquimista.jpg'), 4.782627, -74.042634, 'admin@sharebook.com'),
    ('3', 'English for Dummies', 'Norma', 'English', LOAD_FILE('https://images-na.ssl-images-amazon.com/images/I/51OKSh1gWQL._SX396_BO1,204,203,200_.jpg'), 4.782603, -74.044069, 'admin@sharebook.com'),
    ('4', 'Cien años de Soledad', 'Norma', 'Gabriel Garcia', LOAD_FILE('https://imagessl8.casadellibro.com/a/l/t0/68/9788439728368.jpg'), 4.783601, -74.042311, 'diego@sharebook.com'),
    ('5', 'Juegos del Hambre', 'Norma', 'Suzanne Collins', LOAD_FILE('C:\Users\Diego\SpringBootShareApp\src\main\resources\static\app\imagenes\hambre.jpg'), 4.783981, -74.043069, 'diego@sharebook.com');
   
 INSERT INTO `SOLICITUDES` (`fecha`,`estado`, `LIBROS_Id1`,`Id`, `LIBROS_Id2`)
	VALUES
		('2017-03-22', FALSE, '2', '1', '3');

