# Поиск пассажиров, купивших билеты в указанный пункт назначения, на сумму, больше указанной в запросе, в указанный период времени
SELECT users.*
FROM users, tickets, cruises, routes
GROUP BY tickets.price, users.id, tickets.user_id, tickets.order_date, tickets.cruise_id, cruises.route_id, routes.id, routes.arrival_date, cruises.id
HAVING users.id = tickets.user_id
   AND tickets.cruise_id = cruises.id
   AND cruises.route_id = routes.id
   AND routes.arrival_date = 'Saint Petersburg'
   AND SUM(tickets.price) >= tickets.price
   AND tickets.order_date BETWEEN STR_TO_DATE('2019-01-01','%Y-%m-%d') AND STR_TO_DATE('2019-12-31','%Y-%m-%d')