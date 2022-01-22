package service;

import beans.User;
import connexion.Connexion;
import dao.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IDao<User> {

	@Override
	public boolean create(User o) {
		String sql = "insert into user values (null, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setString(4, o.getPassword());
            ps.setInt(5, o.getIdentifier());
            ps.setInt(6, o.getAdmin());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());
        }
        return false;
	}


	@Override
	public boolean delete(User o) {
		String sql = "delete from user where id = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());
        }
        return false;
	}

	@Override
	public boolean update(User o) {
		String sql = "update user set nom  = ? , prenom = ?, email = ? ,password = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setString(4, o.getPassword());
            ps.setInt(6, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public User findById(int id) {
		String sql = "select * from user where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("password"), rs.getInt("identifier"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
	}
	
	@Override
	public User findByEmailAndPassword(String email, String password) {
		String sql = "select * from user where email = ? and password = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("password"), rs.getInt("identifier"));
            }

        } catch (SQLException e) {
            System.out.println("findByEmailAndPassword " + e.getMessage());
        }
        return null;
	}
	
	@Override
	public User findAdmin(String email, String password) {
		String sql = "select * from user where email = ? and password = ? and admin = 1";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("password"), rs.getInt("identifier"));
            }

        } catch (SQLException e) {
            System.out.println("findAdmin " + e.getMessage());
        }
        return null;
	}

	@Override
	public List<User> findAll() {
		 List<User> users = new ArrayList<User>();

	        String sql = "select * from user";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                users.add(new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("password"), rs.getInt("identifier")));
	            }

	        } catch (SQLException e) {
	            System.out.println("findAll " + e.getMessage());
	        }
	        return users;
	}


	@Override
	public boolean approve(String id) {
		// TODO Auto-generated method stub
		return false;
	}

    
   
}
