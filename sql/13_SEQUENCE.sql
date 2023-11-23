--SEQUENCE

--��ȹ -> ���� -> ����
--���̺�, �⺻Ű, Į��, Ÿ��, �ܷ�Ű(����)

/*
    <SEQUENCE>
        �������� ���������� �����ϴ� ������ �ϴ� ��ü�̴�.
        
    <SEQUENCE ����>
        [����]
            CREATE SEQUNCE ��������
            [START WITH ����]
            [INCREAMENT BY ����]
            [MAXVALUE ����]
            [MINVALUE ����]
            [CYCLE | NOCYCLE]
            [CACHE ����Ʈũ�� | NOCACHE]; (�⺻�� 20 ����Ʈ)
            
        [��� ����]
            ��������.CURRVAL : ���� �������� ��
            ��������.NEXTVAL : ������ ���� ������Ű�� ������ ������ ��
                              (���� ������ ������ INCREAMENT �� ��ŭ ������ ��)
                              
        * ĳ�ø޸�
          - �̸� ���� ������ �����ؼ� �����صд�.
          - �Ź� ȣ���� ������ ������ ���� ���� ������ �ϴ� ���� �ƴ� ĳ�� �޸� ������ �̸� ������ ������ ����Ѵ�.
*/

CREATE SEQUENCE MYSEQ;
DROP SEQUENCE MYSEQ;

DROP SEQUENCE SEQ_MEMBER;
CREATE SEQUENCE SEQ_MEMBER
NOCACHE
NOCYCLE
START WITH 10
MINVALUE 10
MAXVALUE 20
INCREMENT BY 3;

SELECT SEQ_MEMBER.NEXTVAL
FROM DUAL;

SELECT SEQ_MEMBER.CURRVAL
FROM DUAL;

DROP SEQUENCE SEQ_MEMBER;

SELECT * FROM MEMBER;

INSERT INTO MEMBER(NO, ID, PWD)
VALUES(SEQ_MEMBER.NEXTVAL, 'ZZ', '1234');

