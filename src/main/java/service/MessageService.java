package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Chambre;
import beans.Message;
import beans.Reservation;
import connexion.Connexion;
import dao.IDao;

public class MessageService implements IDao<Message>{

	@Override
	public boolean create(Message message) {
		
        try {
        	Connexion obj_DB_Connection = new Connexion();
            Connection connection = obj_DB_Connection.getConnection();
            PreparedStatement ps = null;
            String sql = "insert into message values(null,?,?,?,?)";


           
   			ps = connection.prepareStatement(sql);
   			ps.setString(1,message.getFullname());
   			ps.setString(2, message.getEmail());
   			ps.setString(3, message.getPhone());
   			ps.setString(4, message.getMessage());
   			if (ps.executeUpdate() == 1) {
                return true;
            }
   			else {
   				System.out.println("create : erreur sql : ");
   			}
   			
   		} 
         catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());
        }
		return false;
	}
	
	@Override
	public List<Message> findAll() {
		List<Message> messages = new ArrayList<Message>();

        String sql = "SELECT * FROM message";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                messages.add(new Message(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getString("message")));
            }	

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return messages;
	}

	@Override
	public boolean delete(Message o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Message o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approve(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Message findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message findAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
