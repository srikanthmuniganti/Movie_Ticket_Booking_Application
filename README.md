# Movie_Ticket_Booking_Application


1. Import these microservices in eclipse/intellij/STS and run main classes of both microservices.

2. First we need to add movies to repo and start booking tickets and also perform few other operations.

3. Database Configuration is not required, as I already have written schema definition file and added it in class path. 

4. To access this H2 database, access url like : localhost:8080/h2-console

Sample Inputs:


1. http://localhost:8080/add_movie_slot

input:    {
	"movieName":  "Aagadu"   ,
	"language":   " telugu"  ,
    "totalSeatCount": 10,
	"movieTheatreAddress":  "Hyderabad",
    "startDateTime": "2022 - 07 - 13 07: 00: 00",
    "endDateTime": "2022 - 07 - 30 07: 00: 00"

    }
2. http://localhost:8080/check_availability
input : 
   {
	"movieName":  "Aagadu"   ,
	"language":   " telugu"  ,
	"address":  "Hyderabad",
    "startDateTime": "2022 - 07 - 13 07: 00: 00"

    }
3. http://localhost:8081/book_tickets
input:
   {
	"movieName":  "Aagadu"   ,
	"language":   " telugu"  ,
	"movieTheatreAddress":  "Hyderabad",
    "ticketPrice": 11.20,
    "bookedBy": "srikanth",
    "howManySeats": 5,
    "startDateTime":  "2022 - 07 - 13 07: 00: 00",
    "endDateTime":  "2022 - 07 - 29 07: 00: 00"
    }
4. http://localhost:8081/get_booking_history/srikanth/week

Note : here name and dateRange changes.

5. http://localhost:8081/aggregate_api/Aagadu/2022 - 07 - 13 07: 00: 00

Note: here movie name and date Changes

