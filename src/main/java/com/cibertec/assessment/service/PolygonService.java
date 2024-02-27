package com.cibertec.assessment.service;

import java.util.List;

import com.cibertec.assessment.beans.PolygonBean;
import com.cibertec.assessment.model.Polygon;

public interface PolygonService {

	public List<PolygonBean> list();
	public Polygon create(Polygon p);
	
	//public void create(Polygon p);
	//public void create(List<Polygon> lp);
	
}
