SELECT 
    (
        CASE
            WHEN (SKILL_CODE & (SELECT SUM(CODE) 
                                FROM SKILLCODES
                                WHERE CATEGORY LIKE 'FRONT%'))
                AND SKILL_CODE & (SELECT CODE
                                  FROM SKILLCODES
                                  WHERE NAME = 'PYTHON')
                THEN 'A'
            WHEN SKILL_CODE & (SELECT CODE
                               FROM SKILLCODES
                               WHERE NAME = 'C#')
                THEN 'B'
            WHEN SKILL_CODE & (SELECT SUM(CODE)
                               FROM SKILLCODES
                               WHERE CATEGORY LIKE 'FRONT%')
                THEN 'C'
            ELSE NULL
        END
    ) AS GRADE,
    ID,
    EMAIL
FROM DEVELOPERS
GROUP BY GRADE, ID, EMAIL
HAVING GRADE IS NOT NULL
ORDER BY GRADE ASC, ID ASC;
