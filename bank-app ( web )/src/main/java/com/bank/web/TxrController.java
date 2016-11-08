package com.bank.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.TxrService;

@RestController
public class TxrController {

	@Autowired
	private TxrService txrService;

	// @RequestMapping(name = "/txr", method = RequestMethod.POST)
	// public String doTxr(@RequestParam double amount, @RequestParam String
	// fromAcc, @RequestParam String toAcc) {
	// txrService.txr(amount, fromAcc, toAcc);
	// return "Txr successfull";
	// }

	@RequestMapping(name = "/txr", 
			        method = RequestMethod.POST, 
			        consumes = {"application/xml","application/json" }, 
			        produces = {"application/xml","application/json" })
	public TxrStatus doTxr(@RequestBody TxrForm txrForm,Principal principal) {
		txrService.txr(txrForm.getAmount(), txrForm.getFromAcc(), txrForm.getToAcc());
		TxrStatus status = new TxrStatus();
		status.setMessage("success");
		return status;
	}

}
