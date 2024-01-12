SET SQL_SAFE_UPDATES = 1;

UPDATE department SET dept_title = '해외영업1부' WHERE dept_id = 'D5';
UPDATE department SET dept_title = '해외영업2부' WHERE dept_id = 'D6';
UPDATE department SET dept_title = '해외영업3부' WHERE dept_id = 'D7';

SELECT * FROM department;
SELECT * FROM employee;


/* 
	데이터베이스 구현(문제해결 시나리오) 3문제
*/
-- 1번 문제 ----------------------------------------------------------------------------------------------
-- 다음 작성된 SQL 구문이 정상적으로 작동하지 않는다.
-- 작성된 SQL문
INSERT INTO employee VALUES(300, '전지우', '700101-1234567');

-- 풀이
-- 원인 : INSERT 문 작성 시 일부 컬럼에 해당하는 데이터만 입력하고자 한다면 컬럼명을 명시해야 함
INSERT INTO employee(emp_id, emp_name, emp_no) VALUES(300, '전지우', '700101-1234567');


-- 2번 문제 ----------------------------------------------------------------------------------------------
-- dept_code가 D6이거나 D9이고 salary가 300만원 이상이고 이메일 주소가 _ 앞에 3글자인 사원의 emp_name, emp_no, dept_code, salary 조회
-- 작성된 SQL문
SELECT emp_name, emp_no, dept_code, salary
FROM employee
WHERE dept_code = 'D6' OR dept_code = 'D9'
AND salary > 3000000
AND email LIKE '____%';

-- 풀이
-- 원인 : 1. OR문에 ()를 하거나 IN 연산자를 사용하면 됨
--       2. SALARY 조건은 이상이므로 >=로 변경
--       3. _를 기준으로 조회 하려면 ESCAPE를 사용해야 함
SELECT emp_name, emp_no, dept_code, salary
FROM employee
WHERE dept_code IN ('D6', 'D9')
	AND salary >= 3000000
	AND email LIKE '___$_%' escape '$';


-- 3번 문제 ----------------------------------------------------------------------------------------------
-- 다음과 같이 NULL 값을 비교하였는데 정상적으로 작동하지 않았다.
-- 작성된 SQL문
SELECT * FROM employee WHERE bonus = null;

-- 풀이
-- 원인 : NULL값을 일반적인 값이 아닌 아무것도 없음을 의미하는 것으로 일반연산자로 비교할 수가 없다.
--       NULL값을 비교하려면 IS NULL로 비교해야 함
SELECT *
FROM employee
WHERE bonus IS NULL;




/* 
	SQL 활용(문제해결 시나리오) 2문제
*/
-- 1번 문제 ----------------------------------------------------------------------------------------------
-- 부서 별 평균 월급이 280만원을 초과하는 부서를 조회
-- 작성된 SQL문
SELECT dept_code, sum(salary) 합계, avg(salary) 평균, count(*) 인원수
FROM employee
WHERE salary > 2800000
GROUP BY dept_code
ORDER BY dept_code;

-- 원인 : GROUP BY로 묶인그룹에 조건을 추가하기위해 HAVING절에 조건이 추가되어야 한다.
-- 풀이
SELECT dept_code, format(sum(salary), 0) 합계, format(avg(ifnull(salary, 0)), 0) 평균, count(*) 인원수
FROM employee
GROUP BY dept_code
HAVING avg(ifnull(salary, 0)) > 2800000
ORDER BY dept_code;


-- 2번 문제 ----------------------------------------------------------------------------------------------
-- '해외영업1부', '해외영업2부', '해외영업3부'를 '해외영업부'로 변경하는 UPDATE 문을 작성
-- 작성된 SQL문
UPDATE department
SET dept_title = '해외영업부'
WHERE dept_title LIKE '해외%';

-- 원인 : UPDATE 조건이 불명확하여 변경해야 할 행을 찾지 못하고 있다.
-- 풀이
UPDATE department
SET dept_title = '해외영업부'
WHERE dept_id IN ('D5', 'D6', 'D7');  




/* 
	SQL 활용(문제해결 시나리오) 2문제
*/
-- 1번 문제 ----------------------------------------------------------------------------------------------
-- 직원 테이블에서 사원명, 직급코드, 보너스를 받는 사원 수를 조회하여 직급코드 순으로 오름차순 정렬
-- 작성된 SQL문
SELECT emp_name, job_code, count(*) as 사원수
FROM employee
WHERE bonus != NULL
GROUP BY job_code
ORDER BY job_code;

-- 원인 : 컬럼의 NULL 값 확인은 컬럼명 = '값'으로 확인이 안 되고, GROUP BY를 사용시에 그룹함수를 제외한 모든 컬럼을 기술하지 않아서 오류가 발생
-- 풀이
SELECT emp_name, job_code, count(*) as 사원수
FROM employee
WHERE bonus is not null
GROUP BY emp_name, job_code
ORDER BY job_code;


-- 2번 문제 ----------------------------------------------------------------------------------------------
-- 두 개의 테이블을 조인하여 emp_id, emp_name, dept_id, dept_title 컬럼을 조회
-- 작성된 SQL문
SELECT emp_id, emp_name, dept_id, dept_title
FROM employee
JOIN department USING (dept_id);

-- 원인 : 컬럼의 NULL 값 확인은 컬럼명 = '값'으로 확인이 안 되고, GROUP BY를 사용시에 그룹함수를 제외한 모든 컬럼을 기술하지 않아서 오류가 발생
-- 풀이
SELECT emp_id, emp_name, dept_id, dept_title
FROM employee JOIN department ON (dept_code = dept_id)
ORDER BY emp_id
LIMIT 3;​











