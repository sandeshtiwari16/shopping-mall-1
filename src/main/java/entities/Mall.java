package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mall")
public class Mall {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="admin")    
	private String name;
	
	@Column(name="mallname")
	private String college;
	
	@Column(name="location")
	private String roll;
	
	@Column(name="category")
	private String qualification;

	
	public Mall() {
	}
	
	
	public Mall(String name, String college, String roll, String qualification) 
	{
		
		this.name = name;
		this.college = college;
		this.roll = roll;
		this.qualification = qualification;

	}
	
	public Mall(int id, String name, String college, String roll, String qualification) 
	{
		this.id = id;
		this.name = name;
		this.college = college;
		this.roll = roll;
		this.qualification = qualification;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public String getRoll() {
		return roll;
	}


	public void setRoll(String roll) {
		this.roll = roll;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	
}
