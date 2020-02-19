/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Zed
 */
public interface iServices {
    public boolean _Add(Connection con);
    public Object _get(Connection con,int id);
    public ArrayList<Object> _getAll(Connection con);
    public boolean _delete(Connection con,Object T);
    public boolean _update(Connection con,int id);
}
