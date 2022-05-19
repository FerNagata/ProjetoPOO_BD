package Controler;
import entidades.cliente.Avulso;

import java.sql.*;
import java.util.ArrayList;

public class AvulsoDB extends Database{
    public boolean insertAvulso(Avulso avulso){
        connect();
        String sql = "INSERT INTO avulso(cpf,nome,telefone,email,gasto, idAvulso) VALUES (?,?,?,?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,avulso.getCpf());
            pst.setString(2, avulso.getNome());
            pst.setString(3, avulso.getTelefone());
            pst.setString(4, avulso.getEmail());
            pst.setDouble(5,avulso.getGasto());
            pst.setInt(6, avulso.getIdAvulso());
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

    public ArrayList<Avulso> researchAluno(){
        connect();
        ArrayList<Avulso> avulsos = new ArrayList<>();
        String sql = "SELECT * from avulso";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Avulso avulsoTemp = new Avulso(result.getInt("cpf"),result.getString("nome"),result.getString("telefone"),
                        result.getString("email"),result.getDouble("gasto"));
                avulsoTemp.setCpf(result.getInt("cpf"));
                avulsoTemp.Cliente_cpf = result.getInt("Cliente_cpf");
                System.out.println("Cpf = " + avulsoTemp.getCpf());
                System.out.println("Nome = " + avulsoTemp.getNome());
                System.out.println("Telefone = " + avulsoTemp.getTelefone());
                System.out.println("Email = " + avulsoTemp.getEmail());
                System.out.println("Gasto = " + avulsoTemp.getGasto());
                System.out.println("IdAvulso = " + avulsoTemp.getIdAvulso());
                if(avulsoTemp.Cliente_cpf > 0)
                    System.out.println("Cliente_cpf = " + avulsoTemp.Cliente_cpf);
                System.out.println("-------------------------------");
                avulsos.add(avulsoTemp);
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
        return avulsos;
    }

    public boolean updateFkAvulso(int cpf, int Cliente_cpf){
        connect();
        String sql = "UPDATE avulso SET Cliente_cpf=? WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,cpf);
            pst.setInt(2, Cliente_cpf);
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

    public boolean deleteAvulso(int cpf){
        connect();
        String sql = "DELETE FROM avulso WHERE cpf=?";
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
