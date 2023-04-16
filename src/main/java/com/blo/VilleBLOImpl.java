package com.blo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dto.VilleDto;
import com.dto.VilleResponse;
import com.exceptions.VilleNotFoundException;
import com.models.Ville;
import com.repository.VilleRepository;

@Service
public class VilleBLOImpl implements VilleBlo {

	@Autowired
	private VilleRepository villeRepository;
	
	@Override
	public VilleDto addVille(VilleDto villeDto) {
		Ville ville = new Ville();
		ville.setCodeCommune(villeDto.getCodeCommune());
		ville.setNomCommune(villeDto.getNomCommune());
		ville.setCodePostal(villeDto.getCodePostal());
		ville.setLibelleAcheminement(villeDto.getLibelleAcheminement());
		ville.setLigne(villeDto.getLigne());
		ville.setLatitude(villeDto.getLatitude());
		ville.setLongitude(villeDto.getLongitude());
		
		Ville newVille = villeRepository.save(ville);
		
		VilleDto villeResponse = new VilleDto();
		villeResponse.setCodeCommune(newVille.getCodeCommune());
		villeResponse.setNomCommune(newVille.getNomCommune());
		villeResponse.setCodePostal(newVille.getCodePostal());
		villeResponse.setLibelleAcheminement(newVille.getLibelleAcheminement());
		villeResponse.setLigne(newVille.getLigne());
		villeResponse.setLatitude(newVille.getLatitude());
		villeResponse.setLongitude(newVille.getLongitude());
		
		return villeResponse;
	}
	
	@Override
	public VilleResponse getInfoVilles(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Ville> villes = villeRepository.findAll(pageable);
		List<Ville> listOfVille = villes.getContent();
		List<VilleDto> content = listOfVille.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
		
		VilleResponse villeResponse = new VilleResponse();
		villeResponse.setContent(content);
		villeResponse.setPageNo(villes.getNumber());
		villeResponse.setPageSize(villes.getSize());
		villeResponse.setTotalElements(villes.getTotalElements());
		villeResponse.setTotalPages(villes.getTotalPages());
		villeResponse.setLast(villes.isLast());
		
		return villeResponse;
	}
	
	@Override
	public VilleDto getInfoVille(String codeCommune) {
		Ville ville = villeRepository.findById(codeCommune).orElseThrow(() -> new VilleNotFoundException("Ville could not be found"));
		return mapToDto(ville);
	}

	@Override
	public VilleDto updateVille(String codeCommune, VilleDto villeDto) {
		Ville ville = villeRepository.findById(codeCommune).orElseThrow(() -> new VilleNotFoundException("Ville could not be updated"));

		ville.setCodeCommune(villeDto.getCodeCommune());
		ville.setNomCommune(villeDto.getNomCommune());
		ville.setCodePostal(villeDto.getCodePostal());
		ville.setLibelleAcheminement(villeDto.getLibelleAcheminement());
		ville.setLigne(villeDto.getLigne());
		ville.setLatitude(villeDto.getLatitude());
		ville.setLongitude(villeDto.getLongitude());

        Ville updatedVille = villeRepository.save(ville);
        return mapToDto(updatedVille);
	}

	@Override
	public void deleteVille(String codeCommune) {
		Ville ville = villeRepository.findById(codeCommune).orElseThrow(() -> new VilleNotFoundException("Ville could not be delete"));
        villeRepository.delete(ville);
	}
	
    private VilleDto mapToDto(Ville ville) {
    	VilleDto villeDto = new VilleDto();
    	villeDto.setCodeCommune(ville.getCodeCommune());
    	villeDto.setNomCommune(ville.getNomCommune());
    	villeDto.setCodePostal(ville.getCodePostal());
    	villeDto.setLibelleAcheminement(ville.getLibelleAcheminement());
    	villeDto.setLigne(ville.getLigne());
    	villeDto.setLatitude(ville.getLatitude());
    	villeDto.setLongitude(ville.getLongitude());
        return villeDto;
    }
}
