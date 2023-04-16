package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBlo;
import com.dto.VilleDto;
import com.dto.VilleResponse;

@RestController
public class VilleController {

	@Autowired
	VilleBlo villeBlo;

	@GetMapping(value = { "/", "/ville" })
	public ResponseEntity<VilleResponse> getAll(
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "50", required = false) int pageSize) {
		return new ResponseEntity<>(villeBlo.getInfoVilles(pageNo, pageSize), HttpStatus.OK);
	}

	@GetMapping(value = "/ville", params = "codeCommune")
	public ResponseEntity<VilleDto> getVille(@RequestParam(value = "codeCommune") String codeCommune) {
		return ResponseEntity.ok(villeBlo.getInfoVille(codeCommune));
	}

	@PostMapping("/ville/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<VilleDto> addVille(@RequestBody VilleDto villeDto) {
		return new ResponseEntity<>(villeBlo.addVille(villeDto), HttpStatus.CREATED);
	}

	@PutMapping(value = "/ville", params = "codeCommune")
	public ResponseEntity<VilleDto> updateVille(@RequestParam(value = "codeCommune") String codeCommune, @RequestBody VilleDto villeDto) {
		VilleDto response = villeBlo.updateVille(codeCommune, villeDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/ville", params = "codeCommune")
	public ResponseEntity<String> deleteByCode(@RequestParam(value = "codeCommune") String codeCommune) {
		villeBlo.deleteVille(codeCommune);
		return new ResponseEntity<>("Ville delete", HttpStatus.OK);
	}
}
