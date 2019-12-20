
create database policy_system;
use policy_system;

create table policy(
id int auto_increment not null,
type varchar(20) not null,
policyNo varchar(20) not null,
startDate date not null,
expireDate date not null,
price int not null,
customerId int not null,
primary key (id),
foreign key (customerId) references customers(id)
);

create table customers(
id int auto_increment not null,
name varchar(30) not null,
email varchar(30) not null,
phone varchar(15) not null,
gender varchar(6) not null,
last_four_ssn varchar(4) not null,
dateOfBirth date not null,
primary key (id)   
);

create table address(
id int auto_increment not null,
street1 varchar(30) not null,
street2 varchar(30),
city varchar(25) not null,
state varchar(20) not null,
zip varchar(12) not null,
type varchar(12) not null,
customer_id int,
primary key (id),
foreign key (customer_id) references customers(id)
);

create table covered_vehicles(
id int auto_increment not null,
make varchar(15) not null,
model varchar(15) not null,
year int(5) not null,
color varchar(20),
vin varchar(25) not null unique,
policy_id int,
is_active boolean default 1,
primary key(id),
foreign key (policy_id) references policy(id)
);

create table covered_drivers(
id int auto_increment not null,
name varchar(40),
licenseNo varchar(30),
license_state varchar(30),
policy_id int,
is_active boolean default 1,
primary key (id),
foreign key(policy_id) references policy(id)
);

select * from covered_drivers;

