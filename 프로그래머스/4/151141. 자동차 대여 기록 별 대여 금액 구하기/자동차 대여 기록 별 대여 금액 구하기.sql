WITH TRUCK_RENTAL_HISTORY AS (SELECT
                                h.HISTORY_ID,
                                c.CAR_TYPE,
                                c.DAILY_FEE,
                                DATEDIFF(END_DATE, START_DATE) + 1 AS DURATION,
                                CASE
                                    WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 90 THEN '90일 이상'
                                    WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '30일 이상'
                                    WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 7 THEN '7일 이상'
                                END AS DURATION_TYPE
                            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
                            JOIN CAR_RENTAL_COMPANY_CAR c ON c.CAR_ID = h.CAR_ID
                            WHERE c.CAR_TYPE = '트럭')
SELECT
    th.HISTORY_ID,
    # th.CAR_TYPE,
    # th.DAILY_FEE,
    # th.DURATION,
    # d.*,
    ROUND(th.DAILY_FEE * th.DURATION * (100 - IFNULL(d.DISCOUNT_RATE, 0)) / 100, 0) AS FEE
FROM TRUCK_RENTAL_HISTORY th
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN d ON th.CAR_TYPE = d.CAR_TYPE AND th.DURATION_TYPE = d.DURATION_TYPE
ORDER BY FEE DESC, HISTORY_ID DESC;