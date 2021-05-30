package com.mindtree.store.service;

import java.util.ArrayList;
import java.util.Collections;

import com.mindtree.store.dao.DaoImpl;
import com.mindtree.store.entity.Type;
import com.mindtree.store.entity.Watch;
import com.mindtree.store.exceptions.DaoException;
import com.mindtree.store.exceptions.ServiceException;
import com.mindtree.store.utility.SortByPrice;

public class ServiceImpl implements Service {
	private static DaoImpl dao = new DaoImpl();

	@Override
	public boolean insertType(Type type) throws ServiceException {
		try {
			return dao.insertType(type);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public boolean insertWatch(Watch watch) throws ServiceException {
		try {
			return dao.insertWatch(watch);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public boolean validate(int userTypeId) throws ServiceException {
		ArrayList<Type> watch = new ArrayList<>();
		try {
			watch = dao.getType();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		for (Type d : watch) {
			if (d.getId() == userTypeId) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateWatch(int watch_id, int userId) throws ServiceException {
		try {
			return dao.updateWatch(watch_id, userId);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}

	}

	@Override
	public ArrayList<Watch> getWatch() throws ServiceException {
		try {
			return dao.getWatch();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public ArrayList<Type> getType() throws ServiceException {
		try {
			return dao.getType();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	@Override
	public ArrayList<Watch> sort() throws ServiceException {
		ArrayList<Watch> watchData = new ArrayList<>();
		try {
			watchData = dao.getWatch();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		Collections.sort(watchData, new SortByPrice());
		return watchData;

	}

	@Override
	public boolean delete(int typeId) throws ServiceException {
		try {
			return dao.deleteType(typeId);
		} catch (DaoException e) {

			throw new ServiceException(e.getMessage() + "id not found",e);
		}

	}

	@Override
	public boolean validateId(int typeId) throws ServiceException {
		ArrayList<Watch> typeId1;
		try {
			typeId1 = dao.getWatch();
		} catch (DaoException e1) {
			throw new ServiceException(e1.getMessage(),e1);
		}
		for (Watch e : typeId1) {
			if (e.getT().getId() == typeId)
				return true;
		}
		return false;

	}
}
