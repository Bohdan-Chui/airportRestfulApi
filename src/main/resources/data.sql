#
# LOCK TABLES `air_company` WRITE;
# /*!40000 ALTER TABLE `air_company` DISABLE KEYS */;
# TRUNCATE TABLE air_company;

INSERT IGNORE INTO air_company(name, company_type, founded_date)
VALUES ('LvivAir', 'Regional', '1997-12-02' ),
       ('LondonAir', 'National', '2001-05-13' ),
       ('MariupolCompany', 'Regional', '1991-07-17' ),
       ('FranceCom', 'Major', '1994-02-18' );
# LOCK TABLES `airplane` WRITE;
# /*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
# TRUNCATE TABLE airplane;
INSERT IGNORE INTO airplane
(name, factory_serial_number, number_flights, flight_distance, fuel_capacity, type, created_date, air_company_id)
VALUES ('Antanov AN-225', 'ABS01234', 312, 15400, 375000, 'Transport', '2000-10-23',1),
       ('Airbus A380', 'WDF01234', 412, 15700, 323546, 'Airbus', '2001-02-17',2),
       ('Dassault Falcon 6X', 'ODR01234', 23, 5500, 19156, 'Jet', '1997-03-24',3),
       ('Cessna Citation V', 'PAR01234', 37, 3500, 3272, 'Piston', '1989-11-13',4),
       ('Beechcraft 1900D', 'MRT01234', 700, 970, 2527, 'Piston', '1999-07-09',1);
# UNLOCK TABLES;
# LOCK TABLES `flight` WRITE;
# /*!40000 ALTER TABLE `flight` DISABLE KEYS */;
# TRUNCATE TABLE flight;
INSERT IGNORE INTO flight
(flight_status, departure_country, destination_country, distance, estimated_flight_time, started_time,
 created_date, air_company_id, airplane_id)
VALUES
    ('ACTIVE', 'Spain', 'France', 200, 10000000000000, '2022-02-21 11:10', '2022-02-13 12:00', 1, 1),
    ('ACTIVE','Africa', 'London', 125, 16115000000000, '2022-02-21 12:20', '2022-02-13 12:00', 2, 2),
    ('ACTIVE','Kyiv'  , 'China', 4320, 80150000000000, '2022-02-21 13:30', '2022-02-13 12:00', 3, 3),
    ('ACTIVE','Asia'  , 'Europe', 1200, 20150000000000, '2022-02-21 14:40', '2022-02-13 12:00', 4, 4),
    ('ACTIVE','France', 'France', 6402, 16150000000000, '2022-02-21 15:50', '2022-02-13 12:00', 1, 5),
    ('ACTIVE','Ukraine', 'Italy', 1034, 27280000000000, '2022-02-21 16:05', '2022-02-13 12:00', 2, 1),
    ('ACTIVE','England', 'USA',    890, 5692000000000, '2022-02-21 17:07', '2022-02-13 12:00', 3, 2),
    ('ACTIVE','USA'   , 'Korea',  7423, 39400000000000,'2022-02-21 18:26', '2022-02-13 12:00', 4, 3),
    ('ACTIVE','China', 'Spain',  11032, 6259000000000, '2022-02-21 19:35', '2022-02-13 12:00', 1, 4);

INSERT IGNORE INTO flight
(flight_status, departure_country, destination_country, distance, estimated_flight_time, started_time, ended_time,
 created_date, air_company_id, airplane_id)
VALUES
    ('COMPLETED','Canada', 'USA',  1056, 4100000000000, '2022-02-21 17:35', '2022-02-22 08:00','2022-02-13 20:00', 2, 1),
    ('COMPLETED','Brazil', 'Portu',  15672, 3900000000000, '2022-02-21 19:35', '2022-02-22 12:10','2022-02-13 12:00', 3, 3);
# UNLOCK TABLES;