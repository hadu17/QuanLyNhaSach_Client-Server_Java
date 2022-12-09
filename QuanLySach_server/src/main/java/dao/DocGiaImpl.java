package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import iRemote.DocGiaDao;
import entity.DocGia;
import entity.Sach;
import hibernateCfg.HibernateConfig;

public class DocGiaImpl extends UnicastRemoteObject implements DocGiaDao{
	private SessionFactory sessionFactory; 
	
	public DocGiaImpl() throws RemoteException{
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}
	@Override
	public List<DocGia> layDSDocGia(DocGia docGia) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<DocGia> listNhanVien;
		String sql = "select * from DocGia";
		try {
			tr.begin();
			listNhanVien = session.createNativeQuery(sql, DocGia.class).getResultList();
			tr.commit();
			return listNhanVien;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();

		}
		session.close();
		return null;
	}
	@Override
	public boolean themDocGia(DocGia docGia) throws RemoteException{
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(docGia);
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
	public List<DocGia> layDanhSachDocGia(int page, String ten, int limit) throws RemoteException{
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		if (ten == null)
			ten = "";
		
		if (limit <= 0) {
			limit = 20;
		}

		int offset = page * limit;// lay du lieu bat dau tu vi tri page*20
//		System.out.println(offset+" - "+ page);
try {
	tr.begin();

	String sql= "SELECT *FROM DocGia  where tenDocGia like '%" + ten + "%'  order by maDocGia asc OFFSET "+ offset +"  ROWS FETCH NEXT "+ limit +"  ROWS ONLY;";
	List<DocGia> dsKH = session.createNativeQuery(sql,DocGia.class).getResultList();
	tr.commit();
	return dsKH;
} catch (Exception e) {
	tr.rollback();
	e.printStackTrace();
} finally {
	session.close();
}
return null;
	}
	@Override
	public int tongTrang(String txtSearch, int limit) throws RemoteException{
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		if (txtSearch == null)
			txtSearch = "";
		
		if (limit <= 0) {
			limit = 20;
		}
		try {
			tr.begin();
			String sql = "select count(*) from DocGia where tenDocGia like N'%" + txtSearch + "%' ";
			int result = Integer.parseInt(session.createNativeQuery(sql).uniqueResult().toString());
System.out.println("Tongtrang");
System.out.println(result);
			tr.commit();
			return result % limit == 0 ? result / limit : (result / limit) + 1;
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("tongHang: " + e.getMessage());
			tr.rollback();

		} finally {
			session.close();
		}
		return 0;
	}
//	@Override
	public DocGia layDocGiaTheoMa(String ma) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		String sql = "Select * from DocGia where maDocGia like N'%"+ma+"%'";
		try {
			tr.begin();
			DocGia dG = session.createNativeQuery(sql, DocGia.class).getSingleResult();
			tr.commit();
			System.out.println(dG);
			return dG;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
	}
	
	@Override
	public boolean capNhatDocGia(DocGia docGia) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(docGia);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	@Override
	public boolean xoaDocGia(String docGia) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.delete(session.find(DocGia.class, docGia));
			tr.commit();

			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
	@Override
	public List<DocGia> layDocGiaTheoTen(String ten) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		String sql = "Select * from DocGia where tenDocGia like N'%"+ten+"%'";
		try {
			tr.begin();
			List<DocGia> dG = session.createNativeQuery(sql, DocGia.class).getResultList();
			tr.commit();
			System.out.println(dG);
			return dG;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
	}
	
}
