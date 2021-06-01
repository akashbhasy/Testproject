package com.ust.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue
	@Column(name = "Cart_Id")
	private int cart_ID;
	@Column(name = "Item_Name")
	private String item_Name;
	@Column(name = "Item_Quantity")
	private int item_Quantity;
	@Column(name = "Item_Price")
	private int item_Price;
	@Column(name = "Total_Item_Price")
	private int item_Total_price;

}
