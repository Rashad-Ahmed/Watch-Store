package com.mindtree.store.dao;

import java.util.ArrayList;

import com.mindtree.store.entity.Type;
import com.mindtree.store.entity.Watch;
import com.mindtree.store.exceptions.DaoException;

/**
 * @author M1057823
 *
 */
public interface Dao {
	public boolean insertType(Type type) throws DaoException;

	public ArrayList<Watch> getWatch() throws DaoException;

	public boolean updateWatch(int watch_id, int userId) throws DaoException;

	public boolean deleteType(int typeId) throws DaoException;

	public ArrayList<Type> getType() throws DaoException;

	public boolean insertWatch(Watch watch) throws DaoException;

}
