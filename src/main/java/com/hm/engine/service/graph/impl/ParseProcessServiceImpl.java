package com.hm.engine.service.graph.impl;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.hm.engine.common.ParseJSON;
import com.hm.engine.dao.graph.GraphicProcessDao;
import com.hm.engine.dao.graph.ProcessExpressionDao;
import com.hm.engine.dao.graph.UserDiseaseDigraphDao;
import com.hm.engine.dao.graph.domain.GraphicProcess;
import com.hm.engine.dao.graph.domain.ProcessExpression;
import com.hm.engine.dao.graph.domain.UserDiseaseDigraph;
import com.hm.engine.dao.graph.domain.UserDiseaseDigraph.Bulider;
import com.hm.engine.dao.suport.QueryUtil;
import com.hm.engine.parse.omnigraffle.tools.JaxbParseOmniGraffleTools;
import com.hm.engine.service.graph.ParseProcessService;
@Component
public class ParseProcessServiceImpl implements ParseProcessService {
	@Autowired GraphicProcessDao graphicProcessDao;
	@Autowired UserDiseaseDigraphDao userDiseaseDigraphDao;
	@Override
	public void parseProcess(String path) {
		try {
			List<GraphicProcess> pr =	JaxbParseOmniGraffleTools.gernalAllProcess(path);
			for (GraphicProcess graphicProcess : pr) {
				graphicProcessDao.save(graphicProcess);
			}
			
		} catch (FileNotFoundException | ParserConfigurationException
				| JAXBException | SAXException e) {
			e.printStackTrace();
		}
	}


}
