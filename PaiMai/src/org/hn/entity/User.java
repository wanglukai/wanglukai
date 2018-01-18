package org.hn.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="tbl_user")
public class User implements Serializable {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="seq")
	@SequenceGenerator(name="seq",sequenceName="SEQ")
	private Integer id;
	
	@Column(name="name",columnDefinition="varchar(50) not null")
	private String name;//�û���
	
	@Column(name="password",columnDefinition="varchar(50) default '123456'")
	private String password;//����
	
	@Column(name="phone",columnDefinition="varchar(11)")
	private String phone;//�绰
	
	@Column(name="address",columnDefinition="varchar(200) default '��ַ����'")
	  private String address;//��ͥ��ַ
	
	@Column(name="postNumber",columnDefinition="varchar(6)")
	  private String postNumber;//��������
	
	@Column(name="idCard",columnDefinition="varchar(18) not null")
	  private String idCard;//���֤
	
	@Column(name="idAdmin",columnDefinition="number(1) default 0")
	  private Integer idAdmin;//�ǲ��ǹ���Ա ��1.��2.�ǣ�

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}
	
}
