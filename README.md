# Overview
This is a student project, which provided system for booking tickets from users side, and managing bus trips and theri properties from admin side

 - Admin panel
 - Trips search
 - Ticket formation and pending
 - Payment process
 - Ticket sending on email

# Building from source
To build the source you will need to install OpenJDK 18, Maven and mysql-server

Check out sources:
````
git clone https://github.com/clientforgit/bus_booking
````
Open repository bus_booking and compile project:
````
mvn compile
````
Package project:
````
mvn package
````
Now open mysql comand-line client and paste SQL code from create_db.sql

Run .jar file:
````
java -jar target/bus_booking-0.0.1-SNAPSHOT.jar
````

Finally, you can check it on host localhost:8080

Or you can watch example on 159.89.99.188:8080:
159.89.99.188:8080 - main page
159.89.99.188:8080/admin - admin panel

# Task
<img width = "650" src = "https://user-images.githubusercontent.com/102827476/217517725-af592938-b7c7-409c-a903-ad5c8ed4ff31.png">
Translate:

"Bus Station"

At the bus station, there is a record of the vehicles (buses/minibuses, license plates, number of seats, driver) and information about the routes (departure station and final destination station, list of stations along the route). The bus station sells tickets, and information about ticket sales is recorded in the cash registers: ticket code, vehicle number, seat number; departure date; departure time; ticket price, departure and arrival station of the passenger.

There is a schedule for bus movements along the routes. The schedule indicates the date and time of departure, route, and arrival time.

Tickets can be booked and sold at the bus station itself.

It is necessary to be able to search for routes to reach the destination, book or buy a ticket, receive information about the availability of seats on the selected route. When booking a seat, the user is given a booking code, with which the passenger can redeem their ticket.

It is necessary to automate the selection of routes that allow you to reach the specified destination. The destination can be either the final one or any station along the route.

Foresee the implementation of the following tasks:

 - Maintaining information about buses, routes, and tickets.
 - Booking and selling of tickets.
 - Viewing information about available seats on a bus along a specified route.
 - Generating a "Cashier Report" for a specified month with the date, route number, number of sold tickets, and the total cost of sold tickets.
 - Generating a route utilization report.
 - Generating a report on the utilization of buses and drivers.

# Interface
Main page:

<img width = "650" src = "https://user-images.githubusercontent.com/102827476/218275332-d05cebfe-61fb-4450-86fb-ed2a11fc7689.png">

Main page of admin panel:

<img width = "650" src = "https://user-images.githubusercontent.com/102827476/218275671-18a3a7c9-13bb-4c75-af75-7c18490490be.png">
