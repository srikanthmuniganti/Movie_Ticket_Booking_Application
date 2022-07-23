create table Movie (
  id integer auto_increment,
  Addon varchar(255),
  EndDateTime datetime,
  Language varchar(255),
  MovieName varchar(255),
  MovieTheatreAddress varchar(255),
  StartDateTime datetime,
  TicketPrice double not null,
  TotalSeatCount integer not null,
  primary key (id)
);
