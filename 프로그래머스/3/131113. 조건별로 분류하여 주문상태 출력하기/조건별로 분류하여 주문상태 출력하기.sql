# SELECT
#     ORDER_ID,
#     PRODUCT_ID,
#     OUT_DATE,
#     IF(OUT_DATE <= '2022-05-01', '출고완료',
#        IF(OUT_DATE > '2022-05-01', '출고대기', '출고미정')
#        )AS '출고여부'
# FROM FOOD_ORDER
# ORDER BY ORDER_ID ASC
# ;

SELECT
    ORDER_ID,
    PRODUCT_ID,
    OUT_DATE,
    CASE
        WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
        WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
        ELSE '출고미정'
    END AS '출고여부'
FROM FOOD_ORDER
ORDER BY ORDER_ID ASC
;