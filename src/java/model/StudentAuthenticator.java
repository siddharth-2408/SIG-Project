/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.AdminDTO;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rajes
 */
public class StudentAuthenticator 
{
    public boolean deleteStudent(String fid)
    {
        try
        {
            Statement st = DBConnector.getStatement();
            String query = "DELETE FROM student WHERE student_id='"+fid+"'";
            int i = st.executeUpdate(query);
            
            if(i>0)
            {
                return true;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return false;
    }
    public boolean updateStudent(AdminDTO user)
    {
        try
        {
            Statement st = DBConnector.getStatement();
            String query = "UPDATE student SET student_name = '"+user.getName()+"', student_dept = '"+user.getDept()+"', student_contact = '"+user.getContact()+"', student_city = '"+user.getCity()+"', student_address = '"+user.getAddress()+"' WHERE student_id = '"+user.getId()+"';";
            System.out.println("Update Student Query = "+query);
            int i = st.executeUpdate(query);
            if(i>0)
            {
                return true;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return false;
    }
}

