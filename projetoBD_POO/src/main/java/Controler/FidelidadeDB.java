package Controler;

import entidades.cliente.Fidelidade;

import java.sql.*;
import java.util.ArrayList;

public class FidelidadeDB extends Database {
    public boolean insertFidelidade(Fidelidade fidelidade){
        connect();
        String sql = "INSERT INTO fidelidade(cpf,nome,telefone,email,gasto, idAvulso) VALUES (?,?,?,?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,fidelidade.getCpf());
            pst.setString(2, fidelidade.getNome());
            pst.setString(3, fidelidade.getTelefone());
            pst.setString(4, fidelidade.getEmail());
            pst.setDouble(5,fidelidade.getGasto());
            pst.setInt(6,fidelidade.getIdFidelidade());
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

    public ArrayList<Fidelidade> researchFidelidade(){
        connect();
        ArrayList<Fidelidade> fidelidades = new ArrayList<>();
        String sql = "SELECT * from avulso";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Fidelidade fidelidadeTemp = new Fidelidade(result.getInt("cpf"),result.getString("nome"),result.getString("telefone"),
                        result.getString("email"),result.getDouble("gasto"),result.getInt("idFidelidade"));
                fidelidadeTemp.setCpf(result.getInt("cpf"));
                fidelidadeTemp.Cliente_cpf = result.getInt("Cliente_cpf");
                System.out.println("Cpf = " + fidelidadeTemp.getCpf());
                System.out.println("Nome = " + fidelidadeTemp.getNome());
                System.out.println("Telefone = " + fidelidadeTemp.getTelefone());
                System.out.println("Email = " + fidelidadeTemp.getEmail());
                System.out.println("Gasto = " + fidelidadeTemp.getGasto());
                System.out.println("IdFidelidade = " + fidelidadeTemp.getIdFidelidade());
                if(fidelidadeTemp.Cliente_cpf > 0)
                    System.out.println("Cliente_cpf = " + fidelidadeTemp.Cliente_cpf);
                System.out.println("-------------------------------");
                fidelidades.add(fidelidadeTemp);
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
        return fidelidades;
    }

    public boolean updateFkFidelidade(int cpf, int Cliente_cpf){
        connect();
        String sql = "UPDATE avulso SET Cliente_cpf=? WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(2, Cliente_cpf);
            pst.setInt(1,cpf);
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

    public boolean deleteFidelidade(int cpf){
        connect();
        String sql = "DELETE FROM fidelidade WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,cpf);
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
