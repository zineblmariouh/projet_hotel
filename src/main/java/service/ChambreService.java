package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Chambre;
import beans.User;
import connexion.Connexion;
import dao.IDao;

public class ChambreService implements IDao<Chambre>{

	@Override
	public List<Chambre> findAll() {
		 List<Chambre> chambres = new ArrayList<Chambre>();

	        String sql = "select * from chambre";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                chambres.add(new Chambre(rs.getInt("id"), rs.getString("numero"), rs.getString("type"), rs.getString("prix"), rs.getString("image")));
	            }	

	        } catch (SQLException e) {
	            System.out.println("findAll " + e.getMessage());
	        }
	        return chambres;
	}

	@Override
	public boolean create(Chambre o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Chambre o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Chambre o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Chambre findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chambre findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chambre findAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approve(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

	
	

}
