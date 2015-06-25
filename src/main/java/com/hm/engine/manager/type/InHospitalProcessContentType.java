package com.hm.engine.manager.type;

import org.springframework.stereotype.Component;

import com.hm.engine.dao.graph.domain.GraphicProcess.ProcessContent;
import com.hm.engine.service.PushService;
@Component("inHospital")
public class InHospitalProcessContentType implements IProcessContentType {

	@Override
	public void handle(ProcessContent processContent, PushService service) {
		
	}

}