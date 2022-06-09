package Controler;

import entidades.cliente.Avulso;
import entidades.cliente.Cliente;
import entidades.cliente.Fidelidade;
import entidades.estabelecimento.Fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDB extends Database{
    public boolean insertClienteFidelidade(Fidelidade fidelidade){
        connect();
        String sql = "INSERT INTO cliente(cpf,nome,telefone,email, gasto) VALUES (?,?,?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,fidelidade.getCpf());
            pst.setString(2, fidelidade.getNome());
            pst.setString(3, fidelidade.getTelefone());
            pst.setString(4, fidelidade.getEmail());
            pst.setDouble(5, fidelidade.getGasto());
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

    public boolean insertClienteAvulso(Avulso avulso){
        connect();
        String sql = "INSERT INTO cliente(cpf,nome,telefone,email, gasto) VALUES (?,?,?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,avulso.getCpf());
            pst.setString(2, avulso.getNome());
            pst.setString(3, avulso.getTelefone());
            pst.setString(4, avulso.getEmail());
            pst.setDouble(5, avulso.getGasto());
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

    public double researchGastoClienteAvulso(String cpf){
        connect();

        double gasto = 0;
        String sql = "SELECT * from cliente where cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,cpf);
            pst.execute();
            result = pst.executeQuery();

            while(result.next()){
                gasto = result.getDouble("gasto");
            }
        }
        catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                result.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }

        return gasto;
    }

    public double researchGastoClienteFidelidade(String cpf){
        connect();

        double gasto = 0;
        String sql = "SELECT * from cliente where cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,cpf);
            pst.execute();
            result = pst.executeQuery();

            while(result.next()){
                gasto = result.getDouble("gasto");
            }
        }
        catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                result.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }

        return gasto;
    }

    public boolean updateClienteAvulso(Avulso avulso, String cpf){
        connect();
        String sql = "UPDATE cliente SET nome=?, telefone=?, email=? WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, avulso.getNome());
            pst.setString(2, avulso.getTelefone());
            pst.setString(3, avulso.getEmail());
            pst.setString(4, cpf);
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

    public boolean updateGastoClienteAvulso(String cpf, double gasto){
        connect();
        String sql = "UPDATE cliente SET gasto=? WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setDouble(1, gasto);
            pst.setString(2, cpf);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                result.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public boolean updateClienteFidelidade(Fidelidade fidelidade, String cpf){
        connect();
        String sql = "UPDATE cliente SET nome=?, telefone=?, email=? WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, fidelidade.getNome());
            pst.setString(2, fidelidade.getTelefone());
            pst.setString(3, fidelidade.getEmail());
            pst.setString(4, cpf);
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

    public boolean updateGastoClienteFidelidade(String cpf, double gasto){
        connect();
        String sql = "UPDATE cliente SET gasto=? WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setDouble(1, gasto);
            pst.setString(2, cpf);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                result.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public void researchCliente(){
        connect();
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * from cliente";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                System.out.println("------------------------------------------------");
                //Avulso auxiliar - o cliente pode ou não ser avulso
                Avulso avulsoTemp = new Avulso(result.getString("cpf"), result.getString("nome"),result.getString("telefone"),
                        result.getString("email"),result.getDouble("gasto"));
                avulsoTemp.setCpf(result.getString("cpf"));
                System.out.println("Cpf = " + avulsoTemp.getCpf());
                System.out.println("Nome = " + avulsoTemp.getNome());
                System.out.println("Telefone = " + avulsoTemp.getTelefone());
                System.out.println("Email = " + avulsoTemp.getEmail());
                System.out.println("Gasto = " + avulsoTemp.getGasto());
                clientes.add(avulsoTemp);
                System.out.println("------------------------------------------------");
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
    }

    public ArrayList<Cliente> researchVerificaCliente(){
        connect();
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * from cliente";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                //Avulso auxiliar - o cliente pode ou não ser avulso
                Avulso avulsoTemp = new Avulso(result.getString("cpf"), result.getString("nome"),result.getString("telefone"),
                        result.getString("email"));
                clientes.add(avulsoTemp);
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
        return clientes;
    }
}
