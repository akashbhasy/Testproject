package com.ust.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
@AllArgsConstructor
public class Customer {
	@Id
	@Column(name = "Customer_ID")
	@GeneratedValue
	private @NonNull int customer_ID;
	@Column(name = "First_Name")
	private  @NonNull String first_Name;
	@Column(name = "Last_Name")
	private  @NonNull String last_Name;
	@Column(name = "Customer_Address")
	private @NonNull String customer_Address;
	@Column(name = "Email_Id")
	private  @NonNull String email_Id;
	@Column(name = "Customer_Status")
	private  @NonNull String customer_Status;

}
