package org.hn.Dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hn.entity.User;
import org.hn.util.BaseHibernateDao;
import org.hn.util.HibernateSessionFactory;

public class UserDaoImpl extends BaseHibernateDao<User> implements UserDao  {
	@Override
	public User getUser(String username, String password) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.and(Restrictions.eq("name",username),Restrictions.eq("password", password)));
		User user = (User)criteria.uniqueResult();
		HibernateSessionFactory.closeSession();
		return user;
	}

}
