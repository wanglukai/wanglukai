package org.hn.Service;

import java.util.List;

import org.hn.Dao.AuctionDaoimpl;
import org.hn.entity.Auction;
import org.hn.util.PageBean;

public class AuctionService {
	
	private AuctionDaoimpl auctiondao = new AuctionDaoimpl();//BaseHibernateDaoֱ��ʵ���˷�ҳ�����Բ�ҪAuctionDaoд��
	public List<Auction> getByPage(PageBean pb) {
		return auctiondao.getByPage(pb.getPageSize(), pb.getCurrentPage());

	}
}
