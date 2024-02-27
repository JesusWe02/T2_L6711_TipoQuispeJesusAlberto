package com.cibertec.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.assessment.beans.PolygonBean;
import com.cibertec.assessment.model.Polygon;
import com.cibertec.assessment.service.PolygonService;

@RestController
@RequestMapping("/polygon")
public class PolygonController {
	
	@Autowired
	PolygonService polygonService;
	/*
	@GetMapping
	public ResponseEntity<List<PolygonBean>> list(){
		return new ResponseEntity<>(polygonService.list(), HttpStatus.OK);
	}
	*/
	
	@GetMapping
	public ResponseEntity<List<PolygonBean>> list(){
	    List<PolygonBean> polygons = polygonService.list();
	    System.out.println("Lista de polígonos:");
	    for(PolygonBean polygon : polygons) {
	        System.out.println(polygon.toString());
	    }
	    return new ResponseEntity<>(polygons, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Polygon> create(@RequestBody Polygon p){
		return new ResponseEntity<> (polygonService.create(p), HttpStatus.CREATED);
	}

}
