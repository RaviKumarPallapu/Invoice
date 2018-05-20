package com.walmart.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
	@Autowired
	private InvoiceService invoiceService;
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://temp//";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    //@RequestMapping("/")
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
    		@RequestParam("vendorName") String vendorName,
    		@RequestParam("suplierNumber")String suplierNumber,
    		@RequestParam("customerPo")String customerPo,
    		@RequestParam("totalAmount")String totalAmount,
    		@RequestParam("invoiceNumber")String invoiceNumber,
    		@RequestParam("invoiceDate")String invoiceDate,
    		@RequestParam("fileFormat")String fileFormat, 
    		@RequestParam("fileName")String fileName,
    			
                                   RedirectAttributes redirectAttributes) {
    	String result = "";
    	Invoice invoice = new Invoice();
    	invoice.setCustomerPo(customerPo);
    	invoice.setVendorName(vendorName);
    	invoice.setFileFormat(fileFormat);
    	invoice.setFileName(fileName);
    	invoice.setTotalAmount(totalAmount);
    	invoice.setInvoiceNumber(invoiceNumber);
    	invoice.setInvoiceDate(invoiceDate);
    	invoice.setSuplierNumber(suplierNumber);
    	
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            result = "please Select a file to upload";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            invoice.setFilePath(UPLOADED_FOLDER + file.getOriginalFilename());
            boolean saved = invoiceService.saveInvoice(invoice);
            if(saved){
            	redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");
            	result = "You successfully uploaded '" + file.getOriginalFilename() + "'";
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
        
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}