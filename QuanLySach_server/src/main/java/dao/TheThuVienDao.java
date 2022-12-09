package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.TheThuVien;
import hibernateCfg.HibernateConfig;
import iRemote.ITheThuVien;

public class TheThuVienDao extends UnicastRemoteObject implements ITheThuVien {
	private SessionFactory sessionFactory = null;

	public TheThuVienDao() throws RemoteException {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	@Override
	public TheThuVien getTheThuVien(String ma) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			TheThuVien theThuVien= session.find(TheThuVien.class, ma);
			tr.commit();
			return theThuVien;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
