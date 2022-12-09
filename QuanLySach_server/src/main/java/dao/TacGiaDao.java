package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.TacGia;
import entity.TheLoai;
import hibernateCfg.HibernateConfig;
import iRemote.ITacGia;

public class TacGiaDao extends UnicastRemoteObject implements ITacGia{
	private SessionFactory sessionFactory=null;
	public TacGiaDao() throws RemoteException {
		sessionFactory=HibernateConfig.getInstance().getSessionFactory();
	}

	

	@Override
	public List<TacGia> getAllTacGia() throws RemoteException {
		Session session=sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			List<TacGia> list= session.createNativeQuery("  select * from TacGia",TacGia.class).getResultList();
			
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally {
			session.close();
		}
		return null;
	}
}
