SELECT HISTORY_ID,
       CAR_ID,
       DATE_FORMAT(start_date, '%Y-%m-%d') AS START_DATE,
       DATE_FORMAT(end_date, '%Y-%m-%d') AS END_DATE,
       CASE WHEN DATEDIFF(end_date, start_date) < 29 THEN '단기 대여'
            ELSE '장기 대여'
            END AS RENT_TYPE
       
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE start_date LIKE '2022-09%'
ORDER BY HISTORY_ID DESC;