package org.hn.util;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import java.lang.reflect.ParameterizedType;

public class BaseHibernateDao<T>  {
		
	public Class getGenericType(){
		Type type = this.getClass().getGenericSuperclass();//通过反射得到实体类名称
		if(!(type instanceof ParameterizedType)){
			return Object.class;
		}
		Type[] types = ((ParameterizedType)type).getActualTypeArguments();
		return (Class) types[0];
	}
	
	public Integer getListCount(){//查询总条数
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(getGenericType());
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		HibernateSessionFactory.closeSession();
		return count.intValue();
	}
	
	public List<T> getByPage(int pageSize,int currentPage){//分页查询
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from "+getGenericType().getSimpleName());
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<T> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	
	public List<T> getAll(){//查询方法
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from "+getGenericType().getSimpleName());
		List<T> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	
	public T getOne(Serializable id){//查询单条数据
		Session session = HibernateSessionFactory.getSession();
		Object object = session.get(getGenericType(), id);
		HibernateSessionFactory.closeSession();
		return (T)object;
		
	}
	
	public void add(T entity){//新增
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		session.save(entity);
		ts.commit();
		HibernateSessionFactory.closeSession();
	}
	
	public void update(T entity){//修改
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		session.update(entity);
		ts.commit();
		HibernateSessionFactory.closeSession();
	}
	
	public void delete(Serializable id){//删除
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		Object object = session.get(getGenericType(), id);
		if(object != null){
			session.delete(object);
		}
		ts.commit();
		HibernateSessionFactory.closeSession();
	}
}
