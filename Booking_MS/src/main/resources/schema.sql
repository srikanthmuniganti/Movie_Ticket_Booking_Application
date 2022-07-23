create table movie (
  id integer auto_increment,
  booked_by varchar(255),
  end_date_time timestamp,
  how_many_seats integer not null,
  language varchar(255),
  movie_name varchar(255),
  movie_theatre_address varchar(255),
  start_date_time datetime,
  ticket_price double not null,
  primary key (id)
);