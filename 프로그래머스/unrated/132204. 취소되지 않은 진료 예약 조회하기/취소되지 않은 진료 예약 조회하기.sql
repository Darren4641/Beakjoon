-- 코드를 입력하세요
SELECT A.APNT_NO, P.PT_NAME, A.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM (
    SELECT APNT_NO, PT_NO, MDDR_ID, MCDP_CD, APNT_YMD
    FROM APPOINTMENT
    WHERE APNT_CNCL_YN = 'N'
    AND DATE_FORMAT(APNT_YMD, '%Y-%m-%d') = DATE_FORMAT(STR_TO_DATE('2022-04-13', '%Y-%m-%d'), '%Y-%m-%d')
    AND MCDP_CD = 'CS'
    ) A
JOIN PATIENT P ON A.PT_NO = P.PT_NO
JOIN DOCTOR D ON A.MDDR_ID = D.DR_ID
ORDER BY APNT_YMD ASC
;

#SELECT DATE_FORMAT(STR_TO_DATE('2022-04-13', '%Y-%m-%d'), '%Y-%m-%d');
# 
# 
#DATE_FORMAT(APNT_CNCL_YMD, '%Y-%m-%d') <> DATE_FORMAT(STR_TO_DATE('2022-04-13', '%Y-%m-%d'), '%Y-%m-%d')
