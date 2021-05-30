package com.mindtree.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mindtree.store.entity.Type;
import com.mindtree.store.entity.Watch;
import com.mindtree.store.exceptions.ConnectionUtilityException;
import com.mindtree.store.exceptions.DaoException;
import com.mindtree.store.utility.ConnectionUtility;

public class DaoImpl implements Dao {
	@Override
	public boolean insertType(Type type) throws DaoException {
		ConnectionUtility connec = new ConnectionUtility();
		Connection con;
		try {
			con = connec.getConnection();
		} catch (ConnectionUtilityException e2) {
			throw new DaoException(e2.getMessage());
		}
		int id = type.getId();
		String name = type.getName();
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "insert into type values(" + id + ",'" + name + "');";
			st.execute(sql);
			con.close();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return true;
	}

	@Override
	public boolean insertWatch(Watch watch) throws DaoException {
		ConnectionUtility connec = new ConnectionUtility();
		Connection con;
		try {
			con = connec.getConnection();
		} catch (ConnectionUtilityException e2) {
			throw new DaoException(e2.getMessage(), e2);
		}

		try {
			String sql = "insert into watch values(?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, watch.getWatch_id());
			ps.setInt(2, watch.getModelNumber());
			ps.setFloat(3, watch.getPrice());
			ps.setInt(4, watch.getT().getId());
			ps.execute();
			con.close();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return true;
	}

	@Override
	public ArrayList<Watch> getWatch() throws DaoException {
		ArrayList<Watch> watchTable = new ArrayList<>();
		ConnectionUtility connec = new ConnectionUtility();
		Connection con;
		try {
			con = connec.getConnection();
		} catch (ConnectionUtilityException e1) {
			throw new DaoException(e1.getMessage(), e1);
		}
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "select * from watch;";
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Type t = new Type();
				t.setId(rs.getInt(4));
				Watch watch = new Watch(rs.getInt(1), rs.getInt(2), rs.getInt(3), t);
				watchTable.add(watch);
			}
			con.close();
		} catch (SQLException e) {
			throw new DaoException("type not found", e);
		}
		return watchTable;
	}

	@Override
	public ArrayList<Type> getType() throws DaoException {
		ArrayList<Type> typeTable = new ArrayList<>();
		ConnectionUtility connec = new ConnectionUtility();
		Connection con;
		try {
			con = connec.getConnection();
		} catch (ConnectionUtilityException e1) {
			throw new DaoException(e1.getMessage(), e1);
		}
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "select * from type;";
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Type type = new Type(rs.getInt(1), rs.getString(2));
				typeTable.add(type);
			}
			con.close();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return typeTable;
	}

	@Override
	public boolean updateWatch(int watchh_id, int userId) throws DaoException {
		ConnectionUtility connec = new ConnectionUtility();
		Connection con;
		try {
			con = connec.getConnection();
		} catch (ConnectionUtilityException e1) {
			throw new DaoException(e1.getMessage(), e1);
		}
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = " update watch set modelNumber=" + watchh_id + " where id=" + userId + ";";
			st.execute(sql);
			con.close();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return true;
	}

	@Override
	public boolean deleteType(int Id) throws DaoException {
		ConnectionUtility connec = new ConnectionUtility();
		Connection con;
		try {
			con = connec.getConnection();
		} catch (ConnectionUtilityException e1) {
			throw new DaoException(e1.getMessage(), e1);
		}
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = " delete from watch where id=" + Id + ";";
			st.execute(sql);
			sql = " delete from type where id=" + Id + ";";
			st.execute(sql);
			con.close();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return true;

	}

}
