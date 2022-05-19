package Controler;
import java.sql.*;
import java.util.ArrayList;

import entidades.funcionario.Login;

public class LoginDB extends Database {
    public boolean insertLogin(Login login){
        connect();
        String sql = "INSERT INTO login(email, senha) VALUES (?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, login.getEmail());
            pst.setString(2,login.getSenha());
            pst.execute();
            check = true;
        }
        catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public ArrayList<Login> researchLogin(){
        connect();
        ArrayList<Login> logins = new ArrayList<>();
        String sql = "SELECT * from login";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Login loginTemp = new Login(result.getString("email"),result.getString("senha"));
                loginTemp.setIdLogin(result.getInt("idLogin"));
                System.out.println("idLogin = " + loginTemp.getIdLogin());
                System.out.println("Email = " + loginTemp.getEmail());
                System.out.println("-------------------------------");
                logins.add(loginTemp);
            }
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return logins;
    }

    public boolean updateSenha(String senha, int idLogin){
        connect();
        String sql = "UPDATE login SET senha=? WHERE idLogin=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, senha);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public boolean deleteLogin(int idLogin){
        connect();
        String sql = "DELETE FROM login WHERE idLogin=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idLogin);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
