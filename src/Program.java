import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char op = sc.next().charAt(0);
			if(op == 'i') {
			System.out.print("Name: ");
			sc.nextLine();
			String name= sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			System.out.print("Health expenditures: ");
			double healthExpenditures = sc.nextDouble();
			
			list.add(new Individual(name, anualIncome, healthExpenditures));
			}else {
				System.out.print("Name: ");
				sc.nextLine();
				String name= sc.nextLine();
				System.out.print("Anual income: ");
				double anualIncome = sc.nextDouble();
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				
				list.add(new Company(name, anualIncome, numberOfEmployees));
				
			}
		}
		
		System.out.println();
		double sum=0;
		System.out.println("TAXES PAID:");
		for(TaxPayer taxpayer : list) {
			System.out.println(taxpayer.getName() + ": $ " +  String.format("%.2f", taxpayer.tax()));
			sum += taxpayer.tax();
		}
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f ",sum);
		
	
		
		
		sc.close();
	}

}
