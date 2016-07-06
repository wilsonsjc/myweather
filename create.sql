create table city (city_id integer not null AUTO_INCREMENT,
				   name varchar(50) not null,
				   state_id integer ,
				   zipcode_id integer ,
				   PRIMARY KEY (city_id));
ALTER TABLE city AUTO_INCREMENT = 100;
				   
create table state (state_id integer not null AUTO_INCREMENT ,
				    state_cd varchar(2) not null,
				    name varchar(50) not null,
					PRIMARY KEY (state_id) );			
ALTER TABLE state AUTO_INCREMENT = 200;

create table zipcode (zipcode_id integer not null AUTO_INCREMENT,
				      zipcode integer not null,
				      city_id varchar(50) ,
					  PRIMARY KEY (zipcode_id) );	
ALTER TABLE zipcode AUTO_INCREMENT = 300;

create table image (image_id integer not null AUTO_INCREMENT,
				    path varchar(50),
				    name varchar(50),
					PRIMARY KEY (image_id) );
ALTER TABLE image AUTO_INCREMENT = 247;

create table weather_day (weather_day_id integer not null AUTO_INCREMENT,
						  min_temp integer ,
						  max_temp integer ,
						  zipcode_id  integer ,
						  date date,
						  image_id integer,
						  description varchar(250),
						  PRIMARY KEY (weather_day_id) );	
ALTER TABLE weather_day AUTO_INCREMENT = 400;
				   
create table weather_detail  (weather_detail_id integer not null AUTO_INCREMENT,
							  weather_day_id integer not null,
							  detail_constant_id integer,
							  detail varchar(50),
							  PRIMARY KEY (weather_detail_id) );	
ALTER TABLE weather_detail AUTO_INCREMENT = 500;

create table detail_constant(detail_constant_id integer not null AUTO_INCREMENT, name varchar(100), PRIMARY KEY (detail_constant_id) );				   
ALTER TABLE detail_constant AUTO_INCREMENT = 50;
				   
create table weather_hourly  (weather_hourly_id integer not null AUTO_INCREMENT,
							  weather_day_id integer,
							  temp integer,
							  time varchar(5),
							  date date,
							  image_id integer,
							  description varchar(250),
							  order_number integer,
							  PRIMARY KEY (weather_hourly_id) );	
ALTER TABLE weather_hourly AUTO_INCREMENT = 600;							   
			       