SELECT
    ID,
    FISH_NAME,
    LENGTH
FROM FISH_INFO FI
JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE (FISH_NAME, LENGTH) IN (
                                SELECT
                                    FNI.FISH_NAME,
                                    MAX(FI.LENGTH) AS LENGTH
                                FROM FISH_INFO FI
                                JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
                                GROUP BY FI.FISH_TYPE
                            )
;