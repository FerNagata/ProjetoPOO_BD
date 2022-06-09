package Controler;

import entidades.cliente.Avulso;
import entidades.cliente.Fidelidade;
import entidades.estabelecimento.Caixa;
import entidades.estabelecimento.Funcionario;
import entidades.estabelecimento.Produto;

import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDB extends Database {
    public boolean insertFuncionario(Funcionario funcionario){
        connect();
        String sql = "INSERT INTO funcionario(cpf, nome, salario, endereco, Caixa_id, Login_idLogin) VALUES (?,?,?,?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,funcionario.getCpf());
            pst.setString(2, funcionario.getNome());
            pst.setDouble(3,funcionario.getSalario());
            pst.setString(4,funcionario.getEndereco());
            pst.setInt(5,funcionario.Caixa_id);
            pst.setInt(6,funcionario.Login_idLogin);
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

    public ArrayList<Funcionario> researchVerificarFuncionario(){
        connect();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * from funcionario";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Funcionario funcionarioTemp = new Funcionario(result.getString("cpf"),result.getString("nome"),result.getDouble("salario"),result.getString("endereco"));
                funcionarios.add(funcionarioTemp);
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
        return funcionarios;
    }

    public void researchFuncionario(){
        connect();
        ArrayList<Funcionario> funcionariosTrabalhando = new ArrayList<>();
        ArrayList<Funcionario> funcionariosDemitidos = new ArrayList<>();
        String sql = "SELECT * from funcionario";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                Funcionario funcionarioTemp = new Funcionario(result.getString("cpf"), result.getString("nome"), result.getDouble("salario"), result.getString("endereco"));
                if (funcionarioTemp.getSalario() == 0)
                    funcionariosDemitidos.add(funcionarioTemp);
                else
                    funcionariosTrabalhando.add(funcionarioTemp);
            }
            if(funcionariosTrabalhando.size() != 0){
                System.out.println("---------- FUNCIONÁRIOS ----------");
                for (int i = 0; i < funcionariosTrabalhando.size(); i++) {
                    System.out.println("Nome: " + funcionariosTrabalhando.get(i).getNome());
                    System.out.println("Cpf: " + funcionariosTrabalhando.get(i).getCpf());
                    System.out.println("Salário: " + funcionariosTrabalhando.get(i).getSalario());
                    System.out.println("Endereço: " + funcionariosTrabalhando.get(i).getEndereco());
                    System.out.println("-------------------------------");
                }
                System.out.print("\n");
            }
            else {
                System.out.println("-------------------------------");
                System.out.println("Você não possui funcionário.");
            }
            if (funcionariosDemitidos.size() != 0) {
                System.out.println("----- FUNCIONÁRIOS DEMITIDOS -----");
                for (int i = 0; i < funcionariosDemitidos.size(); i++) {
                    System.out.println("Nome: " + funcionariosDemitidos.get(i).getNome());
                    System.out.println("Cpf: " + funcionariosDemitidos.get(i).getCpf());
                    System.out.println("Edereço: " + funcionariosDemitidos.get(i).getEndereco());
                    System.out.println("-------------------------------");
                }
                System.out.print("\n");
            }
            else {
                System.out.println("-------------------------------");
                System.out.println("Você não tem nenhum funcionário demitido.");
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

    public int researchFuncionarioIdLogin(String cpf){
        connect();
        int Login_idLogin = 0;
        String sql = "SELECT * from funcionario where cpf=?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,cpf);
            pst.execute();
            result = pst.executeQuery();

            while(result.next()){
                Login_idLogin = result.getInt("Login_idLogin");
            }

        }catch(SQLException e){
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
        return Login_idLogin;
    }

    public int researchFuncionarioIdCaixaComLogin(int idLogin){
        connect();
        int idCaixa = 0;
        String sql = "SELECT * from funcionario where Login_idLogin=?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idLogin);
            pst.execute();
            result = pst.executeQuery();

            while(result.next()){
                idCaixa = result.getInt("Caixa_id");
            }

        }catch(SQLException e){
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
        return idCaixa;

    }

    public double custoSalario(){
        connect();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * from funcionario";
        double custoSalario = 0;

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Funcionario funcionarioTemp = new Funcionario(result.getString("cpf"),result.getString("nome"),result.getDouble("salario"),result.getString("endereco"));
                custoSalario += funcionarioTemp.getSalario();
                funcionarios.add(funcionarioTemp);
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

        return custoSalario;
    }

    public boolean updateFuncionario(Funcionario funcionario, String cpf){
        connect();
        String sql = "UPDATE funcionario SET nome=?, salario=?, endereco=? WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            pst.setDouble(2, funcionario.getSalario());
            pst.setString(3, funcionario.getEndereco());
            pst.setString(4,cpf);
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

    public boolean updateFuncionarioDemitido(int idLogin, String cpf){
        LoginDB loginDB = new LoginDB();

        connect();
        String sql = "UPDATE funcionario SET salario=0, Login_idLogin=null WHERE cpf=?";
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

        loginDB.deleteLogin(idLogin);

        return check;
    }

    public boolean comprarAvulso(String cpf, int idProduto, int idCaixaAux){
        ProdutoDB produtoDB = new ProdutoDB();
        CaixaDB caixaDB = new CaixaDB();
        ClienteDB clienteDB = new ClienteDB();

        double gastoAvulso;
        produtoDB.updateFkProduto(idProduto, idCaixaAux,cpf);
        gastoAvulso = (clienteDB.researchGastoClienteAvulso(cpf)+produtoDB.researchPrecoProduto(idProduto));

        clienteDB.updateGastoClienteAvulso(cpf, gastoAvulso);

        caixaDB.updateFkCaixa(idCaixaAux, (produtoDB.researchPrecoProduto(idProduto)+caixaDB.researchGastoTotalCaixa(idCaixaAux)));

        //produtoDB.deleteProduto(idProduto);

        return true;
    }

    public boolean comprarFidelidade(String cpf, int idProduto, int idCaixaAux){
        ProdutoDB produtoDB = new ProdutoDB();
        CaixaDB caixaDB = new CaixaDB();
        ClienteDB clienteDB = new ClienteDB();

        double gastoFidelidade;
        produtoDB.updateFkProduto(idProduto, idCaixaAux,cpf);
        gastoFidelidade = (clienteDB.researchGastoClienteFidelidade(cpf)+produtoDB.researchPrecoProduto(idProduto));

        clienteDB.updateGastoClienteFidelidade(cpf, gastoFidelidade);

        caixaDB.updateFkCaixa(idCaixaAux, (produtoDB.researchPrecoProduto(idProduto)+caixaDB.researchGastoTotalCaixa(idCaixaAux)));

        //produtoDB.deleteProduto(idProduto);

        return true;
    }
}
