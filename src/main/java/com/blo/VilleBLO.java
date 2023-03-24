package com.blo;

import java.util.List;

import com.dto.Ville;

public interface VilleBLO {
	public List<Ville> getInfoVilles();
	public Ville getInfoVilleByCode(String codeCommune);
	public Ville getInfoVilleByNom(String nomCommune);
	public Ville getInfoVilleByCodeP(String codePostal);
	
	public Ville addVille(Ville v);
	
	public Ville updateVilleByCode(String codeCommune, Ville ville);
	public Ville updateVilleByName(String nomCommune, Ville ville);
	public Ville updateVilleByCodeP(String codePostal, Ville ville);
	
	public void deleteVilleByCode(String codeCommune);
	public void deleteVilleByName(String nomCommune);
	public void deleteVilleByCodeP(String codePostal);
}
