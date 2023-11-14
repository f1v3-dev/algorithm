SELECT CATEGORY, SUM(S.SALES) AS TOTAL_SALES
FROM BOOK AS B INNER JOIN BOOK_SALES AS S
    ON B.BOOK_ID = S.BOOK_ID
WHERE S.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY ASC;