package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;
	
	@Override
	public List<Ville> getInfoVilles() {
		return villeDAO.findAllVilles();
	}
	
	@Override
	public Ville getInfoVilleByCode(String codeCommune) {
		for (Ville v : getInfoVilles()) {
			if (v.getCodeCommune().equals(codeCommune)) {
				return v;
			}
		}
		return new Ville();
	}
	
	@Override
	public Ville getInfoVilleByNom(String nomCommune) {
		for (Ville v : getInfoVilles()) {
			if (v.getNomCommune().equals(nomCommune)) {
				return v;
			}
		}
		return new Ville();
	}

	@Override
	public Ville getInfoVilleByCodeP(String codePostal) {
		for (Ville v : getInfoVilles()) {
			if (v.getCodePostal().equals(codePostal)) {
				return v;
			}
		}
		return new Ville();
	}
	
	@Override
	public Ville addVille(Ville ville) {
		return villeDAO.addVille(ville);
	}

	@Override
	public Ville updateVilleByCode(String codeCommune, Ville ville) {
		return villeDAO.updateVille(codeCommune, null, null, ville);
	}

	@Override
	public Ville updateVilleByName(String nomCommune, Ville ville) {
		return villeDAO.updateVille(null, nomCommune, null, ville);
	}

	@Override
	public Ville updateVilleByCodeP(String codePostal, Ville ville) {
		return villeDAO.updateVille(null, null, codePostal, ville);
	}

	@Override
	public void deleteVilleByCode(String codeCommune) {
		villeDAO.deleteVille(codeCommune, null, null);
	}

	@Override
	public void deleteVilleByName(String nomCommune) {
		villeDAO.deleteVille(null, nomCommune, null);
	}

	@Override
	public void deleteVilleByCodeP(String codePostal) {
		villeDAO.deleteVille(null, null, codePostal);
	}
}
