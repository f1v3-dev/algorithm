SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO AS I
WHERE NOT EXISTS (SELECT 1
                  FROM ITEM_TREE AS T            
                  WHERE T.PARENT_ITEM_ID = I.ITEM_ID)
ORDER BY ITEM_ID DESC;
