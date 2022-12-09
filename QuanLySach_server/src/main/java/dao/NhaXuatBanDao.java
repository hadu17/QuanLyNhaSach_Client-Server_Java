package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.NhaXuatBan;
import entity.TheLoai;
import hibernateCfg.HibernateConfig;
import iRemote.INhaXuatBan;

public class NhaXuatBanDao extends UnicastRemoteObject implements INhaXuatBan{
	private SessionFactory sessionFactory=null;
	public NhaXuatBanDao() throws RemoteException {
		sessionFactory= HibernateConfig.getInstance().getSessionFactory();
	}

	@Override
	public List<NhaXuatBan> getAllNXB() throws RemoteException {
		Session session=sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			List<NhaXuatBan> list= session.createNativeQuery("  select * from NhaXuatBan",NhaXuatBan.class).getResultList();
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
