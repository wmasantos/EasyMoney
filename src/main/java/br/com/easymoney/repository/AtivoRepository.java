package br.com.easymoney.repository;

import br.com.easymoney.entity.AtivoEntity;
import br.com.easymoney.entity.HistoricoEntity;
import br.com.easymoney.util.EMConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("request")
public class AtivoRepository {

    @Autowired
    private EMConnection con;

    public List<AtivoEntity> getAtivo(){
        try {
            List<AtivoEntity> ativoEntities = new ArrayList<>();

            String query = "SELECT * FROM listAtivo()";

            PreparedStatement stm = con.getConnection().prepareStatement(query);
            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                ativoEntities.add(new AtivoEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }

            con.closeConnection();

            return ativoEntities;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HistoricoEntity> getHistorico(int idAtivo){
        try {
            List<HistoricoEntity> historicoEntities = new ArrayList<>();

            String query = "SELECT * FROM listHistorico(?);";

            PreparedStatement stm = con.getConnection().prepareStatement(query);
            stm.setInt(1, idAtivo);

            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                historicoEntities.add(new HistoricoEntity(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }

            con.closeConnection();

            return historicoEntities;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
