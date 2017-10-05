/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import wsademo.remote.ReporteBeanRemote;
import wsademo.util.Reporte;

/**
 *
 * @author nestorarevalo
 */
@Stateless(mappedName = "ReporteBean", name = "ReporteBean")
public class ReporteBean implements ReporteBeanRemote {

    @PersistenceContext(name = "WSADemoPersistence")
    private EntityManager em;

    @Override
    public Reporte find() throws Exception {
        Reporte reporte = new Reporte();
        Query query = em.createNativeQuery("select top 500 * from unico_tlf, unico_adquiriente");
        reporte.setDatos(query.getResultList());
        Connection connection = em.unwrap(java.sql.Connection.class);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select top 1 * from unico_tlf, unico_adquiriente");
        ResultSetMetaData metaData = resultSet.getMetaData();
        reporte.setColumnas(new ArrayList<String>());
        for (int i = 1; i < metaData.getColumnCount(); i++) {
            reporte.getColumnas().add(metaData.getColumnName(i));
        }
        return reporte;
//        try {

//        try {
//            Connection connection = em.unwrap(java.sql.Connection.class);
//
//            
//            Connection connection = em.unwrap(java.sql.Connection.class);
//            Statement s = connection.createStatement();
//            ResultSet rs = s.executeQuery("select top 500 * from unico_tlf, unico_adquiriente");
//            ResultSetMetaData metaData = rs.getMetaData();
//            for (int i = 0; i < metaData.getColumnCount(); i++) {
//                System.out.println(metaData.getColumnName(i));
//            }
//        Query query = em.createNativeQuery("select top 500 * from unico_tlf, unico_adquiriente");
//        java.sql.ResultSetMetaData rsmd = em.unwrap(java.sql.ResultSetMetaData.class);
//        try {
//            for (int i = 0; i < rsmd.getColumnCount(); i++) {
//                System.out.println(rsmd.getColumnName(i));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ReporteBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return query.getResultList();
//        } catch (Exception ex) {
//            Logger.getLogger(ReporteBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(ReporteBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
