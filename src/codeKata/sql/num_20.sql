-- 기본구조
SELECT
FROM
WHERE
GROUP BY
HAVING BY
ORDER BY


--
-- NULL 처리하기
SELECT ANIMAL_TYPE,
       IF (NAME IS NULL, 'No name', NAME) as NAME
        , SEX_UPON_INTAKE
FROM ANIMAL_INS

--          경기도에 위치한 식품창고 목록 출력하기
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS,
       If(FREEZER_YN IS NULL, 'N', FREEZER_YN) as FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID

--     강원도에 위치한 생산공장 목록 출력하기
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID

--     DATETIME에서 DATE로 형 변환
SELECT ANIMAL_ID, NAME,
       DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

--     흉부외과 또는 일반외과 의사 목록 출력하기
SELECT  DR_NAME, DR_ID, MCDP_CD,
        DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD	= 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME

--     가격이 제일 비싼 식품의 정보 출력하기
SELECT  PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD,
        CATEGORY, PRICE
FROM FOOD_PRODUCT
Order by PRICE DESC
    limit 1

-- 이름이 없는 동물의 아이디
SELECT  ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL
Order by ANIMAL_ID

--     조건에 맞는 회원수 구하기
SELECT count(USER_ID) as USERS
FROM USER_INFO
WHERE YEAR(JOINED) = '2021'
  AND 20 <= AGE AND AGE <= 29;

-- 중성화 여부 파악하기
SELECT ANIMAL_ID, NAME,
       IF (SEX_UPON_INTAKE like 'Neutered%' or  SEX_UPON_INTAKE like 'Spayed%', 'O', 'X') AS '중성화'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

--     카테고리 별 상품 개수 구하기
SELECT LEFT(PRODUCT_CODE, 2) CATEGORY
        , COUNT(PRODUCT_ID) PRODUCTS
FROM PRODUCT
GROUP BY CATEGORY


--     고양이와 개는 몇 마리 있을까
SELECT ANIMAL_TYPE, count(ANIMAL_TYPE)
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE

-- 26 입양 시각 구하기
SELECT  HOUR(DATETIME) HOUR,
       COUNT(DATETIME) COUNT
   FROM ANIMAL_OUTS
   GROUP BY HOUR(DATETIME)
   HAVING HOUR >= 9 and HOUR <= 19
   ORDER BY HOUR(DATETIME)

-- having 대신 where 이용한 풀이
SELECT  HOUR(DATETIME) HOUR,
    COUNT(DATETIME) COUNT
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) >= 9 and HOUR(DATETIME) <= 19
GROUP BY HOUR(DATETIME)
ORDER BY HOUR(DATETIME)


-- 진료과별 총 예약 횟수 출력하기
SELECT MCDP_CD as '진료과코드', COUNT(PT_NO) as '5월예약건수'
FROM APPOINTMENT
WHERE YEAR(APNT_YMD) = '2022' AND MONTH(APNT_YMD) = '05'
GROUP BY MCDP_CD
ORDER BY 5월예약건수,  진료과코드

-- 12세 이하인 여자 환자 목록 출력하기
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IF (TLNO IS NULL, 'NONE', TLNO) as TLNO
FROM PATIENT
WHERE (AGE <= 12) AND (GEND_CD = 'W')
order by AGE DESC, PT_NAME

-- 인기있는 아이스크림
SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID

-- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
SELECT CAR_TYPE, COUNT(CAR_ID) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%열선시트%' OR OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE

-- 오랜 기간 보호한 동물(1)
SELECT A.NAME, A.DATETIME
FROM ANIMAL_INS A LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.DATETIME
    LIMIT 3

-- 카테고리 별 도서 판매량 집계하기
SELECT A.CATEGORY, SUM(B.SALES) TOTAL_SALES
FROM BOOK A JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
WHERE B.SALES_DATE LIKE '2022-01%'
GROUP BY A.CATEGORY
ORDER BY A.CATEGORY

-- 다른 풀이
SELECT B.CATEGORY, SUM(BS.SALES)  TOTAL_SALES
FROM BOOK AS B, BOOK_SALES AS BS
WHERE YEAR(BS.SALES_DATE) = '2022'AND MONTH(BS.SALES_DATE) = '01'
AND BS.BOOK_ID = B.BOOK_ID
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY

-- 다른 풀이
SELECT A.category, SUM(B.sales)
FROM book A JOIN book_sales B ON A.book_id = B.book_id
WHERE DATE_FORMAT(B.sales_date, '%Y-%m') = '2022-01'
GROUP BY A.category
ORDER BY A.category

--     오랜 기간 보호한 동물(2)
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS AS A, ANIMAL_OUTS AS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY B.DATETIME - A.DATETIME
        DESC LIMIT 2

--     오랜 기간 보호한 동물(2) 다른 풀이
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS AS A, ANIMAL_OUTS AS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY B.DATETIME - A.DATETIME DESC
LIMIT 2

--    보호소에서 중성화한 동물
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS as I JOIN ANIMAL_OUTS as O
WHERE I.ANIMAL_ID = O.ANIMAL_ID AND I.SEX_UPON_INTAKE != O.SEX_UPON_OUTCOME
ORDER BY I.ANIMAL_ID

--     조건에 맞는 도서와 저자 리스트 출력하기
SELECT B.BOOK_ID, A.AUTHOR_NAME,
       DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK B
         LEFT JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE B.CATEGORY = '경제'
ORDER BY B.PUBLISHED_DATE ASC;

-- 조건별로 분류하여 주문상태 출력하기
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
       CASE WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
            WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
            ELSE '출고미정'
           END AS 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID ASC;
