-- 코드를 입력하세요
SELECT RR.REST_ID, RI.REST_NAME, RI.FOOD_TYPE, RI.FAVORITES, RI.ADDRESS, ROUND(AVG(RR.REVIEW_SCORE), 2) AS SCORE
FROM REST_REVIEW RR
JOIN REST_INFO RI ON RR.REST_ID = RI.REST_ID
WHERE RI.ADDRESS like '서울%'
GROUP BY RR.REST_ID
ORDER BY SCORE DESC, RI.FAVORITES DESC;