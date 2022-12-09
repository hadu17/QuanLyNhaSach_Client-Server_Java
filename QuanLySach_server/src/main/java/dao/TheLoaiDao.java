package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.TheLoai;
import hibernateCfg.HibernateConfig;
import iRemote.ITheLoai;

public class TheLoaiDao extends UnicastRemoteObject implements ITheLoai{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory= null;
	public TheLoaiDao() throws RemoteException {
		sessionFactory=HibernateConfig.getInstance().getSessionFactory();
	}

	@Override
	public List<TheLoai> getAllTheLoai() throws RemoteException {
		Session session=sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			List<TheLoai> list= session.createNativeQuery("  select * from TheLoai",TheLoai.class).getResultList();
			
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
	public static void main(String[] args) throws RemoteException {
		TheLoaiDao theLoaiDao= new TheLoaiDao();
		theLoaiDao.getAllTheLoai().forEach(action->{
			System.out.println(action);
		});
	}
}
