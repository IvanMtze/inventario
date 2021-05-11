CREATE TABLE public.bajas (
    id bigint NOT NULL,
    descripcion CHARACTER VARYING,
    PRIMARY KEY (id)
);


CREATE TABLE public.categorias (
    id bigint NOT NULL,
    descripcion CHARACTER VARYING,
    nombre CHARACTER VARYING,
    PRIMARY KEY (id)
);


CREATE TABLE public.detalles_pedido (
    id bigint NOT NULL,
    cantidad REAL,
    descuento REAL,
    pago BYTEA NOT NULL,
    pedido BYTEA NOT NULL,
    preciounidad REAL,
    producto BYTEA NOT NULL,
    size integer,
    total REAL,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.detalles_pedido
    (pago);
CREATE INDEX ON public.detalles_pedido
    (pedido);
CREATE INDEX ON public.detalles_pedido
    (producto);


CREATE TABLE public.items (
    id bigint NOT NULL,
    existencias integer,
    producto BYTEA,
    items_id bigint,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.items
    (items_id);


CREATE TABLE public.pagos (
    id bigint NOT NULL,
    detalles CHARACTER VARYING,
    tipodepago CHARACTER VARYING,
    PRIMARY KEY (id)
);


CREATE TABLE public.pedidos (
    id bigint NOT NULL,
    comentarios CHARACTER VARYING,
    fechaderealizacion TIMESTAMP WITHOUT TIME ZONE,
    PRIMARY KEY (id)
);


CREATE TABLE public.productos (
    id bigint NOT NULL,
    descripcion CHARACTER VARYING,
    categoria BYTEA NOT NULL,
    nombre CHARACTER VARYING,
    unit CHARACTER VARYING,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.productos
    (categoria);


CREATE TABLE public.proveedores (
    id bigint NOT NULL,
    direccion CHARACTER VARYING,
    email CHARACTER VARYING,
    nombre CHARACTER VARYING,
    otrosdetalles CHARACTER VARYING,
    telefono CHARACTER VARYING,
    proveedor_id bigint,
    PRIMARY KEY (id)
);

CREATE INDEX ON public.proveedores
    (proveedor_id);


CREATE TABLE public.recepciones (
    id bigint NOT NULL,
    comentarios CHARACTER VARYING,
    fecharecepcion TIMESTAMP WITHOUT TIME ZONE,
    pedido BYTEA,
    PRIMARY KEY (id)
);


CREATE TABLE public.reportes (
    id bigint NOT NULL,
    descripcion CHARACTER VARYING,
    fechageneracion TIMESTAMP WITHOUT TIME ZONE,
    fechareporte TIMESTAMP WITHOUT TIME ZONE,
    PRIMARY KEY (id)
);


CREATE TABLE public.stocks (
    id bigint NOT NULL,
    descripcion CHARACTER VARYING,
    PRIMARY KEY (id)
);


CREATE TABLE public.usuarios (
    id bigint NOT NULL,
    address CHARACTER VARYING,
    email CHARACTER VARYING,
    firstname CHARACTER VARYING,
    lastname CHARACTER VARYING,
    password CHARACTER VARYING,
    phone CHARACTER VARYING,
    username CHARACTER VARYING,
    PRIMARY KEY (id)
);


ALTER TABLE public.detalles_pedido ADD CONSTRAINT FK_detalles_pedido__pago FOREIGN KEY (pago) REFERENCES public.pagos(id);
ALTER TABLE public.detalles_pedido ADD CONSTRAINT FK_detalles_pedido__pedido FOREIGN KEY (pedido) REFERENCES public.pedidos(id);
ALTER TABLE public.detalles_pedido ADD CONSTRAINT FK_detalles_pedido__producto FOREIGN KEY (producto) REFERENCES public.productos(id);
ALTER TABLE public.items ADD CONSTRAINT FK_items__items_id FOREIGN KEY (items_id) REFERENCES public.stocks(id);
ALTER TABLE public.productos ADD CONSTRAINT FK_productos__categoria FOREIGN KEY (categoria) REFERENCES public.categorias(id);
ALTER TABLE public.proveedores ADD CONSTRAINT FK_proveedores__proveedor_id FOREIGN KEY (proveedor_id) REFERENCES public.productos(id);