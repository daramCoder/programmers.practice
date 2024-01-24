

-- 문제 설명
-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다.
-- ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는
-- 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

-- 동물 수 구하기
-- 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.
SELECT count(ANIMAL_ID)
FROM ANIMAL_INS

-- 7번 문제
-- 동물 보호소에 들어온 동물 중 아픈 동물1의 아이디와 이름을 조회하는 SQL 문을 작성해주세요. 이때 결과는 아이디 순으로 조회해주세요.
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'SICK'
GROUP BY ANIMAL_ID


--     상위 n개 레코드
-- SELECT NAME
-- FROM ANIMAL_INS
-- WHERE DATETIME = (SELECT MAX(DATETIME) FROM ANIMAL_INS)

SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1