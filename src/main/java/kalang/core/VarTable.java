package kalang.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/**
 * The class holds the declared local variables.
 *
 * @author Kason Yang <i@kasonyang.com>
 * @param <T> key type
 * @param <V> value type
 */
public class VarTable<T, V> {

    private HashMap<T, V> vars = new HashMap<>();

    VarTable<T, V> parent;

    public VarTable() {

    }

    public VarTable(@Nullable VarTable<T, V> parent) {
        this.parent = parent;
    }

    public void put(T key, V var) {
        vars.put(key, var);
    }

    public boolean exist(T key) {
        return exist(key, true);
    }

    public boolean exist(T key, boolean includeParent) {
        boolean e = vars.containsKey(key);
        if(!e && parent!=null){
            e =  parent.exist(key);
        }
        return e;
    }

    public V get(T key) {
        return get(key, true);
    }

    public V get(T key, boolean includeParent) {
        V est = vars.get(key);
        if (est == null && includeParent && parent != null) {
            est = parent.get(key, includeParent);
        }
        return est;
    }
    
    public void remove(T key,boolean includeParent){
        vars.remove(key);
        if(includeParent && parent!=null) parent.remove(key, includeParent);
    }

    /**
     * get all variables not including parent's
     * @return 
     */
    public V[] toArray(V[] arr) {
        return vars.values().toArray(arr);
    }

    @Override
    public String toString() {
        return Arrays.toString(vars.values().toArray());
    }

    public VarTable<T, V> getParent() {
        return parent;
    }

    public void setParent(VarTable<T, V> parent) {
        this.parent = parent;
    }
    
    /**
     * all keys not including parent's
     * @return 
     */
    public Set<T> keySet(){
        return vars.keySet();
    }
    
    public VarTable<T,V> newStack(){
        return new VarTable(this);
    }
    
    public VarTable<T,V> popStack(){
        return this.getParent();
    }
    
    /**
     * get all values not including parent's
     * @return 
     */
    public Collection<V> values(){
        return vars.values();
    }
    
    /**
     * get all variables not including parent's
     * @return 
     */
    public HashMap<T, V> vars(){
        return vars;
    }

}
