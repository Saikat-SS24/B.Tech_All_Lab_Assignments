                                        <==========Assignment1============>

1=> create table Student(id number(5),name varchar(20),branch varchar(10))

2=>     =>insert into Student(id,name,branch)
          values(1,'SAIKAT','CSE')

        =>insert into Student(id,name,branch)
          values(2,'SOUMYA','CSE')

        =>insert into Student(id,name,branch)
          values(3,'SAYAN','ECE')

        =>insert into Student(id,name,branch)
          values(4,'ABHIJIT','AIML')

        =>insert into Student(id,name,branch)
          values(5,'SANGITA','BCA')

3=> ALTER TABLE Student
    RENAME COLUMN ID TO ROLL

4=> ALTER TABLE Student
    ADD AGE NUMBER
    ALTER TABLE Student ADD ADDRESS VARCHAR(20) DEFAULT 'TINT';

5=>UPDATE Student SET AGE=20 where roll=1
   UPDATE Student SET AGE=15 where roll=2
   UPDATE Student SET AGE=22 where roll=3
   UPDATE Student SET AGE=24 where roll=4
   UPDATE Student SET AGE=19 where roll=5

6=> ALTER TABLE Student ADD PRIMARY KEY(ROLL)

7=> ALTER TABLE Student MODIFY NAME NOT NULL

8=> ALTER TABLE Student
    ADD MARKS NUMBER
    UPDATE Student SET MARKS=90 where roll=1
    UPDATE Student SET MARKS=80 where roll=2
    UPDATE Student SET MARKS=75 where roll=3
    UPDATE Student SET MARKS=45 where roll=4
    UPDATE Student SET MARKS=30 where roll=5

9=> select * from student where MARKS>=50

10=> DELETE FROM student WHERE MARKS<50

11=> ALTER TABLE student
     DROP COLUMN ADDRESS


       
                                       
                                        <==========Assignment2============>

=> CREATE TABLE Emp (
  EMPNO int,
  EMPNAME varchar2(50),
  JOB varchar2(50),
  HIREDATE varchar2(50),
  MGR int,
  SAL int,
  COMM int,
  DEPTNO int 
  );
  
=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7369,'SMITH','CLERK','17-12-1980',7902,800,NULL,20)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7499,'ALLEN','SALESMAN','20-02-1981',7698,1600,300,30)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7521,'WARD','SALESMAN','22-02-1981',7698,1250,500,30)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7566,'JONES','MANAGER','02-04-1981',7839,2975,NULL,20)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7654,'MARTIN','SALESMAN','28-09-1981',7698,1250,1400,30)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7698,'BLAKE','MANAGER','01-05-1981',7839,2850,NULL,30)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7782,'CLARK','MANAGER','09-06-1981',7839,2450,NULL,10)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7788,'SCOTT','ANALYST','19-04-1987',7566,3000,NULL,20)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7839,'KING','PRESIDENT','17-11-1981',NULL,5000,NULL,10)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7844,'TURNER','SALESMAN','08-09-1981',7698,1500,0,30)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7876,'ADAMS','CLERK','23-05-1987',7788,1100,NULL,20)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7900,'JAMES','CLERK','03-12-1981',7698,950,NULL,30)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7902,'FORD','ANALYST','03-12-1981',7566,3000,NULL,20)

=>  INSERT INTO Emp (EMPNO, EMPNAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
    VALUES (7934,'MILLER','CLERK','23-01-1982',7782,1300,NULL,10)

=> select EMPNAME
   from emp
   where COMM IS NOT NULL AND COMM <> 0;

=> select EMPNAME
   from emp
   where COMM IS NOT NULL;

=> SELECT empname || ' is working as a ' || job || ' in the Department ' || DEPTNO || ' and their salary 
   is ' || sal || '.'
   FROM emp
   WHERE EMPNAME = 'JONES' AND JOB = 'MANAGER';

=> SELECT DISTINCT JOB
   FROM EMP;

=> SELECT job, COUNT(*)
   FROM emp
   GROUP BY job;

=> SELECT LENGTH(EMPNO)
   FROM EMP
   WHERE JOB = 'SALESMAN';

=> SELECT EMPNAME, JOB, SAL
   FROM EMP
   ORDER BY SAL;

=> SELECT COUNT(*) 
   FROM EMP
   WHERE SAL > 1000;

=> SELECT * 
   FROM EMP
   WHERE JOB = 'CLERK' AND JOB ='MANAGER';

=> SELECT * 
   FROM EMP
   WHERE EMPNAME LIKE 'A%';

=> SELECT INSTR(empname, 'K') as k_location
   FROM emp
   WHERE empname = 'BLAKE';

=> SELECT *
   FROM EMP
   WHERE HIREDATE <= TO_DATE('1982-12-31', 'YYYY-MM-DD') AND JOB = 'CLERK';

=> SELECT INSTR(empname, 'R') as k_location
   FROM emp
   WHERE empname = 'MARTIN';

=> UPDATE EMP
   SET EMPNAME = REPLACE(EMPNAME, 'KING', 'KONG')
   WHERE EMPNAME = 'KING';

=> SELECT LPAD(CONCAT('Mr. ', EMPNAME), 20) AS Name
   FROM emp;

=> SELECT SUBSTR(EMPNAME, 1, 1) AS first_letter
   FROM emp
   WHERE sal = 800;

=> SELECT LOWER(EMPNAME) AS EMP_NAME, JOB
   FROM EMP

=> SELECT MONTHS_BETWEEN(SYSDATE, HIREDAT) AS MONTHS_WORKED
   FROM emp
   WHERE empname = 'MILLER';

=> SELECT TO_CHAR(hiredate, 'YYYY') AS hire_year
   FROM emp
   WHERE empname = 'ADAMS';

=> SELECT EXPERIENCE
   FROM EMP
   WHERE EMPNO = 7788

=> UPDATE emp
   SET SAL = SAL * 1.1
   WHERE EXPERIENCE > 10










