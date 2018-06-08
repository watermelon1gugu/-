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
				//��������
				tx = session.beginTransaction();
						
				//����query��ķ����õ����
				List<CourseTbEntity> list=courseDAOImpl.getAllCourse();
				
				
				//�ύ����
				tx.commit();
				
				return list;
						
				//return list;
			}catch(Exception e) {
				e.printStackTrace();
				//�ع�����
				tx.rollback();
			}finally {
				//�رղ���
				//session.close();
				//sessionFactory.close();
			}
			return null;
		}
	
	@Override
	/*ѧ��ɾ��*/
	public void StudentDeleteCourse(int courseId,int stuId) {
		CourseDAOImpl courseDAOImpl=new CourseDAOImpl();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionobject();
			//��������
			tx = session.beginTransaction();
			Query query=session.createQuery("delete CourseSelectionTbEntity c where c.id = ? and c.stuCourseId=?");
			query.setParameter(0, stuId);
			query.setParameter(1, courseId);
			query.executeUpdate();
			//�ύ����
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			//�ع�����
			tx.rollback();
		}finally {
			//�رղ���
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

	/*ѧ����Σ������Լ�ѡ�Ŀ�*/
	public List<CourseSelectionTbEntity> StudentFindOwnCourse(int stuId) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionobject();
			//��������
			tx = session.beginTransaction();
					
			//����query��ķ����õ����
			Query query=session.createQuery("from CourseSelectionTbEntity c where c.id=? ");
			query.setParameter(0, stuId);
			//����query��ķ����õ����
			List<CourseSelectionTbEntity> list=query.list();
			
			//�ύ����
			tx.commit();
			
			return list;
			
			//return list;
		}catch(Exception e) {
			e.printStackTrace();
			//�ع�����
			tx.rollback();
		}finally {
			//�رղ���
			//session.close();
			//sessionFactory.close();
		}
		return null;
	}

	@Override
	//ѧ���������пγ�
	public List<CourseTbEntity> StudentFindCourse() {
		CourseDAOImpl courseDAOImpl=new CourseDAOImpl();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionobject();
			//��������
			tx = session.beginTransaction();
					
			//����query��ķ����õ����
			List<CourseTbEntity> list=courseDAOImpl.getAllCourse();
			
			//�ύ����
			tx.commit();
			
			return list;
			
			//return list;
		}catch(Exception e) {
			e.printStackTrace();
			//�ع�����
			tx.rollback();
		}finally {
			//�رղ���
			//session.close();
			//sessionFactory.close();
		}
		return null;
	}
	   
	
}
