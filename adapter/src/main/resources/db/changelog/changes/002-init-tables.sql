INSERT INTO box (id,name,longitude,latitude) VALUES
	 (1,'Estadio RCD Mallroca',2.6274512679069817,39.58929859953975),
	 (2,'Estadio Athletic Bilbao',-2.949555493307151,43.26414713286044);
INSERT INTO public.shirt_design (id,team,"style",image_url) VALUES
	 (1,'RCD Mallorca','Principal','https://tienda.rcdmallorca.es/cdn/shop/files/CamOfi1.jpg?v=1726227233&width=700'),
	 (2,'RCD Mallorca','Secundaria','https://tienda.rcdmallorca.es/cdn/shop/files/DSC9869_0ba25b2d-146f-42ec-a053-aefa2ffa8f3f.jpg?v=1720686741&width=700'),
	 (3,'RCD Mallorca','Camiseta 2010-2011','https://cdn.footballkitarchive.com/2021/08/05/cxiXBHF03bYHXrX.jpg'),
	 (4,'Athletic Club','Principal','https://shop.athletic-club.eus/cdn/shop/files/TM6250_071_RACINGRED_BRILLIANTWHITE_01_430x.jpg?v=1720517219'),
	 (5,'Athletic Club','Secundaria','https://shop.athletic-club.eus/cdn/shop/files/TM6258_SURFTHEWEB_01_430x.jpg?v=1715588982');
INSERT INTO box_stock (shirt_design_id,box_id,available_amount,real_amount, price) VALUES
	 (1,1,10,10,25),
	 (2,1,5,5,20),
	 (4,1,2,2,30),
	 (4,2,20,20,25),
	 (5,2,8,8,20),
	 (3,1,1,2,120);
INSERT INTO "user" (id,username,email) VALUES
	 (1,'admin','admin@gmail.com'),
	 (2,'dani','dani@gmail.com'),
	 (3,'otro','otro@gmail.com');
INSERT INTO purchase (shirt_design_id,id,user_id,picked,box_id,created_at,picked_at) VALUES
	 (1,100,2,true,1,'2024-11-28 12:48:10.467351+01',NULL),
	 (1,101,2,true,1,'2024-11-28 12:48:10.467351+01',NULL),
	 (3,102,2,false,1,'2024-11-28 12:48:10.467351+01',NULL);
