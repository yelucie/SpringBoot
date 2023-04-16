package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VilleDto {
	private String codeCommune;
	private String nomCommune;
	private String codePostal;
	private String libelleAcheminement;
	private String ligne;
	private String latitude;
	private String longitude;
	
	public String toString() {
		return String.format("INSEE %1$s - %2$s %3$s Libellé [%4$s] | Lat = %5$s Lon = %6$s%n",
				getCodeCommune(), getCodePostal(), getNomCommune(), getLibelleAcheminement(), getLatitude(), getLongitude());
	}
}
