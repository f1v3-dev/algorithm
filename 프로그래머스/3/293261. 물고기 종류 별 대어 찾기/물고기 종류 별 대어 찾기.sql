SELECT I.ID, N.FISH_NAME, I.LENGTH
FROM FISH_INFO AS I
 JOIN FISH_NAME_INFO AS N
 ON I.FISH_TYPE = N.FISH_TYPE
 WHERE I.ID IN (SELECT ID
                FROM FISH_INFO AS f1
                WHERE LENGTH = (
                    SELECT MAX(LENGTH)
                    FROM FISH_INFO AS f2
                    WHERE f1.FISH_TYPE = f2.FISH_TYPE)
               );