package Controler;
import entidades.cliente.Avulso;

import java.sql.*;
import java.util.ArrayList;

public class AvulsoDB extends Database{
    public boolean insertAvulso(Avulso avulso){
        connect();
        String sql = "INSERT INTO avulso(idAvulso, Cliente_cpf) VALUES (?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, avulso.getIdAvulso());
            pst.setString(2, avulso.getCpf());
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

    public int researchAvulso(){
        connect();
        String sql = "SELECT * from avulso order by idAvulso";
        int id = 0;

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                id = result.getInt("idAvulso");
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
        return id;
    }

    public boolean updateFkAvulso(Avulso avulso){
        connect();
        String sql = "UPDATE avulso SET Cliente_cpf=? WHERE idAvulso=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, avulso.getCpf());
            pst.setInt(2, avulso.getIdAvulso());
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            System.out.println("Cliente não encontrado!");
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

    public boolean deleteAvulso(String cpf){
        connect();
        String sql = "DELETE FROM avulso WHERE Cliente_cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,cpf);
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
