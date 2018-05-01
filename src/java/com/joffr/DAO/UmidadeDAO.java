/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joffr.DAO;

import com.sun.istack.internal.logging.Logger;
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
        String sql = "INSERT INTO umidade(valor) VALUES (?)";
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
                
                retorno.add(u);
            }
        } catch (Exception e) {
        }
        
        return retorno;
    }
}
