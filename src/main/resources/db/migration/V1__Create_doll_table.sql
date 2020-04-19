CREATE TABLE doll (
  id int(10) unsigned not null auto_increment,
  name varchar(255) not null,
  type varchar(255) not null,
  star varchar(255) not null,
  production_minute int(10) not null,
  link_url varchar(255) not null,
  how_to_get varchar(255) not null,
  image_url varchar(255) not null,
  created_at datetime not null default current_timestamp,
  updated_at datetime not null default current_timestamp on update current_timestamp,
  primary key (id)
);
