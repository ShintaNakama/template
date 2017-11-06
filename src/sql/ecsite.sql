drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
login_flg boolean default FALSE,
insert_date datetime,
updated_date datetime
);

drop table if exists reservation_info;

create table reservation_info(
reservation_number int(10) primary key auto_increment,
reservation_name varchar(50),
reservation_date varchar(12),
reservation_start varchar(10),/*予約開始時間*/
reservation_end varchar(10),/*予約終了時間*/
reservation_login_user varchar(50),
update_date datetime default current_timestamp on update current_timestamp,
delete_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);



INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous", "internous01", "test");
