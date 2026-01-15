CREATE TABLE categoria(
    id_categoria     char(10)       NOT NULL,
    nom_categoria    varchar(50)    NOT NULL,
    CONSTRAINT "PK3" PRIMARY KEY (id_categoria)
)
;



-- 
-- TABLE: estado 
--

CREATE TABLE estado(
    id_estado     char(10)       NOT NULL,
    nom_estado    varchar(30)    NOT NULL,
    CONSTRAINT "PK2" PRIMARY KEY (id_estado)
)
;



-- 
-- TABLE: icono 
--

CREATE TABLE icono(
    id_icono     char(10)        NOT NULL,
    url_icono    varchar(100)    NOT NULL,
    CONSTRAINT "PK4" PRIMARY KEY (id_icono)
)
;



-- 
-- TABLE: proyecto 
--

CREATE TABLE proyecto(
    id_proyecto     char(10)        NOT NULL,
    cod_proyecto    char(10)        NOT NULL,
    nom_proyecto    varchar(100)    NOT NULL,
    descripcion     varchar(300)    NOT NULL,
    fecha_inicio    date            NOT NULL,
    fecha_fin       date            NOT NULL,
    id_estado       char(10)        NOT NULL,
    id_icono        char(10)        NOT NULL,
    id_categoria    char(10)        NOT NULL,
    CONSTRAINT "PK5" PRIMARY KEY (id_proyecto)
)
;



-- 
-- TABLE: usuario_proyecto 
--

CREATE TABLE usuario_proyecto(
	id_usuario_proyecto		bigserial	 NOT NULL,
    id_proyecto       		char(10)     NOT NULL,
    id_usu            		char(10)     NOT NULL,
    fecha_creacion    		timestamp,
    CONSTRAINT "PK12" PRIMARY KEY (id_usuario_proyecto, id_proyecto, id_usu)
)
;



-- 
-- TABLE: usuario 
--

CREATE TABLE usuario(
    id_usu         char(10)        NOT NULL,
    nombre         varchar(60)     NOT NULL,
    apellido       varchar(60)     NOT NULL,
    nom_empresa    varchar(60)     NOT NULL,
    cargo          varchar(30)     NOT NULL,
    telefono       varchar(15)     NOT NULL,
    foto_url       varchar(100)    NOT NULL,
    correo         varchar(100)    NOT NULL,
    password       varchar(30)     NOT NULL,
    CONSTRAINT "PK1" PRIMARY KEY (id_usu)
)
;



-- 
-- TABLE: proyecto 
--

ALTER TABLE proyecto ADD CONSTRAINT "Refestado16" 
    FOREIGN KEY (id_estado)
    REFERENCES estado(id_estado)
;

ALTER TABLE proyecto ADD CONSTRAINT "Reficono17" 
    FOREIGN KEY (id_icono)
    REFERENCES icono(id_icono)
;

ALTER TABLE proyecto ADD CONSTRAINT "Refcategoria18" 
    FOREIGN KEY (id_categoria)
    REFERENCES categoria(id_categoria)
;


-- 
-- TABLE: usuario_proyecto
--

ALTER TABLE usuario_proyecto ADD CONSTRAINT "Refproyecto31" 
    FOREIGN KEY (id_proyecto)
    REFERENCES proyecto(id_proyecto)
;

ALTER TABLE usuario_proyecto ADD CONSTRAINT "Refusuario32" 
    FOREIGN KEY (id_usu)
    REFERENCES usuario(id_usu)
;

