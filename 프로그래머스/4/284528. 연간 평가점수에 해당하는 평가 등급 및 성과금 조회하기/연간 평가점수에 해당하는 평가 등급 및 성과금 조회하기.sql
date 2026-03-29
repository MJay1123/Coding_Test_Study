SELECT
    e.EMP_NO,
    e.EMP_NAME,
    # g.SCORE,
    CASE
        WHEN AVG(g.SCORE) >= 96 THEN 'S'
        WHEN AVG(g.SCORE) >= 90 THEN 'A'
        WHEN AVG(g.SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN AVG(g.SCORE) >= 96 THEN SAL * 0.2
        WHEN AVG(g.SCORE) >= 90 THEN SAL * 0.15
        WHEN AVG(g.SCORE) >= 80 THEN SAL * 0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES e
JOIN HR_GRADE g ON e.EMP_NO = g.EMP_NO
GROUP BY e.EMP_NO
