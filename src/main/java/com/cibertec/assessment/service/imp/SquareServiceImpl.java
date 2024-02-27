package com.cibertec.assessment.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.assessment.beans.PolygonBean;
import com.cibertec.assessment.beans.SquareBean;
import com.cibertec.assessment.model.Square;
import com.cibertec.assessment.repo.SquareRepo;
import com.cibertec.assessment.service.PolygonService;
import com.cibertec.assessment.service.SquareService;

@Service
public class SquareServiceImpl implements SquareService{

	@Autowired 
	SquareRepo squareRepo;
	
	@Autowired
	PolygonService polygonService;
	
	
	@Override
    public Square create(Square s) {
        List<PolygonBean> polygons = polygonService.list();
        
        List<Integer> intersectingPolygonIds = new ArrayList<>();
        for (PolygonBean polygon : polygons) {
            if (checkPoints(s, polygon)) {
                intersectingPolygonIds.add(polygon.getId());
            }
        }
        
        if (!intersectingPolygonIds.isEmpty()) {
            s.setPolygons(intersectingPolygonIds.toString());
            s.setNpoints(intersectingPolygonIds.size());
        } else {
            s.setPolygons("NoCoincidencia");
            s.setNpoints(0);
        }
        
        return squareRepo.save(s);
    }

	private boolean checkPoints(Square square, PolygonBean polygon) {
	    Integer[] squareXPoints = new Integer[4];
	    Integer[] squareYPoints = new Integer[4];
	    convertStringInIntegerArray(square.getXPoints(), square.getYPoints(), squareXPoints, squareYPoints);

	    Integer[] polygonXPoints = polygon.getXPoints();
	    Integer[] polygonYPoints = polygon.getYPoints();

	    for (int i = 0; i < squareXPoints.length; i++) {
	        for (int j = 0; j < polygonXPoints.length; j++) {
	            if (squareXPoints[i].equals(polygonXPoints[j]) && squareYPoints[i].equals(polygonYPoints[j])) {
	                return true;
	            }
	        }
	    }

	    return false;
	}
	
	
	@Override
	public List<SquareBean> list() {
		List<Square> list = squareRepo.findAll();
		List<SquareBean> listSquaresBeans = new ArrayList<>();
		list.forEach(s -> {
			Integer[] intArrayX = new Integer[4];
			Integer[] intArrayY = new Integer[4];

			convertStringInIntegerArray(s.getXPoints(), s.getYPoints(), intArrayX, intArrayY);
			 
			SquareBean squareBean = new SquareBean();
			squareBean.setId(s.getId());
			squareBean.setName(s.getName());
			squareBean.setNpoints(s.getNpoints());
			squareBean.setXPoints(intArrayX);
			squareBean.setYPoints(intArrayY);
			squareBean.setPolygons(s.getPolygons()); 
			listSquaresBeans.add(squareBean);
		});

		return listSquaresBeans;
	}
	
	
	private void convertStringInIntegerArray(String xPoints, String yPoints, Integer[] intArrayX, Integer[] intArrayY) {
		String cleanedXPoints = xPoints.substring(1, xPoints.length() - 1);
		String cleanedYPoints = yPoints.substring(1, yPoints.length() - 1);

		// Split the string by commas
		String[] partsX = cleanedXPoints.split(", ");
		String[] partsY = cleanedYPoints.split(", ");

		for (int i = 0; i < partsX.length; i++) {
			intArrayX[i] = Integer.parseInt(partsX[i]);
		}
		
		for (int i = 0; i < partsY.length; i++) {
			intArrayY[i] = Integer.parseInt(partsY[i]);
		}
	}
  
}
