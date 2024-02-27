package com.cibertec.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cibertec.assessment.model.Polygon;
import com.cibertec.assessment.model.Square;
import com.cibertec.assessment.service.PolygonService;
import com.cibertec.assessment.service.SquareService;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

	@Autowired
	PolygonService polygonService;
	
	@Autowired
	SquareService squareService;

	@PostConstruct
	public void initializeData() {
		
		// POLYGON
		
		/*	
		List<Polygon> list = new ArrayList<>();

		String[] xpoint1 = { "10", "205", "305", "405", "500" };
		String[] ypoint1 = { "10", "501", "506", "107", "30" };

		String[] xpoint2 = { "100", "605", "305", "405", "500" };
		String[] ypoint2 = { "100", "601", "506", "337", "300" };
		
		String[] xpoint3 = { "150", "250", "350", "300", "200" };
		String[] ypoint3 = { "100", "0", "100", "200", "200" };
		
		String[] xpoint4 = { "150", "250", "350", "350", "250", "150"};
		String[] ypoint4 = { "100", "50", "100", "200", "250", "200"};
		
		
		Polygon polygon1 = new Polygon().builder()
				.name("Poligon 01")
				.npoints(xpoint1.length)
				.xPoints(Arrays.toString(xpoint1))
				.yPoints(Arrays.toString(ypoint1))
				.build();
		
		Polygon polygon2 = new Polygon().builder()
				.name("Poligon 02")
				.npoints(xpoint2.length)
				.xPoints(Arrays.toString(xpoint2))
				.yPoints(Arrays.toString(ypoint2))
				.build();
		
		Polygon polygon3 = new Polygon().builder()
				.name("Poligon 03")
				.npoints(xpoint3.length)
				.xPoints(Arrays.toString(xpoint3))
				.yPoints(Arrays.toString(ypoint3))
				.build();
		
		Polygon polygon4 = new Polygon().builder()
				.name("Poligon 04")
				.npoints(xpoint4.length)
				.xPoints(Arrays.toString(xpoint4))
				.yPoints(Arrays.toString(ypoint4))
				.build();
		
		list.add(polygon1);
		list.add(polygon2);
		list.add(polygon3);
		list.add(polygon4);
		
		polygonService.create(list);

		*/
		// SQUARE
		/*
		List<Square> list2 = new ArrayList<>();
		
		String[] xpoint5 = {"150.0", "250.0", "250.0", "150.0"};
		String[] ypoint5 = {"100.0", "100.0", "200.0", "200.0"};
		
		
		Square square1 = new Square().builder()
				.name("Square 01")
				.xPoints(Arrays.toString(xpoint5))
				.yPoints(Arrays.toString(ypoint5))
				.npoints(squareService.MetodoParaCalcularNumeroVertices())
                .polygons(squareService.MetodoParaTraerIdsDePoligonosCoincidentes())
				.build();
		
		list2.add(square1);		
		
		squareService.create(list2);
		
			*/
		
		//polygonService.list();
	}
}
