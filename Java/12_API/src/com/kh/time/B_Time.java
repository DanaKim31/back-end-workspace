package com.kh.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
 * java.time 패키지
 * 	- Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공 (JDK 1.8에서 만들어짐) / JDK 1.8 : Java 8 버전
 * 	- LocalDate, LocalTime, LocalDateTime, ZonedDateTime 클래스 포함
 * 	- 날짜와 시간에 대한 다양한 메서드를 제공
 * */

public class B_Time {

	public static void main(String[] args) {
		B_Time b = new B_Time();
//		b.method1();
//		b.method2();
		b.method3();
	}

	public void method1() {
		
		/*
		 * LocalDateTime
		 * 	- 날짜와 시간 정보를 모두 저장
		 * */
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Today : " + now); // 지금 날짜시간 출력, 2024-01-29T09:41:19.223682500
		
		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2024, 5, 16, 17, 50, 00);
		System.out.println("when : " + when); // 2024-05-16T17:50
		
		// ZonedDateTime : LocalDateTime + 시간대[지역]
		System.out.println("ZonedDateTime : " + ZonedDateTime.now()); // 2024-01-29T09:44:19.171047800+09:00[Asia/Seoul]
		
		// 년, 월, 일, 시, 분, 초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonth()); // JANUARY
		System.out.println(now.getMonthValue() + "월"); // 1월
		System.out.println(now.getDayOfMonth() + "일"); // 29일
		System.out.println(now.getDayOfWeek()); // MONDAY
		System.out.println(now.getHour() + "시");
		System.out.println(now.getMinute() + "분");
		System.out.println(now.getSecond() + "초");
		
		System.out.println();
		
		// 날짜 조작
		LocalDateTime plusDays = now.plusDays(1).plusMonths(1).plusYears(1);  
		System.out.println("plusDays : " + plusDays); // 2025-02-28T11:04:52.415690400  => 현재날짜에서 지정한 만큼 더한 날짜 출력
		
		LocalDateTime minusDays = now.minusYears(1).minusMonths(1).minusDays(1);
		System.out.println("minusDays : " + minusDays); // 2022-12-28T11:04:52.415690400  => 현재날짜에서 지정한 만큼 뺀 날짜 출력
		
		LocalDateTime withDays = now.withYear(2025).withMonth(3).withDayOfMonth(10);
		System.out.println("withDays : " + withDays); // 2025-03-10T11:04:52.415690400  => 지정한 날짜로 출력
		
		System.out.println("isAfter : " + now.isAfter(withDays)); // false  => 오늘이 해당 날짜보다 이후인가
		System.out.println("isBefore : " + now.isBefore(withDays)); // true  => 오늘이 해당 날짜보다 이전인가
		
		// LocalDate : 날짜 정보를 저장
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate : " + localDate); // 2024-01-29
		localDate = LocalDate.of(2024, 12, 25);
		System.out.println("localDate 2 : " + localDate); // 2024-12-25
		
		// LocalTime : 시간 정보만을 저장
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime : " + localTime); // 11:11:54.543288100
		localTime = LocalTime.of(17, 49, 59);
		System.out.println("localTime 2 : " + localTime); // 17:49:59
		
	}
	
	/*
	 * Period와 Duration
	 * 	- 날짜와 시간 간격을 표현하기 위한 클래스
	 * 	- Period : 두 날짜 간의 차이
	 * 	- Duration : 시간의 차이
	 * */
	public void method2() {
		
		LocalDate date1 = LocalDate.of(2024, 1, 1);
		LocalDate date2 = LocalDate.of(2025, 12, 31);
		
		// between : 두 날짜의 차이 (until - 별반 차이 없음)
		Period pe = Period.between(date1, date2);
		System.out.println("pe : " + pe); // P1Y11M30D
		
		System.out.println("years : " + pe.getYears()); // 1
		System.out.println("years : " + pe.get(ChronoUnit.YEARS)); // 1
		
		System.out.println("months : " + pe.getMonths()); // 11
		System.out.println("months : " + pe.get(ChronoUnit.MONTHS)); // 11
		
		System.out.println("days : " + pe.getDays()); // 30
		System.out.println("days : " + pe.get(ChronoUnit.DAYS)); // 30
		
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(11, 23, 55);
		
		// Duration : 두 시간의 차이
		Duration du = Duration.between(time1, time2);
		System.out.println(du); // PT11H23M55S
		
		System.out.println("hour : " + du.toHours()); // 11
		System.out.println("minutes : " + du.toMinutes()); // 683
		System.out.println("seconds : " + du.toSeconds()); // 41035
		
		// 문자열을 LocalDate 객체로 파싱(parsing)
		LocalDate date = LocalDate.parse("2024-02-08");
		System.out.println(date); // 2024-02-08
		
		// DateTimeFormatter
		// 	- 날짜와 시간을 포맷팅(Formatting)된 문자열로 변환하는 메서드를 제공하는 클래스
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String formatDate = today.format(ofPattern);
		System.out.println(formatDate); // 2024-01-29 11:34:36
		
	}
	
	// D-Day 계산기 : 년월일을 입력하여 디데이 계산
	// ChronoUnit.DAYS.between(날짜, 날짜) 또는 날짜.until(날짜, ChronoUnit.DAYS) 사용 
	public void method3() {
		
		// 오늘 날짜
		LocalDate today = LocalDate.now();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("년 : ");
		int year = Integer.parseInt(sc.nextLine());
		System.out.print("월 : ");
		int month = Integer.parseInt(sc.nextLine());
		System.out.print("일 : ");
		int day = Integer.parseInt(sc.nextLine());
		
		// 입력할 날짜
		LocalDate inputDate = LocalDate.of(year, month, day);
		
		long dDay = ChronoUnit.DAYS.between(today, inputDate);
		dDay = today.until(inputDate, ChronoUnit.DAYS);
		
		if(dDay == 0) {
			System.out.println("D-Day");
		} else if(dDay < 0) {
			System.out.println("D + " + (-dDay));
		} else {
			System.out.println("D - " + dDay);
		}
	}
}

















