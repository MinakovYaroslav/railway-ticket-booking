# Поиск наиболее прибыльного маршрута за текущий квартал
SELECT cruise_id, SUM(price)
FROM tickets
GROUP BY cruise_id
HAVING cruise_id IN (SELECT cruise_id
                     FROM tickets
                     WHERE order_date BETWEEN (MAKEDATE(YEAR(CURDATE()), 1) + INTERVAL QUARTER(CURDATE()) QUARTER -
                                               INTERVAL 1 QUARTER -
                                               INTERVAL 1 DAY) AND (MAKEDATE(YEAR(CURDATE()), 1) + INTERVAL QUARTER(CURDATE()) QUARTER))
ORDER BY price DESC
LIMIT 1