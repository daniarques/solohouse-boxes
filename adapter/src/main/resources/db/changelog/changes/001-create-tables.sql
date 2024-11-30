CREATE TABLE box (
	id serial NOT NULL,
	longitude numeric NOT NULL,
	latitude numeric NOT NULL,
	"name" varchar(500) NOT NULL,
CONSTRAINT box_pk PRIMARY KEY (id)
);

CREATE TABLE shirt_design (
	id serial NOT NULL,
	team varchar(500) NOT NULL,
	"style" varchar(500) NOT NULL,
	image_url varchar NULL,
	CONSTRAINT shirt_design_pk PRIMARY KEY (id)
);

CREATE TABLE box_stock (
	shirt_design_id int8 NOT NULL,
	box_id int8 NOT NULL,
	available_amount int4 NOT NULL CONSTRAINT positive_available_amount CHECK (available_amount >= 0),
	real_amount int4 NOT NULL CONSTRAINT positive_real_amount CHECK (real_amount >= 0),
	price numeric NOT NULL CONSTRAINT positive_price CHECK (price > 0),
	CONSTRAINT box_stock_pk PRIMARY KEY (shirt_design_id, box_id),
	CONSTRAINT box_stock_box_fk FOREIGN KEY (box_id) REFERENCES box(id),
	CONSTRAINT box_stock_shirt_design_fk FOREIGN KEY (shirt_design_id) REFERENCES shirt_design(id)
);

CREATE TABLE "user" (
	id serial NOT NULL,
	username varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id),
    CONSTRAINT user_unique UNIQUE (email)
);

CREATE TABLE purchase (
	id serial NOT NULL,
	shirt_design_id int8 NOT NULL,
	user_id int8 NOT NULL,
	picked bool DEFAULT false NOT NULL,
	box_id int8 NOT NULL,
	created_at timestamptz DEFAULT CURRENT_TIMESTAMP NOT NULL,
	picked_at timestamptz NULL,
	CONSTRAINT purchase_pk PRIMARY KEY (id),
	CONSTRAINT purchase_box_fk FOREIGN KEY (box_id) REFERENCES box(id),
	CONSTRAINT purchase_shirt_design_fk FOREIGN KEY (shirt_design_id) REFERENCES shirt_design(id),
	CONSTRAINT purchase_user_fk FOREIGN KEY (user_id) REFERENCES "user"(id)
);