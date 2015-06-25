package com.hm.engine.manager.type;

import com.hm.engine.dao.graph.domain.GraphicProcess.ProcessContent;
import com.hm.engine.service.PushService;

public interface IProcessContentType {
//	private ProcessContent processContent;
	/**
	 * 处理流程节点
	 * @param processContent
	 * @param service 通过回调函数来确认是推送到数据库还是前端
	 */
	public void handle(ProcessContent processContent,PushService service);
}
