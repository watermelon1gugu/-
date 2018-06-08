package service;

import java.util.List;


import DAO.CourseSelectionDAO;
import DAO.Impl.CourseSelectionDAOImpl;
import DAO.Impl.StuDAOImpl;
import DAO.StuDAO;
import entity.CourseSelectionTbEntity;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import DAO.Impl.CourseDAOImpl;
import entity.CourseTbEntity;



public class StudentServiceImpl implements StudentService{
	@Test
	public  List<CourseTbEntity> studentFindCourse() {
			CourseDAOImpl courseDAOImpl=new CourseDAOImpl();
			Session session = null;
			Transaction tx = null;
			try {
				 session = courseDAOImpl.getSessionFactory().getCurrentSession();
				//开启事务
				tx = session.beginTransaction();
						
				//调用query里的方法得到结果
				List<CourseTbEntity> list=courseDAOImpl.getAllCourse();
				
				
				//提交事务
				tx.commit();
				
				return list;
						
				//return list;
			}catch(Exception e) {
				e.printStackTrace();
				//回滚事务
				tx.rollback();
			}finally {
				//关闭操作
				//session.close();
				//sessionFactory.close();
			}
			return null;
		}
	
	@Override
	/*学生删课*/
	public void StudentDeleteCourse(int courseId,int stuId) {
		CourseDAOImpl courseDAOImpl=new CourseDAOImpl();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionobject();
			//开启事务
			tx = session.beginTransaction();
			Query query=session.createQuery("delete CourseSelectionTbEntity c where c.id = ? and c.stuCourseId=?");
			query.setParameter(0, stuId);
			query.setParameter(1, courseId);
			query.executeUpdate();
			//提交事务
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			//回滚事务
			tx.rollback();
		}finally {
			//关闭操作
			//session.close();
			//sessionFactory.close();
		}
	}

	@Override
	public void StudentSelectionCourse(int courseId, int stuId) {

		CourseSelectionTbEntity courseSelectionTbEntity = new CourseSelectionTbEntity();
		courseSelectionTbEntity.setStuId(stuId);
		courseSelectionTbEntity.setCourseId(courseId);
		CourseSelectionDAO courseSelectionDAO = new CourseSelectionDAOImpl();
		courseSelectionDAO.addCourseSelection(courseSelectionTbEntity);
	}

	/*学生查课，查找自己选的课*/
	public List<CourseSelectionTbEntity> StudentFindOwnCourse(int stuId) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionobject();
			//开启事务
			tx = session.beginTransaction();
					
			//调用query里的方法得到结果
			Query query=session.createQuery("from CourseSelectionTbEntity c where c.id=? ");
			query.setParameter(0, stuId);
			//调用query里的方法得到结果
			List<CourseSelectionTbEntity> list=query.list();
			
			//提交事务
			tx.commit();
			
			return list;
			
			//return list;
		}catch(Exception e) {
			e.printStackTrace();
			//回滚事务
			tx.rollback();
		}finally {
			//关闭操作
			//session.close();
			//sessionFactory.close();
		}
		return null;
	}

	@Override
	//学生查找所有课程
	public List<CourseTbEntity> StudentFindCourse() {
		CourseDAOImpl courseDAOImpl=new CourseDAOImpl();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionobject();
			//开启事务
			tx = session.beginTransaction();
					
			//调用query里的方法得到结果
			List<CourseTbEntity> list=courseDAOImpl.getAllCourse();
			
			//提交事务
			tx.commit();
			
			return list;
			
			//return list;
		}catch(Exception e) {
			e.printStackTrace();
			//回滚事务
			tx.rollback();
		}finally {
			//关闭操作
			//session.close();
			//sessionFactory.close();
		}
		return null;
	}
	   
	
}
