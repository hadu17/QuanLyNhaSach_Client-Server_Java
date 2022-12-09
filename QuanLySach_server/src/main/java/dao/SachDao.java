package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Sach;
import hibernateCfg.HibernateConfig;
import iRemote.ISach;

public class SachDao extends UnicastRemoteObject implements ISach {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1368582452143774092L;
	private SessionFactory sessionFactory = null;

	public SachDao() throws RemoteException {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	@Override
	public List<Sach> getSach(String maLoai, int from, int to) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = " select * from Sach where maTheLoai like '%" + maLoai + "%'  " + "  order by maSach " + "  offset "
					+ from + " rows " + "  fetch next " + (to - from) + " rows only ";
			List<Sach> list = session.createNativeQuery(query, Sach.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean themSach(Sach sach) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(sach);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Sach> getSachTheoTen(String tenSach, int from, int to) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = " select * from Sach where tenSach like '%" + tenSach + "%' " + "  order by maSach " + "  offset "
					+ from + " rows " + "  fetch next " + (to - from) + " rows only ";
			List<Sach> list = session.createNativeQuery(query, Sach.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public static void main(String[] args) throws RemoteException {
		SachDao sachDao = new SachDao();
		sachDao.getSach("SA00035").getDsChiTietPhieuMuon().forEach(e->{
			System.out.println("\n"+e);
		});
	}

	@Override
	public int tongSoDong() throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			int soDong = (int) session.createNativeQuery(" select COUNT(maSach) from Sach where maTheLoai != 'null'").getSingleResult();
			tr.commit();
			return soDong;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return -1;
	}

	@Override
	public Sach getSach(String maSach) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			Sach sach = session.find(Sach.class, maSach);
			tr.commit();
			return sach;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean updateSach(Sach sach) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(sach);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}
//	public static void main(String[] args) {
//		SachDao sachDao = new SachDao();
//		s
//	}

	@Override
	public List<Sach> timSachTheoTenTacGia(String tenTacGia) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "SELECT        s.* "
					+ "FROM            TacGia AS t INNER JOIN "
					+ "                         Sach AS s ON t.maTacGia = s.maTacGia "
					+ "where tenTacGia like '%"+tenTacGia+"%'";
			List<Sach> list = session.createNativeQuery(query, Sach.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
