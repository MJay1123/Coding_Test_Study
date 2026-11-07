SELECT
    DISTINCT CAR_ID,
    IF(CAR_ID IN (SELECT
                    DISTINCT CAR_ID
                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CRCRH1
                WHERE NOT EXISTS (SELECT 1
                                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CRCRH2
                                    WHERE CRCRH1.CAR_ID = CRCRH2.CAR_ID
                                    AND '2022-10-16' BETWEEN START_DATE AND END_DATE
                                  )
                  ), '대여 가능', '대여중') AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
ORDER BY CAR_ID DESC
;