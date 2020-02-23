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
public interface iServices<T> {
     boolean _Add(T obj);
     T _get(int id);
     ArrayList<T> _getAll();
     boolean _delete(T obj);
     boolean _update(int id,T obj);          
}
