package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.TaiKhoan;
import hibernateCfg.HibernateConfig;
import iRemote.ITaiKhoan;

public class TaiKhoanDao extends UnicastRemoteObject implements ITaiKhoan {
	private SessionFactory sessionFactory = null;

	public TaiKhoanDao() throws RemoteException {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	@Override
	public TaiKhoan getTaiKhoan(String tenTaiKhoan) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			TaiKhoan khoan = session.find(TaiKhoan.class, tenTaiKhoan);
			tr.commit();
			return khoan;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean themTaiKhoan(TaiKhoan taiKhoan) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(taiKhoan);
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
	public boolean suaTaiKhoan(TaiKhoan taiKhoan) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(taiKhoan);
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
	public boolean xoaTaiKhoan(String tenTaiKhoan) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(TaiKhoan.class, tenTaiKhoan));
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
}
