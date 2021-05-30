package com.mindtree.store.service;

import java.util.ArrayList;

import com.mindtree.store.entity.Type;
import com.mindtree.store.entity.Watch;
import com.mindtree.store.exceptions.ServiceException;

/**
 * @author M1057823
 *
 */
public interface Service {
	public boolean insertType(Type type) throws ServiceException;

	public boolean validate(int userId) throws ServiceException;

	public boolean updateWatch(int watch_id, int userId) throws ServiceException;

	public ArrayList<Watch> sort() throws ServiceException;

	public boolean delete(int typeId) throws ServiceException;

	public ArrayList<Watch> getWatch() throws ServiceException;

	public boolean insertWatch(Watch watch) throws ServiceException;

	public ArrayList<Type> getType() throws ServiceException;
	public boolean validateId(int typeId) throws ServiceException;

}
