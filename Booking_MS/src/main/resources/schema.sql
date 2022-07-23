create table Movie (
  id integer auto_increment,
  BookedBy varchar(255),
  EndDateTime datetime,
  HowManySeats integer not null,
  Language varchar(255),
  MovieName varchar(255),
  MovieTheatreAddress varchar(255),
  StartDateTime datetime,
  TicketPrice double not null,
  primary key (id)
);
