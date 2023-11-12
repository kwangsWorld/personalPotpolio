--사용자 계정 생성

-- 한줄 주석

/*
    여러줄
    주석
    가능
    알간 모르간
    ㅋㅋ
    ㅎㅎ
*/

-- 사용자 계정 생성 (관리자 계정으로만 가능)
-- [문법]
-- CREATE USER 계정명 IDENTIFIED BY 비밀번호;
CREATE USER C##KH IDENTIFIED BY 1234;

-- 권한 부여
-- [문법]
-- GRANT 권한1, 권한2, ... TO 계정명;
GRANT CONNECT, RESOURCE TO C##KH;

-- 권한 해제
--REVOKE
REVOKE RESOURCE FROM C##KH;

-- 확인
SELECT *
FROM ROLE_SYS_PRIVS;

GRANT CONNECT, RESOURCE TO EMP;
CREATE USER EMP IDENTIFIED BY EMP0123;