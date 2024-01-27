package com.silva.app.p3cams.repositories;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Inquilino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InquilinosRepository implements IRepository<Inquilino>
{
    Connection conn;

    public InquilinosRepository (Connection conn)
    {
        this.conn=conn;
    }
    @Override
    public List<Inquilino> listar() throws SQLException
    {
        List<Inquilino> inquilinos = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM INQUILINOS"))
        {
            while(rs.next())
            {
                Inquilino a = this.getInquilino(rs);
                inquilinos.add(a);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return inquilinos;
    }

    @Override
    public Inquilino getById(Long id) throws SQLException
    {
        Inquilino inquilino = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM inquilinos WHERE ID_INQUILINO = ?"))
        {
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    inquilino = this.getInquilino(rs);
                }
            }
        }
        return inquilino;
    }

    @Override
    public void guardar(Inquilino inquilino) throws SQLException
    {
        String sql ="";
        if (inquilino.getId() != null && inquilino.getId()>0)
        {
            sql = "update inquilinos set nombre=?, a_paterno=?, " +
                    "a_materno=?, telefono=?, fecha_pago=? " +
                    "where id_inquilino=?";
        }
        else
        {
            sql = "insert into inquilinos (id_inquilino, nombre, " +
                    "a_paterno, a_materno, telefono, fecha_pago) " +
                    "values (SEQUENCE_INQUILINO.NEXTVAL,?,?,?,?,?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            if(inquilino.getId() != null && inquilino.getId() > 0)
            {
                stmt.setString(1,inquilino.getNombre());
                stmt.setString(2,inquilino.getApPaterno());
                stmt.setString(3,inquilino.getApMaterno());
                stmt.setString(4,inquilino.getTelefono());
                stmt.setString(5,inquilino.getFechaPago());
                stmt.setLong(6,inquilino.getId());
            }
            else
            {
                stmt.setString(1,inquilino.getNombre());
                stmt.setString(2,inquilino.getApPaterno());
                stmt.setString(3,inquilino.getApMaterno());
                stmt.setString(4,inquilino.getTelefono());
                stmt.setString(5,inquilino.getFechaPago());
            }
            stmt.executeUpdate();
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException
    {
        String sql = "delete from inquilinos where id_inquilino=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
    private Inquilino getInquilino(ResultSet rs) throws SQLException
    {
        Inquilino a = new Inquilino();
        a.setId(rs.getLong("ID_INQUILINO"));
        a.setNombre(rs.getString("NOMBRE"));
        a.setApPaterno(rs.getString("A_PATERNO"));
        a.setApMaterno(rs.getString("A_MATERNO"));
        a.setTelefono(rs.getString("TELEFONO"));
        a.setFechaPago(rs.getString("FECHA_PAGO"));

        return a;
    }
}
