-- 코드를 입력하세요
SET @PRICE = -10000;

SELECT (
    CASE
        WHEN PRICE >= 10000 AND PRICE <= 19999 THEN 10000
        WHEN PRICE >= 20000 AND PRICE <= 29999 THEN 20000
        WHEN PRICE >= 30000 AND PRICE <= 39999 THEN 30000
        WHEN PRICE >= 40000 AND PRICE <= 49999 THEN 40000
        WHEN PRICE >= 50000 AND PRICE <= 59999 THEN 50000
        WHEN PRICE >= 60000 AND PRICE <= 69999 THEN 60000
        WHEN PRICE >= 70000 AND PRICE <= 79999 THEN 70000
        WHEN PRICE >= 80000 AND PRICE <= 89999 THEN 80000
        WHEN PRICE >= 90000 AND PRICE <= 99999 THEN 90000
    END
    ) AS PRICE_GROUP , count(*) as PRODUCTS
FROM PRODUCT
WHERE PRICE >= 10000 and PRICE <= 99999
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP ASC;