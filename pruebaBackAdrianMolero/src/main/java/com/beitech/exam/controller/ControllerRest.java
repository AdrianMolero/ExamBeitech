package com.beitech.exam.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beitech.exam.dto.RequestCreateOrder;
import com.beitech.exam.dto.ResponseOrderByCustomerAndDateDTO;
import com.beitech.exam.service.PruebasBackService;

@RestController
public class ControllerRest {
	
	@Autowired
	private PruebasBackService service;
	
	@GetMapping(value = "/beitech/test/{idCustomer}/{initDate}/{finalDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseOrderByCustomerAndDateDTO> getListOrdersByCustomerAndDateRange(@PathVariable("idCustomer") Integer idCustomer,  
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@PathVariable("initDate") LocalDate initDate, 
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@PathVariable("finalDate") LocalDate finalDate) {
		return ResponseEntity.ok(service.getListOrdersByDateRange(idCustomer, initDate, finalDate));
	}
	
	@PostMapping("/beitech/test/create-order")
	public ResponseEntity<String> createOrder(@RequestBody RequestCreateOrder request){
		Boolean response = service.createOrder(request);
		
		if(response) {
			return ResponseEntity.ok("Se han cargado los datos exitosamente");
		}else {
			return ResponseEntity.ok("Se ha generado un error al momento de cargar los datos");
		}
	}
}
