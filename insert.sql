insert into detail_constant (name) values ('Feels like'); -- 50
insert into detail_constant (name) values ('Humidity'); -- 51
insert into detail_constant (name) values ('Visibility'); -- 52
insert into detail_constant (name) values ('Tree Pollen'); -- 53
insert into detail_constant (name) values ('UV Index'); -- 54

insert into state (state_cd, name ) values ('GA', 'Georgia'); -- 200
insert into state (state_cd, name ) values ('FL', 'Florida'); -- 201

insert into city (name,state_id) values ('Alpharetta', 200); -- 100
insert into city (name,state_id) values ('Cumming', 200); -- 101
insert into city (name,state_id) values ('Atlanta', 200); -- 102
insert into city (name,state_id) values ('Orlando', 201); -- 103

insert into zipcode(zipcode,city_id) values (30005, 100); -- 300
insert into zipcode(zipcode,city_id) values (30022, 100); -- 301
insert into zipcode(zipcode,city_id) values (30041, 101); -- 302
insert into zipcode(zipcode,city_id) values (30301, 102); -- 303
insert into zipcode(zipcode,city_id) values (32821, 103); -- 304

update city set zipcode_id=300 where city_id = 100;
update city set zipcode_id=302 where city_id = 101;
update city set zipcode_id=303 where city_id = 102;
update city set zipcode_id=304 where city_id = 103;

insert into weather_day ( min_temp, max_temp, zipcode_id,date, description ) values (23, 45, 300, '2015-03-02', 'Feels like 45. Aweson weather!'); -- 400
insert into weather_day ( min_temp, max_temp, zipcode_id,date, image_id, description ) values (45, 55, 300, '2015-03-03', 250, 'Sunny.');
insert into weather_day ( min_temp, max_temp, zipcode_id,date, image_id, description ) values (45, 72, 300, '2015-03-04', 249, 'Cloudy,Sunny & Rainy.');

insert into weather_detail (weather_day_id,detail_constant_id,detail ) values (400, 50, 'Feels like 16');  -- 500
insert into weather_detail (weather_day_id,detail_constant_id,detail ) values (400, 51, '63%');  -- 501
insert into weather_detail (weather_day_id,detail_constant_id,detail ) values (400, 52, '10 mi');  -- 502
insert into weather_detail (weather_day_id,detail_constant_id,detail ) values (400, 54, 'Moderate 4');  -- 503

insert into weather_hourly(weather_day_id, temp, time, date, order_number) values (400, 17, '6 AM', '2015-2-17', 1); -- 600
insert into weather_hourly(weather_day_id, temp, time, date, order_number) values (400, 20, '7 AM', '2015-2-17', 2);
insert into weather_hourly(weather_day_id, temp, time, date, order_number) values (400, 21, '8 AM', '2015-2-17', 3);
insert into weather_hourly(weather_day_id, temp, time, date, order_number) values (400, 22, '9 AM', '2015-2-17', 4);
insert into weather_hourly(weather_day_id, temp, time, date, order_number) values (400, 24, '10 AM', '2015-2-17', 5);
insert into weather_hourly(weather_day_id, temp, time, date, order_number) values (400, 35, '12 PM', '2015-2-17', 8);
insert into weather_hourly(weather_day_id, temp, time, date, order_number) values (400, 40, '2 PM', '2015-2-17', 9);

insert into image (path, name) values ('icon','cloudy.ico');
insert into image (path, name) values ('icon','cloudyRainy.ico');
insert into image (path, name) values ('icon','particalCloudySunnyRainy.ico');
insert into image (path, name) values ('icon','sunny.ico');
insert into image (path, name) values ('icon','sunnyFlurries');
