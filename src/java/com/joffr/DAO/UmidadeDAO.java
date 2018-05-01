
package com.joffr.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.joffr.model.Umidade;

/**
 *
 * @author joffr
 */
public class UmidadeDAO {
    public UmidadeDAO(){
        
    }
    
    public boolean inserir(Umidade umidade){
        String sql = "INSERT INTO umidade(valor, data_registro, hora_registro) VALUES (?, CURRENT_DATE, CURRENT_TIME)";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, ""+umidade.getValor());
            
            if (pst.executeUpdate()>0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
            return true;
    }
    
    public boolean excluir(){
        String sql = "DELETE from umidade WHERE 1";
        PreparedStatement pst =  Conexao.getPreparedStatement(sql);
        try {
            if (pst.executeUpdate()>0) {
                return true;                
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public List<Umidade> listar(){
        String sql = "SELECT * FROM umidade";
        List<Umidade> retorno = new ArrayList<>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Umidade u = new Umidade();
                u.setId(res.getInt("id"));
                u.setValor(Double.parseDouble(res.getString("valor")));
                u.setHora(""+res.getTime("hora_registro"));
                u.setData(""+res.getDate("data_registro"));
                retorno.add(u);
            }
        } catch (Exception e) {
        }
        
        return retorno;
    }
}
