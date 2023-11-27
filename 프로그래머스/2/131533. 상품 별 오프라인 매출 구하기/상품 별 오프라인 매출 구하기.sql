
    
SELECT p.product_code AS PRODUCT_CODE, SUM(p.price * o.sales_amount) AS SALES
FROM product AS p JOIN OFFLINE_SALE AS o 
    ON p.product_id = o.product_id
GROUP BY p.product_id
ORDER BY SALES DESC, PRODUCT_CODE ASC;