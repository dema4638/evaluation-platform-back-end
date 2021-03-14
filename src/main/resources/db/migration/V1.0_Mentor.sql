create table mentor(
id bigint PRIMARY KEY,
name varchar(255) not null,
stream varchar(255) not null
);

insert into mentor (id, name, stream) value (1, 'Vardenis Pavardenis', 'backend');
insert into mentor (id, name, stream) value (2, 'Bevardis Bevardenis', 'frontend');
insert into mentor (id, name, stream) value (3, 'Nitanas Gausėda', 'QA');