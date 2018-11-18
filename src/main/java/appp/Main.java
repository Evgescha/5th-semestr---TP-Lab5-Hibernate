package appp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class Main {

	// get fabric and session
	static SessionFactory sf;
	static Session s;
	static Criteria ctr = null;

	public static void main(String[] args) {
		// get new session and open
		sf = HibernateUtil.getSessionFactory();
		s = sf.openSession();
		// list for two tables
		List<Stud> students = null;
		List<Groups> groups = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Input command");
		String command = sc.nextLine();
		System.out.println("Input table name");
		String table = sc.nextLine();

		try {
			s.beginTransaction();
			switch (command.toLowerCase()) {
			// command get, get table and print this
			case "get":
				System.out.println("Command get");
				switch (table.toLowerCase()) {
				case "gruppyi":
					ctr = s.createCriteria(Groups.class);
					groups = ctr.list();
					for (Groups group : groups) {
						System.out.println(group);
					}
					break;
				case "studentyi":
					ctr = s.createCriteria(Stud.class);
					students = ctr.list();
					for (Stud stud : students) {
						System.out.println(stud);
					}
					break;
				default:
					System.out.println("False table name");
					break;
				}
				break;
			// command add, add new group or student
			case "add":
				switch (table.toLowerCase()) {
				// add new group
				case "gruppyi":
					Groups gr = new Groups();
					// yyyy-MM-dd
					System.out.println("Input nazvanie");
					gr.setNazvanie(sc.nextLine());
					System.out.println("Input kodPlana ");
					gr.setKodPlana(Integer.parseInt(sc.nextLine()));
					System.out.println("Input shifr");
					gr.setShifr(Integer.parseInt(sc.nextLine()));
					System.out.println("Input status");
					gr.setStatus(sc.nextLine());
					System.out.println("Input dataFormir");
					gr.setDataFormir(Date.valueOf(sc.nextLine()));
					System.out.println("Input statusDate");
					gr.setStatusDate(Date.valueOf(sc.nextLine()));
					// save new group
					s.save(gr);
					s.getTransaction().commit();
					System.out.println("Group add complete");
					break;

				case "studentyi":
					// add new student
					Stud st = new Stud();
					System.out.println("Input imya");
					st.setImya(sc.nextLine());
					System.out.println("Input familiya");
					st.setFamiliya(sc.nextLine());
					System.out.println("Input otchestvo");
					st.setOtchestvo(sc.nextLine());
					System.out.println("Input gorod");
					st.setGorod(sc.nextLine());
					System.out.println("Input adres");
					st.setAdres(sc.nextLine());
					System.out.println("Input nomerZachetki");
					st.setNomerZachetki(Integer.parseInt(sc.nextLine()));
					System.out.println("Input status");
					st.setStatus(sc.nextLine());
					System.out.println("Input tel");
					st.setTel(Long.parseLong(sc.nextLine()));

					System.out.println("Input shifrGruppyi");
					ctr = s.createCriteria(Groups.class);
					groups = ctr.list();
					ctr.add(Restrictions.idEq(Integer.parseInt(sc.nextLine())));
					groups = ctr.list();
					st.setGroup(groups.get(0));

					System.out.println("Input statusDate");
					st.setStatusDate(Date.valueOf(sc.nextLine()));

					ctr = s.createCriteria(Stud.class);
					students = ctr.list();
					st.setShifrGruppyi(students.size());
					// save new student
					s.save(st);
					s.getTransaction().commit();
					System.out.println("Student add comlete");
					break;
				default:
					System.out.println("False table name");
					break;
				}

				break;
			case "set":
				switch (table.toLowerCase()) {
				case "studentyi":
					ctr = s.createCriteria(Stud.class);
					String what = "";
					System.err.println("What update?  Familiya, Imya, Otchestvo, Gorod, Adres");
					what = sc.nextLine();
					System.err.println("Input "+ what + ", where need update");
					ctr.add(Restrictions.like(what, sc.nextLine()));
					students = ctr.list();
					if (students.isEmpty()) {
						System.out.println("He can't be");					
						break;
					}
					System.out.println("Input new " + what);
					switch (what) {
						case "Familiya":
							students.get(0).setFamiliya(sc.nextLine());
							break;
	
						case "Imya":
							students.get(0).setImya(sc.nextLine());
							break;
	
						case "Otchestvo":
							students.get(0).setOtchestvo(sc.nextLine());
							break;
	
						case "Gorod":
							students.get(0).setGorod(sc.nextLine());
							break;
	
						case "Adres":
							students.get(0).setAdres(sc.nextLine());
							break;						
					}
					
					s.getTransaction().commit();
					s.flush();
					System.err.println("Data for student update!");
					break;
				}
				break;

			default:
				System.out.println("False command");
				break;
			}
		} catch (Exception e) {
			System.out.println("FATAL ERROR");
			e.printStackTrace();
			s.flush();
			s.close();
			main(args);
		}

		s.flush();
		s.close();
		main(args);

	}
}
