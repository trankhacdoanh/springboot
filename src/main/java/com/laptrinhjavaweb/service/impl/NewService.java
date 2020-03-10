package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Autowired
	private NewRepository newRepository;
	
	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() != null) {
			newEntity = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, newEntity);
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity category = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(category);
		return newConverter.toDTO(newRepository.save(newEntity));
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			newRepository.delete(id);
		}
		
	}

}
