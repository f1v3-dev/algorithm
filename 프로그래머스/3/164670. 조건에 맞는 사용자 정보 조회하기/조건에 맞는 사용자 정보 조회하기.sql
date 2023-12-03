SELECT U.USER_ID, U.NICKNAME,
        CONCAT(U.CITY, ' ', U.STREET_ADDRESS1, ' ', U.STREET_ADDRESS2) AS '전체주소',
        CONCAT(substr(U.TLNO, 1, 3), '-', substr(U.TLNO, 4, 4), '-', substr(U.TLNO, 8, 4)) AS '전화번호'
FROM USED_GOODS_BOARD AS B INNER JOIN USED_GOODS_USER AS U
        ON B.writer_id = U.user_id
GROUP BY B.writer_id
HAVING COUNT(B.writer_id) >= 3
ORDER BY U.USER_ID DESC;