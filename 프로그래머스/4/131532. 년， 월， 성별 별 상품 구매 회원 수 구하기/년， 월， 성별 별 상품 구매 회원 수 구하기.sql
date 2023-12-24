SELECT YEAR(O.SALES_DATE) AS YEAR,
       MONTH(O.SALES_DATE) AS MONTH,
       U.GENDER,
       COUNT(DISTINCT U.USER_ID) AS USERS
FROM USER_INFO AS U INNER JOIN ONLINE_SALE AS O
    ON U.USER_ID = O.USER_ID
WHERE U.GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR ASC, MONTH ASC, GENDER ASC;