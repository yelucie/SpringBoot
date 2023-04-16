package com.blo;

import com.dto.VilleDto;
import com.dto.VilleResponse;

public interface VilleBlo {
	public VilleDto addVille(VilleDto villeDto);
	public VilleResponse getInfoVilles(int pageNo, int pageSize);
	public VilleDto getInfoVille(String codeCommune);
	public VilleDto updateVille(String codeCommune, VilleDto villeDto);
	public void deleteVille(String codeCommune);
}
