package org.hn.Service;

import java.util.List;

import org.hn.Dao.AuctionDaoimpl;
import org.hn.entity.Auction;
import org.hn.util.PageBean;

public class AuctionService {
	
	private AuctionDaoimpl auctiondao = new AuctionDaoimpl();//BaseHibernateDao直接实现了分页，所以不要AuctionDao写了
	public List<Auction> getByPage(PageBean pb) {
		return auctiondao.getByPage(pb.getPageSize(), pb.getCurrentPage());

	}
}
