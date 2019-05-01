package com.Insurance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Insurance {

	public String name;
	public String type;
	public Insurance() {
		super();
	}
 public Insurance(String name, String type) {
		super();
		this.name = name;
		this.type = type;
		//this.progress = progress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String primaryDetails() {

		String progress="verified";
		if (!name.isEmpty() && type != null)

			return progress;
		else
			return null;

	}
}
