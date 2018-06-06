package service;

import java.util.List;

import entity.CourseSelectionTbEntity;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.Impl.CourseDAOImpl;
import entity.CourseTbEntity;

public class ManagerServiceImpl implements ManagerService{

	@Override

	public List<CourseTbEntity> ManagerFindCourse() {
		CourseDAOImpl courseDAOImpl=new CourseDAOImpl();
		Session session = null;
		Transaction tx = null;
		try {
			 session = courseDAOImpl.getSessionFactory().getCurrentSession();

			tx = session.beginTransaction();
					

			List<CourseTbEntity> list=courseDAOImpl.getAllCourse();
			
			

			tx.commit();
			
			return list;
					
			//return list;
		}catch(Exception e) {
			e.printStackTrace();

			tx.rollback();
		}finally {

			//session.close();
			//sessionFactory.close();
		}
		return null;
	}

	@Override

	public List<CourseSelectionTbEntity> ManagerFindCourseSelection(int stuId) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionobject();

			tx = session.beginTransaction();
					

			Query query=session.createQuery("from CourseSelectionTbEntity where stuId=? ");
			query.setParameter(0, stuId);

			List<CourseSelectionTbEntity> list=query.list();
			

			tx.commit();
			
			return list;
			
			//return list;
		}catch(Exception e) {
			e.printStackTrace();

			tx.rollback();
		}finally {
			//session.close();
			//sessionFactory.close();
		}
		return null;
	}

	public void ManagerDeleteStuCourse(int courseId,int stuId) {
		CourseDAOImpl courseDAOImpl=new CourseDAOImpl();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionobject();

			tx = session.beginTransaction();
			Query query=session.createQuery("delete CourseSelectionTbEntity where.stuId=? and.courseId=?");
			query.setParameter(0, stuId);
			query.setParameter(1, courseId);
			query.executeUpdate();

			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();

			tx.rollback();
		}finally {

			//session.close();
			//sessionFactory.close();
		}
	}
	
}
