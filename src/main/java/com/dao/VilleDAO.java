package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VilleDAO {
	public Ville addVille(Ville ville);
	public List<Ville> findAllVilles();
	public Ville updateVille(String codeCommune, String nomCommune, String codePostal, Ville ville);
	public void deleteVille(String codeCommune, String nomCommune, String codePostal);
}