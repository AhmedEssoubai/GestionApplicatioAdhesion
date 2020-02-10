/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.ArrayList;

/**
 *
 * @author Zed
 */
public interface iServices {
    public int _Add();
    public int _get(int id);
    public ArrayList<Object> _getAll();
    public boolean _delete(Object T);
    public boolean _update(int id);
}
