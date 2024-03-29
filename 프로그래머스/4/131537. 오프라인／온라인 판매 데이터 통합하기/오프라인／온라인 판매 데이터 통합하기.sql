(SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE AS N
WHERE YEAR(SALES_DATE) = 2022 AND MONTH(SALES_DATE) = 3)
UNION ALL
(SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE AS F
WHERE YEAR(SALES_DATE) = 2022 AND MONTH(SALES_DATE) = 3)
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC;