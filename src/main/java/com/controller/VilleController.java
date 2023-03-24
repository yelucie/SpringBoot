package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeBLO;

	// Get methods
	@GetMapping(value = { "/", "/ville" })
	public List<Ville> getAll() {
		return villeBLO.getInfoVilles();
	}

	@GetMapping(value = "/ville", params = "codeCommune")
	public Ville getByCode(@RequestParam(required = false) String codeCommune) {
		return villeBLO.getInfoVilleByCode(codeCommune);
	}

	@GetMapping(value = "/ville", params = "nomCommune")
	public Ville getByNom(@RequestParam(required = false) String nomCommune) {
		return villeBLO.getInfoVilleByNom(nomCommune);
	}

	@GetMapping(value = "/ville", params = "codePostal")
	public Ville getByCodeP(@RequestParam(required = false) String codePostal) {
		return villeBLO.getInfoVilleByCodeP(codePostal);
	}

	// Post method
	@PostMapping(value = { "/ville/add" })
	public Ville post(@RequestBody Ville ville) {
		return villeBLO.addVille(ville);
	}

	// Put methods
	@PutMapping(value = "/ville", params = "codeCommune")
	public Ville putByCode(@RequestParam(value = "codeCommune") String codeCommune, @RequestBody Ville ville) {
		return villeBLO.updateVilleByCode(codeCommune, ville);
	}

	@PutMapping(value = "/ville", params = "nomCommune")
	public Ville putByName(@RequestParam(value = "nomCommune") String nomCommune, @RequestBody Ville ville) {
		return villeBLO.updateVilleByName(nomCommune, ville);
	}

	@PutMapping(value = "/ville", params = "codePostal")
	public Ville putByCodeP(@RequestParam(value = "codePostal") String codePostal, @RequestBody Ville ville) {
		return villeBLO.updateVilleByCodeP(codePostal, ville);
	}

	// Delete methods
	@DeleteMapping(value = "/ville", params = "codeCommune")
	public void deleteByCode(@RequestParam(value = "codeCommune") String codeCommune) {
		villeBLO.deleteVilleByCode(codeCommune);
	}

	@DeleteMapping(value = "/ville", params = "nomCommune")
	public void deleteByName(@RequestParam(value = "nomCommune") String nomCommune) {
		villeBLO.deleteVilleByName(nomCommune);
	}

	@DeleteMapping(value = "/ville", params = "codePostal")
	public void deleteByCodeP(@RequestParam(value = "codePostal") String codePostal) {
		villeBLO.deleteVilleByCodeP(codePostal);
	}
}
