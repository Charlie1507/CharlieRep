package com.silva.app.p3cams.repositories;

import com.silva.app.p3cams.models.Contrato;
import com.silva.app.p3cams.models.Duenio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratosRepository implements IRepository<Contrato>
{
    private Connection conn;

    public ContratosRepository(Connection conn)
    {
        this.conn=conn;
    }
    @Override
    public List<Contrato> listar() throws SQLException
    {
        List<Contrato> contratos = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contratos"))
        {
            while(rs.next())
            {
                Contrato a = this.getContrato(rs);
                contratos.add(a);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return contratos;
    }

    @Override
    public Contrato getById(Long id) throws SQLException
    {
        Contrato contrato = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contratos WHERE ID_contrato = ?"))
        {
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    contrato = this.getContrato(rs);
                }
            }
        }
        return contrato;
    }

    @Override
    public void guardar(Contrato contrato) throws SQLException
    {
        String sql ="";
        if (contrato.getId() != null && contrato.getId()>0)
        {
            sql = "update contratos set PROPIEDAD_ID=?, DUENIO_ID=?, " +
                    "INQUILINO_ID=?, DURACION=?, TIPO_CONTRATO=? " +
                    "where ID_CONTRATO=?";
        }
        else
        {
            sql = "insert into contratos (ID_CONTRATO, PROPIEDAD_ID, DUENIO_ID, INQUILINO_ID, DURACION, TIPO_CONTRATO) " +
                    "values (SEQUENCE_contrato.NEXTVAL,?,?,?,?,?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (contrato.getId() != null && contrato.getId() > 0) {
                stmt.setLong(1, contrato.getPropiedadId());
                stmt.setLong(2, contrato.getDuenioId());
                stmt.setLong(3, contrato.getInquilinoId());
                stmt.setInt(4, contrato.getDuracion());
                stmt.setString(5, contrato.getTipoContrato());
                stmt.setLong(6, contrato.getId());
            } else
            {
                stmt.setLong(1, contrato.getPropiedadId());
                stmt.setLong(2, contrato.getDuenioId());
                stmt.setLong(3, contrato.getInquilinoId());
                stmt.setInt(4, contrato.getDuracion());
                stmt.setString(5, contrato.getTipoContrato());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    private Contrato getContrato(ResultSet rs) throws SQLException
    {
        Contrato a = new Contrato();
        a.setId(rs.getLong("ID_CONTRATO"));
        a.setPropiedadId(rs.getLong("PROPIEDAD_ID"));
        a.setDuenioId(rs.getLong("DUENIO_ID"));
        a.setInquilinoId(rs.getLong("INQUILINO_ID"));
        a.setTipoContrato(rs.getString("TIPO_CONTRATO"));
        a.setDuracion(rs.getInt("DURACION"));

        return a;
    }
}
