package com.boot.controller;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
//http://localhost:8080/index.html (Home Page)
@RestController
@RequestMapping(value="api/v1/")
public class ShipwreckController {
	
	@Autowired
	ShipwreckRepository shipwreckRepository;
	
	@RequestMapping(value="shipwrecks",method=RequestMethod.GET)
	public List<Shipwreck> list()
	{
		//return ShipwreckStub.list();
		return shipwreckRepository.findAll();
	}
	
	@RequestMapping(value="shipwrecks",method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck)
	{
		//return ShipwreckStub.create(shipwreck);
		return shipwreckRepository.saveAndFlush(shipwreck);
	}
	
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id)
	{
		//return ShipwreckStub.get(id);
		return shipwreckRepository.findOne(id);
	}
	
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id,@RequestBody Shipwreck shipwreck)
	{
		//return ShipwreckStub.update(id, shipwreck);
		Shipwreck sh = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, sh);
		return shipwreckRepository.saveAndFlush(sh);
	}
	
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id)
	{
		Shipwreck sh = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(sh);
		return sh;
		//return ShipwreckStub.delete(id);
	}
	

}
