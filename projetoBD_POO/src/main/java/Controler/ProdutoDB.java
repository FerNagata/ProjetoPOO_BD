package Controler;
import entidades.estabelecimento.Produto;

import java.sql.*;
import java.util.ArrayList;

public class ProdutoDB extends Database{
    public boolean insertProduto(Produto produto){
        connect();
        String sql = "INSERT INTO produto(custo,preco,idProduto) VALUES (?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setDouble(1, produto.getCusto());
            pst.setDouble(2,produto.getPreco());
            pst.setInt(3,produto.getIdProduto());
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

    public ArrayList<Produto> researchProduto(){
        connect();
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * from produtos";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Produto produtoTemp = new Produto(result.getInt("idProduto"),result.getDouble("custo"),result.getDouble("preco"));
                produtoTemp.setIdProduto(result.getInt("idProduto"));
                produtoTemp.Cliente_cpf = result.getInt("Cliente_cpf");
                produtoTemp.Caixa_id = result.getInt("Caixa_id");
                System.out.println("IdProduto = " + produtoTemp.getIdProduto());
                System.out.println("Custo = " + produtoTemp.getCusto());
                System.out.println("Preço = " + produtoTemp.getPreco());
                if((produtoTemp.Cliente_cpf > 0) && (produtoTemp.Caixa_id > 0)) {
                    System.out.println("Cliente_cpf = " + produtoTemp.Cliente_cpf);
                    System.out.println("Caixa_id = " + produtoTemp.Caixa_id);
                }
                System.out.println("-------------------------------");
                produtos.add(produtoTemp);
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
        return produtos;
    }

    public boolean updateFkProduto(int idProduto, int Caixa_id, int Cliente_cpf){
        connect();
        String sql = "UPDATE aluno SET Caixa_id=?, Cliente_cpf=? WHERE idProduto=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id_curso);
            pst.setInt(2,matricula);
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
 */

    public boolean deleteProduto(int idProduto){
        connect();
        String sql = "DELETE FROM produto WHERE idProduto=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idProduto);
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
