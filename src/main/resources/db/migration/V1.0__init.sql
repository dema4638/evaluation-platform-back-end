CREATE TABLE teacher(
                        id bigint PRIMARY KEY,
                        first_name varchar(255) not null,
                        last_name varchar(255) not null
);

insert into teacher (id, first_name, last_name) values (123, 'Vardas', 'Pavarde');