package org.btm.project;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class LibraryDao {

	public int saveLibrary(LibraryDTO library) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();

		session.beginTransaction();

		// return the primary key
		Serializable save = session.save(library);
		Integer id = (Integer) save;
		session.getTransaction().commit();
		session.close();
		return id;
	}

	public int saveLibraryAndBooks(LibraryDTO library, List<BookDTO> listofBooks) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();

		session.beginTransaction();

		// return the primary key
		Serializable save = session.save(library);
		Integer id = (Integer) save;

		for (BookDTO book : listofBooks) {
			session.save(book);
		}

		session.getTransaction().commit();
		session.close();
		return 0;
	}

	/*
	 * public LibraryDTO getLibraryById(int id) { SessionFactory
	 * factory=HibernateUtil.getFactory(); Session session=factory.openSession();
	 * //general
	 * 
	 * LibraryDTO li1=session.get(LibraryDTO.class,new Integer(1));
	 * 
	 * System.out.println(li1); return li1; }
	 */

	public LibraryDTO getLibraryById(int id) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		session.get(LibraryDTO.class, new Integer(1));
		session.close();

		Session session1 = factory.openSession(); // for checking the chasing mechanism

		LibraryDTO li1 = session1.get(LibraryDTO.class, new Integer(1));
		session1.close();
		System.out.println(li1);

		return li1;
	}

	public void updateLibrary(LibraryDTO libFromRunner) {

		SessionFactory factory = HibernateUtil.getFactory();
		Session session2 = factory.openSession();
		session2.beginTransaction();

		// get id using dto object and use get method to get the object
		LibraryDTO libraryFromDb = session2.get(LibraryDTO.class, new Integer(libFromRunner.getId()));
		libraryFromDb.setName(libFromRunner.getName());
		libraryFromDb.setName(libFromRunner.getLocation());

		// update the object
		session2.update(libraryFromDb);
		session2.getTransaction().commit();
		session2.close();

	}

	public void deleteLibrary(LibraryDTO lib) {

		SessionFactory factory = HibernateUtil.getFactory();
		Session session2 = factory.openSession();
		session2.delete(lib);
		session2.close();
	}

}

