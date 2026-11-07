SELECT
    CAR_ID,
    CAR_TYPE,
    CASE
        WHEN CAR_TYPE = 'SUV' THEN DAILY_FEE * 30 * (100 - (SELECT DISCOUNT_RATE
                                                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                                        WHERE CAR_TYPE = 'SUV'
                                                        AND DURATION_TYPE = '30일 이상')
                                                     ) / 100
        WHEN CAR_TYPE = '세단' THEN DAILY_FEE * 30 * (100 - (SELECT DISCOUNT_RATE
                                                       FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                                       WHERE CAR_TYPE = '세단'
                                                       AND DURATION_TYPE = '30일 이상')
                                                    ) / 100
    END AS FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE IN ('SUV', '세단')
AND CAR_ID NOT IN (SELECT
                    CAR_ID
                  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                  WHERE START_DATE <= '2022-11-30'
                  AND END_DATE >= '2022-11-01')
HAVING FEE BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC
;