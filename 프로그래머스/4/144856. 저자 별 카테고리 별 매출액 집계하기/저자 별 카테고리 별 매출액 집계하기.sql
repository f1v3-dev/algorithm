SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * S.SALES) AS TOTAL_SALE
FROM BOOK AS B INNER JOIN AUTHOR AS A
    ON B.AUTHOR_ID = A.AUTHOR_ID
               INNER JOIN BOOK_SALES AS S
    ON B.BOOK_ID = S.BOOK_ID
WHERE SALES_DATE LIKE '2022-01%'
GROUP BY A.AUTHOR_ID, B.CATEGORY
ORDER BY A.AUTHOR_ID ASC, B.CATEGORY DESC;