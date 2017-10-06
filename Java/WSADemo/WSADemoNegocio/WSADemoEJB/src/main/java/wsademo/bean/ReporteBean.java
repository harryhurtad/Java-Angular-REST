/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
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
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
