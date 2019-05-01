package com.Insurance;

import ilog.rules.bom.annotations.CustomProperties;
import ilog.rules.bom.annotations.NotBusiness;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@CustomProperties(names={"",""},values={"",""})
public class InsuranceProcess {

	public String name;
	public List<String> type;
	public String priority;
	public double paidMonths;
	public double age;

	public InsuranceProcess(String name, List<String> type, String priority,
			double paidMonths, double age) {
		super();
		this.name = name;
		this.type = type;
		this.priority = priority;
		this.paidMonths = paidMonths;
		this.age = age;
	}

	public InsuranceProcess() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public double getPaidMonths() {
		return paidMonths;
	}

	public void setPaidMonths(double paidMonths) {
		this.paidMonths = paidMonths;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String checkProcess(List<String> type, double paidMonths) {
		for (String insuranceType : type) {
			if (insuranceType.equalsIgnoreCase("Vehicle")) {
				if (paidMonths >= 54) {
					priority = "High";
				} else if (paidMonths >= 42) {
					priority = "Medium";
				} else {
					priority = "Low";
				}
			} else if (insuranceType.equalsIgnoreCase("Health")) {
				if (paidMonths >= 66) {
					priority = "High";
				} else if (paidMonths >= 54) {
					priority = "Medium";
				} else {
					priority = "Low";
				}

			} else if (insuranceType.equalsIgnoreCase("Life")) {
				priority = age(age, priority, paidMonths);
			} else if (insuranceType.equalsIgnoreCase("House")) {
				if (paidMonths >= 126) {
					priority = "High";
				} else if (paidMonths >= 92) {
					priority = "Medium";
				} else {
					priority = "Low";
				}
			}
		}
		return priority;

	}

	public String checkEligibility() {

		String status = checkProcess(type, paidMonths);
		if (status.equals("High") || status.equals("Medium")
				|| status.equals("Low"))
			return status;
		else
			return "Sorry Not Applicable";
	}

	/*@NotBusiness int flag = 0;
	@NotBusiness boolean result;
	@NotBusiness
	public int dbConnection() {

		DBConnection connect = new DBConnection();
		result = connect.newData(name, type, paidMonths, age);
		flag = 1;
		return 1;
	}*/

	public String age(double age, String priority, double paidMonths) {
		if (age > 60 && (paidMonths >= 60)) {
			priority = "High";
		} else if (age > 45 && (paidMonths >= 36)) {
			priority = "Medium";
		} else
			priority = "Low";
		return priority;
	}
}
