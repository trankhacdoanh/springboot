package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {
	public NewDTO toDTO(NewEntity newEntity) {
		NewDTO newDTO = new NewDTO();
		if(newEntity.getId() != null) {
			newDTO.setId(newEntity.getId());
		}
		newDTO.setTitle(newEntity.getTitle());
		newDTO.setShortDescription(newEntity.getShortDescription());
		newDTO.setContent(newEntity.getContent());
		newDTO.setThumbnail(newEntity.getThumbnail());
		newDTO.setCategoryCode(newEntity.getCategory().getCode());
		newDTO.setCreatedDate(newEntity.getCreatedDate());
		newDTO.setCreatedBy(newEntity.getCreatedBy());
		newDTO.setModifiedDate(newEntity.getModifiedDate());
		newDTO.setModifiedBy(newEntity.getModifiedBy());
		return newDTO;
	}
	
	public NewEntity toEntity(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setShortDescription(newDTO.getShortDescription());
		newEntity.setContent(newDTO.getContent());
		newEntity.setThumbnail(newDTO.getThumbnail());
		return newEntity;
	}
	
	public NewEntity toEntity(NewDTO newDTO, NewEntity newEntity) {
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setShortDescription(newDTO.getShortDescription());
		newEntity.setContent(newDTO.getContent());
		newEntity.setThumbnail(newDTO.getThumbnail());
		return newEntity;
	}
}
