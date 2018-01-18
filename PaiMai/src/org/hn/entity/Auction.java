package org.hn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Auction")
public class Auction {
	    @Id
	    @Column(name = "id")
	    @GeneratedValue(generator = "auction")
	    @SequenceGenerator(name = "auction",sequenceName = "AUCTION")
	    private Integer id;//编号
	    @Column(name = "name",columnDefinition = "varchar(50) not null")
	    private String name;//拍卖品名�?
	    @Column(name = "startprice",columnDefinition = "number(9,2) not null")
	    private Double startPrice;//拍卖品价格起拍价�?
	    @Column(name = "upset",columnDefinition = "number(9,2) not null")
	    private Double upset;//拍卖品底�?
	    @Column(name = "startTime",columnDefinition = "timestamp not null")
	    private Date startTime;//起拍时间
	    @Column(name = "endTime",columnDefinition = "timestamp not null")
	    private Date endTime;//结束时间
	    @Column(name = "pic",columnDefinition = "blob not null")
	    private byte[] pic;//牌品图片
	    @Column(name = "picType",columnDefinition = "varchar(20) not null")
	    private String picType;//图片后缀
	    @Column(name = "esc",columnDefinition = "varchar(500)")  //原本是desc 因为是关键字会报错，所以改了
	    private String esc;//拍品描述
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getStartPrice() {
			return startPrice;
		}
		public void setStartPrice(Double startPrice) {
			this.startPrice = startPrice;
		}
		public Double getUpset() {
			return upset;
		}
		public void setUpset(Double upset) {
			this.upset = upset;
		}
		public Date getStartTime() {
			return startTime;
		}
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		public Date getEndTime() {
			return endTime;
		}
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
		public byte[] getPic() {
			return pic;
		}
		public void setPic(byte[] pic) {
			this.pic = pic;
		}
		public String getPicType() {
			return picType;
		}
		public void setPicType(String picType) {
			this.picType = picType;
		}
		public String getesc() {
			return esc;
		}
		public void setesc(String esc) {
			this.esc = esc;
		}

	
}
