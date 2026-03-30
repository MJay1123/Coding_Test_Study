WITH MAX_PRICE_PRODUCT AS (SELECT
                                CATEGORY,
                                MAX(PRICE) AS MAX_PRICE
                            FROM FOOD_PRODUCT
                            GROUP BY CATEGORY)
SELECT
    fp.CATEGORY,
    fp.PRICE AS MAX_PRICE,
    fp.PRODUCT_NAME
FROM FOOD_PRODUCT fp
JOIN MAX_PRICE_PRODUCT mpp ON fp.CATEGORY = mpp.CATEGORY AND fp.PRICE = mpp.MAX_PRICE
WHERE fp.CATEGORY IN ('과자','국','김치','식용유')
ORDER BY fp.PRICE DESC;