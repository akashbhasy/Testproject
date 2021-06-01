package com.ust.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "Product_ID")
	private @NonNull int productId;
	@Column(name = "Product_Name")
	private  @NonNull String productName;
	@Column(name = "Product_Quantity")
	private @NonNull int quantityOnHand;
	@Column(name = "Product_Price")
	private  @NonNull int price;

	
}
