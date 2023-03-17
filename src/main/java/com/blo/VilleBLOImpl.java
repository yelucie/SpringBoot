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
	public Ville getInfoVilles(String codePostal) {
		List<Ville> listVille = villeDAO.findAllVilles();

		for (Ville v : listVille) {
			if (v.getCodePostal().equals(codePostal)) {
				return v;
			}
		}
		return new Ville();
	}
}
