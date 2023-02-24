-- 코드를 입력하세요
select *
from ((select date_format(sales_date, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from online_sale)
union all
(select date_format(sales_date, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
from offline_sale)) as all_data
where date_format(all_data.SALES_DATE, '%Y-%m') = '2022-03'
order by all_data.SALES_DATE, all_data.PRODUCT_ID, all_data.USER_ID;

