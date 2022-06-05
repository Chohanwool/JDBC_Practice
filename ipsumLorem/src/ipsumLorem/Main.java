package ipsumLorem;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("생년월일 입력 > ");
		String birthday = sc.nextLine();
		
		System.out.println(birthday);
		
		Date bd = Date.valueOf(birthday);
		
		System.out.println(bd);
		
		
		

	}

}
