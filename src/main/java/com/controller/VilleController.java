package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeBLO;
	
	@RequestMapping(value="/ville", method=RequestMethod.GET)
	@ResponseBody
	public Ville get(@RequestParam(required=false, value="codePostal") String codePostal) {
		System.out.println("get : " + codePostal);
		
		Ville v = villeBLO.getInfoVilles(codePostal);
		
		return v;
	}

}
