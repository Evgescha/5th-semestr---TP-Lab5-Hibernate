package appp;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "studentyi")
public class Stud {
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "Shifr")
	private Groups group;

	public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}

	@Id
	@Column(name = "ShifrGruppyi")
	private int ShifrGruppyi;

	@Column(name = "NomerZachetki")
	private int NomerZachetki;

	@Column(name = "Familiya")
	private String Familiya;

	@Column(name = "Imya")
	private String Imya;

	@Column(name = "Otchestvo")
	private String Otchestvo;

	@Column(name = "Gorod")
	private String Gorod;

	@Column(name = "Adres")
	private String Adres;

	@Column(name = "Tel")
	private long Tel;

	@Column(name = "Status")
	private String Status;

	@Column(name = "StatusDate")
	private Date StatusDate;

	public Stud() {

	}

	public int getShifrGruppyi() {
		return ShifrGruppyi;
	}

	public void setShifrGruppyi(int shifrGruppyi) {
		ShifrGruppyi = shifrGruppyi;
	}

	public int getNomerZachetki() {
		return NomerZachetki;
	}

	public void setNomerZachetki(int nomerZachetki) {
		NomerZachetki = nomerZachetki;
	}

	public String getFamiliya() {
		return Familiya;
	}

	public void setFamiliya(String familiya) {
		Familiya = familiya;
	}

	public String getImya() {
		return Imya;
	}

	public void setImya(String imya) {
		Imya = imya;
	}

	public String getOtchestvo() {
		return Otchestvo;
	}

	public void setOtchestvo(String otchestvo) {
		Otchestvo = otchestvo;
	}

	public String getGorod() {
		return Gorod;
	}

	public void setGorod(String gorod) {
		Gorod = gorod;
	}

	public String getAdres() {
		return Adres;
	}

	public void setAdres(String adres) {
		Adres = adres;
	}

	public long getTel() {
		return Tel;
	}

	public void setTel(long tel) {
		Tel = tel;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getStatusDate() {
		return StatusDate;
	}

	public void setStatusDate(Date statusDate) {
		StatusDate = statusDate;
	}

	@Override
	public String toString() {
		return "|" + Integer.toString(group.getShifr()) + "|" + Integer.toString(NomerZachetki) + "|" + Familiya + "|"
				+ Imya + "|" + Otchestvo + "|" + Gorod + "|" + Adres + "|" + Long.toString(Tel) + "|" + Status + "|";

	}

}
