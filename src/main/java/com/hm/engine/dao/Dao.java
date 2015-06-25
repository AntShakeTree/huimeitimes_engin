/**
 * Project Name:vdi-core-server-lls
 * File Name:Dao.java
 * Package Name:com.vdi.dao
 * Date:2014年7月30日下午4:18:18
 * Copyright (c) 2014 All Rights Reserved.
 *
*/
/**
 * Project Name:vdi-core-server-lls
 * File Name:Dao.java
 * Package Name:com.vdi.dao
 * Date:2014年7月30日下午4:18:18
 * Copyright (c) 2014,  All Rights Reserved.
 *
 */

package com.hm.engine.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ant_shake_tree
 * @version 
 * @since JDK 1.7
 */
public interface Dao<T > {
	public  void save(Object domain);
	public  T get(Class<T> clazz,Serializable identity);
	public  List<T> listRequest(Request<T> request);
	public  T update(T domain);
	public  void deleteByIds(Class<T> clazz,Serializable ... identities);
	public  void delete(T domain);
	public T findOneByKey(String filedName,Object key);
	public T findOne(String hql,Object... keys);
	public void excuteNative(String hql, Object... args);
	public void excuteHql(String hql, Object... args);
	public List<T> findHql(String hql, Object... args);
	public List<Object> findAllSql(String hql, Object... args);

	public List<T> findAll();
	public T find(Object id);
}
