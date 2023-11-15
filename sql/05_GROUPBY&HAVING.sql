--GROUP BY, HAVING
/*
    <GROUP BY>
        그룹 기준을 제시할 수 있는 구문
        여래 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용한다.
*/

-- 부서별 사원의 수
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 보너스를 받는 사원 수
SELECT COUNT(BONUS)
FROM EMPLOYEE;

-- 부서별로 보너스를 받는 사원 수
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 급여 평균 조회
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- 부서별 급여 평균 조회
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 남, 녀 사원 수
SELECT SUBSTR(EMP_NO, 8 , 1), COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8 , 1);

-- 부서코드랑 직급코드가 같은 인원 수
SELECT  DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

/*
    <HAVING>
        그룹에 대한 조건을 제시할 때 사용하는 구문
        (주로 그룹 함수의 결과를 가지고 비교 수행)
        5: SELECT      조회하고자 하는 컬럼명 AS "별칭" | 계산식 | 함수식
        1: FROM        조회하고자 하는 테이블명
        2: WHERE       조건식
        3: GROUP BY    그룹 기준에 해당하는 컬럼명 | 계산식 | 함수식
        4: HAVING      그룹에 대한 조건식
        6: ORDER BY    정렬 기준에 해당하는 컬럼명 | 별칭 | 컬럼 순번
        서브쿼리가 있다면 위의 순서의 순서 아래서 작동함.
*/

--조회 : 부서코드, 평균급여
--테이블 : 사원 테이블에서
--조건 : 보너스가 NULL이 아닌 사원들
--그룹 : 부서별로 그룹 나눔
--그룹조건 : 부서의 평균 급여가 300만원 이상
--정렬기준 : 평균급여 기준으로 정렬

--보너스를 받는 사원들에 대하여, 부서코드와 부서별 평균급여를 평균급여 순으로 조회하라
--(단, 평균급여가 300만원 미만인 부서는 제외한다.)

SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000
ORDER BY AVG(SALARY);

-- 각 부서별 급여가 300만원 이상인 직원의 평균 급여 조회
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE;


-- 각 부서별 평균 급여가 300만원 이상인 부서들만 조회
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;

-- 직급별 총 급여의 합이 10000000 이상인 직급들만 조회
SELECT JOB_CODE
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;

-- 부서별 보너스를 받는 사원이 없는 부서들만 조회
SELECT DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

/* 
    <집계 함수>
        그룹별 산출한 결과 값의 중간 집계를 계산 해주는 함수
*/

-- 직급별 급여 합계 조회
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE);

SELECT DEPT_CODE,JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE, DEPT_CODE)
ORDER BY DEPT_CODE, JOB_CODE;

/*
    ROLLUP(칼럼1, 칼럼2, ....) : 칼럼1만 가지고 중간집계
    CUBE(칼럼1, 칼럼2, ....) : 칼럼1로 중간집계, 칼럼2로 중간집계 ...
*/

/*
    <집합 연산자>
        여러 개의 쿼리문을 가지고 하나의 쿼리문으로 만드는 연산자이다.
        
        UNION       : 두 쿼리문을 수행한 결과값을 더한 후 중복되는 행은 제거한다. (합집합)
        UNION ALL   : UNION과 동일하게 두 쿼리문을 수행한 결과값을 더하고 중복은 허용한다. (합집합)
        INTERSECT   : 두 쿼리문을 수행한 결과값에 중복된 결과값만 추출한다. (교집합)
        MINUS       : 선행 쿼리의 결과값에서 후행 쿼리의 결과값을 뺀 나머지 결과값만 추출한다. (차집합)

*/

--부서코드가 D5인 사원 주회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D5';

--급여가 300만원 초과인 사원 조회
SELECT * FROM EMPLOYEE WHERE SALARY > 3000000;

SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D5'
MINUS
SELECT * FROM EMPLOYEE WHERE SALARY > 3000000;
