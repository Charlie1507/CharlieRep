package com.silva.app.p3cams.repositories;

import com.silva.app.p3cams.models.Duenio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DueniosRepository implements IRepository<Duenio>
{
    private Connection conn;

    public DueniosRepository (Connection conn)
    {
        this.conn=conn;
    }

    @Override
    public List<Duenio> listar() throws SQLException
    {
        List<Duenio> duenios = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DUENIOS"))
        {
            while(rs.next())
            {
                Duenio a = this.getDuenio(rs);
                duenios.add(a);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return duenios;
    }

    @Override
    public Duenio getById(Long id) throws SQLException
    {
        Duenio duenio = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM duenios WHERE ID_DUENIO = ?"))
        {
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    duenio = this.getDuenio(rs);
                }
            }
        }
        return duenio;
    }

    @Override
    public void guardar(Duenio duenio) throws SQLException
    {
        String sql ="";
        if (duenio.getId() != null && duenio.getId()>0)
        {
            sql = "update duenios set nombre=?, a_paterno=?, " +
                    "a_materno=?, telefono=?, cuenta=? " +
                    "where id_duenio=?";
        }
        else
        {
            sql = "insert into duenios (id_duenio, nombre, " +
                    "a_paterno, a_materno, telefono, cuenta) " +
                    "values (SEQUENCE_DUENIO.NEXTVAL,?,?,?,?,?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            if(duenio.getId() != null && duenio.getId() > 0)
            {
                stmt.setString(1,duenio.getNombre());
                stmt.setString(2,duenio.getApPaterno());
                stmt.setString(3,duenio.getApMaterno());
                stmt.setString(4,duenio.getTelefono());
                stmt.setString(5,duenio.getCuenta());
                stmt.setLong(6,duenio.getId());
            }
            else
            {
                stmt.setString(1,duenio.getNombre());
                stmt.setString(2,duenio.getApPaterno());
                stmt.setString(3,duenio.getApMaterno());
                stmt.setString(4,duenio.getTelefono());
                stmt.setString(5,duenio.getCuenta());
            }
            stmt.executeUpdate();
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException
    {
        String sql = "delete from duenios where id_duenio=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }

    }

    private Duenio getDuenio(ResultSet rs) throws SQLException
    {
        Duenio a = new Duenio();
        a.setId(rs.getLong("ID_DUENIO"));
        a.setNombre(rs.getString("NOMBRE"));
        a.setApPaterno(rs.getString("A_PATERNO"));
        a.setApMaterno(rs.getString("A_MATERNO"));
        a.setTelefono(rs.getString("TELEFONO"));
        a.setCuenta(rs.getString("CUENTA"));

        return a;
    }
}
