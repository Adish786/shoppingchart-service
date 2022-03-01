package com.common.retail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name ="SHOPPING")
public class Shopping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String shoppingname;
	private String shoppingtype;
	private int totalshopping;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShoppingname() {
		return shoppingname;
	}
	public void setShoppingname(String shoppingname) {
		this.shoppingname = shoppingname;
	}
	public String getShoppingtype() {
		return shoppingtype;
	}
	public void setShoppingtype(String shoppingtype) {
		this.shoppingtype = shoppingtype;
	}
	public int getTotalshopping() {
		return totalshopping;
	}
	public void setTotalshopping(int totalshopping) {
		this.totalshopping = totalshopping;
	}
	@Override
	public String toString() {
		return "Shopping [id=" + id + ", shoppingname=" + shoppingname + ", shoppingtype=" + shoppingtype
				+ ", totalshopping=" + totalshopping + "]";
	}
	public Shopping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
