package com.walmart.invoice.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice_details")
public class Invoice {
	
	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;
	@Column(name="Vendor_Name")
	private String vendorName;
	@Column(name="Suplier_Number")
	private String suplierNumber;
	@Column(name="Customer_Po")
	private String customerPo;
	@Column(name="Total_Amount")
	private String totalAmount;
	@Column(name="Invoice_Number")
	private String invoiceNumber;
	@Column(name="Invoice_Date")
	private String invoiceDate;
	@Column(name="File_Format")
	private String fileFormat; 
	@Column(name="File_Name")
	private String fileName;
	@Column(name="File_Path")
	private String filePath;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getSuplierNumber() {
		return suplierNumber;
	}
	public void setSuplierNumber(String suplierNumber) {
		this.suplierNumber = suplierNumber;
	}
	public String getCustomerPo() {
		return customerPo;
	}
	public void setCustomerPo(String customerPo) {
		this.customerPo = customerPo;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


}
