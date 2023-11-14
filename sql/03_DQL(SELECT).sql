-- DQL (SELELCT)
/*
    DQL: Data Query Language == SELECT
    
    <SELELCT>
        [문법]
            SELECT 칼럼1, 칼럼2, ...
            FROM 테이블명;
            
        - 데이터를 조회할 때 사용
        - 조회된 결과는 RESULT SET (결과 집합) 으로 표현된다.
        - 테이블에 없는 칼럼을 조회하면 안됨
*/

-- EMPLOYEE 테이블에서 전체 사원의 사번(EMP_ID), 이름(EMP_nAME), 월급(SALARY) 조회

SELECT EMP_ID, EMP_NAME, SALARY 
FROM EMPLOYEE;

--EMPLOYEE 테이블에서 전체 사원의 모든 컬럼(*) 정보 조회
SELECT * 
FROM EMPLOYEE;

--쿼리는 대소문자 상관없음

/*
    <산술연산>
    SELECT 절의 컬럼명 입력 부분에서 산술 연산 가능
*/

--이름, 연봉 조회
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

-- 보너스 포함해서 조회
-- 산술 연산 중, NULL값이 존재하면 결과값은 무조건 NULL이 나옴
SELECT EMP_NAME, SALARY * 12 + SALARY * BONUS
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 직원명, 입사일(HIRE_DATE), 근무일수(오늘 날짜 - 입사일)
-- DATE 형식 간 연산 가능
-- 현재시각 : SYSDATE
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE "근무 일수" --띄어쓰기하려면 " "안에 넣기
FROM EMPLOYEE;

-- 칼럼명에 별칭 (AS)

/*
    <리터럴>
        SELECT절에서 리터럴 사용 가능
*/

SELECT EMP_NAME, EMAIL, 123, 'ABC'
FROM EMPLOYEE;

-- 연습
-- 사원 테이블에서 모든 사원의 모든 정보 조회
SELECT *
FROM EMPLOYEE;

-- 연습
-- 사원 테이블에서 모든 사원의 이름, 이메일, 전화번호 조회
SELECT EMP_NAME, EMAIL, PHONE
FROM EMPLOYEE;

-- 연습
-- 사원 테이블에서 모든 사원의 이름, 월급, 연봉 조회
-- (연봉은 월급 * 12로 계산)
-- (단,연봉 조회 결과는 칼럼 별칭을 연봉으로 지정
SELECT EMP_NAME, SALARY, SALARY * 12 AS 연봉
FROM EMPLOYEE;

-- 연습
-- 사원 테이블에서 모든 사원의 직원코드 (JOB_CODE) 조회
SELECT JOB_CODE
FROM EMPLOYEE;

/*
    <DISTINCT>
        -중복값 제거
        -SELECT 절에서 한번만 사용 가능
        - 칼럼이 여러개라면? 모두 동일해야 중복으로 판단
*/

-- 직원코드 조회 (중복제거)
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- 부서코드 조회 (중복제거)
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- 직원코드, 부서코드 조회(둘다 같지않으면 중복으로 처리하지 않음)
SELECT DISTINCT JOB_CODE, DEPT_CODE
FROM EMPLOYEE;

/*
    <연결 연산자>
        여러 칼럼 값을 연결해줌
        리터럴 값을 연결해줌
        칼럼과 리터럴을 연결해줌
*/

-- 사번, 사원명, 급여 조회
SELECT EMP_ID || '사번을 가진 ' || EMP_NAME || ' 사원의 급여는 '|| SALARY || '입니다'
FROM EMPLOYEE;

/*
    <WHERE>
        [문법]
        SELECT 칼럼, ~~~
        FROM 테이블명
        WHERE 조건식;
        
    -조회하려는 ROW가 조건식을 만족해야 조회
    -조회식에는 연산자 사용 가능
*/

-- 부서코드가 D9가 사원들의 모든 칼럼 조회

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE != 'D9';

-- ORACLE에서는 !=, ^=, <> 세 기호 모두 같은 의미를 가진다.

-- EMPLOYEE 테이블에서 급여가 400만원 이상인 직원들의
-- 직원명, 부서코드, 급여조회

SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

------------------ 실습 문제 -----------------
-- 1. EMPLOYEE 테이블에서 재직 중(ENT_YN 컬럼 값이 'N')인 직원들의 사번, 이름, 입사일 조회 
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N';

-- 2. EMPLOYEE 테이블에서 연봉이 5000이상인 직원의 직원명, 급여, 연봉, 입사일 조회
SELECT EMP_NAME, SALARY, SALARY * 12 AS 연봉 , HIRE_DATE
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000;
---------------------------------------------
-- EMPLOYEE 테이블에서 부서 코드가 D6이면서 급여가 300만원 이상인 직원들의 사번, 직원명, 부서 코드, 급여 조회
SELECT EMP_ID AS 사번, EMP_NAME AS 직원명, EMP_NO AS 부서코드, SALARY AS 급여
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' 
AND SALARY >= 3000000;

-- EMPLOYEE 테이블에서 급여가 400만원 이상, 직급 코드가 J2인 사원의 모든 컬럼 조회
SELECT * 
FROM EMPLOYEE
WHERE JOB_CODE = 'J2'
AND SALARY >= 4000000;

-- EMPLOYEE 테이블에서 급여가 350만원 이상 600만원 이하를 받는 직원의 사번, 직원명, 부서 코드, 급여 조회
SELECT EMP_ID AS 사번, EMP_NAME AS 직원명, EMP_NO AS 부서코드, SALARY AS 급여
FROM EMPLOYEE
WHERE SALARY >= 3500000 
AND SALARY <= 6000000;

/*
    <BETWEEN A AND B>
    - A이상 B이하
*/

-- EMPLOYEE 테이블에서 급여가 350만원 이상 600만원 이하를 받는 직원의 사번, 직원명, 부서 코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- EMPLOYEE 테이블에서 급여가 350만원 이상 600만원 이하가 아닌 직원의 사번, 직원명, 부서 코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE NOT SALARY BETWEEN 3500000 AND 6000000
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- EMPLOYEE 테이블에서 입사일 '90/01/01' ~ '01/01/01'인 사원의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01'--따음표안에 있다고해서 문자열로 인식하는건 아님
ORDER BY EMP_NAME;

/*
    <LIKE>
        [문법]
            WHERE 비교대상컬럼 LIKE '특정 패턴';
            
        - 비교하려는 컬럼 값이 지정된 특정 패턴에 만족할 경우 TRUE를 리턴한다.
        - 특정 패턴에는 '%', '_'를 와일드카드로 사용할 수 있다.
          '%' : 0글자 이상
            ex) 비교대상컬럼 LIKE '문자%'  => 비교대상컬럼 값 중에 '문자'로 시작하는 모든 행을 조회한다.
                비교대상컬럼 LIKE '%문자'  => 비교대상컬럼 값 중에 '문자'로 끝나는 모든 행을 조회한다.
                비교대상컬럼 LIKE '%문자%' => 비교대상컬럼 값 중에 '문자'가 포함되어 있는 모든 행을 조회한다.
                
          '_' : 1글자
            ex) 비교대상컬럼 LIKE '_문자'  => 비교대상컬럼 값 중에 '문자'앞에 무조건 한 글자가 오는 모든 행을 조회한다.
                비교대상컬럼 LIKE '__문자' => 비교대상컬럼 값 중에 '문자'앞에 무조건 두 글자가 오는 모든 행을 조회한다.
*/

-- EMPLOYEE 테이블에서 성이 전 씨인 사원의 사원명, 급여, 입사일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- EMPLOYEE 테이블에서 이름 중에 '하'가 포함된 사원의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

-- EMPLOYEE 테이블에서 전화번호 4번째 자리가 9로 시작하는 사원의 모든 칼럼 조회
SELECT *
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

--EMPLOYEE 테이블에서 이메일 중 _ 앞 글자가 3자리인 이메일 주소를 가진 사원의 사번 사원명, 이메일 조회
-- ex) sun_di@kh.or.kr, yoo_js@kh.or.kr, ...
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___/_%' ESCAPE '/';

------------------- 실습 문제 -------------------
-- 1. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

-- 2. DEPARTMENT 테이블에서 해외영업부에 대한 모든 컬럼 조회
SELECT *
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%';
------------------------------------------------

/*
    <IS NULL / IS NOT NULL>
        [문법]
            WHERE 비교대상컬럼 IS [NOT] NULL;
            
        - 컬럼 값에 NULL이 있을 경우 NULL 값 비교에 사용된다.
          IS NULL : 비교대상컬럼 값이 NULL인 경우 TRUE를 리턴한다.
          IS NOT NULL : 비교대상컬럼 값이 NULL이 아닌 경우 TRUE 리턴한다.
*/ 

-- EMPLOYEE 테이블에서 보너스를 받지 않는 사원의 사번, 사원명, 급여 조회

--EMPLOYEE 테이블에서 관리자(사수)가 없는 사원 이름, 부서 코드 조회 

/*
    <IN>
        [문법]
            WHERE 비교대상컬럼 IN('값', '값', '값', ..., '값');
        
        - 값 목록 중에 일치하는 값이 있을 때 TRUE 리턴한다.
*/
--부서코드 D5, D6, D8에 해당하는 사원들의 모든 칼럼 조회

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5', 'D6', 'D8');

/*
    <연산자 우선순위>
        0. ()
        1. 산술 연산자
        2. 연결 연산자
        3. 비교 연산자
        4. IS NULL, LIKE, IN
        5. BETWEEN AND
        6. 논리 연산자 - NOT
        7. 논리 연산자 - AND
        8. 논리 연산자 - OR
*/

/*
    <ORDER BY>
        [문법]
            SELECT 컬럼, 컬럼, ..., 컬럼
              FROM 테이블명
             WHERE 조건식
          ORDER BY 정렬시키고자 하는 컬럼명|별칭|컬럼 순번 [ASC|DESC] [NULLS FIRST | NULLS LAST];
          
        - SELECT 문에서 가장 마지막에 기입하는 구문으로 실행 또한 가장 마지막에 진행된다.
        - ASC : 오름차순으로 정렬한다. (ASC 또는 DESC 생략 시 기본값)
        - DESC : 내림차순으로 정렬한다.
        - NULLS FIRST : 정렬하고자 하는 컬럼 값에 NULL이 있는 경우 해당 데이터 값을 맨 앞으로 정렬한다.
        - NULLS LAST : 정렬하고자 하는 컬럼 값에 NULL이 있는 경우 해당 데이터 값을 맨 뒤로 정렬한다.
*/

-- EMPLOYEE 테이블에서 BONUS로 오름차순 정렬
SELECT *
FROM EMPLOYEE
ORDER BY BONUS ASC; -- 정렬은 기본이 ASC, ASC는 기본적으로 NULLS LAST

-- EMPLOYEE 테이블에서 BONUS로 내림차순 정렬(단, BONUS 값이 일치할 경우 그때는 SALARY 가지고 오름차순정렬)
SELECT *
FROM EMPLOYEE
ORDER BY BONUS DESC, SALARY ASC;

-- EMPLOYEE 테이블에서 연봉별 내림차순으로 정렬된 사원의 사원명, 연봉 조회
SELECT EMP_NAME, SALARY * 12 AS 연봉 -- 띄어쓰기 쓸 때는 따음표 써줘야함 ,홑따음표가 문자열
FROM EMPLOYEE
ORDER BY 연봉 DESC -- SELECT에서 별칭을 주면, ORDER BY 에서 쓸 수 있음