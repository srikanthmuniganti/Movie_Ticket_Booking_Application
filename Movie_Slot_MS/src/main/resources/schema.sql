create table movie (
  id integer auto_increment  not null,
  addon varchar(255),
  end_date_time datetime,
  language varchar(255) not null,
  movie_name varchar(255) not null,
  movie_theatre_address varchar(255) not null, 
  start_date_time datetime,
  ticket_price double not null,
  total_seat_count integer not null,
  primary key (id)
);