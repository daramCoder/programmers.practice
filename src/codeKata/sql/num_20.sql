-- 기본구조
SELECT
FROM
WHERE
GROUP BY
ORDER BY


--
-- NULL 처리하기
SELECT ANIMAL_TYPE,
       IF (NAME IS NULL, 'No name', NAME) as NAME
        , SEX_UPON_INTAKE
FROM ANIMAL_INS

