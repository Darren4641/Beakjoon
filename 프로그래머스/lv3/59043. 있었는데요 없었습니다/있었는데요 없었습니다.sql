-- 코드를 입력하세요
SELECT AO.ANIMAL_ID, AO.NAME
FROM ANIMAL_INS AI
left JOIN ANIMAL_OUTS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AO.DATETIME < AI.DATETIME
ORDER BY AI.DATETIME ASC
;

# DATEDIFF(DATE_FORMAT(AO.DATETIME, '%Y-%m-%d'), DATE_FORMAT(AI.DATETIME, '%Y-%m-%d')) < 0

