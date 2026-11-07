WITH FISH_INFO_FULL AS (SELECT
                            ID,
                            FISH_TYPE,
                            IF(LENGTH IS NULL, 10, LENGTH) AS LENGTH,
                            TIME
                        FROM FISH_INFO)
SELECT
    COUNT(ID) AS FISH_COUNT,
    MAX(LENGTH) AS MAX_LENGTH,
    FISH_TYPE
FROM FISH_INFO_FULL
GROUP BY FISH_TYPE
HAVING AVG(LENGTH) >= 33
ORDER BY FISH_TYPE ASC
;