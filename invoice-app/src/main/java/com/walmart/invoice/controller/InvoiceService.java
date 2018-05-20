package com.walmart.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepo;
	public boolean saveInvoice(Invoice invoice){
		Invoice res = invoiceRepo.save(invoice);
		return res.getFilePath()!=null;
		
	}
	

}
