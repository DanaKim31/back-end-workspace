/*
	서브쿼리(SUBQUERY)
    - 하나의 SQL문 안에 포함된 또 다른 SQL문
    - 서브쿼리를 수행한 결과값이 몇 행 몇 열이냐에 따라 분류
    - 서브쿼리 종류에 따라 서브쿼리와 사용하는 연산자가 달라짐
    
    1. 단일행 서브쿼리 (SINGLE ROW SUBQUERY)
    - 서브쿼리의 조회 결과값의 개수가 오로지 1개일 때 (한 행, 한 열)
    - 일반 비교연산자 사용 가능 : =, !=, ^=, <>, >, <, >=, <=, ...
*/
-- 노옹철 사원과 같은 부서원들을 조회
-- 1) 노옹철 사원의 부서코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = '노옹철'; -- D9

-- 2) 부서코드가 D9인 사원들 조회
SELECT emp_name
FROM employee
WHERE dept_code = 'D9'; -- 선동일, 송종기, 노옹철

-- 3) 위의 2단계를 하나의 쿼리문으로!
SELECT emp_name
FROM employee
WHERE dept_code = (SELECT dept_code
				   FROM employee
                   WHERE emp_name = '노옹철');

-- ----------------------------------------------------------------------------

-- 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번, 사원명, 직급코드, 급여 조회
-- 1) 전 직원의 평균 급여 조회
SELECT avg(salary)
FROM employee; -- 3047662.6087

-- 2) 평균 급여보다 더 많은 급여를 받는 사원들의 사번, 사원명, 직급코드, 급여 조회
SELECT emp_id, emp_name, dept_code, format(salary, 0) 급여
FROM employee
WHERE salary > 3047662.6087;

-- 3) 합치깅!
SELECT emp_id, emp_name, dept_code, format(salary, 0) 급여
FROM employee
WHERE salary > (SELECT avg(salary)
				FROM employee);

-- ----------------------------------------------------------------------------

-- 최저 급여를 받는 사원의 사번, 이름, 직급코드, 급여, 입사일 조회
SELECT emp_id, emp_name, job_code, format(salary, 0) 급여, hire_date
FROM employee
WHERE salary = (SELECT min(salary)
				FROM employee);

-- ----------------------------------------------------------------------------

-- 전지연 사원이 속해있는 부서원들의 사번, 직원명, 전화번호, 직급명, 부서명, 입사일 조회
-- 단, 전지연 사원은 제외
-- 1) 전지연 사원의 부서코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = '전지연'; -- D1

-- 2) 전지연 사원을 사원들의 사번~입사일 조회
SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM employee 
	JOIN department ON (dept_code = dept_id)
    JOIN job USING (job_code)
WHERE emp_name != '전지연';

-- 3) 합치기! 전지연 사원이 속해 있는 부서원들의 사번~입사일 조회
SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM employee 
	JOIN department ON (dept_code = dept_id)
    JOIN job USING (job_code)
WHERE emp_name != '전지연'
	AND dept_code = (SELECT dept_code
					 FROM employee
                     WHERE emp_name = '전지연');

-- ----------------------------------------------------------------------------

-- 부서별 급여의 합이 가장 큰 부서의 부서코드, 급여의 합 조회
-- 서브쿼리 사용하지 않고 조회
SELECT dept_code 부서코드, format(sum(salary), 0) "급여의 합"
FROM employee
GROUP BY dept_code
ORDER BY sum(salary) DESC
LIMIT 1;

-- 서브쿼리 사용하여 조회
-- 1) 부서별 급여의 합 조회
SELECT dept_code, sum(salary) sum_sal
FROM employee
GROUP BY dept_code; -- > 결과값이 테이블이라 생각

-- 2) 부서별 급여 합이 가장 큰 값
SELECT max(sum_sal)
FROM (SELECT dept_code, sum(salary) sum_sal
	  FROM employee
	  GROUP BY dept_code) as dept_sum;

-- 3) 합치기! -> 다 배운 후 다시 설명 예정!
-- 서브쿼리 특징 : 쿼리 자체는 직관적이지만 쿼리속도가 느림
-- 실무에서는 쿼리 속도를 중요시 하기 때문에 가급적으로 서브쿼리를 사용하지 않아도 되는 경우면 서브쿼리를 사용하지 않는 것을 추천!
SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
HAVING sum(salary) = (SELECT max(sum_sal)
					  FROM (SELECT dept_code, sum(salary) sum_sal
							FROM employee
							GROUP BY dept_code) as dept_sum);

-- ----------------------------------------------------------------------------

/*
	2. 다중행 서브쿼리
    - 서브쿼리의 조회 결과 값의 개수가 여러 행일 때 (여러 행, 한 열)
    
    IN 서브쿼리 : 여러개의 결과값 중에서 한개로 다 일치하는 값이 있다면
*/
-- 각 부서별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회

-- 각 부서별 최고 급여 조회 (조건)
SELECT max(salary)
FROM employee
GROUP BY dept_code;  -- 8000000, 3900000, ....

-- 위의 값들을 직원의 이름, 직급코드, 부서코드, 급여 조회 (조회)
SELECT emp_name, job_code, dept_code, salary
FROM employee
WHERE salary IN (SELECT max(salary)
				 FROM employee
				 GROUP BY dept_code);

-- ----------------------------------------------------------------------------

-- 직원에 대해 사번, 이름, 부서코드, 구분(사수/사원) 조회
-- 사수인 사람들의 id
SELECT distinct manager_id
FROM employee
WHERE manager_id is not null;

-- 사수 테이블
SELECT emp_id, emp_name, dept_code, '사수' as "구분"
FROM employee
WHERE emp_id IN (SELECT distinct manager_id
				 FROM employee
				 WHERE manager_id is not null);
                 
-- 사원 테이블
SELECT emp_id, emp_name, dept_code, '사원' as "구분"
FROM employee
WHERE emp_id NOT IN (SELECT distinct manager_id
					 FROM employee
					 WHERE manager_id is not null);


-- 서브쿼리로만 사용하는 방법! (SELECT 절에서도 서브쿼리 사용 가능)
-- if 사용
SELECT 
	emp_id, emp_name, dept_code,
	if(emp_id IN (SELECT distinct manager_id
				  FROM employee
				  WHERE manager_id is not null), "사수", "사원") 구분
FROM employee;

-- case 사용
SELECT 
	emp_id, emp_name, dept_code,
    CASE WHEN emp_id IN (SELECT distinct manager_id
						 FROM employee
						 WHERE manager_id is not null) THEN "사수"
		 ELSE "사원"
	END 구분
FROM employee;

/*
	비교대상 컬럼 > ANY (서브쿼리) : 여러개의 결과값 중에서 "한개라도" 클 경우
							(비교대상 컬럼의 여러개 결과값 중에서 가장 작은 값 보다 클 경우)
    비교대상 컬럼 < ANY (서브쿼리) : 여러개의 결과값 중에서 "한개라도" 작을 경우
							(비교대상 컬럼의 여러개 결과값 중에서 가장 큰 값 보다 작을 경우)
	=> OR
*/
-- 대리 직급임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
-- 1) 과장 직급들의 급여 조회
SELECT salary
FROM employee JOIN job USING (job_code)
WHERE job_name = '과장'; -- 2200000, 2500000, 3760000 

-- 2) ANY 사용, 해당 조건으로 조회
SELECT emp_id, emp_name, job_name, format(salary, 0) 급여
FROM employee JOIN job USING (job_code)
WHERE job_name = '대리'
	AND salary > ANY (SELECT salary
					  FROM employee JOIN job USING (job_code)
                      WHERE job_name = '과장');
-- salary > 2200000 OR salary > 2500000 OR salary > 3760000

/*
	비교대상 컬럼 > ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 클 경우
    비교대상 컬럼 < ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 작을 경우
*/
-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들의 사번, 이름, 직급, 급여 조회
SELECT salary
FROM employee JOIN job USING (job_code)
WHERE job_name = '차장';

SELECT emp_id, emp_name, job_name, format(salary, 0) 급여
FROM employee JOIN job USING (job_code)
WHERE job_name = '과장'
	AND salary > ALL (SELECT salary
					  FROM employee JOIN job USING (job_code)
                      WHERE job_name = '차장');

SELECT emp_id, emp_name, job_name, format(salary, 0) 급여
FROM employee e, job j 
WHERE e.job_code = j.job_code
	AND job_name = '과장'
    AND salary > ALL (SELECT salary
					  FROM employee e, job j 
                      WHERE e.job_code = j.job_code
                      AND job_name = '차장');

/*
	3. 다중열 서브쿼리
	- 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일 때 (한 행, 여러 열)
*/
-- 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들의 사원명, 부서코드, 직급코드 조회
-- 1) 하이유 사원과 같은 부서코드
SELECT dept_code
FROM employee
WHERE emp_name = '하이유';

-- 2) 하이유 사원과 같은 직급코드
SELECT job_code
FROM employee
WHERE emp_name = '하이유';

-- 3) 부서코드가 D5이면서, 직급코드가 J5인 사원명, 부서코드, 직급코드 조회
SELECT emp_name, dept_code, job_code
FROM employee
WHERE dept_code = (SELECT dept_code
				   FROM employee
                   WHERE emp_name = '하이유')
	AND job_code = (SELECT job_code
					FROM employee
					WHERE emp_name = '하이유');
                    
-- >> 다중열 서브쿼리로!
SELECT emp_name, dept_code, job_code
FROM employee
-- WHERE dept_code = 'D5' AND job_code = 'J5';
-- WHERE (dept_code, job_code) = (('D5', 'J5'));
WHERE (dept_code, job_code) = (SELECT dept_code, job_code
							   FROM employee
                               WHERE emp_name = '하이유');
                               
                               
-- 박나라 사원과 직급코드가 일치하면서 같은 사수를 가지고 있는 사원의 사번, 이름, 직급코드, 사수사번 조회
SELECT job_code, manager_id
FROM employee
WHERE emp_name = '박나라'; -- J7 / 207

SELECT emp_id, emp_name, job_code, manager_id
FROM employee
WHERE (job_code, manager_id) IN (SELECT job_code, manager_id
								FROM employee
                                WHERE emp_name = '박나라');

/*
	4. 다중행 다중열 서브쿼리
    - 서브쿼리의 조회 결과값이 여러 행, 여러 열일 경우
*/
-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT job_code, min(salary)
FROM employee
GROUP BY job_code;

SELECT emp_id, emp_name, job_code, format(salary, 0) 급여
FROM employee
WHERE (job_code, salary) IN (SELECT job_code, min(salary)
							 FROM employee
							 GROUP BY job_code);

-- 각 부서별 최대 급여를 받는 사원들의 사번, 이름, 부서코드, 급여 조회 (부서없음 명시)
SELECT ifnull(dept_code, '부서없음') 부서코드, max(salary)
FROM employee
GROUP BY dept_code;

SELECT emp_id, emp_name, ifnull(dept_code, '부서없음') 부서코드, format(salary, 0) 급여
FROM employee
WHERE (ifnull(dept_code, '부서없음'), salary) IN (SELECT ifnull(dept_code, '부서없음'), max(salary)
												FROM employee
												GROUP BY dept_code);

/*
	RANK 함수
    - RANK() OVER (정렬기준) : 동일한 순위 이후의 등수를 동일한 인원수만큼 건너뛰고 순위를 계산한다.
							 (ex. 공동 1위가 2명이면 다음 순위는 3위)
    - DENSE_RANK() OVER (정렬 기준) : 동일한 순위 이후의 등수를 무조건 1씩 증가한다.
									(ex. 공동 1위가 2명이면 다음 순위는 2위)
*/
-- 사원별 급여가 높은 순서대로 순위 매겨서 순위, 사원명, 급여 조회
SELECT 
	rank() over(ORDER BY salary DESC) 순위, emp_name, format(salary, 0) 급여
FROM employee;

-- 1 ~ 10위까지만!
SELECT 
	dense_rank() over(ORDER BY salary DESC) 순위, emp_name, format(salary, 0) 급여
FROM employee
LIMIT 10; -- LIMIT : MySQL에서만 사용 가능







