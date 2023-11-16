-- JOIN

/*
    <JOIN>
        �� ���� �̻��� ���̺��� �����͸� ��ȸ�ϰ��� �� �� ����ϴ� �����̴�.
        
        1. � ����(EQUAL JOIN) / ���� ����(INNER JOIN)
            �����Ű�� Į���� ���� ��ġ�ϴ� ��鸸 ���εǼ� ��ȸ�Ѵ�.(��ġ�ϴ� ���� ���� ���� ��ȸ X)
            
            1) ����Ŭ ���� ����
                [ǥ����]
                    SELECT Į��, Į��, ...
                    FROM ���̺�1, ���̺�2
                    WHERE ���̺�1.Į���� = ���̺�2.Į����;
                
                - FROM ���� ��ȸ�ϰ��� �ϴ� ���̺���� �޸�(,)�� �����Ͽ� �����Ѵ�.
                - WHERE ���� ��Ī ��ų Į���� ���� ������ �����Ѵ�.
            
            2) ANSI ǥ�� ����
                [ǥ����]
                    SELECT Į��, Į��, ...
                    FROM ���̺�1
                    [INNER] JOIN ���̺�2 ON (���̺�1.Į���� = ���̺�2.Į����);
                
                - FROM ���� ������ �Ǵ� ���̺��� ����Ѵ�.
                - JOIN ���� ���� ��ȸ�ϰ��� �ϴ� ���̺��� ��� �� ��Ī ��ų Į���� ���� ������ ����Ѵ�.
                - ���ῡ ����Ϸ��� Į������ ���� ��� ON ���� ��ſ� USING(Į����) ������ ����Ѵ�.
*/

--�����, �μ��ڵ� ��ȸ
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
;

--�����, �����ڵ�, ���޸� ��ȸ
SELECT EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE;

/*
    2. ���� JOIN
        ���� ���� ���̺� �����ϴ� ��쿡 ����Ѵ�.
*/

-- ����̸�, �μ��ڵ�, �μ���, �����ڵ�
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE, NATIONAL_CODE
FROM EMPLOYEE
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
JOIN LOCATION ON LOCATION_ID = LOCAL_CODE;

/*
    3. �ܺ� ���� (OUTER JOIN)
        ���̺� ���� JOIN �� ��ġ���� �ʴ� �൵ ���Խ��Ѽ� ��ȸ�� �����ϴ�.
        ��, �ݵ�� �����̵Ǵ� ���̺�(�÷�)�� �����ؾ� �Ѵ�. (LEFT/RIGHT/(+))
*/

--�����, �μ��̸�
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT OUTER JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

/*
    4. ī�׽þȰ�(CARTESIAN PRODUCT) / ���� ����(CROSS JOIN)
        ���εǴ� ��� ���̺��� �� ����� ���μ��� ��� ���ε� �����Ͱ� �˻��ȴ�.
        ���̺��� ����� ��� ������ ����� ������ ��� -> ����ȭ�� ����
*/

--�μ��̸�, �����ڵ�
SELECT DEPT_TITLE, NATIONAL_CODE
FROM DEPARTMENT
CROSS JOIN LOCATION;

/*
    5. �� ����(NON EQUAL JOIN)
        ���� ���ǿ� ��ȣ(=)�� ������� �ʴ� ���ι��� �� �����̶�� �Ѵ�.
        ������ �÷� ���� ��ġ�ϴ� ��찡 �ƴ�, ���� ������ ���ԵǴ� ����� �����ϴ� ����̴�.
        ( = �̿ܿ� �� ������ >, <, >=, <=, BETWEEN AND, IN, NOT IN ���� ����Ѵ�.)
        
        -- ANSI �������δ� JOIN ON �������θ� ����� �����ϴ�. (USING ��� �Ұ�)
*/

--�����, �޿�, �޿����
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON SALARY BETWEEN MIN_SAL AND MAX_SAL;

/*
    6. ��ü ����(SELF JOIN)
        ���� ���̺��� �ٽ� �ѹ� �����ϴ� ��쿡 ����Ѵ�.
*/
--�����ȣ, �����, �����ȣ, ����� 
SELECT 
    E1.EMP_ID       AS �����ȣ
    , E1.EMP_NAME   AS ����̸�
    , NVL(E1.MANAGER_ID,'�������') AS �����ȣ
    , NVL(E2.EMP_NAME, '�������') AS ����̸�
FROM EMPLOYEE E1
LEFT OUTER JOIN EMPLOYEE E2 ON E1.MANAGER_ID = E2.EMP_ID
ORDER BY E1.EMP_ID;

-------------------------------------------------------------------------------
-- 1. DEPARTMENT ���̺�� LOCATION ���̺��� �����Ͽ� �μ� �ڵ�, �μ���, ���� �ڵ�, �������� ��ȸ -> INNER JOIN
SELECT 
    DEPT_ID
    , DEPT_TITLE
    , LOCATION_ID
    , LOCAL_NAME
FROM DEPARTMENT D 
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE;

-- 2. EMPLOYEE ���̺�� DEPARTMENT ���̺��� �����ؼ� ���ʽ��� �޴� ������� ���, �����, ���ʽ�, �μ����� ��ȸ -> INNER JOIN, NOT NULL
SELECT 
    E.EMP_ID
    , E.EMP_NAME
    , E.BONUS
    , D.DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
WHERE BONUS IS NOT NULL;

-- 3. EMPLOYEE ���̺�� DEPARTMENT ���̺��� �����ؼ� �λ�����ΰ� �ƴ� ������� �����, �μ���, �޿��� ��ȸ -> INNER JOIN + NOT �λ������
SELECT
    E.EMP_NAME
    , D.DEPT_TITLE
    , E.SALARY
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
WHERE D.DEPT_TITLE != '�λ������' OR D.DEPT_TITLE IS NULL;

-- 4. EMPLOYEE ���̺�, DEPARTMENT ���̺�, LOCATION ���̺��� �����ؼ� ���, �����, �μ���, ������ ��ȸ -> ���� JOIN
SELECT 
    E.EMP_ID
    , E.EMP_NAME
    , D.DEPT_TITLE
    , L.LOCAL_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE;


-- 5. ���, �����, �μ���, ������, ������ ��ȸ -> ���� JOIN
SELECT
    E.EMP_ID            AS ���
    ,E.EMP_NAME         AS �����
    ,D.DEPT_TITLE       AS �μ���
    ,L.LOCAL_NAME       AS ������
    ,N.NATIONAL_NAME    AS ������
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
LEFT JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE
LEFT JOIN NATIONAL N ON L.NATIONAL_CODE = N.NATIONAL_CODE;

-- 6. ���, �����, �μ���, ������, ������, �޿� ��� ��ȸ -> ���� JOIN
SELECT
    E.EMP_ID            AS ���
    ,E.EMP_NAME         AS �����
    ,D.DEPT_TITLE       AS �μ���
    ,L.LOCAL_NAME       AS ������
    ,N.NATIONAL_NAME    AS ������
    ,S.SAL_LEVEL        AS �޿����
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
LEFT JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE
LEFT JOIN NATIONAL N ON L.NATIONAL_CODE = N.NATIONAL_CODE
LEFT JOIN SAL_GRADE S ON E.SALARY BETWEEN MIN_SAL AND MAX_SAL;

------------------------- ���� �ǽ� ���� -------------------------
-- 1. ������ �븮�̸鼭 ASIA �������� �ٹ��ϴ� �������� ���, �����, ���޸�, �μ���, �ٹ�����, �޿��� ��ȸ�ϼ���.
SELECT 
    E.EMP_ID
    , E.EMP_NAME
    , J.JOB_NAME
    , D.DEPT_TITLE
    , L.LOCAL_NAME
    , E.SALARY
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE
WHERE JOB_NAME = '�븮' AND SUBSTR(LOCAL_NAME,1,4) = 'ASIA';

-- 2. 70���� �̸鼭 �����̰�, ���� �� ���� �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�ϼ���.
SELECT 
    E.EMP_NAME
    , E.EMP_NO
    , D.DEPT_TITLE
    , J.JOB_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE SUBSTR(EMP_NO,1,1) = '7' AND SUBSTR(EMP_NO,8,1) = '2' AND SUBSTR(EMP_NAME,1,1) = '��';

-- 3. ���ʽ��� �޴� �������� �����, ���ʽ�, ����, �μ���, �ٹ������� ��ȸ�ϼ���.
SELECT
    E.EMP_NAME, 
    E.BONUS, 
    E.SALARY, 
    D.DEPT_TITLE, 
    L.LOCAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE
WHERE E.BONUS IS NOT NULL;

-- 4. �ѱ��� �Ϻ����� �ٹ��ϴ� �������� �����, �μ���, �ٹ�����, �ٹ� ������ ��ȸ�ϼ���.
SELECT 
    E.EMP_ID
    , D.DEPT_TITLE
    , L.LOCAL_NAME
    , N.NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE
JOIN NATIONAL N ON L.NATIONAL_CODE = N.NATIONAL_CODE
WHERE NATIONAL_NAME = '�ѱ�' OR NATIONAL_NAME = '�Ϻ�';

-- 5. �� �μ��� ��� �޿��� ��ȸ�Ͽ� �μ���, ��� �޿�(���� ó��)�� ��ȸ�ϼ���. 
--����: SELECT ���� 2���� ���� ����ϴµ� �� �ϳ��� ���Ǹ� �����ص� ��µǴ���?
--�׷���̸� 2�����ؼ� ��� �������ѾߵǴ°� �ƴ���?
SELECT 
        D.DEPT_TITLE            AS �μ���
        , ROUND(AVG(E.SALARY))  AS ��ձ޿�
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
GROUP BY D.DEPT_TITLE;

-- 6. �� �μ��� �� �޿��� ���� 1000���� �̻��� �μ���, �޿��� ���� ��ȸ�Ͻÿ�.
SELECT 
        D.DEPT_TITLE            AS �μ���
        , ROUND(AVG(E.SALARY))  AS ��ձ޿�
        , SUM(E.SALARY)         AS �ѱ޿�
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
GROUP BY D.DEPT_TITLE
HAVING SUM(E.SALARY) >= 10000000;

-- 7. ���, �����, ���޸�, �޿� ���, �������θ� ��ȸ
SELECT 
    E.EMP_ID AS ���
    , E.EMP_NAME AS �����
    , J.JOB_NAME AS ���޸�
    , S.SAL_LEVEL AS �޿����
    , DECODE(E.ENT_YN, 'N', 'Y', 'Y', 'N') AS ��������
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
JOIN SAL_GRADE S ON E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL;

-- 8. ���ʽ��� ���� �ʴ� ������ �� ���� �ڵ尡 J4 �Ǵ� J7�� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�.
SELECT 
    E.EMP_NAME
    ,J.JOB_NAME
    ,E.SALARY
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE J.JOB_CODE IN ('J4', 'J7');

-- 9. �μ��� �ִ� �������� �����, ���޸�, �μ���, �ٹ� ������ ��ȸ�Ͻÿ�.
--���� : ���ǹ� �ְ� ���� ���̰� ����? DEPARTMENT ���̺��� DEPT_ID ����  NULL���� ��� �׷�����?
SELECT 
    E.EMP_NAME
    , J.JOB_NAME
    , D.DEPT_TITLE
    , L.LOCAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE
WHERE E.DEPT_CODE IS NOT NULL;

-- 10. �ؿܿ������� �ٹ��ϴ� �������� �����, ���޸�, �μ� �ڵ�, �μ����� ��ȸ�Ͻÿ�
SELECT
    E.EMP_NAME
    , J.JOB_NAME
    , D.DEPT_ID
    , D.DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE SUBSTR(D.DEPT_TITLE, 1, 4) = '�ؿܿ���';


-- 11. �̸��� '��'�ڰ� ����ִ� �������� ���, �����, ���޸��� ��ȸ�Ͻÿ�.
SELECT 
    E.EMP_ID AS ���
    , E.EMP_NAME AS �����
    , J.JOB_NAME AS ���޸�
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE E.EMP_NAME LIKE '%��%';