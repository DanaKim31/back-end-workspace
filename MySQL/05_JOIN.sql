/*
	JOIN
    - 두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용하는 구문
	- 조회 결과는 하나의 결과물(RESULT SET)으로 나옴
    
    - 관계형 데이터베이스는 최소한의 데이터로 각각의 테이블에 담고 있음
      (중복을 최소화하기 위해 최대한 쪼개서 관리)
      부서 데이터는 부서 테이블, 사원에 대한 데이터는 사원 테이블, 직급 테이블....
      만약 어떤 사원이 어떤 부서에 속해있는지 부서명과 같이 조회하고 싶다면?
      만약 어떤 사원이 어떤 직급인지 직급명과 같이 조회하고 싶다면?
      
      => 즉, 관계형 데이터베이스에서 SQL 문을 이용한 테이블 간에 "관계"를 맺어 원하는 데이터만 조회하는 방법
      
      (primary key : 테이블 각 행을 지칭하는 고유값)
*/
/*
	1. 내부 조인(INNER JOIN)
    - 연결시키는 컬럼의 값이 일치하는 행들만 조인되어 조회 (일치하는 값이 없는 행은 조회 X)
    
    1) WHERE 구문
		SELECT 컬럼, 컬럼, ...
		FROM   테이블1, 테이블2
        WHERE  테이블1.컬럼명 = 테이블2.컬럼명;
        
        - FROM 절에 조회하고자 하는 테이블들을 콤마로 구분하여 나열
        - WHERE 절에 매칭시킬 컬럼명에 대한 조건 제시
        
	2) ANSI (미국국립표준협회, 산업표준을 제정하는 단체) 표준 구문 -> 다른 DB에서도 사용 가능!
		SELECT			컬럼, 컬럼, ...
        FROM			테이블1
        [INNER] JOIN	테이블2 ON (테이블1.컬럼명 = 테이블2.컬럼명);
        
        - FROM 절에서 기준이 되는 테이블을 기술(테이블 하나만 기술)
        - JOIN 절에서 같이 조회하고자 하는 테이블을 기술 수 매칭 시킬 컬럼에 대한 조건을 기술
        - 연결에 사용하려는 컬럼명이 같은 경우 ON 구문 대신 USING(컬럼명) 구문 사용
*/
-- 1) 연결할 두 컬럼명이 다른 경우 (employee : dept_code - department : dept_id)
-- 사번, 사원명, 부서코드, 부서명을 같이 조회
SELECT emp_id, emp_name, dept_code, dept_title
FROM employee, department
WHERE dept_code = dept_id;

-- >> ANSI 구문
SELECT emp_id, emp_name, dept_code, dept_title
FROM employee
JOIN department ON (dept_code = dept_id);

-- 일치하는 값이 없는 행은 조회에서 제외된 것 확인!
-- dept_code가 null인 사원 조회 안됨

-- 2) 연결할 두 컬럼명이 같은 경우 (employee : job_code - job : job_code)
-- 사번, 사원명, 직급코드, 직급명 조회
SELECT emp_id, emp_name, job_code, job_name
FROM employee, job
WHERE job_code = job_code; -- ambiguous : 애매한, 모호한 / 에러 발생 코드!

-- 해결방법 1) 테이블명을 이용하는 방법
SELECT emp_id, emp_name, job.job_code, job_name -- 'job_code' 컬럼이 어떤 테이블의 컬럼을 가져올지 지정해 줘야 함
FROM employee, job
WHERE employee.job_code = job.job_code;

-- 해결방법 2) 테이블에 별칭을 부여해서 이용하는 방법 -> FROM 의 테이블명 + 스페이스 + 별칭
SELECT emp_id, emp_name, e.job_code, job_name
FROM employee e, job j
WHERE e.job_code = j.job_code;

-- >> ANSI 구문
SELECT emp_id, emp_name, e.job_code, job_name
FROM employee e
JOIN job j ON (e.job_code = j.job_code);

-- 두 컬럼명이 같을 때만 USING 구문 사용 가능! USING 사용 시 별칭 필요 없음
SELECT emp_id, emp_name, job_code, job_name
FROM employee
JOIN job USING (job_code); 

-- 참고사항! 자연조인(NATURAL JOIN) : 각 테이블마다 동일한 컬럼이 한 개만 존재할 경우만 사용 가능
-- 실제로 추천하지 않음!!! 가급적으로 절대 쓰지 마세요
SELECT emp_id, emp_name, job_code, job_name
FROM employee
NATURAL JOIN job;

-- 직급이 대리인 사원의 사번, 이름, 직급명(job_name), 급여를 조회
-- 1) WHERE 구문
SELECT emp_id, emp_name, job_name, format(salary, 0)
FROM employee e, job j
WHERE e.job_code = j.job_code
	  AND job_name = '대리';

-- 2) ANSI 구문_1
SELECT emp_id, emp_name, job_name, format(salary, 0)
FROM employee e JOIN job j ON (e.job_code = j.job_code)
WHERE job_name = '대리' ;

-- 3) ANSI 구문_2
SELECT emp_id, emp_name, job_name, format(salary, 0)
FROM employee JOIN job USING(job_code)
WHERE job_name = '대리';

-- 실습문제 -----------------------------------------------------
-- 1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회 (employee, department)
SELECT * FROM employee; 
SELECT * FROM department;

-- ANSI 구문
SELECT emp_id, emp_name, bonus
FROM employee JOIN department ON (dept_code = dept_id)
WHERE dept_title = '인사관리부';

-- WHERE 구문
SELECT emp_id, emp_name, bonus
FROM employee, department
WHERE dept_title = '인사관리부' AND dept_code = dept_id;


-- 2. 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회 (department, location)
SELECT * FROM department; 
SELECT * FROM location;

-- ANSI 구문
SELECT dept_id, dept_title, location_id, local_name
FROM department JOIN location ON (location_id = local_code);

-- WHERE 구문
SELECT dept_id, dept_title, location_id, local_name
FROM department, location
WHERE location_id = local_code;


-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회 (employee, department)
SELECT * FROM employee; 
SELECT * FROM department;

-- ANSI 구문
SELECT emp_id, emp_name, bonus, dept_title
FROM employee JOIN department ON (dept_code = dept_id)
WHERE bonus IS NOT NULL;

-- WHERE 구문
SELECT emp_id, emp_name, bonus, dept_title
FROM employee, department
WHERE dept_code = dept_id AND bonus IS NOT NULL;


-- 4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회 (employee, department)
SELECT * FROM employee; 
SELECT * FROM department;

-- ANSI 구문
SELECT emp_name, format(salary, 0)
FROM employee JOIN department ON (dept_code = dept_id)
WHERE dept_title != '총무부';

-- WHERE 구문
SELECT emp_name, format(salary, 0)
FROM employee, department
WHERE dept_code = dept_id AND dept_title != '총무부';

/*
	2. 외부 조인(OUTER JOIN) : MySQL은 ANSI 구문만 가능(WHERE 구문 사용 불가) -> 사용하는 경우 거의 없음
    - 두 테이블 간의 JOIN 시 일치하지 않는 행도 포함시켜서 조회가 가능하다.
    - 단, 반드시 기준이 되는 테이블(컬럼)을 지정해야 한다. (LEFT, RIGHT, FULL)
*/
-- 사원명, 부서명, 급여, 연봉 조회
SELECT emp_name, dept_title, format(salary, 0) 급여, format(salary * 12, 0) 연봉
FROM employee JOIN department ON (dept_code = dept_id);
-- > 부서 배치가 안된 사원(부서 배치값이 null인 사원) 2명에 대한 정보가 조회되지 않음
-- > 부서에 배치된 사원이 없는 부서에 대한 정보도 조회되지 않음

-- 1) LEFT [OUTER] JOIN : 두 테이블 중 왼편에 기술된 테이블을 기준으로 JOIN
SELECT emp_name, dept_title, format(salary, 0) 급여, format(salary * 12, 0) 연봉
FROM employee LEFT JOIN department ON (dept_code = dept_id);
-- > 왼쪽 테이블인 employee를 기준으로 23 행 조회 / 부서 배치가 안 된 사원 2명을 포함하여 조회

-- 2) RIGHT [OUTER] JOIN : 두 테이블 중 오른편에 기술된 테이블을 기준으로 JOIN
SELECT emp_name, dept_title, format(salary, 0) 급여, format(salary * 12, 0) 연봉
FROM employee RIGHT JOIN department ON (dept_code = dept_id);
-- > 오른쪽 테이블인 department를 기준으로 24 행 조회 / 부서에 배치된 사원이 없는 부서를 포함하여 조회

-- 3) FULL [OUTER] JOIN : 두 테이블이 가진 모든 행을 조회할 수 있음  - MySQL X
SELECT emp_name, dept_title, format(salary, 0) 급여, format(salary * 12, 0) 연봉
FROM employee FULL JOIN department ON (dept_code = dept_id);

/*
	3. 비등가 조인 (NON EQUAL JOIN) -> 사용하는 경우 거의 없음
    - 매칭시킬 컬럼에 대한 조건 작성시 '='(등호)를 사용하지 않는 조인문
    - 값의 범위에 포함되는 행들을 연결하는 방식
*/
SELECT * FROM employee;
SELECT * FROM sal_grade; -- 급여 등급 테이블 : sal_level, min_sal, max_sal - employee 테이블과 데이터가 겹치지는 않지만 salary 컬럼과 연관이 있음

-- 사원명, 급여, 급여 레벨 조회
SELECT emp_name, salary, sal_level
FROM employee JOIN sal_grade ON (min_sal <= salary AND salary <= max_sal);

-- >> WHERE 구문
SELECT emp_name, salary, sal_level
FROM employee, sal_grade
WHERE salary BETWEEN min_sal AND max_sal;

/*
	4. 자체 조인(SELF JOIN)
    - 같은 테이블을 다시 한번 조인하는 경우 (자기 자신과 조인)
    
    활용 예시 : 대댓글
    대댓글 짜는 방법 : 2가지
		1. 댓글 테이블 하나에 SELF JOIN 활용
        2. 댓글 테이블, 대댓글 테이블 따로 짜기
*/
SELECT * FROM employee;

-- 전체 사원의 사원사번(emp_id), 사원명(emp_name), 사원부서코드(dept_code), manager_id 
-- 			사수사번(emp_id), 사수명(emp_name), 사수부서코드 조회(dept_code)
SELECT e.emp_id "사원 사번", e.emp_name "사원명", e.dept_code "사원 부서코드",
	   m.emp_id "사수사번", m.emp_name "사수명", m.dept_code "사수 부서코드"
	-- 사수가 없는 사원들까지 조회 : LEFT JOIN 사용
FROM employee e LEFT JOIN employee m ON (e.manager_id = m.emp_id);

/*
	5. 카테시안곱(CARTESIAN PRODUCT) / 교차 조인(CROSS JOIN) -> 사용하는 경우 없음
    - 조인되는 모든 테이블의 각 행들이 서로서로 모두 매핑된 데이터가 검색된다. (곱집합)
    - 두 테이블의 행들이 모두 곱해진 행들의 조합이 출력 -> 방대한 데이터 출력 -> 과부하의 위험
*/
-- 사원명, 부서명 조회 (employee, department)
-- >> ANSI 구문
SELECT emp_name, dept_title
FROM employee CROSS JOIN department; -- 207개 행 조회(사원명을 각 부서명과 엮은 결과 값)

-- >> WHERE 구문
SELECT emp_name, dept_title
FROM employee, department;

/*
	6. 다중 JOIN
    - 여러 개의 테이블을 조인하는 경우
    - WHERE 구문에서는 AND로 등호 추가
    - ANSI 구문에서는 JOIN으로 테이블 각자 하나씩 추가
*/
-- 사번, 사원명, 부서명, 직급명 조회
SELECT * FROM employee;		-- emp_id, emp_name, dept_code, job_code
SELECT * FROM department;	-- dept_title,		 dept_id
SELECT * FROM job;			-- job_name,					job_code

-- >> WHERE 구문
SELECT emp_id, emp_name, dept_title, job_name
FROM employee e, department, job j
WHERE dept_code = dept_id AND e.job_code = j.job_code;

-- >> ANSI 구문
SELECT emp_id, emp_name, dept_title, job_name
FROM employee 
	JOIN department ON (dept_code = dept_id)
	JOIN job USING (job_code);

-- 사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여등급 조회 (employee, job, department, location, national, sal_grade)
-- >> WHERE 구문
SELECT emp_id, emp_name, dept_title, job_name, local_name, national_name, sal_level
FROM employee, job, department, location, national, sal_grade
WHERE dept_code = dept_id
	AND location_id = local_code
    AND employee.job_code = job.job_code
    AND location.national_code = national.national_code
    AND salary BETWEEN min_sal AND max_sal;

-- >> ANSI 구문
SELECT emp_id, emp_name, dept_title, job_name, local_name, national_name, sal_level
FROM employee 
	JOIN department ON (dept_code = dept_id) 
	JOIN location ON (location_id = local_code)
    JOIN job USING (job_code)
	JOIN national USING (national_code)
	JOIN sal_grade ON (min_sal <= salary AND salary <= max_sal);
    
-- 종합 실습 문제 -------------------------------------------------------
-- 1. 직급이 대리면서 ASIA 지역에서 근무하는 직원들의 사번, 직원명, 직급명, 부서명, 근무지역, 급여를 조회
-- >> ANSI 구문
SELECT emp_id, emp_name, job_name, dept_title, local_name, salary
FROM employee
	JOIN department ON (dept_code = dept_id)
	JOIN job USING (job_code)
    JOIN location ON (location_id = local_code)
WHERE job_name = '대리' AND local_name LIKE 'ASIA_';

-- >> WHERE 구문
SELECT emp_id, emp_name, job_name, dept_title, local_name, salary
FROM employee e, job j, department, location
WHERE e.job_code = j.job_code
	AND dept_code = dept_id
    AND local_code = location_id
    AND job_name = '대리'
    AND local_name LIKE 'ASIA%';

-- ----------------------------------------------------------------------------

-- 2. 70년대생 이면서 여자이고, 성이 전씨인 직원들의 직원명, 주민번호, 부서명, 직급명 조회
-- >> ANSI 구문
SELECT emp_name, emp_no, dept_title, job_name
FROM employee 
	JOIN department ON (dept_code = dept_id)
    JOIN job USING (job_code)
WHERE emp_no LIKE '7%' AND substr(emp_no, -7, 1) = 2 AND emp_name LIKE '전%';

-- >> WHERE 구문
SELECT emp_name, emp_no, dept_title, job_name
FROM employee e, department, job j
WHERE dept_code = dept_id
	AND e.job_code = j.job_code
    -- AND substr(emp_no, 1, 1) = 7;
    -- AND emp_no LIKE '7%';
    -- AND substr(emp_no, -7, 1) = 2;
	AND emp_no LIKE '7_____-2%'
    AND emp_name LIKE '전%';
    
-- ----------------------------------------------------------------------------

-- 3. 보너스를 받은 직원들의 직원명, 보너스, 연봉, 부서명, 근무지역 조회. 단, 부서코드가 없는 사원도 출력 (OUTER JOIN 사용!)
-- >> ANSI 구문
SELECT emp_name, bonus, format((salary + salary * ifnull(bonus, 0)) * 12, 0) "연봉", dept_title, local_name
FROM employee LEFT JOIN department ON (dept_code = dept_id)
	LEFT JOIN location ON (location_id = local_code)
WHERE bonus IS NOT NULL;

-- >> WHERE 구문
SELECT emp_name, bonus, format((salary + salary * ifnull(bonus, 0)) * 12, 0) "연봉", dept_title, local_name
FROM employee, department, location
WHERE 


-- ----------------------------------------------------------------------------

-- 4. 한국과 일본에서 근무하는 직원들의 직원명, 부서명, 근무지역, 근무 국가를 조회
SELECT emp_name, dept_title, local_name, national_name
FROM employee 
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id = local_code)
    JOIN national USING (national_code)
WHERE national_name IN ('한국', '일본');


-- ----------------------------------------------------------------------------

-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균급여를 조회. 단, 부서 코드가 없는 사원들의 평균도 같이 나오게끔! (OUTER JOIN 사용)
SELECT dept_title "부서명", format(avg(salary), 0) "평균급여"
FROM employee LEFT JOIN department ON (dept_code = dept_id)
GROUP BY dept_title;


-- ----------------------------------------------------------------------------

-- 6. 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여의 합을 조회
SELECT dept_title "부서명", format(sum(salary), 0) "급여의 합"
FROM employee JOIN department ON (dept_code = dept_id)
GROUP BY dept_title
HAVING sum(salary) >= 10000000;


-- ----------------------------------------------------------------------------

-- 7. 사번, 직원명, 직급명, 급여 등급, 구분을 조회. 이 때, 구분에 해당하는 값은 아래와 같이 조회 되도록!
-- 급여 등급이 S1, S2인 경우 '고급'
-- 급여 등급이 S3, S4인 경우 '중급'
-- 급여 등급이 S5, S6인 경우 '초급'
SELECT emp_id, emp_name, job_name, sal_level, 
	CASE WHEN sal_level = 'S1' OR 'S2' THEN '고급'
	WHEN sal_level = 'S3' OR 'S4' THEN '중급'
    ELSE '초급'
	END "구분"
FROM employee 
	JOIN job USING (job_code)
	JOIN sal_grade ON (min_sal <= salary AND salary <= max_sal);


-- ----------------------------------------------------------------------------

-- 8. 보너스를 받지 않는 직원들 중 직급 코드가 J4 또는 J7인 직원들의 직원명, 직급명, 급여를 조회
SELECT emp_name, job_name, format(salary, 0) "급여"
FROM employee 
	JOIN job USING (job_code)
WHERE bonus IS NULL AND job_code IN ('J4', 'J7');


-- ----------------------------------------------------------------------------

-- 9. 부서가 있는 직원들의 직원명, 직급명, 부서명, 근무지역을 조회
SELECT emp_name, job_name, dept_title, local_name
FROM employee
	JOIN job USING (job_code)
    JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id = local_code)
WHERE dept_code IS NOT NULL;


-- ----------------------------------------------------------------------------

-- 10. 해외영업팀에 근무하는 직원들의 직원명, 직급명, 부서코드, 부서명을 조회
SELECT emp_name, job_name, dept_code, dept_title
FROM employee
	JOIN job USING (job_code)
    JOIN department ON (dept_code = dept_id)
WHERE dept_title LIKE '해외영업%';


-- ----------------------------------------------------------------------------

-- 11. 이름에 '형'자가 들어있는 직원들의 사번, 직원명, 직급명을 조회
SELECT emp_id, emp_name, job_name
FROM employee
	JOIN job USING (job_code)
WHERE emp_name LIKE '%형%';
    



