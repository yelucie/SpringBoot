package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="ville_france")
public class Ville {
	
	@Id
	@Column(name="Code_commune_INSEE")
    private String codeCommune;
	
	@Column(name="Nom_commune")
	private String nomCommune;
	
	@Column(name="Code_postal")
	private String codePostal;
	
	@Column(name="Libelle_acheminement")
	private String libelleAcheminement;
	
	@Column(name="Ligne_5")
	private String ligne;
	
	@Column(name="Latitude")
	private String latitude;
	
	@Column(name="Longitude")
	private String longitude;
}
