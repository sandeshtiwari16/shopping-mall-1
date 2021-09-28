package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="itemname")    
	private String name;
	
	@Column(name="price")
	private String college;
	
	@Column(name="mdate")
	private String roll;
	
	@Column(name="edate")
	private String qualification;
	
	@Column(name="category")
	private String course;
	

	
	public Item() {
	}
	
	
	public Item(String name, String college, String roll, String qualification, String course) 
	{
		
		this.name = name;
		this.college = college;
		this.roll = roll;
		this.qualification = qualification;
		this.course = course;

	}
	
	public Item(int id, String name, String college, String roll, String qualification, String course) 
	{
		this.id = id;
		this.name = name;
		this.college = college;
		this.roll = roll;
		this.qualification = qualification;
		this.course = course;
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


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	
}
