WITH SALES_IN_2022_01 AS (SELECT
                            B.BOOK_ID,
                            B.CATEGORY,
                            B.AUTHOR_ID,
                            A.AUTHOR_NAME,
                            B.PRICE * BS.SALES AS SALE_PRICE,
                            BS.SALES_DATE
                        FROM BOOK B
                        JOIN BOOK_SALES BS ON B.BOOK_ID = BS.BOOK_ID
                        JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
                        WHERE YEAR(BS.SALES_DATE) = 2022 AND MONTH(BS.SALES_DATE) = 1)
SELECT
    A.AUTHOR_ID,
    A.AUTHOR_NAME,
    CATEGORY,
    SUM(SALE_PRICE) AS TOTAL_SALES
FROM SALES_IN_2022_01 SS
JOIN AUTHOR A ON A.AUTHOR_ID = SS.AUTHOR_ID
GROUP BY SS.AUTHOR_ID, CATEGORY
ORDER BY SS.AUTHOR_ID ASC, SS.CATEGORY DESC
;