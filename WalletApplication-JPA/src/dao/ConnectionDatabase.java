package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDatabase {
	public EntityManager getConnection() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Wallet");

		EntityManager em = emf.createEntityManager();
		return em;
	}

}