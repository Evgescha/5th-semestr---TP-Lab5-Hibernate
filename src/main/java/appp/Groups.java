package appp;

import java.sql.Date;
import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "gruppyi")
public class Groups {
	
	 @OneToMany (mappedBy="group", fetch=FetchType.EAGER)
	 private Set<Stud> stud;
	 
	public Set<Stud> getStud() {
		return stud;
	}

	public void setStud(Set<Stud> stud) {
		this.stud = stud;
	}
	@Id
	@Column(name="Shifr")
	private int Shifr;
	
	
	@Column(name="Nazvanie")
	private String Nazvanie;
	
	@Column(name="KodPlana")
	private int KodPlana;
	
	@Column(name="Status")
	private String Status;
	
	@Column(name="DataFormir")
	private Date DataFormir;
	
	@Column(name="StatusDate")
	private Date StatusDate;
	
	public Groups() {
		
	}
	/*public void setStud(Set<Stud> students) {
        this.students = students;
    }

    public Set<Stud> getStud() {
        return students;
    }
    */
	
	@Override
	public String toString() {
		return 
				"|" +Integer.toString(Shifr)+ 
				"|" +Nazvanie+ 
				"|" +Integer.toString(KodPlana)+
				"|" +Status+ 
				"|" +DataFormir+ 
				"|" +StatusDate+ "|" ;
		
	}
	// @OneToMany(mappedBy = "studentyi", cascade = CascadeType.ALL, orphanRemoval = true)
	public int getShifr() {
		return Shifr;
	}
	public void setShifr(int shifr) {
		Shifr = shifr;
	}
	public String getNazvanie() {
		return Nazvanie;
	}
	public void setNazvanie(String nazvanie) {
		Nazvanie = nazvanie;
	}
	public int getKodPlana() {
		return KodPlana;
	}
	public void setKodPlana(int kodPlana) {
		KodPlana = kodPlana;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getDataFormir() {
		return DataFormir;
	}
	public void setDataFormir(Date dataFormir) {
		DataFormir = dataFormir;
	}
	public Date getStatusDate() {
		return StatusDate;
	}
	public void setStatusDate(Date statusDate) {
		StatusDate = statusDate;
	}
}
